package com.dpet.commons;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OrderStatus {
	
	public static final int PENDING_PAY = 1;
	
	public static final int PAYING = 2;
	
	public static final int PAYED = 3;
	
	public static final int PEND_COMMENT = 4;
	
	public static final int COMPELETED = 5;
	
	public static final int CANCLE = 6;
	
	private static final Map<Integer, String> statusMap;
	
	public static final Set<Integer> NotPayedset = new HashSet<Integer>();
	
	public static final Set<Integer> PayedSet = new HashSet<Integer>();
	
	static{
		statusMap = new HashMap<Integer, String>();
		statusMap.put(PENDING_PAY, "待付款");
		statusMap.put(PAYING, "付款中");
		statusMap.put(PAYED, "已付款");
		statusMap.put(PEND_COMMENT, "待评价");
		statusMap.put(COMPELETED, "完成");
		statusMap.put(CANCLE, "取消");
		
		NotPayedset.add(1);
		NotPayedset.add(2);
		NotPayedset.add(6);
		
		PayedSet.add(3);
		PayedSet.add(4);
		PayedSet.add(5);
	}
	
	public static String getValue(int key){
		return statusMap.get(key);
	}

}
