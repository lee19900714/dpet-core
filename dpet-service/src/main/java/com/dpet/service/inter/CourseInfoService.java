package com.dpet.service.inter;

import java.util.List;
import java.util.Map;

import com.dpet.model.CourseInfo;


public interface CourseInfoService extends MetaService<CourseInfo>{
	
	List<CourseInfo> getCourseInfoByType(Map<String, String> map);
}