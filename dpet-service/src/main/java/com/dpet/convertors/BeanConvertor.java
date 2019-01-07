package com.dpet.convertors;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

public interface BeanConvertor<M, V> {

	public M convertModel(V vo);

	public V convertVO(M model);

	public List<M> convertModelList(List<V> listvo);

	public List<V> convertVOList(List<M> listvo);

}
