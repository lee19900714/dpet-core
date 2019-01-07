package com.dpet.model;

public class OrderInfoKey extends MetaModel{
    private String id;

    private String orderNo;

    private String buyCourseId;

    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getBuyCourseId() {
        return buyCourseId;
    }

    public void setBuyCourseId(String buyCourseId) {
        this.buyCourseId = buyCourseId == null ? null : buyCourseId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}