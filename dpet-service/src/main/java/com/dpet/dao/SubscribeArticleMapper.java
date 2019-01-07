package com.dpet.dao;

import java.util.List;

import com.dpet.model.SubscribeArticle;

public interface SubscribeArticleMapper extends MetaMapper<SubscribeArticle> {
	
	List<SubscribeArticle> selectByUserIdAndPage(String userId);
	
}