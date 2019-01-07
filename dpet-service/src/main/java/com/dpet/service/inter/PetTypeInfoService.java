package com.dpet.service.inter;

import java.util.List;

import com.dpet.model.PetTypeInfo;

public interface PetTypeInfoService extends MetaService<PetTypeInfo> {
	public List<PetTypeInfo> selectAll();
}