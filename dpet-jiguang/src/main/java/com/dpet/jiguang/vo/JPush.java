package com.dpet.jiguang.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.dpet.commons.Constants;
import com.dpet.jiguang.config.JPushConfig;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.PushPayload.Builder;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class JPush implements Runnable{
	
	private static Logger logger = LoggerFactory.getLogger(JPush.class);

	private int type;
	
	private Map<String, Object> datas;
	
	private Set<String> aliasList;
	
	private JPushClient jPushClient = JPushConfig.getJPushClient();
	
	public JPush(int type, Map<String, Object> datas, String user_id) {
		this.type = type;
		this.datas = datas;
		aliasList = new HashSet<String>();
		aliasList.add(user_id);
	}

	public JPush(int type, Map<String, Object> datas, List<String> user_ids) {
		this.type = type;
		this.datas = datas;
		aliasList = new HashSet<String>();
		for(String user_id : user_ids){
			aliasList.add(user_id);
		}
	}
	
	/**
     * 推送别名列表的用户
     * @param aliasList 别名列表
     * @param notification_title 通知内容标题
     * @param msg_title 消息内容标题
     * @param msg_content 消息内容
     * @param extrasparam 扩展字段
     * @return 0推送失败，1推送成功
     */
    public int pushMessage(Set<String> aliasList) {
        int result = 0;
        try {
        	if(type == Constants.JPUSH_MESSAGE_TYPE_NOTIFI){
        		datas.put("push_type", "notice");
        	}else if(type == Constants.JPUSH_MESSAGE_TYPE_TOUCHUAN){
        		datas.put("push_type", "message");
        	}
        	
        	String msg_title = "消息标题";
        	String msg_content = "消息内容";
        	if(datas.get("msg_title") != null){
        		msg_title = String.valueOf(datas.get("msg_title"));
        	}
        	if(datas.get("msg_content") != null){
        		msg_content = String.valueOf(datas.get("msg_content"));
        	}
        	
            PushPayload pushPayload = buildPushPayload(aliasList, msg_title, msg_title, msg_content, JSON.toJSONString(datas));
            PushResult pushResult = jPushClient.sendPush(pushPayload);
            if(pushResult.getResponseCode() == 200){
                result = 1;
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }
        return result;
    }
    
    private PushPayload buildPushPayload(Set<String> aliasList,String notification_title, String msg_title, String msg_content, String extrasparam) {
    	Builder builder = PushPayload.newBuilder()
                //指定要推送的平台，all代表当前应用配置了的所有平台，也可以传android等具体平台
                .setPlatform(Platform.all())
                //指定推送的接收对象，all代表所有人，也可以指定已经设置成功的tag或alias或该应应用客户端调用接口获取到的registration id
                .setAudience(Audience.alias(aliasList));
    	if(type == Constants.JPUSH_MESSAGE_TYPE_NOTIFI){
    		builder.setNotification(Notification.newBuilder()
                    //指定当前推送的android通知
                    .addPlatformNotification(AndroidNotification.newBuilder()
                            .setAlert(notification_title)
                            .setTitle(notification_title)
                            //此字段为透传字段，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
                            .addExtra("info",extrasparam)
                            .build())
                    //指定当前推送的iOS通知
                    .addPlatformNotification(IosNotification.newBuilder()
                            //传一个IosAlert对象，指定apns title、title、subtitle等
                            .setAlert(notification_title)
                            //直接传alert
                            //此项是指定此推送的badge自动加1
                            .incrBadge(1)
                            //此字段的值default表示系统默认声音；传sound.caf表示此推送以项目里面打包的sound.caf声音来提醒，
                            // 如果系统没有此音频则以系统默认声音提醒；此字段如果传空字符串，iOS9及以上的系统是无声音提醒，以下的系统是默认声音
                            .setSound("sound.caf")
                            //此字段为透传字段，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
                            .addExtra("info",extrasparam)
                            //此项说明此推送是一个background推送，想了解background看：http://docs.jpush.io/client/ios_tutorials/#ios-7-background-remote-notification
                            //取消此注释，消息推送时ios将无法在锁屏情况接收
                            // .setContentAvailable(true)
                            .build())
                    .build());
    	}else{
    		builder.setMessage(Message.newBuilder()
                   .setMsgContent(msg_content)
                   .setTitle(msg_title)
                   .addExtra("info",extrasparam)
                   .build());
    	}
    	return  builder.setOptions(Options.newBuilder()
                //此字段的值是用来指定本推送要推送的apns环境，false表示开发，true表示生产；对android和自定义消息无意义
                .setApnsProduction(false)
                //此字段是给开发者自己给推送编号，方便推送者分辨推送记录
                .setSendno(1)
                //此字段的值是用来指定本推送的离线保存时长，如果不传此字段则默认保存一天，最多指定保留十天；
                .setTimeToLive(86400)
                .build())
    			.build();
    }

	@Override
	public void run() {
		logger.info("极光推送target="+ JSON.toJSONString(this.aliasList));
		String result = pushMessage(this.aliasList)==1?"成功":"失败";
		logger.info("极光推送result="+ result);
	}
}
