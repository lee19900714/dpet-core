package com.dpet.jiguang.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dpet.commons.Constants;
import com.dpet.jiguang.service.JPushService;
import com.dpet.jiguang.vo.JPush;

@Service("jPushServiceImpl")
public class JPushServiceImpl implements JPushService{

	@Override
	public void pushMessage(Map<String, Object> datas, String user_id) {
		JPush push = new JPush(Constants.JPUSH_MESSAGE_TYPE_TOUCHUAN, datas, user_id); 
		new Thread(push).start();
	}

	@Override
	public void pushMessage(Map<String, Object> datas, List<String> user_ids) {
		JPush push = new JPush(Constants.JPUSH_MESSAGE_TYPE_TOUCHUAN, datas, user_ids); 
		new Thread(push).start();
	}

	@Override
	public void pushNotice(Map<String, Object> datas, String user_id) {
		JPush push = new JPush(Constants.JPUSH_MESSAGE_TYPE_NOTIFI, datas, user_id); 
		new Thread(push).start();
	}

	@Override
	public void pushNotice(Map<String, Object> datas, List<String> user_ids) {
		JPush push = new JPush(Constants.JPUSH_MESSAGE_TYPE_NOTIFI, datas, user_ids); 
		new Thread(push).start();
	}
	
	

}
