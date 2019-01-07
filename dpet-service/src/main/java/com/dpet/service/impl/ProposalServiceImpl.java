package com.dpet.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpet.dao.ProposalMapper;
import com.dpet.model.Proposal;
import com.dpet.service.inter.ProposalService;

@Service
public class ProposalServiceImpl implements ProposalService {
	
	@Autowired
	private ProposalMapper proposalMapper;

	@Override
	public int deleteByPrimaryKey(Map<String,String> ids) {
		return proposalMapper.deleteByPrimaryKey(ids);
	}

	@Override
	public int insert(Proposal t) {
		return proposalMapper.insert(t);
	}

	@Override
	public int insertSelective(Proposal t) {
		return proposalMapper.insertSelective(t);
	}

	@Override
	public Proposal selectByPrimaryKey(String id) {
		return (Proposal) proposalMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Proposal t) {
		return proposalMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updateByPrimaryKey(Proposal t) {
		return proposalMapper.updateByPrimaryKey(t);
	}
}
