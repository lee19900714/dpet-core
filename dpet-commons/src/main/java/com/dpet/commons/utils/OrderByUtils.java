package com.dpet.commons.utils;

public class OrderByUtils {
	
	public static String getOrderSql(String sorter, String sort){
		if(StringUtil.isNotEmpty(sort) && StringUtil.isNotEmpty(sorter)){
			return " ORDER BY " + sorter + " " + sort;
		}
		return "";	
	}

}
