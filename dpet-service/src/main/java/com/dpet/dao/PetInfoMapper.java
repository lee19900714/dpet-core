package com.dpet.dao;

import java.util.List;

import com.dpet.model.PetInfo;

public interface PetInfoMapper extends MetaMapper<PetInfo> {

	List<PetInfo> selectByUserId(String myselfId);
}