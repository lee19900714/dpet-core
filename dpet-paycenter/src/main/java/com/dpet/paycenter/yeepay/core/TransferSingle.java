package com.dpet.paycenter.yeepay.core;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data")
public class TransferSingle {

	/**
	 * 命令，固定值  TransferSingle 
	 */
	private String cmd = "TransferSingle";
	/**
	 * 版本号
	 */
	private String version = "1.1";
	/**
	 * 交易商商户编号
	 */
	private String mer_Id;
	/**
	 * 总公司商户编号
	 */
	private String group_Id;
	/**
	 * 打款批次号
	 */
	private String batch_No;
	/**
	 * 订单号
	 */
	private String order_Id;
	/**
	 * 收款银行编号（非必填）
	 */
	private String bank_Code;
	/**
	 * 联行号（非必填）
	 */
	private String cnaps;
	/**
	 * 收款银行全称
	 */
	private String bank_Name;
	/**
	 * 收款银行支行名称
	 */
	private String branch_Bank_Name;
	/**
	 * 打款金额
	 */
	private String amount;
	/**
	 * 账户名称
	 */
	private String account_Name;
	/**
	 * 账户号
	 */
	private String account_Number;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 手续费收取方式
	 */
	private String fee_Type = "SOURCE";
	/**
	 * 收款人邮箱
	 */
	private String payee_Email;
	/**
	 * 收款人手机号
	 */
	private String payee_Mobile;
	/**
	 * 加急
	 */
	private String urgency = "1";
	/**
	 * 留言
	 */
	private String leave_Word;
	/**
	 * 摘要
	 */
	private String abstractInfo;
	/**
	 * 备注
	 */
	private String remarksInfo;
	/**
	 * 签名信息
	 */
	private String hmac = "";

	public String getCmd() {
		return cmd;
	}

	@XmlElement
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getVersion() {
		return version;
	}

	@XmlElement
	public void setVersion(String version) {
		this.version = version;
	}

	public String getMer_Id() {
		return mer_Id;
	}

	@XmlElement
	public void setMer_Id(String mer_Id) {
		this.mer_Id = mer_Id;
	}

	public String getGroup_Id() {
		return group_Id;
	}

	@XmlElement
	public void setGroup_Id(String group_Id) {
		this.group_Id = group_Id;
	}

	public String getBatch_No() {
		return batch_No;
	}

	@XmlElement
	public void setBatch_No(String batch_No) {
		this.batch_No = batch_No;
	}

	public String getOrder_Id() {
		return order_Id;
	}

	@XmlElement
	public void setOrder_Id(String order_Id) {
		this.order_Id = order_Id;
	}

	public String getBank_Code() {
		return bank_Code;
	}

	@XmlElement
	public void setBank_Code(String bank_Code) {
		this.bank_Code = bank_Code;
	}

	public String getCnaps() {
		return cnaps;
	}

	@XmlElement
	public void setCnaps(String cnaps) {
		this.cnaps = cnaps;
	}

	public String getBank_Name() {
		return bank_Name;
	}

	@XmlElement
	public void setBank_Name(String bank_Name) {
		this.bank_Name = bank_Name;
	}

	public String getBranch_Bank_Name() {
		return branch_Bank_Name;
	}

	@XmlElement
	public void setBranch_Bank_Name(String branch_Bank_Name) {
		this.branch_Bank_Name = branch_Bank_Name;
	}

	public String getAmount() {
		return amount;
	}

	@XmlElement
	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAccount_Name() {
		return account_Name;
	}

	@XmlElement
	public void setAccount_Name(String account_Name) {
		this.account_Name = account_Name;
	}

	public String getAccount_Number() {
		return account_Number;
	}

	@XmlElement
	public void setAccount_Number(String account_Number) {
		this.account_Number = account_Number;
	}

	public String getProvince() {
		return province;
	}

	@XmlElement
	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	@XmlElement
	public void setCity(String city) {
		this.city = city;
	}

	public String getFee_Type() {
		return fee_Type;
	}

	@XmlElement
	public void setFee_Type(String fee_Type) {
		this.fee_Type = fee_Type;
	}

	public String getPayee_Email() {
		return payee_Email;
	}

	@XmlElement
	public void setPayee_Email(String payee_Email) {
		this.payee_Email = payee_Email;
	}

	public String getPayee_Mobile() {
		return payee_Mobile;
	}

	@XmlElement
	public void setPayee_Mobile(String payee_Mobile) {
		this.payee_Mobile = payee_Mobile;
	}

	public String getLeave_Word() {
		return leave_Word;
	}

	@XmlElement
	public void setLeave_Word(String leave_Word) {
		this.leave_Word = leave_Word;
	}

	public String getAbstractInfo() {
		return abstractInfo;
	}

	@XmlElement
	public void setAbstractInfo(String abstractInfo) {
		this.abstractInfo = abstractInfo;
	}

	public String getRemarksInfo() {
		return remarksInfo;
	}

	@XmlElement
	public void setRemarksInfo(String remarksInfo) {
		this.remarksInfo = remarksInfo;
	}

	public String getUrgency() {
		return urgency;
	}

	@XmlElement
	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	public String getHmac() {
		return hmac;
	}

	@XmlElement
	public void setHmac(String hmac) {
		this.hmac = hmac;
	}

}
