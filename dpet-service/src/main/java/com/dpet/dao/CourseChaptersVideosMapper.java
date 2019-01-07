package com.dpet.dao;

import java.util.List;

import com.dpet.model.CourseChaptersVideos;
import com.dpet.model.CourseChaptersVideosKey;

public interface CourseChaptersVideosMapper extends MetaMapper<CourseChaptersVideosKey>{

	List<CourseChaptersVideos> selectByCourseChaptersId(String courseChaptersId);

}