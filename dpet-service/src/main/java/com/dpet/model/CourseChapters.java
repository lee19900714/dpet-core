package com.dpet.model;

import java.util.Date;

public class CourseChapters extends CourseChaptersKey {
    private String courseChapters;

    private Integer chapterOrder;

    private Date createTime;

    private Date modifyTime;

    private String createId;

    public String getCourseChapters() {
        return courseChapters;
    }

    public void setCourseChapters(String courseChapters) {
        this.courseChapters = courseChapters == null ? null : courseChapters.trim();
    }

    public Integer getChapterOrder() {
        return chapterOrder;
    }

    public void setChapterOrder(Integer chapterOrder) {
        this.chapterOrder = chapterOrder;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }
}