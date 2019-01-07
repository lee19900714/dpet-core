package com.dpet.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpet.dao.CourseChaptersVideosMapper;
import com.dpet.model.CourseChaptersVideos;
import com.dpet.service.inter.CourseChaptersVideosService;

@Service
public class CourseChaptersVideosServiceImpl implements CourseChaptersVideosService {
	
	@Autowired
	private CourseChaptersVideosMapper courseChaptersVideosMapper;

	@Override
	public int deleteByPrimaryKey(Map<String,String> ids) {
		return courseChaptersVideosMapper.deleteByPrimaryKey(ids);
	}

	@Override
	public int insert(CourseChaptersVideos t) {
		return courseChaptersVideosMapper.insert(t);
	}

	@Override
	public int insertSelective(CourseChaptersVideos t) {
		return courseChaptersVideosMapper.insertSelective(t);
	}

	@Override
	public CourseChaptersVideos selectByPrimaryKey(String id) {
		return (CourseChaptersVideos) courseChaptersVideosMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(CourseChaptersVideos t) {
		return courseChaptersVideosMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updateByPrimaryKey(CourseChaptersVideos t) {
		return courseChaptersVideosMapper.updateByPrimaryKey(t);
	}

	@Override
	public List<CourseChaptersVideos> selectByCourseChaptersId(
			String courseChaptersId) {
		return courseChaptersVideosMapper.selectByCourseChaptersId(courseChaptersId);
	}

}
