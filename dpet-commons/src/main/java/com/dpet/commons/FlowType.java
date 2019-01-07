package com.dpet.commons;

import java.util.HashMap;
import java.util.Map;

public class FlowType {
	
	private static final Map<String, String> FlowTypeMap;
	
	static{
		FlowTypeMap = new HashMap<String, String>();
		FlowTypeMap.put("order_service", "订单工时收入");
		FlowTypeMap.put("order_sku", "订单耗材收入");
		FlowTypeMap.put("order_other", "订单其他收入");
		FlowTypeMap.put("award", "平台活动奖励");
		FlowTypeMap.put("withdrawl", "提现");
	}
	
	public static String getValue(String key){
		return FlowTypeMap.get(key);
	}

}
