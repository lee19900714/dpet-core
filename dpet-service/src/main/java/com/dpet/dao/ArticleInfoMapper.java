package com.dpet.dao;

import java.util.List;

import com.dpet.model.ArticleInfo;

public interface ArticleInfoMapper extends MetaMapper<ArticleInfo> {
	List<ArticleInfo> selectByPage();
}