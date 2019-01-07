package com.dpet.model;

import java.util.Date;

public class PetTypeInfo extends MetaModel{
    private String id;

    private String petTypeName;

    private Integer petTypeNo;

    private String petIcon;

    private String isEnable;

    private Date createTime;

    private Date modifyTime;

    private String createId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPetTypeName() {
        return petTypeName;
    }

    public void setPetTypeName(String petTypeName) {
        this.petTypeName = petTypeName == null ? null : petTypeName.trim();
    }

    public Integer getPetTypeNo() {
        return petTypeNo;
    }

    public void setPetTypeNo(Integer petTypeNo) {
        this.petTypeNo = petTypeNo;
    }

    public String getPetIcon() {
        return petIcon;
    }

    public void setPetIcon(String petIcon) {
        this.petIcon = petIcon == null ? null : petIcon.trim();
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable == null ? null : isEnable.trim();
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