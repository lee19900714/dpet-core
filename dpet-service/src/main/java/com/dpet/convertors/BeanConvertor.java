package com.dpet.convertors;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public interface BeanConvertor<M, V> {

    public M convertModel(V vo);

    public V convertVO(M model);

    default List<M> convertModelList(List<V> listvo) {
        List<M> list = new ArrayList<>();
        if (!CollectionUtils.isEmpty(listvo)) {
            listvo.forEach(r -> list.add(convertModel(r)));
        }
        return list;
    }

    default List<V> convertVOList(List<M> list) {
        List<V> listvo = new ArrayList<>();
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(r -> listvo.add(convertVO(r)));
        }
        return listvo;
    }

}
