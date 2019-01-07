package com.dpet.service.inter;

import java.util.List;

import com.dpet.model.CourseChaptersVideos;

public interface CourseChaptersVideosService extends
		MetaService<CourseChaptersVideos> {
	
	List<CourseChaptersVideos> selectByCourseChaptersId(String courseChaptersId);
}