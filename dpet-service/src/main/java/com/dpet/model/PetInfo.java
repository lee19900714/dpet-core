package com.dpet.model;

import java.util.Date;

public class PetInfo extends PetInfoKey {
    private String petName;

    private Integer petSex;

    private Date petBrithday;

    private Date homeDay;

    private Double petWeight;

    private Double petHeight;

    private Double petLength;

    private Integer anthelminticCondition;

    private Integer sterilizationCondition;

    private Integer vaccineCondition;

    private String petImageId;

    private Date modifyTime;

    private Date createTime;

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName == null ? null : petName.trim();
    }

    public Integer getPetSex() {
        return petSex;
    }

    public void setPetSex(Integer petSex) {
        this.petSex = petSex;
    }

    public Date getPetBrithday() {
        return petBrithday;
    }

    public void setPetBrithday(Date petBrithday) {
        this.petBrithday = petBrithday;
    }

    public Date getHomeDay() {
        return homeDay;
    }

    public void setHomeDay(Date homeDay) {
        this.homeDay = homeDay;
    }

    public Double getPetWeight() {
        return petWeight;
    }

    public void setPetWeight(Double petWeight) {
        this.petWeight = petWeight;
    }

    public Double getPetHeight() {
        return petHeight;
    }

    public void setPetHeight(Double petHeight) {
        this.petHeight = petHeight;
    }

    public Double getPetLength() {
        return petLength;
    }

    public void setPetLength(Double petLength) {
        this.petLength = petLength;
    }

    public Integer getAnthelminticCondition() {
        return anthelminticCondition;
    }

    public void setAnthelminticCondition(Integer anthelminticCondition) {
        this.anthelminticCondition = anthelminticCondition;
    }

    public Integer getSterilizationCondition() {
        return sterilizationCondition;
    }

    public void setSterilizationCondition(Integer sterilizationCondition) {
        this.sterilizationCondition = sterilizationCondition;
    }

    public Integer getVaccineCondition() {
        return vaccineCondition;
    }

    public void setVaccineCondition(Integer vaccineCondition) {
        this.vaccineCondition = vaccineCondition;
    }

    public String getPetImageId() {
        return petImageId;
    }

    public void setPetImageId(String petImageId) {
        this.petImageId = petImageId == null ? null : petImageId.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}