package com.dpet.service.inter;

import java.util.List;

import com.dpet.model.PetInfo;

public interface PetInfoService extends MetaService<PetInfo>{

	List<PetInfo> selectByUserId(String myselfId);
	
}