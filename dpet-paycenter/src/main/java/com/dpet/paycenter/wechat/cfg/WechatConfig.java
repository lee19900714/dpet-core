package com.dpet.paycenter.wechat.cfg;

/**
 * <p>Title: 微信基础配置类</p>
 * <p>Description:设置帐户有关信息及返回路径
 * @author zhusong
 * @version 1.0
 */

public class WechatConfig {
	
	//公众账号ID
	public static String appId = "wx5ccdb2f9cc6516a4";
	//商户号
	public static String mchId = "1522819581";
	//交易类型
	public static String tradeType = "JSAPI";
	//终端ip
	public static String spbillCreateIp = "39.96.46.173";
	//商户支付密钥
	public static String PAY_KEY = "beijingchongdaokejigongsi2018309";
	//微信统一支付接口地址
	public static String unifiedorderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	//微信支付回调支付网关地址
	public static String notifyUrl = "http://39.96.46.173/dpet-core/ipet/orderinfo/notify";
	
}
