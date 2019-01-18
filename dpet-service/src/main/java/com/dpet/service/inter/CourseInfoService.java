package com.dpet.service.inter;

import java.util.Map;

import com.dpet.model.CourseInfo;
import com.github.pagehelper.Page;


public interface CourseInfoService extends MetaService<CourseInfo>{
	
	Page<CourseInfo> getCourseInfoByType(Map<String, String> map,int pageNum,int pageSize);
}