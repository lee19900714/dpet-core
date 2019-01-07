package com.dpet.commons.utils;


import java.util.Date;
import java.util.HashMap;

import com.dpet.commons.vo.JWTUser;

public class ActionParam {
	
	public ActionParam(boolean isPage){
		this.isPage = isPage;
		this.sysTime = new Date();
	}
	
	/**
	 * 是否需要分页
	 */
	private boolean isPage;
	/**
	 * 分页第几页
	 */
	private int pageNo;
	/**
	 * 分页每页条数
	 */	
	private int pageSize;
	/**
	 * 总页数
	 */	
	private int pageNum;
	/**
	 * 总数
	 */
	private int total;
	
	/**
	 * 是否内部查询
	 */
	private boolean isInside;
	
	private Date sysTime;
	
	private JWTUser user;
	/**
	 * 用户ID
	 */
	private Long user_id;
	/**
	 * 用户ID
	 */
	private String user_type;
	/**
	 * 客户端类型
	 */
	private String app_type;
	/**
	 * 请求的参数值
	 */
	private HashMap<String, String> param;
	/**
	 * 是否缓存到APP本地
	 */
	private boolean isCache;
	/**
	 * 是否缓存到APP本地Cache版本
	 */
	private long cache_version;

	public boolean isPage() {
		return isPage;
	}

	public void setPage(boolean isPage) {
		this.isPage = isPage;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Date getSysTime() {
		return sysTime;
	}

	public void setSysTime(Date sysTime) {
		this.sysTime = sysTime;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getApp_type() {
		return app_type;
	}

	public void setApp_type(String app_type) {
		this.app_type = app_type;
	}

	public HashMap<String, String> getParam() {
		return param;
	}

	public void setParam(HashMap<String, String> param) {
		this.param = param;
	}

	public boolean isCache() {
		return isCache;
	}

	public void setCache(boolean isCache) {
		this.isCache = isCache;
	}

	public long getCache_version() {
		return cache_version;
	}

	public void setCache_version(long cache_version) {
		this.cache_version = cache_version;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public boolean isInside() {
		return isInside;
	}

	public void setInside(boolean isInside) {
		this.isInside = isInside;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public JWTUser getUser() {
		return user;
	}

	public void setUser(JWTUser user) {
		this.user = user;
	}
}
