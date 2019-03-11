package com.dpet.service.inter;

import com.dpet.model.ArticleInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface ArticleInfoService extends MetaService<ArticleInfo> {

	Page<ArticleInfo> selectByPage(int pageNum, int pageSize);

}