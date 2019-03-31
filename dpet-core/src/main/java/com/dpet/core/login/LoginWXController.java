package com.dpet.core.login;

import com.alibaba.fastjson.JSONObject;
import com.dpet.commons.utils.GDPhoneUtil;
import com.dpet.commons.utils.UUIDUtil;
import com.dpet.commons.utils.WxConstanst;
import com.dpet.model.UserInfo;
import com.dpet.service.inter.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "login")
public class LoginWXController {

    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping(value = "/code2Session")
    @ResponseBody
    public Object code2Session(String code) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        String login_url = WxConstanst.LOGIN_URL + "appid=" + WxConstanst.APP_ID + "&secret=" + WxConstanst.APP_SECRET
                + "& js_code =" + code + "& grant_type = authorization_code";
        String jsonData = GDPhoneUtil.http(login_url, null, "GET", false, false);
        JSONObject jsonObject = JSONObject.parseObject(jsonData);
        String openId = jsonObject.getString("openid");
        String sessionKey = jsonObject.getString("session_key");
        UserInfo userInfo = userInfoService.selectByOpenId(openId);
        if (userInfo == null) {
            userInfoService.insert(this.creatUser(openId));
        }
        return resultMap;
    }

    private UserInfo creatUser(String openId) {
        UserInfo userInfo = new UserInfo();
        Date date = new Date();
        userInfo.setId(UUIDUtil.getUUID());
        userInfo.setOpenId(openId);
        userInfo.setCreateTime(date);
        userInfo.setUserType(1);
        userInfo.setLastActiveTime(date);
        return userInfo;
    }
}