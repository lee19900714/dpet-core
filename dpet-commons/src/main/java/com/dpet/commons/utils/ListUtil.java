package com.dpet.commons.utils;

import java.util.List;

public class ListUtil {
	/***
	 * 判断一个List是否为空
	 * @param list
	 * @return
	 */
	public static boolean isEmpty(List<?> list){
		return list == null || list.size() == 0;
	}
	
	/***
	 * 判断一个List是否为空
	 * @param list
	 * @return
	 */
	public static boolean isNotEmpty(List<?> list){
		return list != null && list.size() > 0;
	}
}
