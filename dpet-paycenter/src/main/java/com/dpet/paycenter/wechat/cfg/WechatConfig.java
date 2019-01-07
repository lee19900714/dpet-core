package com.dpet.paycenter.wechat.cfg;

/**
 * <p>Title: 微信基础配置类</p>
 * <p>Description:设置帐户有关信息及返回路径
 * @author zhusong
 * @version 1.0
 */

public class WechatConfig {
	
	//公众账号ID
	public static String appId = "wx3e98278c327dfef2";
	//商户号
	public static String mchId = "1492791962";
	//交易类型
	public static String tradeType = "JSAPI";
	//商户支付密钥
	public static String PAY_KEY = "baochelian2017beijingtuwuyou0312";
	//微信统一支付接口地址
	public static String unifiedorderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	//微信支付回调支付网关地址
	public static String notifyUrl = "https://core.91bcl.com/v2/wechatPay/notify";
	
}
