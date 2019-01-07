package com.dpet.wechat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;

/**
 * <p>Title: 微信公众号开发工具工厂类</p>
 * @author zhusong
 * @version 1.0
 */

public class WeiXinFactory {
	
    private static Log logger = LogFactory.getLog(WeiXinFactory.class);

    private static WxMpInMemoryConfigStorage mpConfig;
	
	private static WxMpService helper;
	
	private static String WECHAT_APPID = "wx3e98278c327dfef2";
	
	private static String WECHAT_APPSECRET = "d668f2eeb5e29f1fd9fd757b9b21f68b";
	
	static {
		try {
			init();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	protected static void init() throws Exception{
		loadConfig();
		helper = new WxMpServiceImpl();
		helper.setWxMpConfigStorage(mpConfig);
	}
	
	protected static void loadConfig(){
		try {
			mpConfig = new WxMpInMemoryConfigStorage();
			mpConfig.setAppId(WECHAT_APPID);
			mpConfig.setSecret(WECHAT_APPSECRET);
	    	logger.info("配置微信公众平台信息完毕");
	    }catch(Exception e){
	    	e.printStackTrace();
	    	logger.error("配置微信公众平台信息失败");	
	    }
	}
	
	public static WxMpInMemoryConfigStorage getConfig(){
		return mpConfig;
	}
	
	public static WxMpService getHelper() throws WeiXinException{
		return helper;
	}
	
	public void destroy() {
	}
}
