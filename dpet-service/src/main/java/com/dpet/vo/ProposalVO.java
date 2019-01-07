package com.dpet.vo;

public class ProposalVO extends MetaModelVO {

	private String id;

	private String proposal;

	private String proposalUrl;

	private String phoneNo;

	private String createTime;

	private String createId;

	public String getProposal() {
		return proposal;
	}

	public void setProposal(String proposal) {
		this.proposal = proposal;
	}

	public String getProposalUrl() {
		return proposalUrl;
	}

	public void setProposalUrl(String proposalUrl) {
		this.proposalUrl = proposalUrl;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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