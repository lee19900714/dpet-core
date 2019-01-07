package com.dpet.dao;

import java.util.List;

import com.dpet.model.CourseChapters;

public interface CourseChaptersMapper extends MetaMapper<CourseChapters>{
	
	List<CourseChapters> selectByCourseId(String courseId);
	
}