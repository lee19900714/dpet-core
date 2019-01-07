package com.dpet.convertors;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;

import com.dpet.model.Proposal;
import com.dpet.vo.ProposalVO;

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

	@Override
	public List<Proposal> convertModelList(List<ProposalVO> listvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProposalVO> convertVOList(List<Proposal> listvo) {
		// TODO Auto-generated method stub
		return null;
	}

}
