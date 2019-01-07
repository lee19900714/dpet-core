package com.dpet.paycenter.wechat.utils;

import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

import com.dpet.paycenter.wechat.cfg.WechatConfig;
import com.dpet.paycenter.wechat.vo.JSCfgParam;
import com.dpet.paycenter.wechat.vo.JSPayParam;

public class JSAPIUtils {
	
	public static JSPayParam createPayParam(String prepay_id){
		JSPayParam param = new JSPayParam();
		SortedMap<String, String> map = new TreeMap<String, String>();
		param.setAppId(WechatConfig.appId);
		map.put("appId", param.getAppId());
		param.setNonceStr(CommonUtil.CreateNoncestr());
		map.put("nonceStr", param.getNonceStr());
		param.setPk("prepay_id=" + prepay_id);
		map.put("package", param.getPk());
		param.setSignType("MD5");
		map.put("signType", param.getSignType());
		param.setTimeStamp(String.valueOf(new Date().getTime()));
		map.put("timeStamp", param.getTimeStamp());
		
		param.setPaySign(CommonUtil.createSign("UTF-8", map));
		
		return param;
	}
	
	public static JSCfgParam createCfgParam(String jsapi_ticket, String useUrl){
		JSCfgParam param = new JSCfgParam();
		SortedMap<String, String> map = new TreeMap<String, String>();
		param.setAppId(WechatConfig.appId);
		
		param.setTimestamp(String.valueOf(new Date().getTime()));
		map.put("timestamp", param.getTimestamp());
		
		param.setNonceStr(CommonUtil.CreateNoncestr());
		map.put("noncestr", param.getNonceStr());
		
		map.put("jsapi_ticket", jsapi_ticket);
		
		map.put("url", useUrl);
		
		param.setSignature(CommonUtil.createJsapiCfgSign(map));
		
		return param;
	}

}
