package com.dpet.dao;

import com.dpet.model.OrderInfo;
import com.github.pagehelper.Page;

public interface OrderInfoMapper extends MetaMapper<OrderInfo> {
    Page<OrderInfo> selectByUserId(String userId);
}