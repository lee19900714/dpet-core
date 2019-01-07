package com.dpet.jiguang.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jmessage.api.JMessageClient;
import cn.jpush.api.JPushClient;

public class JPushConfig {
	
	 private final static Logger logger = LoggerFactory.getLogger(JPushConfig.class);
	
	 private final static String appKey = "551edbd8588f058297807f01";
	 
	 private final static String masterSecret = "e29462e69bbc8a5fd0c9a4cd";
	 
	 private static JPushClient jPushClient;
	 
	 private static JMessageClient jMessageClient;
	 
	 static {
		try {
			logger.info("开始初始化极光配置............");
			jPushClient = new JPushClient(masterSecret, appKey);
			jMessageClient = new JMessageClient(appKey, masterSecret);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	 }

	public static JPushClient getJPushClient() {
		if (jPushClient == null){
			jPushClient = new JPushClient(masterSecret,appKey);
		}
		return jPushClient;
	}
	
	public static JMessageClient getJMessageClient() {
		if (jMessageClient == null){
			jMessageClient = new JMessageClient(appKey, masterSecret);
		}
		return jMessageClient;
	}

}
