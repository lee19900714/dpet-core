package com.dpet.service.inter;

import java.util.Map;


public interface MetaService<T>{
	
	int deleteByPrimaryKey(Map<String,String> ids);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);
}
