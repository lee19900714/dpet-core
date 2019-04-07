package com.dpet.dao;

import com.dpet.model.SubscribeArticle;

import java.util.List;
import java.util.Map;

/**
 * The interface Subscribe article mapper.
 */
public interface SubscribeArticleMapper extends MetaMapper<SubscribeArticle> {

    /**
     * Select by user id and page list.
     *
     * @param userId the user id
     * @return the list
     */
    List<SubscribeArticle> selectByUserIdAndPage(String userId);

    /**
     * Select by article id subscribe article.
     *
     * @param map the article id
     * @return the subscribe article
     */
    SubscribeArticle selectByArticleId(Map map);

}