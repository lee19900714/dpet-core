package com.dpet.dao;

import java.util.List;

import com.dpet.model.PetTypeInfo;

public interface PetTypeInfoMapper extends MetaMapper<PetTypeInfo> {

	List<PetTypeInfo> selectAll();
	
}