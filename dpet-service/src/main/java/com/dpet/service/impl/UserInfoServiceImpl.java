package com.dpet.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpet.dao.UserInfoMapper;
import com.dpet.model.UserInfo;
import com.dpet.service.inter.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int deleteByPrimaryKey(Map<String, String> ids) {
        return userInfoMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public int insert(UserInfo t) {
        return userInfoMapper.insert(t);
    }

    @Override
    public int insertSelective(UserInfo t) {
        return userInfoMapper.insertSelective(t);
    }

    @Override
    public UserInfo selectByPrimaryKey(String id) {
        return (UserInfo) userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo t) {
        return userInfoMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int updateByPrimaryKey(UserInfo t) {
        return userInfoMapper.updateByPrimaryKey(t);
    }

    @Override
    public UserInfo selectByOpenId(String openId) {
        Map<String, Object> map = new HashMap<>();
        map.put("openId", openId);
        return userInfoMapper.selectByOpenId(map);
    }
}
