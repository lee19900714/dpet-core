package com.dpet.model;

import java.util.Date;

public class PetImageInfo extends PetImageInfoKey {
    private String petImageUrl;

    private String checker;

    private String checkedOpinion;

    private Date checkedTime;

    private Integer isChecked;

    private Date createTime;

    private Date modifyTime;

    private String createId;

    public String getPetImageUrl() {
        return petImageUrl;
    }

    public void setPetImageUrl(String petImageUrl) {
        this.petImageUrl = petImageUrl == null ? null : petImageUrl.trim();
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker == null ? null : checker.trim();
    }

    public String getCheckedOpinion() {
        return checkedOpinion;
    }

    public void setCheckedOpinion(String checkedOpinion) {
        this.checkedOpinion = checkedOpinion == null ? null : checkedOpinion.trim();
    }

    public Date getCheckedTime() {
        return checkedTime;
    }

    public void setCheckedTime(Date checkedTime) {
        this.checkedTime = checkedTime;
    }

    public Integer getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Integer isChecked) {
        this.isChecked = isChecked;
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