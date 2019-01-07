package com.dpet.service.inter;

import com.dpet.model.SubscribeArticle;
import com.github.pagehelper.Page;

public interface SubscribeArticleService extends MetaService<SubscribeArticle> {

	Page<SubscribeArticle> selectByUserIdAndPage(String userId,
			int pageNum, int pageSize);

}