package com.dpet.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpet.dao.SubscribeArticleMapper;
import com.dpet.model.SubscribeArticle;
import com.dpet.service.inter.SubscribeArticleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@SuppressWarnings("ALL")
@Service
public class SubscribeArticleServiceImpl implements SubscribeArticleService {
	
	@Autowired
	private SubscribeArticleMapper subscribeArticleMapper;

	@Override
	public int deleteByPrimaryKey(Map<String,String> ids) {
		return subscribeArticleMapper.deleteByPrimaryKey(ids);
	}

	@Override
	public int insert(SubscribeArticle t) {
		return subscribeArticleMapper.insert(t);
	}

	@Override
	public int insertSelective(SubscribeArticle t) {
		return subscribeArticleMapper.insertSelective(t);
	}

	@Override
	public SubscribeArticle selectByPrimaryKey(String id) {
		return (SubscribeArticle) subscribeArticleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SubscribeArticle t) {
		return subscribeArticleMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updateByPrimaryKey(SubscribeArticle t) {
		return subscribeArticleMapper.updateByPrimaryKey(t);
	}
	
	@Override
	public Page<SubscribeArticle> selectByUserIdAndPage(String userId, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return (Page<SubscribeArticle>) subscribeArticleMapper.selectByUserIdAndPage(userId);
	}

}
