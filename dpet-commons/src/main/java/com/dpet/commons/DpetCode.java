package com.dpet.commons;

public class DpetCode {
	
	public static final int Success = 0;
	public static final String SuccessMsg = "操作成功";
	
	public static final int ServerErr = 1;
	public static final String ServerErrMsg = "服务内部错误";
	
	public static final int ParamValidateErr = 100001;
	public static final String ParamValidateErrMsg = "参数校验错误";
	
	public static final int UserExist = 100002;
	public static final String UserExistMsg = "用户已存在,请直接登录";
	
	public static final int AuthErr = 100003;
	public static final String AuthErrMsg = "鉴权失败";
	
	public static final int UserNotExist = 100004;
	public static final String UserNotExistMsg = "用户不存在";
	
	public static final int PasswordErr = 100005;
	public static final String PasswordErrMsg = "密码错误";
	
	public static final int NotExist = 100006;
	public static final String NotExistMsg = "不存在";
	
	public static final int CaptchaErr = 100007;
	public static final String CaptchaErrMsg = "验证码错";
	
	public static final int MsgSendErr = 100008;
	public static final String MsgSendErrMsg = "短信发送失败";
	
	public static final int PaymentErr = 100009;
	public static final String PaymentErrMsg = "支付失败";
	
	public static final int PaymentCheckErr = 100010;
	public static final String PaymentCheckErrMsg = "支付中,不可重复提交";
	
	public static final int CheckErr = 100011;
    public static final String CheckErrMsg = "条件不满足,检查失败";
	
	public static final int UnPaidOrder = 100012;
	public static final String UnPaidOrderMsg = "您有尚未支付的订单,请完成支付后再下单";
	
	public static final int SamePhoneLimit = 100013;
	public static final String SamePhoneLimitMsg = "下单与接单手机号不能相同";
	
	public static final int AlreadyApplied = 100014;
	public static final String AlreadyAppliedMsg = "已领取过该优惠券,请关注其他活动";
	
	public static final int NoTechnician = 110001;
	public static final String NoTechnicianMsg = "附近25公里内无技师,订单将由平台处理";
}
