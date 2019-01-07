package com.dpet.wechat.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.dpet.wechat.WeixinConstants;

public class WechatUtil {
	
	public static String getOAuthUrl(String appid, String callbackUrl){
		try {
			String oAuthUrl =  WeixinConstants.WECHAT_OAUTH2_URL.replaceAll("APPID", appid)
					   .replaceAll("REDIRECT_URI", URLEncoder.encode(callbackUrl, "utf-8"))
					   .replaceAll("SCOPE", "snsapi_userinfo")
					   .replaceAll("STATE", "wechat_parent_oauth_login");
			return oAuthUrl;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

}
