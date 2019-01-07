package com.dpet.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpet.dao.PetInfoMapper;
import com.dpet.model.PetInfo;
import com.dpet.service.inter.PetInfoService;

@Service
public class PetInfoServiceImpl implements PetInfoService {
	
	@Autowired
	private PetInfoMapper petInfoMapper;

	@Override
	public int deleteByPrimaryKey(Map<String,String> ids) {
		return petInfoMapper.deleteByPrimaryKey(ids);
	}

	@Override
	public int insert(PetInfo t) {
		return petInfoMapper.insert(t);
	}

	@Override
	public int insertSelective(PetInfo t) {
		return petInfoMapper.insertSelective(t);
	}

	@Override
	public PetInfo selectByPrimaryKey(String id) {
		return (PetInfo) petInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PetInfo t) {
		return petInfoMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updateByPrimaryKey(PetInfo t) {
		return petInfoMapper.updateByPrimaryKey(t);
	}

	@Override
	public List<PetInfo> selectByUserId(String myselfId) {
		return petInfoMapper.selectByUserId(myselfId);
	}

}
