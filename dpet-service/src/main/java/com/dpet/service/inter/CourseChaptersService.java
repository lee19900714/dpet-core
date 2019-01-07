package com.dpet.service.inter;

import java.util.List;

import com.dpet.model.CourseChapters;

public interface CourseChaptersService extends MetaService<CourseChapters> {

	List<CourseChapters> selectByCourseId(String courseId);
}