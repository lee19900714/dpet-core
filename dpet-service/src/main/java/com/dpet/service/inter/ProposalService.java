package com.dpet.service.inter;

import com.dpet.model.Proposal;
import com.github.pagehelper.Page;

/**
 * @author lijun
 */
@SuppressWarnings("ALL")
public interface ProposalService extends MetaService<Proposal> {
    /**
     * 查出所有的反馈意见
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Proposal> selectAll(int pageNum, int pageSize);
}