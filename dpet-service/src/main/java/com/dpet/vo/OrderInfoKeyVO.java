package com.dpet.vo;


public class OrderInfoKeyVO extends MetaModelVO {
	
	private String id;

	private String orderNo;

	private String buyCourseId;

	private String userId;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getBuyCourseId() {
		return buyCourseId;
	}

	public void setBuyCourseId(String buyCourseId) {
		this.buyCourseId = buyCourseId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}