package com.dpet.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpet.dao.SubscribeCourseMapper;
import com.dpet.model.SubscribeCourse;
import com.dpet.service.inter.SubscribeCourseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SubscribeCourseServiceImpl implements SubscribeCourseService {
	
	@Autowired
	private SubscribeCourseMapper subscribeCourseMapper;

	@Override
	public int deleteByPrimaryKey(Map<String,String> ids) {
		return subscribeCourseMapper.deleteByPrimaryKey(ids);
	}

	@Override
	public int insert(SubscribeCourse t) {
		return subscribeCourseMapper.insert(t);
	}

	@Override
	public int insertSelective(SubscribeCourse t) {
		return subscribeCourseMapper.insertSelective(t);
	}

	@Override
	public SubscribeCourse selectByPrimaryKey(String id) {
		return (SubscribeCourse) subscribeCourseMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SubscribeCourse t) {
		return subscribeCourseMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updateByPrimaryKey(SubscribeCourse t) {
		return subscribeCourseMapper.updateByPrimaryKey(t);
	}

	@Override
	public Page<SubscribeCourse> selectByUserIdAndPage(String userId,
			int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return (Page<SubscribeCourse>) subscribeCourseMapper.selectByUserIdAndPage(userId);
		 
	}


}
