package com.dpet.service.inter;

import com.dpet.model.ArticleInfo;
import com.github.pagehelper.PageInfo;

public interface ArticleInfoService extends MetaService<ArticleInfo> {

	PageInfo<ArticleInfo> selectByPage(int pageNum, int pageSize);

}