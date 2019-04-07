package com.dpet.core.login;

import com.alibaba.fastjson.JSONObject;
import com.dpet.commons.utils.ActionUtil;
import com.dpet.commons.utils.DateUtil;
import com.dpet.commons.utils.UUIDUtil;
import com.dpet.commons.utils.WxConstanst;
import com.dpet.commons.vo.JWTUser;
import com.dpet.core.util.JedisPoolCacheUtils;
import com.dpet.framework.JWTUtil;
import com.dpet.model.UserInfo;
import com.dpet.paycenter.yeepay.utils.HttpUtil;
import com.dpet.service.inter.UserInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Login wx controller.
 */
@RestController
@RequestMapping(value = "login")
public class LoginWXController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private JedisPoolCacheUtils jedisPoolCacheUtils;


    /**
     * Code 2 session object.
     *
     * @param code the code
     * @return the object
     * @throws Exception the exception
     */
    @RequestMapping(value = "/code2Session")
    @ResponseBody
    public Object code2Session(String code, HttpServletResponse response) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        String login_url = WxConstanst.LOGIN_URL;
        String param = "appid=" + WxConstanst.APP_ID + "&secret=" + WxConstanst.APP_SECRET
                + "&js_code=" + code + "&grant_type=authorization_code";
        String jsonData = HttpUtil.sendGet(login_url, param);
        JSONObject jsonObject = JSONObject.parseObject(jsonData);
        String openId = jsonObject.getString("openid");
        String sessionKey = jsonObject.getString("session_key");
        if (StringUtils.isNotBlank(openId)) {
            UserInfo userInfo = userInfoService.selectByOpenId(openId);
            if (userInfo == null) {
                userInfo = this.creatUser(openId);
                userInfoService.insert(userInfo);
            }
            Date date = new Date();
            Date end = DateUtil.addDay(date, 7);
            jedisPoolCacheUtils.setex(userInfo.getId(), (int) ((end.getTime() - date.getTime()) / 1000), openId + "," + sessionKey);

            JWTUser jwtUser = setActionUser(userInfo);
            //设置token
            response.addHeader("x-auth-token", JWTUtil.sign(JSONObject.toJSONString(jwtUser), DateUtil.formatDateToString(end, DateUtil.ymd_HMS)));
        }
        return resultMap;
    }

    private UserInfo creatUser(String openId) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(UUIDUtil.getUUID());
        userInfo.setOpenId(openId);
        userInfo.setUserType(1);
        return userInfo;
    }

    private JWTUser setActionUser(UserInfo userInfo) {
        JWTUser user = new JWTUser();
        user.setUser_id(userInfo.getId());
        user.setProvider_key(userInfo.getOpenId());
        ActionUtil.setUser(user);
        return user;
    }
}