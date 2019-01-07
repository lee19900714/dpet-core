package com.dpet.paycenter.yeepay.utils;

import java.util.Date;
import java.util.Random;

import com.dpet.commons.utils.DateUtil;

public class OrderUtils {
	
	//产生业务批次号(20位)
	public static String createBatchNo(){
		StringBuffer  sb = new StringBuffer();
		Random rand = new Random();
		String timeStamp = DateUtil.formatDate(new Date(), "yyyyMMddHHmmssS");
		sb.append(timeStamp);
		for(int i = 0; i < (17 - timeStamp.length()); i++){
			sb.append(rand.nextInt(10));
		}
		
		for(int i = 0; i < 3; i++){
			sb.append(rand.nextInt(10));
		}
		
		return sb.toString();
	} 
	
	//产生订单号(32位)
	public static String createOrderNo(){
		StringBuffer  sb = new StringBuffer();
		Random rand = new Random();
		String timeStamp = DateUtil.formatDate(new Date(), "yyyyMMddHHmmssS");
		sb.append(timeStamp);
		for(int i = 0; i < (17 - timeStamp.length()); i++){
			sb.append(rand.nextInt(10));
		}
		for(int i = 0; i < 15; i++){
			sb.append(rand.nextInt(10));
		}
		return sb.toString();
	}
}
