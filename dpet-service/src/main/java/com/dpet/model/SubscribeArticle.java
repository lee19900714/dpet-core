package com.dpet.model;

import java.util.Date;

public class SubscribeArticle extends SubscribeArticleKey {
    private Date subscribeTime;

    private Date createTime;

    public Date getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}