package com.dpet.model;

import java.util.Date;

public class CourseChaptersVideos extends CourseChaptersVideosKey {
    private String videoName;

    private Integer videoLengthTime;

    private String videoImageUrl;

    private Integer videoOrder;

    private String videoUrl;

    private String points;

    private String pointPicUrl;

    private Date createTime;

    private Date modifyTime;

    private String createId;

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
    }

    public Integer getVideoLengthTime() {
        return videoLengthTime;
    }

    public void setVideoLengthTime(Integer videoLengthTime) {
        this.videoLengthTime = videoLengthTime;
    }

    public String getVideoImageUrl() {
        return videoImageUrl;
    }

    public void setVideoImageUrl(String videoImageUrl) {
        this.videoImageUrl = videoImageUrl == null ? null : videoImageUrl.trim();
    }

    public Integer getVideoOrder() {
        return videoOrder;
    }

    public void setVideoOrder(Integer videoOrder) {
        this.videoOrder = videoOrder;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points == null ? null : points.trim();
    }

    public String getPointPicUrl() {
        return pointPicUrl;
    }

    public void setPointPicUrl(String pointPicUrl) {
        this.pointPicUrl = pointPicUrl == null ? null : pointPicUrl.trim();
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