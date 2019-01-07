package com.dpet.commons.vo;


import java.util.Date;

public class BaseVO {
	
	/**
	* 创建日期
	*/
	protected Date create_time;
	
	/**
	* 更新日期
	*/
	protected Date modify_time;

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
}