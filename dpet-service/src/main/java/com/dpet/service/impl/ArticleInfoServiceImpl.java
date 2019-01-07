package com.dpet.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpet.dao.ArticleInfoMapper;
import com.dpet.model.ArticleInfo;
import com.dpet.service.inter.ArticleInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ArticleInfoServiceImpl implements ArticleInfoService {

	@Autowired
	private ArticleInfoMapper articleInfoMapper;

	@Override
	public int deleteByPrimaryKey(Map<String,String> ids) {
		return articleInfoMapper.deleteByPrimaryKey(ids);
	}

	@Override
	public int insert(ArticleInfo t) {
		return articleInfoMapper.insert(t);
	}

	@Override
	public int insertSelective(ArticleInfo t) {
		return articleInfoMapper.insertSelective(t);
	}

	@Override
	public ArticleInfo selectByPrimaryKey(String id) {
		return (ArticleInfo) articleInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ArticleInfo t) {
		return articleInfoMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updateByPrimaryKey(ArticleInfo t) {
		return articleInfoMapper.updateByPrimaryKey(t);
	}

	@Override
	public PageInfo<ArticleInfo> selectByPage(int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return (PageInfo<ArticleInfo>) articleInfoMapper.selectByPage();
	}
}
