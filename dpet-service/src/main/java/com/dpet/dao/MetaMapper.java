package com.dpet.dao;

import java.util.Map;


/**
 * @author lee
 *
 * @param <T>
 */
public interface MetaMapper<T>{
	
	int deleteByPrimaryKey(Map<String,String> ids);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);
}
