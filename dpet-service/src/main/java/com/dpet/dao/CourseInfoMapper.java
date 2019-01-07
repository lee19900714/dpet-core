package com.dpet.dao;

import java.util.List;
import java.util.Map;

import com.dpet.model.CourseInfo;

public interface CourseInfoMapper extends MetaMapper<CourseInfo>{
	
	List<CourseInfo> getCourseInfoByType(Map<String, String> map);
	
}