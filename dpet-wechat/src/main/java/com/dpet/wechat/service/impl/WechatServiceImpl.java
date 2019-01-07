package com.dpet.wechat.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dpet.wechat.WeiXinFactory;
import com.dpet.wechat.service.WechatService;
import com.dpet.wechat.vo.WechatUserVO;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.WxMpTemplateMessage;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

@Service("wechatService")
public class WechatServiceImpl implements WechatService{
	
	@Override
	public WechatUserVO getWechatUser(String code){
		try{
			WxMpService helper = WeiXinFactory.getHelper();
			WxMpOAuth2AccessToken wxMpOAuth2AccessToken = helper.oauth2getAccessToken(code);
			WxMpUser wxMpUser = helper.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
			WechatUserVO user = new WechatUserVO();
			user.setHead_img_url(wxMpUser.getHeadImgUrl());
			user.setNick_name(wxMpUser.getNickname());
			user.setOpen_id(wxMpUser.getOpenId());
			user.setUnionid(wxMpUser.getUnionId());
			if(wxMpUser.getSexId() != null){
				user.setSex(wxMpUser.getSexId());
			}
			return user;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public WechatUserVO getWechatUserByOpenid(String openid) {
		try{
			WxMpService helper = WeiXinFactory.getHelper();
			WxMpUser wxMpUser = helper.userInfo(openid, null);
			WechatUserVO user = new WechatUserVO();
			user.setHead_img_url(wxMpUser.getHeadImgUrl());
			user.setNick_name(wxMpUser.getNickname());
			user.setOpen_id(wxMpUser.getOpenId());
			user.setUnionid(wxMpUser.getUnionId());
			if(wxMpUser.getSexId() != null){
				user.setSex(wxMpUser.getSexId());
			}
			return user;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/*List<WxMpTemplateData> datas = new ArrayList<WxMpTemplateData>();
	datas.add(new WxMpTemplateData("first", "尊敬的司机", "#473C8B"));
	datas.add(new WxMpTemplateData("orderMoneySum", "100.0", "#473C8B"));
	datas.add(new WxMpTemplateData("orderProductName", "补胎救援-带内胎轮胎650R16", "#473C8B"));
	datas.add(new WxMpTemplateData("Remark", "点击\"详情\"，查看订单信息", "#473C8B"));*/
	
	@Override
	public void sendTemplateMessage(String template_id, String toUser, String url, List<WxMpTemplateData> datas) {
		
		WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
		templateMessage.setToUser(toUser);
		templateMessage.setTemplateId(template_id);
		templateMessage.setUrl(url);
		
		for(WxMpTemplateData data : datas){
			templateMessage.getDatas().add(data);
		}
		
		try{
			WxMpService helper = WeiXinFactory.getHelper();
			helper.templateSend(templateMessage);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
