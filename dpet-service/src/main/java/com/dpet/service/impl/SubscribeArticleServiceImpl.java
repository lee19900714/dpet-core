package com.dpet.service.impl;

import com.dpet.dao.SubscribeArticleMapper;
import com.dpet.model.SubscribeArticle;
import com.dpet.service.inter.SubscribeArticleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ALL")
@Service
public class SubscribeArticleServiceImpl implements SubscribeArticleService {

    @Autowired
    private SubscribeArticleMapper subscribeArticleMapper;

    @Override
    public int deleteByPrimaryKey(Map<String, String> ids) {
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

    @Override
    public SubscribeArticle selectByArticleId(String articleId, String userId) {
        Map<String,Object> params = new HashMap<>();
        params.put("articleId",articleId);
        params.put("userId",userId);
        return subscribeArticleMapper.selectByArticleId(params);
    }

}
