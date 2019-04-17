package com.dpet.vo;


import java.util.List;

public class OrderInfoVO extends OrderInfoKeyVO {
    private String orderAmount;

    private String payType;

    private String orderState;

    private String createTime;

    private String modifyTime;

    private String modifierId;

    private List<CourseInfoVO> courseInfoVOS;

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifierId() {
		return modifierId;
	}

	public void setModifierId(String modifierId) {
		this.modifierId = modifierId;
	}

	public List<CourseInfoVO> getCourseInfoVOS() {
		return courseInfoVOS;
	}

	public void setCourseInfoVOS(List<CourseInfoVO> courseInfoVOS) {
		this.courseInfoVOS = courseInfoVOS;
	}
}