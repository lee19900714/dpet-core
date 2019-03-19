package com.dpet.model;

import java.util.Date;

public class CourseInfo extends MetaModel {
    private String id;

    private String courseName;

    private String courseTitle;

    private Integer courseType;

    private Integer courseLengthTime;

    private String courseDesc;

    private String courseLabel;

    private Double courseCost;

    private String courseImage;

    private Integer saleState;

    private Integer courseOrder;

    private String trainerInfo;

    private Integer level;

    private String learningStep;

    private Integer learningTimes = 0;

    private Integer joinerCount = 0;

    private Date createTime;

    private Date modifyTime;

    private String createId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle == null ? null : courseTitle.trim();
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public Integer getCourseLengthTime() {
        return courseLengthTime;
    }

    public void setCourseLengthTime(Integer courseLengthTime) {
        this.courseLengthTime = courseLengthTime;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc == null ? null : courseDesc.trim();
    }

    public String getCourseLabel() {
        return courseLabel;
    }

    public void setCourseLabel(String courseLabel) {
        this.courseLabel = courseLabel == null ? null : courseLabel.trim();
    }

    public Double getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(Double courseCost) {
        this.courseCost = courseCost;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage == null ? null : courseImage.trim();
    }

    public Integer getSaleState() {
        return saleState;
    }

    public void setSaleState(Integer saleState) {
        this.saleState = saleState;
    }

    public Integer getCourseOrder() {
        return courseOrder;
    }

    public void setCourseOrder(Integer courseOrder) {
        this.courseOrder = courseOrder;
    }

    public String getTrainerInfo() {
        return trainerInfo;
    }

    public void setTrainerInfo(String trainerInfo) {
        this.trainerInfo = trainerInfo == null ? null : trainerInfo.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLearningStep() {
        return learningStep;
    }

    public void setLearningStep(String learningStep) {
        this.learningStep = learningStep == null ? null : learningStep.trim();
    }

    public Integer getLearningTimes() {
        return learningTimes;
    }

    public void setLearningTimes(Integer learningTimes) {
        this.learningTimes = learningTimes;
    }

    public Integer getJoinerCount() {
        return joinerCount;
    }

    public void setJoinerCount(Integer joinerCount) {
        this.joinerCount = joinerCount;
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