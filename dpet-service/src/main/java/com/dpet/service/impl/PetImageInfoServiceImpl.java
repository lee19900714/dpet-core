package com.dpet.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpet.dao.PetImageInfoMapper;
import com.dpet.model.PetImageInfo;
import com.dpet.service.inter.PetImageInfoService;

@Service
public class PetImageInfoServiceImpl implements PetImageInfoService {
	
	@Autowired
	private PetImageInfoMapper petImageInfoMapper;

	@Override
	public int deleteByPrimaryKey(Map<String,String> ids) {
		return petImageInfoMapper.deleteByPrimaryKey(ids);
	}

	@Override
	public int insert(PetImageInfo t) {
		return petImageInfoMapper.insert(t);
	}

	@Override
	public int insertSelective(PetImageInfo t) {
		return petImageInfoMapper.insertSelective(t);
	}

	@Override
	public PetImageInfo selectByPrimaryKey(String id) {
		return (PetImageInfo) petImageInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PetImageInfo t) {
		return petImageInfoMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updateByPrimaryKey(PetImageInfo t) {
		return petImageInfoMapper.updateByPrimaryKey(t);
	}

}
