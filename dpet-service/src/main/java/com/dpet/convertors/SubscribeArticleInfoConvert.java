package com.dpet.convertors;

import com.dpet.commons.utils.DateUtil;
import com.dpet.model.SubscribeArticle;
import com.dpet.vo.SubscribeArticleVO;
import org.springframework.stereotype.Component;

@Component
public class SubscribeArticleInfoConvert implements BeanConvertor<SubscribeArticle, SubscribeArticleVO> {
    @Override
    public SubscribeArticle convertModel(SubscribeArticleVO vo) {
        SubscribeArticle model = new SubscribeArticle();
        model.setId(vo.getId());
        model.setUserId(vo.getUserId());
        model.setArticleId(vo.getArticleId());
        model.setCreateTime(DateUtil.formatStringToDate(vo.getCreateTime(), DateUtil.Y_M_D_HMS));
        model.setSubscribeTime(DateUtil.formatStringToDate(vo.getSubscribeTime(), DateUtil.Y_M_D_HMS));
        return model;
    }

    @Override
    public SubscribeArticleVO convertVO(SubscribeArticle model) {
        SubscribeArticleVO vo = new SubscribeArticleVO();
        vo.setId(model.getId());
        vo.setUserId(model.getUserId());
        vo.setArticleId(model.getArticleId());
        vo.setCreateTime(DateUtil.formatDateToString(model.getCreateTime(), DateUtil.Y_M_D_HMS));
        vo.setSubscribeTime(DateUtil.formatDateToString(model.getSubscribeTime(), DateUtil.Y_M_D_HMS));
        return vo;
    }
}
