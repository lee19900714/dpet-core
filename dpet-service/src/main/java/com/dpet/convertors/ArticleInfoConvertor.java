package com.dpet.convertors;

import com.dpet.commons.utils.DateUtil;
import com.dpet.model.ArticleInfo;
import com.dpet.vo.ArticleInfoVO;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ArticleInfoConvertor implements BeanConvertor<ArticleInfo, ArticleInfoVO> {

    @Override
    public ArticleInfo convertModel(ArticleInfoVO vo) {
        ArticleInfo model = new ArticleInfo();
        model.setArticleContent(vo.getArticleContent());
        model.setArticleName(vo.getArticleName());
        model.setArticleOrder(Integer.parseInt(vo.getArticleOrder()));
        model.setArticlePicUrl(vo.getArticlePicUrl());
        model.setArticleTitle(vo.getArticleTitle());
        model.setCollCount(Integer.parseInt(vo.getCollCount()));
        model.setCreateId(vo.getCreateId());
        model.setReadCount(Integer.parseInt(vo.getReadCount()));
        model.setId(vo.getId());
        Date createTime = DateUtil.formatStringToDate(vo.getCreateTime(), DateUtil.Y_M_D_HMS);
        Date modifyTime = DateUtil.formatStringToDate(vo.getModifyTime(), DateUtil.Y_M_D_HMS);
        model.setCreateTime(createTime);
        model.setModifyTime(modifyTime);
        return model;
    }

    @Override
    public ArticleInfoVO convertVO(ArticleInfo model) {
        ArticleInfoVO vo = new ArticleInfoVO();
        vo.setArticleContent(model.getArticleContent());
        vo.setArticleName(model.getArticleName());
        vo.setArticleOrder(model.getArticleOrder() + "");
        vo.setArticlePicUrl(model.getArticlePicUrl());
        vo.setArticleTitle(model.getArticleTitle());
        vo.setCollCount(model.getCollCount() + "");
        vo.setCreateId(model.getCreateId());
        vo.setReadCount(model.getReadCount() + "");
        vo.setId(model.getId());
        String createTime = DateUtil.formatDate(model.getCreateTime(), DateUtil.Y_M_D_HMS);
        String modifyTime = DateUtil.formatDate(model.getModifyTime(), DateUtil.Y_M_D_HMS);
        vo.setCreateTime(createTime);
        vo.setModifyTime(modifyTime);
        return vo;
    }
}
