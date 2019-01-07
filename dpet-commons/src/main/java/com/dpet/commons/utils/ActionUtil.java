package com.dpet.commons.utils;

import java.util.Date;
import java.util.HashMap;

import org.springframework.core.NamedThreadLocal;

import com.dpet.commons.vo.JWTUser;


/**
 * 用于存放分页参数、用户信息
 * 采用ThreadLocal是为了使每个线程保存一份属于自己的数据。
 * */
public class ActionUtil {

	private static final ThreadLocal<ActionParam> ActionParamHolder = new NamedThreadLocal<ActionParam>(
			"ActionParam Holder");

    /**
	 * 初始化线程参数
	 */
	public static void initParam(String user_type, Long user_id){
		if (getActionParam() == null) ActionParamHolder.set(new ActionParam(false));
		ActionParam param = ActionParamHolder.get();
		param.setUser_id(user_id);
	}

	/**
	 * 设置线程参数
	 * @param p
	 */
	public static void setActionParam(ActionParam p){
		ActionParamHolder.set(p);
	}
	
	public static ActionParam getActionParam(){
		return ActionParamHolder.get();
	}
	
	public static int getPageNo(){
		return getActionParam().getPageNo();
	}
	
	public static void setPageNo(int pageNo){
		getActionParam().setPageNo(pageNo);
	}
	
	public static int getPageSize(){
		return getActionParam().getPageSize();
	}
	
	public static void setPageSize(int pageSize){
		getActionParam().setPageSize(pageSize);
	}
	
	public static int getPageNum(){
		return getActionParam().getPageNum();
	}
	
	public static void setPageNum(int pageNum){
		getActionParam().setPageNum(pageNum);
	}
	
	public static void setTotal(int total){
		getActionParam().setTotal(total);
	}
	
	public static int getTotal(){
		return getActionParam().getTotal();
	}
	
	public static boolean isPage(){
		if (getActionParam()==null) return false;
		return getActionParam().isPage();
	}
	
	public static void setPage(boolean isPage){
		getActionParam().setPage(isPage);
	}
	
	public static boolean isInside(){
		if (getActionParam()==null) return false;
		return getActionParam().isInside();
	}
	
	public static void setInside(boolean isInside){
		getActionParam().setInside(isInside);
	}
	
	public static boolean exist(){
		return getActionParam() != null;
	}

	/**
	 * 获取系统时间
	 * @return
	 */
	public static Date getSysTime() {
		return getActionParam().getSysTime();
	}

	/**
	 * 获取当前操作用户
	 * @return
	 */
	public static Long getUserID() {
		return getActionParam().getUser_id();
	}
	
	/**
	 * 获取客户端类型
	 * @return
	 */
	public static String getAppType() {
		return getActionParam().getApp_type();
	}

	/**
	 * 获取传递过来的某个参数的值
	 * @return
	 */
	public static String getParameter(String key) {
		return getActionParam().getParam().get(key);
	}
	
	/**
	 * 获取参数Map
	 * @return
	 */
	public static HashMap<String, String> getParameterMap() {
		return ActionUtil.getActionParam().getParam();
	}
	
	public static void setCache(boolean isCache) {
		ActionUtil.getActionParam().setCache(isCache);
	}
	
	public static boolean isCache() {
		return ActionUtil.getActionParam().isCache();
	}
	
	public static long getCache_version() {
		return ActionUtil.getActionParam().getCache_version();
	}

	public static void setCache_version(long cache_version) {
		ActionUtil.getActionParam().setCache_version(cache_version);
	}
	
	public static String getUserType() {
		return ActionUtil.getActionParam().getUser_type();
	}

	public static void setUserType(String user_type) {
		ActionUtil.getActionParam().setUser_type(user_type);
	}
	
	public static JWTUser getUser() {
		return ActionUtil.getActionParam().getUser();
	}

	public static void setUser(JWTUser user) {
		ActionUtil.getActionParam().setUser(user);
	}
}
