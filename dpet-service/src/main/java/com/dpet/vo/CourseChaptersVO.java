package com.dpet.vo;


public class CourseChaptersVO extends CourseChaptersKeyVO {
    private String courseChapters;

    private String chapterOrder;

    private String createTime;

    private String modifyTime;

    private String createId;

	public String getCourseChapters() {
		return courseChapters;
	}

	public void setCourseChapters(String courseChapters) {
		this.courseChapters = courseChapters;
	}

	public String getChapterOrder() {
		return chapterOrder;
	}

	public void setChapterOrder(String chapterOrder) {
		this.chapterOrder = chapterOrder;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

    
}