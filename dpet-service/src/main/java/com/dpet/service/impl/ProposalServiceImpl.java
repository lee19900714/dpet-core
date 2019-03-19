package com.dpet.service.impl;

import com.dpet.dao.ProposalMapper;
import com.dpet.model.Proposal;
import com.dpet.service.inter.ProposalService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author lijun
 */
@SuppressWarnings("ALL")
@Service
public class ProposalServiceImpl implements ProposalService {

    @Autowired
    private ProposalMapper proposalMapper;

    @Override
    public int deleteByPrimaryKey(Map<String, String> ids) {
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

    @Override
    public Page<Proposal> selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return proposalMapper.selectAll();
    }
}
