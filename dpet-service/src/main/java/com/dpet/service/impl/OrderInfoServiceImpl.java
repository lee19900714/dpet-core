package com.dpet.service.impl;

import com.dpet.dao.OrderInfoMapper;
import com.dpet.model.OrderInfo;
import com.dpet.service.inter.OrderInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public int deleteByPrimaryKey(Map<String, String> ids) {
        return orderInfoMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public int insert(OrderInfo t) {
        return orderInfoMapper.insert(t);
    }

    @Override
    public int insertSelective(OrderInfo t) {
        return orderInfoMapper.insertSelective(t);
    }

    @Override
    public OrderInfo selectByPrimaryKey(String id) {
        return (OrderInfo) orderInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderInfo t) {
        return orderInfoMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int updateByPrimaryKey(OrderInfo t) {
        return orderInfoMapper.updateByPrimaryKey(t);
    }

    @Override
    public Page<OrderInfo> selectByUserId(String userId, String orderStatus, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("orderState", Integer.parseInt(orderStatus));
        return orderInfoMapper.selectByUserId(params);
    }
}
