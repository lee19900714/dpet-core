package com.dpet.dao;

import com.dpet.model.OrderInfo;
import com.github.pagehelper.Page;

import java.util.Map;

public interface OrderInfoMapper extends MetaMapper<OrderInfo> {
    Page<OrderInfo> selectByUserId(Map<String, Object> param);
}