package com.dpet.vo;


public class PetTypeInfoVO extends MetaModelVO {
	
	private String id;

	private String petTypeName;

	private String petTypeNo;

	private String petIcon;

	private String isEnable;

	private String createTime;

	private String modifyTime;

	private String createId;

	public String getPetTypeName() {
		return petTypeName;
	}

	public void setPetTypeName(String petTypeName) {
		this.petTypeName = petTypeName;
	}

	public String getPetTypeNo() {
		return petTypeNo;
	}

	public void setPetTypeNo(String petTypeNo) {
		this.petTypeNo = petTypeNo;
	}

	public String getPetIcon() {
		return petIcon;
	}

	public void setPetIcon(String petIcon) {
		this.petIcon = petIcon;
	}

	public String getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
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

}