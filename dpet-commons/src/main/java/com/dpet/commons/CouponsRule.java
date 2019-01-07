package com.dpet.commons;

import java.util.HashMap;
import java.util.Map;

public class CouponsRule {
	
	private static final Map<Integer, String> typeMap;
	
	static{
		typeMap = new HashMap<Integer, String>();
		typeMap.put(1, "分组");
		typeMap.put(2, "品牌");
		typeMap.put(3, "服务");
		typeMap.put(4, "通用");
	}
	
	public static String getValue(int key){
		return typeMap.get(key);
	}

}
