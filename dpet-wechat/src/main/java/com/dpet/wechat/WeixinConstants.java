package com.dpet.wechat;

public class WeixinConstants {
	/**
	 * SNS微信类型
	 */
	public static final String SNS_TYPE_WECHAT = "wechat";
	/**
	 * SNS微信小程序类型
	 */
	public static final String SNS_TYPE_WECHATAPP = "wechatapp";
	
	/**
	 * 微信oauth2地址
	 */
	public static final String WECHAT_OAUTH2_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	
	/**
	 * 微信access_token请求地址
	 */
	public static final String WECHAT_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?grant_type=authorization_code&appid=%s&secret=%s&code=%s";
	
	/**
	 * 微信用户信息请求地址
	 */
	public static final String WECHAT_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s";
	
}
