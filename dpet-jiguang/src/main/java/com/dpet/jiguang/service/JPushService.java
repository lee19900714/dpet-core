package com.dpet.jiguang.service;

import java.util.List;
import java.util.Map;

public interface JPushService {
	
	/**
	 * 推送给个人（透传）
	 * @param datas 传递的数据
	 * @param user_id 用户id
	 */
	public void pushMessage(Map<String, Object> datas,String user_id);
	
	/**
	 * 推送给多个人（透传）
	 * @param datas 传递的数据
	 * @param user_ids 用户id列表
	 */
	public void pushMessage(Map<String, Object> datas, List<String> user_ids);

	/**
	 * 推送给个人（通知）
	 * @param datas 传递的数据
	 * @param user_id 用户id
	 */
	public void pushNotice(Map<String, Object> datas, String user_id);

	/**
	 * 推送给多个人（通知）
	 * @param datas 传递的数据
	 * @param user_ids 用户id列表
	 */
	public void pushNotice(Map<String, Object> datas, List<String> user_ids);
}
