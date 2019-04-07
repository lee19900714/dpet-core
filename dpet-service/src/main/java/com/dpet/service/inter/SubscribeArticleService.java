package com.dpet.service.inter;

import com.dpet.model.SubscribeArticle;
import com.github.pagehelper.Page;

/**
 * The interface Subscribe article service.
 */
public interface SubscribeArticleService extends MetaService<SubscribeArticle> {

	/**
	 * Select by user id and page page.
	 *
	 * @param userId   the user id
	 * @param pageNum  the page num
	 * @param pageSize the page size
	 * @return the page
	 */
	Page<SubscribeArticle> selectByUserIdAndPage(String userId,
			int pageNum, int pageSize);

	/**
	 * Select by article id subscribe article.
	 *
	 * @param articleId the article id
	 * @return the subscribe article
	 */
	SubscribeArticle selectByArticleId(String articleId,String userId);

}