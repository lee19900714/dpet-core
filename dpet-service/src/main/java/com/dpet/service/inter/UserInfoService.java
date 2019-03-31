package com.dpet.service.inter;

import com.dpet.model.UserInfo;

public interface UserInfoService extends MetaService<UserInfo> {
    UserInfo selectByOpenId(String openId);
}