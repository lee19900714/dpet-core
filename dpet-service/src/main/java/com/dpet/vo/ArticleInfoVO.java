package com.dpet.vo;

public class ArticleInfoVO extends MetaModelVO {

    private String id;

    private String articleName;

    private String articlePicUrl;

    private String articleContent;

    private String readCount;

    private String collCount;

    private String articleTitle;

    private String articleOrder;

    private String createTime;

    private String modifyTime;

    private String createId;

    private String createName;

    private Boolean collect = false;

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticlePicUrl() {
        return articlePicUrl;
    }

    public void setArticlePicUrl(String articlePicUrl) {
        this.articlePicUrl = articlePicUrl;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getReadCount() {
        return readCount;
    }

    public void setReadCount(String readCount) {
        this.readCount = readCount;
    }

    public String getCollCount() {
        return collCount;
    }

    public void setCollCount(String collCount) {
        this.collCount = collCount;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleOrder() {
        return articleOrder;
    }

    public void setArticleOrder(String articleOrder) {
        this.articleOrder = articleOrder;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Boolean getCollect() {
        return collect;
    }

    public void setCollect(Boolean collect) {
        this.collect = collect;
    }
}