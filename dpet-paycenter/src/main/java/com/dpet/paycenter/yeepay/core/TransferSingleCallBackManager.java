package com.dpet.paycenter.yeepay.core;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.dpet.paycenter.yeepay.data.TransferSingleCallBackParam;
import com.dpet.paycenter.yeepay.securityplatform.Digest;

public class TransferSingleCallBackManager {

	private static final Logger logger = LoggerFactory.getLogger(TransferSingleCallBackManager.class);

	public TransferSingleCallBackParam doHandle(String responseMsg) throws Exception {
		// 商户密钥
		String hmacKey = YeepayConfig.hmacKey;
		Map<String, String> xmlBackMap = new LinkedHashMap<String, String>();
		TransferSingleCallBackParam param = new TransferSingleCallBackParam();

		logger.info("-------->>服务器回调xml报文:" + responseMsg);

		Document document = null;
		document = DocumentHelper.parseText(responseMsg);
		Element rootEle = document.getRootElement();
		String cmdValue = rootEle.elementText("hmac");

		// 对服务器响应报文进行验证签名
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

		JKey jkey = KeyUtil.getPriKey(YeepayConfig.syFilePath, "Bjtwy2017");
		X509Cert cert = CertUtil.getCert(YeepayConfig.syFilePath, "Bjtwy2017");

		X509Cert[] cs = new X509Cert[1];
		cs[0] = cert;
		boolean sigerCertFlag = false;
		SignatureUtil signUtil = new SignatureUtil();
		if (cmdValue != null) {
			sigerCertFlag = signUtil.p7VerifySignMessage(cmdValue.getBytes(), tempsession);
			String backmd5hmac = xmlBackMap.get("hmac") + "";
			if (sigerCertFlag) {
				logger.info("证书验签成功");
				backmd5hmac = new String(signUtil.getSignedContent());
				logger.info("证书验签获得的MD5签名数据为----" + backmd5hmac);
				logger.info("证书验签获得的证书dn为----" + new String(signUtil.getSigerCert()[0].getSubject()));
				// 将验签出来的结果数据与自己针对响应数据做MD5签名之后的数据进行比较是否相等
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
				String[] backDigestValues = "cmd,mer_Id,batch_No,order_Id,status,message,hmacKey".split(",");
				for (int i = 0; i < backDigestValues.length; i++) {
					if (backDigestValues[i].equals("hmacKey")) {
						backHmacStr = backHmacStr + hmacKey;
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
					// 判断该证书DN是否为易宝
					if (signUtil.getSigerCert()[0].getSubject().toUpperCase().indexOf("OU=YEEPAY,") > 0) {
						logger.info("<<---------证书DN是易宝的");
						// 系统状态码
						String status = xmlBackMap.get("status");
						if ("S".equals(status)) {
							// 回写易宝
							StringBuffer str = new StringBuffer();
							str.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
							str.append("<data>");
							str.append("<cmd>TransferNotify</cmd>");
							str.append("<version>1.1<ersion>");
							str.append("<mer_Id>" + xmlBackMap.get("mer_Id") + "</mer_Id>");
							str.append("<batch_No>" + xmlBackMap.get("batch_No") + "</batch_No>");
							str.append("<order_Id>" + xmlBackMap.get("order_Id") + "</order_Id>");
							str.append("<ret_Code>S</ret_Code>");// 这里根据情况传 S 或
																	// F
																	// 如果是 S
																	// 则不会重发
																	// 如果是 F 会重发
							cmdValue = "TransferNotify" + xmlBackMap.get("mer_Id") + xmlBackMap.get("batch_No")
									+ xmlBackMap.get("order_Id") + "S" + hmacKey;
							String hmac = Digest.hmacSign(cmdValue);
							str.append("<hmac>" + new String(
									signUtil.p7SignMessage(true, hmac.getBytes(), ALGORITHM, jkey, cs, tempsession))
									+ "</hmac>");
							str.append("</data>");
							logger.info("--------->>回写易宝数据：" + str);
							param.setOrderId(xmlBackMap.get("order_Id"));
							param.setResponseMsg(str.toString());
							return param;
						} else {
							logger.info("xxxxxxxxxxxxxxxxxxxxxx单笔打款易宝回调返回错误代码：" + status);
							throw new BusinessException("错误代码：" + status + ",错误提示：" + xmlBackMap.get("message"));
						}
					} else {
						logger.info("xxxxxxxxxxxxxxxxxxxxxx证书DN不是易宝的");
						throw new BusinessException("证书DN不是易宝的");
					}
				} else {
					logger.info("xxxxxxxxxxxxxxxxxxxxxxmd5验签失败");
					throw new BusinessException("md5验签失败");
				}
			} else {
				logger.info("xxxxxxxxxxxxxxxxxxxxxx证书验签失败....");
				throw new BusinessException("证书验签失败....");
			}
		} else {
			logger.info("xxxxxxxxxxxxxxxxxxxx易宝返回cmdValue为空....");
			throw new BusinessException("易宝返回cmdValue为空");
		}
	}

	public String doRetrunSuccessHandle(String responseMsg) {
		try {
			Map<String, String> xmlBackMap = new LinkedHashMap<String, String>();

			Document document = null;
			document = DocumentHelper.parseText(responseMsg);
			Element rootEle = document.getRootElement();
			String cmdValue = rootEle.elementText("hmac");

			// 对服务器响应报文进行验证签名
			com.cfca.util.pki.cipher.Session tempsession = null;
			JCrypto jcrypto = null;
			if (tempsession == null) {
				jcrypto = JCrypto.getInstance();
				jcrypto.initialize(JCrypto.JSOFT_LIB, null);
				tempsession = jcrypto.openSession(JCrypto.JSOFT_LIB);
			}

			X509Cert cert = CertUtil.getCert(YeepayConfig.syFilePath, "Bjtwy2017");

			X509Cert[] cs = new X509Cert[1];
			cs[0] = cert;
			boolean sigerCertFlag = false;
			SignatureUtil signUtil = new SignatureUtil();
			if (cmdValue != null) {
				sigerCertFlag = signUtil.p7VerifySignMessage(cmdValue.getBytes(), tempsession);
				String backmd5hmac = xmlBackMap.get("hmac") + "";
				if (sigerCertFlag) {
					logger.info("证书验签成功");
					backmd5hmac = new String(signUtil.getSignedContent());
					logger.info("证书验签获得的MD5签名数据为----" + backmd5hmac);
					logger.info("证书验签获得的证书dn为----" + new String(signUtil.getSigerCert()[0].getSubject()));
					// 将验签出来的结果数据与自己针对响应数据做MD5签名之后的数据进行比较是否相等
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

					// 回写易宝
					StringBuffer str = new StringBuffer();
					str.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
					str.append("<data>");
					str.append("<cmd>TransferNotify</cmd>");
					str.append("<version>1.1<ersion>");
					str.append("<mer_Id>" + xmlBackMap.get("mer_Id") + "</mer_Id>");
					str.append("<batch_No>" + xmlBackMap.get("batch_No") + "</batch_No>");
					str.append("<order_Id>" + xmlBackMap.get("order_Id") + "</order_Id>");
					str.append("<ret_Code>S</ret_Code>");
					return str.toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
