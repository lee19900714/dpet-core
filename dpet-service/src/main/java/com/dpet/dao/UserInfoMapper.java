package com.dpet.dao;

import com.dpet.model.UserInfo;

import java.util.Map;

public interface UserInfoMapper extends MetaMapper<UserInfo> {
    UserInfo selectByOpenId(Map map);
}