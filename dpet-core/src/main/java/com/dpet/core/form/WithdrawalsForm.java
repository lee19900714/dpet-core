package com.dpet.core.form;

import java.util.Date;

public class WithdrawalsForm {

	private String id;
	/**
	 * 用户 ID<br>
	 */
	private String userId;
	/**
	 * 支付宝/银行卡<br>
	 */
	private Integer type;
	/**
	 * 金额<br>
	 */
	private Double amount;
	/**
	 * 手续费<br>
	 */
	private Double serviceCharge;
	/**
	 * 实际到账金额<br>
	 */
	private Double actualAmount;
	/**
	 * 银行卡号
	 */
	private String cardNo;
	/**
	 * 银行名称
	 */
	private String bankName;
	/**
	 * 银行LOGO
	 */
	private String bakLogo;
	
	/**
	 * 状态<br>
	 */
	private Integer status;
	/**
	 * 创建时间<br>
	 */
	private Date createTime;
	/**
	 * 更新时间<br>
	 */
	private Date modifyTime;
	/**
	 * 支付宝账号<br>
	 */
	private String alipayUserName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(Double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public Double getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(Double actualAmount) {
		this.actualAmount = actualAmount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getAlipayUserName() {
		return alipayUserName;
	}

	public void setAlipayUserName(String alipayUserName) {
		this.alipayUserName = alipayUserName;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBakLogo() {
		return bakLogo;
	}

	public void setBakLogo(String bakLogo) {
		this.bakLogo = bakLogo;
	}
}
