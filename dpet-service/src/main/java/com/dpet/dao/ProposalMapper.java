package com.dpet.dao;

import com.dpet.model.Proposal;
import com.github.pagehelper.Page;

/**
 * @author lijun
 */
@SuppressWarnings("ALL")
public interface ProposalMapper extends MetaMapper<Proposal> {
    /**
     * 查出所有的反馈意见
     *
     * @return
     */
    Page<Proposal> selectAll();
}
