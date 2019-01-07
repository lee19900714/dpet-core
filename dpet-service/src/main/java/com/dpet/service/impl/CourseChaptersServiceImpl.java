package com.dpet.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpet.dao.CourseChaptersMapper;
import com.dpet.model.CourseChapters;
import com.dpet.service.inter.CourseChaptersService;

@Service
public class CourseChaptersServiceImpl implements CourseChaptersService {
	
	@Autowired
	private CourseChaptersMapper courseChaptersMapper;

	@Override
	public int deleteByPrimaryKey(Map<String,String> ids) {
		return courseChaptersMapper.deleteByPrimaryKey(ids);
	}

	@Override
	public int insert(CourseChapters t) {
		return courseChaptersMapper.insert(t);
	}

	@Override
	public int insertSelective(CourseChapters t) {
		return courseChaptersMapper.insertSelective(t);
	}

	@Override
	public CourseChapters selectByPrimaryKey(String id) {
		return (CourseChapters) courseChaptersMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(CourseChapters t) {
		return courseChaptersMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updateByPrimaryKey(CourseChapters t) {
		return courseChaptersMapper.updateByPrimaryKey(t);
	}

	@Override
	public List<CourseChapters> selectByCourseId(String courseId) {
		return courseChaptersMapper.selectByCourseId(courseId);
	}

}
