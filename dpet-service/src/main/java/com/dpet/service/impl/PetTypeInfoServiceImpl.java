package com.dpet.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpet.dao.PetTypeInfoMapper;
import com.dpet.model.PetTypeInfo;
import com.dpet.service.inter.PetTypeInfoService;

@Service
public class PetTypeInfoServiceImpl implements PetTypeInfoService {
	
	@Autowired
	private PetTypeInfoMapper petTypeInfoMapper;

	@Override
	public int deleteByPrimaryKey(Map<String,String> ids) {
		return petTypeInfoMapper.deleteByPrimaryKey(ids);
	}

	@Override
	public int insert(PetTypeInfo t) {
		return petTypeInfoMapper.insert(t);
	}

	@Override
	public int insertSelective(PetTypeInfo t) {
		return petTypeInfoMapper.insertSelective(t);
	}

	@Override
	public PetTypeInfo selectByPrimaryKey(String id) {
		return (PetTypeInfo) petTypeInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PetTypeInfo t) {
		return petTypeInfoMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updateByPrimaryKey(PetTypeInfo t) {
		return petTypeInfoMapper.updateByPrimaryKey(t);
	}

	@Override
	public List<PetTypeInfo> selectAll() {
		return petTypeInfoMapper.selectAll();
	}

}
