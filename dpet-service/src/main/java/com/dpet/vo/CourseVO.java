package com.dpet.vo;

import java.util.List;

public class CourseVO extends MetaModelVO {
	
	private CourseInfoVO courseInfoVO;
	
	private List<CourseVideosVO> courseVideosVOS;

	public CourseInfoVO getCourseInfoVO() {
		return courseInfoVO;
	}

	public void setCourseInfoVO(CourseInfoVO courseInfoVO) {
		this.courseInfoVO = courseInfoVO;
	}

	public List<CourseVideosVO> getCourseVideosVOS() {
		return courseVideosVOS;
	}

	public void setCourseVideosVOS(List<CourseVideosVO> courseVideosVOS) {
		this.courseVideosVOS = courseVideosVOS;
	}
	
	

}
