package com.dpet.convertors;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;

import com.dpet.commons.utils.DateUtil;
import com.dpet.model.ArticleInfo;
import com.dpet.vo.ArticleInfoVO;

@Component
public class ArticleInfoConvertor implements BeanConvertor<ArticleInfo, ArticleInfoVO> {

	@Override
	public ArticleInfo convertModel(ArticleInfoVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleInfoVO convertVO(ArticleInfo model) {
		ArticleInfoVO vo = new ArticleInfoVO();
		try {
			BeanUtils.copyProperties(vo, model);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		String createTime = DateUtil.formatDate(model.getCreateTime(), DateUtil.Y_M_D_HMS);
		String modifyTime = DateUtil.formatDate(model.getModifyTime(), DateUtil.Y_M_D_HMS);
		vo.setCreateTime(createTime);
		vo.setModifyTime(modifyTime);
		return vo;
	}

	@Override
	public List<ArticleInfo> convertModelList(List<ArticleInfoVO> listvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleInfoVO> convertVOList(List<ArticleInfo> listvo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
