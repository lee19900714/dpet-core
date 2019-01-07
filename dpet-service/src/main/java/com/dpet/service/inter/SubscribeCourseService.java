package com.dpet.service.inter;

import com.dpet.model.SubscribeCourse;
import com.github.pagehelper.Page;

public interface SubscribeCourseService extends MetaService<SubscribeCourse>{
	
	Page<SubscribeCourse> selectByUserIdAndPage(String userId,
			int pageNum, int pageSize);
}