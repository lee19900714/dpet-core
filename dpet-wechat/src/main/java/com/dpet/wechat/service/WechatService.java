package com.dpet.wechat.service;

import java.util.List;

import com.dpet.wechat.vo.WechatUserVO;

import me.chanjar.weixin.mp.bean.WxMpTemplateData;

public interface WechatService {
	
	/**
	 * 根据openid获取公众号授权的微信用户信息
	 */
	public WechatUserVO getWechatUserByOpenid(String openid);
	/**
	 * 获取公众号授权的微信用户信息
	 */
	public WechatUserVO getWechatUser(String code);
	/**
	 * 发送消息模板
	 */
	public void sendTemplateMessage(String template_id, String toUser, String url, List<WxMpTemplateData> datas);
}
