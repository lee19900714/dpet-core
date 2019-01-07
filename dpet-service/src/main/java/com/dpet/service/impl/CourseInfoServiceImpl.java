package com.dpet.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpet.dao.CourseInfoMapper;
import com.dpet.model.CourseInfo;
import com.dpet.service.inter.CourseInfoService;

@Service
public class CourseInfoServiceImpl implements CourseInfoService {

	@Autowired
	private CourseInfoMapper courseInfoMapper;

	@Override
	public int deleteByPrimaryKey(Map<String,String> ids) {
		return courseInfoMapper.deleteByPrimaryKey(ids);
	}

	@Override
	public int insert(CourseInfo t) {
		return courseInfoMapper.insert(t);
	}

	@Override
	public int insertSelective(CourseInfo t) {
		return courseInfoMapper.insertSelective(t);
	}

	@Override
	public CourseInfo selectByPrimaryKey(String id) {
		return (CourseInfo) courseInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(CourseInfo t) {
		return courseInfoMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updateByPrimaryKey(CourseInfo t) {
		return courseInfoMapper.updateByPrimaryKey(t);
	}

	@Override
	public List<CourseInfo> getCourseInfoByType(Map<String, String> map) {
		return courseInfoMapper.getCourseInfoByType(map);
	}
}
