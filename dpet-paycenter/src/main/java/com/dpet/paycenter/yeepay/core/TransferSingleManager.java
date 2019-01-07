package com.dpet.paycenter.yeepay.core;

import java.io.ByteArrayOutputStream;
import java.security.Security;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cfca.util.pki.api.CertUtil;
import com.cfca.util.pki.api.KeyUtil;
import com.cfca.util.pki.api.SignatureUtil;
import com.cfca.util.pki.cert.X509Cert;
import com.cfca.util.pki.cipher.JCrypto;
import com.cfca.util.pki.cipher.JKey;
import com.dpet.framework.BusinessException;
import com.dpet.paycenter.yeepay.cfg.YeepayConfig;
import com.dpet.paycenter.yeepay.data.TransferSingleRequestParam;
import com.dpet.paycenter.yeepay.data.TransferSingleResponseParam;
import com.dpet.paycenter.yeepay.securityplatform.Digest;
import com.dpet.paycenter.yeepay.utils.CallbackUtils;
import com.dpet.paycenter.yeepay.utils.OrderUtils;

public class TransferSingleManager {

	private static final Logger logger = LoggerFactory.getLogger(TransferSingleManager.class);
	
	private static final String textHost = "http://cha.yeepay.com/app-merchant-proxy/groupTransferController.action";

	public TransferSingleResponseParam doRequest(TransferSingleRequestParam param) throws Exception {

		Map<String, String> result = new LinkedHashMap<String, String>();
		Map<String, String> xmlMap = new LinkedHashMap<String, String>();
		Map<String, String> xmlBackMap = new LinkedHashMap<String, String>();
		TransferSingleResponseParam resultParam = new TransferSingleResponseParam();

		String digest = "cmd,mer_Id,batch_No,order_Id,amount,account_Number,hmacKey";
		String backDigest = "cmd,ret_Code,mer_Id,batch_No,total_Amt,total_Num,r1_Code,hmacKey";

		String[] digestValues = digest.split(",");
		String[] backDigestValues = backDigest.split(",");

		TransferSingle ts = new TransferSingle();
		ts.setGroup_Id(YeepayConfig.p1_MerId);
		ts.setMer_Id(YeepayConfig.p1_MerId);
		ts.setBatch_No(OrderUtils.createBatchNo());
		ts.setOrder_Id(OrderUtils.createOrderNo());
		
		resultParam.setBatchNo(ts.getBatch_No());
		resultParam.setOrderId(ts.getOrder_Id());
		
		ts.setBank_Code(param.getBankCode());
		ts.setAmount(param.getAmount());
		ts.setAccount_Name(param.getAccountName());
		ts.setAccount_Number(param.getAccountNumber());
		ts.setLeave_Word("保车连提现");
		ts.setRemarksInfo("保车连提现");

		String xml = covert2Xml(ts);

		// 第一步:将请求的数据和商户自己的密钥拼成一个字符串,
		Document document = DocumentHelper.parseText(xml);
		Element rootEle = document.getRootElement();
		String cmdValue = rootEle.elementText("cmd");

		@SuppressWarnings("rawtypes")
		List list = rootEle.elements();
		for (int i = 0; i < list.size(); i++) {
			Element ele = (Element) list.get(i);
			String eleName = ele.getName();
			if (!eleName.equals("list")) {
				xmlMap.put(eleName, ele.getText().trim());
			} else {
				continue;
			}
		}

		String hmacStr = "";
		for (int i = 0; i < digestValues.length; i++) {
			if (digestValues[i].equals("hmacKey")) {
				hmacStr = hmacStr + YeepayConfig.hmacKey;
				continue;
			}
			hmacStr = hmacStr + xmlMap.get(digestValues[i]);

		}

		// 下面用数字证书进行签名
		com.cfca.util.pki.cipher.Session tempsession = null;
		String ALGORITHM = SignatureUtil.SHA1_RSA;
		JCrypto jcrypto = null;
		if (tempsession == null) {
			// 初始化加密库，获得会话session
			// 多线程的应用可以共享一个session,不需要重复,只需初始化一次
			// 初始化加密库并获得session。
			// 系统退出后要jcrypto.finalize()，释放加密库
			jcrypto = JCrypto.getInstance();
			jcrypto.initialize(JCrypto.JSOFT_LIB, null);
			tempsession = jcrypto.openSession(JCrypto.JSOFT_LIB);
		}

		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		
		JKey jkey = KeyUtil.getPriKey(YeepayConfig.syFilePath, "Bjtwy2017");
		X509Cert cert = CertUtil.getCert(YeepayConfig.syFilePath, "Bjtwy2017");

		X509Cert[] cs = new X509Cert[1];
		cs[0] = cert;
		String signMessage = "";
		SignatureUtil signUtil = null;
		
		// 第二步:对请求的串进行MD5对数据进行签名
		String yphs = Digest.hmacSign(hmacStr);
		signUtil = new SignatureUtil();
		byte[] b64SignData;
		// 第三步:对MD5签名之后数据调用CFCA提供的api方法用商户自己的数字证书进行签名
		b64SignData = signUtil.p7SignMessage(true, yphs.getBytes(), ALGORITHM, jkey, cs, tempsession);
		if (jcrypto != null) {
			jcrypto.finalize(com.cfca.util.pki.cipher.JCrypto.JSOFT_LIB, null);
		}
		signMessage = new String(b64SignData, "UTF-8");
		

		Element r = rootEle.element("hmac");
		r.setText(signMessage);
		result.put("xml", xml);
		document.setXMLEncoding("GBK");
		logger.info("-------->>完整xml请求报文:" + document.asXML());
		logger.info("-------->>请求地址为:" + textHost);

		// 第四步:发送https请求
		String responseMsg = CallbackUtils.httpRequest(textHost, document.asXML(), "POST", "gbk",
				"text/xml ;charset=gbk", false);
		logger.info("<<---------服务器响应xml报文:" + responseMsg);

		document = DocumentHelper.parseText(responseMsg);
		
		rootEle = document.getRootElement();
		cmdValue = rootEle.elementText("hmac");

		// 第五步:对服务器响应报文进行验证签名
		boolean sigerCertFlag = false;
		if (cmdValue != null) {
			sigerCertFlag = signUtil.p7VerifySignMessage(cmdValue.getBytes(), tempsession);
			String backmd5hmac = xmlBackMap.get("hmac") + "";
			if (sigerCertFlag) {
				backmd5hmac = new String(signUtil.getSignedContent());
				// 第六步.将验签出来的结果数据与自己针对响应数据做MD5签名之后的数据进行比较是否相等
				Document backDocument = null;
				backDocument = DocumentHelper.parseText(responseMsg);
				Element backRootEle = backDocument.getRootElement();
				@SuppressWarnings("rawtypes")
				List backlist = backRootEle.elements();
				for (int i = 0; i < backlist.size(); i++) {
					Element ele = (Element) backlist.get(i);
					String eleName = ele.getName();
					if (!eleName.equals("list")) {
						xmlBackMap.put(eleName, ele.getText().trim());
					} else {
						continue;
					}
				}
				String backHmacStr = "";
				for (int i = 0; i < backDigestValues.length; i++) {
					if (backDigestValues[i].equals("hmacKey")) {
						backHmacStr = backHmacStr + YeepayConfig.hmacKey;
						continue;
					}
					String tempStr = (String) xmlBackMap.get(backDigestValues[i]);
					backHmacStr = backHmacStr + ((tempStr == null) ? "" : tempStr);
				}
				String newmd5hmac = Digest.hmacSign(backHmacStr);
				
				logger.info("<<---------提交返回源数据为---||" + backHmacStr + "||");
				logger.info("<<---------经过md5签名后的验证返回hmac为---||" + newmd5hmac + "||");
				logger.info("<<---------提交返回的hmac为---||" + backmd5hmac + "||");
				
				if (newmd5hmac.equals(backmd5hmac)) {
					logger.info("<<---------md5验签成功");
					// 第七步:判断该证书DN是否为易宝
					if (signUtil.getSigerCert()[0].getSubject().toUpperCase().indexOf("OU=YEEPAY,") > 0) {
						logger.info("<<---------证书DN是易宝的");
						// 第八步:返回正确业务逻辑
						//系统状态码
						String retCode = xmlBackMap.get("ret_Code");
						//打款状态码
						String r1Code = xmlBackMap.get("r1_Code");
						//银行状态码
						String bankStatus = xmlBackMap.get("bank_Status");
						
						if(!"1".equals(retCode)){
							logger.info("xxxxxxxxxxxxxxxxxxxxxx单笔打款发起易宝请求失败，返回错误代码：" + retCode + "|" + r1Code + "|" + bankStatus);
							throw new BusinessException("错误代码：" + retCode + "|" + r1Code + "|" + bankStatus + ",错误提示：" + xmlBackMap.get("error_Msg"));
						}
						if("0025".equals(r1Code) || "0026".equals(r1Code)){
							return resultParam;
						}else{
							logger.info("xxxxxxxxxxxxxxxxxxxxxx单笔打款发起易宝请求失败，返回错误代码：" + retCode + "|" + r1Code + "|" + bankStatus);
							throw new BusinessException("错误代码：" + retCode + "|" + r1Code + "|" + bankStatus + ",错误提示：" + xmlBackMap.get("error_Msg"));
						}
					} else {
						logger.info("xxxxxxxxxxxxxxxxxxxxxx证书DN不是易宝的");
						throw new BusinessException("证书DN不是易宝的");
					}
				} else {
					logger.info("xxxxxxxxxxxxxxxxxxxmd5验签失败");
					throw new BusinessException("证书DN不是易宝的");
				}
			} else {
				logger.info("xxxxxxxxxxxxxxxxxxxx证书验签失败....");
				throw new BusinessException("证书DN不是易宝的");
			}
		}else{
			logger.info("xxxxxxxxxxxxxxxxxxxx易宝返回cmdValue为空....");
			throw new BusinessException("易宝返回cmdValue为空");
		}
	}

	private String covert2Xml(TransferSingle ts) throws Exception {
		JAXBContext context = JAXBContext.newInstance(TransferSingle.class); // 获取上下文对象
		Marshaller marshaller = context.createMarshaller(); // 根据上下文获取marshaller对象

		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8"); // 设置编码字符集
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化XML输出，有分行和缩进

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(ts, baos);
		String xmlObj = new String(baos.toByteArray());
		return xmlObj;
	}
}
