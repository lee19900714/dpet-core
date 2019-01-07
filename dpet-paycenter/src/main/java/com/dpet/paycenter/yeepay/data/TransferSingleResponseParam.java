package com.dpet.paycenter.yeepay.data;

public class TransferSingleResponseParam {
	
	private String orderId;
	
	private String batchNo;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
}
