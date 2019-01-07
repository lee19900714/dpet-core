package com.dpet.dao;

import java.util.List;

import com.dpet.model.SubscribeCourse;
import com.dpet.model.SubscribeCourseKey;

public interface SubscribeCourseMapper extends MetaMapper<SubscribeCourseKey> {

	List<SubscribeCourse> selectByUserIdAndPage(String userId);
}