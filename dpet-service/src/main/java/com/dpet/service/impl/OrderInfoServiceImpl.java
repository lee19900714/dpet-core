package com.dpet.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpet.dao.OrderInfoMapper;
import com.dpet.model.OrderInfo;
import com.dpet.service.inter.OrderInfoService;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
	
	@Autowired
	private OrderInfoMapper orderInfoMapper;

	@Override
	public int deleteByPrimaryKey(Map<String,String> ids) {
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
}
