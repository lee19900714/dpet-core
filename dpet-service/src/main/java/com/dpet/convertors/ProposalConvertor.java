package com.dpet.convertors;

import com.dpet.model.Proposal;
import com.dpet.vo.ProposalVO;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

@Component
public class ProposalConvertor implements BeanConvertor<Proposal, ProposalVO> {

    @Override
    public Proposal convertModel(ProposalVO vo) {
        Proposal p = new Proposal();
        try {
            BeanUtils.copyProperties(p, vo);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public ProposalVO convertVO(Proposal model) {
        // TODO Auto-generated method stub
        return null;
    }
}
