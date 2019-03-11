package com.dpet.service.inter;

import com.dpet.model.OrderInfo;
import com.github.pagehelper.Page;


public interface OrderInfoService extends MetaService<OrderInfo> {
    Page<OrderInfo> selectByUserId(String userId, int pageNum, int pageSize);
}