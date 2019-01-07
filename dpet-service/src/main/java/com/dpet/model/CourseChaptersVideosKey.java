package com.dpet.model;

public class CourseChaptersVideosKey extends MetaModel{
    private String id;

    private String courseChaptersId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCourseChaptersId() {
        return courseChaptersId;
    }

    public void setCourseChaptersId(String courseChaptersId) {
        this.courseChaptersId = courseChaptersId == null ? null : courseChaptersId.trim();
    }
}