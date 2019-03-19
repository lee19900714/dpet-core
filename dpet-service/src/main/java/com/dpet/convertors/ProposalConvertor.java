package com.dpet.convertors;

import com.dpet.commons.utils.DateUtil;
import com.dpet.model.Proposal;
import com.dpet.vo.ProposalVO;
import org.springframework.stereotype.Component;

/**
 * @author lijun
 */
@SuppressWarnings("ALL")
@Component
public class ProposalConvertor implements BeanConvertor<Proposal, ProposalVO> {

    @Override
    public Proposal convertModel(ProposalVO vo) {
        Proposal p = new Proposal();
        p.setPhoneNo(vo.getPhoneNo());
        p.setProposal(vo.getProposal());
        p.setProposalUrl(vo.getProposalUrl());
        p.setCreateTime(DateUtil.formatStringToDate(vo.getCreateTime(),DateUtil.Y_M_D_HMS));
        p.setCreateId(vo.getCreateId());
        return p;
    }

    @Override
    public ProposalVO convertVO(Proposal model) {
        ProposalVO p = new ProposalVO();
        p.setPhoneNo(model.getPhoneNo());
        p.setProposal(model.getProposal());
        p.setProposalUrl(model.getProposalUrl());
        p.setCreateTime(DateUtil.formatDateToString(model.getCreateTime(),DateUtil.Y_M_D_HMS));
        p.setCreateId(model.getCreateId());
        return p;
    }
}
