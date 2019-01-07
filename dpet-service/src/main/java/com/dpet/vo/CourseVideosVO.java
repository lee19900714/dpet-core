package com.dpet.vo;

import java.util.List;

public class CourseVideosVO extends MetaModelVO {

	private CourseChaptersVO courseChaptersVO;

	private List<CourseChaptersVideosVO> courseChaptersVideosVOS;

	public CourseChaptersVO getCourseChaptersVO() {
		return courseChaptersVO;
	}

	public void setCourseChaptersVO(CourseChaptersVO courseChaptersVO) {
		this.courseChaptersVO = courseChaptersVO;
	}

	public List<CourseChaptersVideosVO> getCourseChaptersVideosVOS() {
		return courseChaptersVideosVOS;
	}

	public void setCourseChaptersVideosVOS(
			List<CourseChaptersVideosVO> courseChaptersVideosVOS) {
		this.courseChaptersVideosVOS = courseChaptersVideosVOS;
	}

}
