package com.dpet.commons;

import java.util.HashMap;
import java.util.Map;

public class PayType {

	public static final String WX_PAY = "1";

	public static final String ZFB_PAY = "2";

	private static final Map<String, String> payTypeMap;

	static {
		payTypeMap = new HashMap<String, String>();
		payTypeMap.put(WX_PAY, "微信支付");
		payTypeMap.put(ZFB_PAY, "支付宝支付");
	}

	public static String getValue(int key) {
		return payTypeMap.get(key);
	}

}
