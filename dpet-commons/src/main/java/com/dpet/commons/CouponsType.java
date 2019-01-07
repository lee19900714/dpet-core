package com.dpet.commons;

import java.util.HashMap;
import java.util.Map;

public class CouponsType {
	
	private static final Map<Integer, String> typeMap;
	
	static{
		typeMap = new HashMap<Integer, String>();
		typeMap.put(1, "满减");
		typeMap.put(2, "立减");
		typeMap.put(3, "折扣");
	}
	
	public static String getValue(int key){
		return typeMap.get(key);
	}

}
