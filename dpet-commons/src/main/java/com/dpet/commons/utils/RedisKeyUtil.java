package com.dpet.commons.utils;

public class RedisKeyUtil {
	
	/**
	 * 操作类型:插入操作
	 */
	public static final String OPTYPE_CREATE="C";
	
	/**
	 * 操作类型:更新操作
	 */
	public static final String OPTYPE_UPDATE="U";
	
	/**
	 * 操作类型:读取操作
	 */
	public static final String OPTYPE_READ="R";
	
	/**
	 * 操作类型:删除操作
	 */
	public static final String OPTYPE_DELETE="D";
	
	/**
	 * 计算类型:加法
	 */
	public static final String MATH_ADD="ADD";
	
	/**
	 * 操作类型:减法操作
	 */
	public static final String MATH_SUB="SUB";
	
	
	/**
	 * 动态redis 临时Key前缀
	 */
	public static final String KEY_SEQUENCE_PRE="SEQUENCE:";
	
	/**
	 * 动态redis 已读标记前缀
	 */
	public static final String KEY_READ_PRE="READ:";
	
	/**
	 * 动态redis 已读标记前缀
	 */
	public static final String KEY_SCORE_PRE="SCORE:";
	
	/**
	 * 动态redis 临时Key前缀
	 */
	public static final String KEY_TEMP_PRE="TEMP:";
	
	/**
	 * 动态redis 集合前缀
	 */
	public static final String KEY_SET_PRE="DATA:";
	
	/**
	 * 动态redis Key前缀
	 */
	public static final String KEY_DYNAMIC_PRE="DYNAMIC:";
	
	/**
	 * 动态redis MODULE_CODE
	 */
	public static final String KEY_MODULE_CODE="MODULE_CODE:";
	
	/**
	 * 动态redis PKID
	 */
	public static final String KEY_MODULE_PKID="PKID:";
	
	/**
	 * 通知redis Key前缀
	 */
	public static final String KEY_NOTICE_PRE="NOTICE:";
	
	/**
	 * 通知redis NOTICEID
	 */
	public static final String KEY_NOTICE_ID=":NOTICEID";
	
	/**
	 * 动态redis Key前缀
	 */
	public static final String KEY_DYNAMIC_RECEIVE="RECEIVE_GROUPS";
	
	/**
	 * 动态redis Key前缀
	 */
	public static final String KEY_GROUP_PRE="USER_GROUPS:";
	
	/**
	 * 动态redis Key前缀
	 */
	public static final String REPLY="REPLY:";
	
	/**
	 * 动态redis Key前缀
	 */
	public static final String USERS="USERS:";
	
	/**
	 * 动态redis 缓存
	 */
	public static final String CACHE="CACHE:";
	
	/**
	 * 排名redis Key前缀
	 */
	public static final String KEY_RANK_PRE="RANK:";
	
	/**
	 * 最近扣分记录redis Key前缀
	 */
	public static final String KEY_RECORD_PRE="RECORD:";
	/**
	 * 考勤项目，扣分原因信息redis Key前缀
	 */
	public static final String KEY_CODE_PRE="CODE:";
	
	/**
	 * 学校配置redis Key前缀
	 */
	public static final String KEY_CONFIG_PRE="CONFIG:";
	
	/**
	 * 获取公共参数组装起来的唯一Key
	 * @return 唯一Key
	 */
	public static String getUnionKey(){
		return getUnionKey(ActionUtil.getUserType(),ActionUtil.getUserID());
	}
	
	/**
	 * 获取公共参数组装起来的唯一Key
	 * @return 唯一Key
	 */
	public static String getUnionKey(String user_type, Long user_id){
		return "USER_TYPE"+user_type+":USER_ID"+user_id; 
	}
}
