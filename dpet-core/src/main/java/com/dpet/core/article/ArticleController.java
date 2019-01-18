package com.dpet.core.article;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dpet.commons.SubscribeArticleType;
import com.dpet.commons.utils.UUIDUtil;
import com.dpet.convertors.ArticleInfoConvertor;
import com.dpet.core.MyBaseController;
import com.dpet.framework.ResponseUtils;
import com.dpet.model.ArticleInfo;
import com.dpet.model.SubscribeArticle;
import com.dpet.service.inter.ArticleInfoService;
import com.dpet.service.inter.SubscribeArticleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * The type Article controller.
 */
@RestController
@RequestMapping(value = "ipet/articleinfo")
public class ArticleController extends MyBaseController {

	private static Log logger = LogFactory.getLog(ArticleController.class);

	@Autowired
	private ArticleInfoService articleInfoService;
	@Autowired
	private SubscribeArticleService subscribeArticleService;
	@Autowired
	private ArticleInfoConvertor articleInfoConvertor;

	/**
	 * Article list object.
	 *
	 * @param request the request
	 * @return the object
	 */
	@RequestMapping(value = "/articleList")
	@ResponseBody
	public Object articleList(HttpServletRequest request) {
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		PageInfo<ArticleInfo> articleInfos = articleInfoService.selectByPage(
				pageNum, pageSize);
		return ResponseUtils.sendSuccess(articleInfos);
	}

	/**
	 * Article info object.
	 *
	 * @param request the request
	 * @return the object
	 */
	@RequestMapping(value = "/articleInfo")
	@ResponseBody
	public Object articleInfo(HttpServletRequest request) {
		String articleId = request.getParameter("articleId");
		ArticleInfo articleInfo = articleInfoService.selectByPrimaryKey(articleId);
		return ResponseUtils.sendSuccess(articleInfoConvertor.convertVO(articleInfo));
	}

	/**
	 * Subscribe article object.
	 *
	 * @param request the request
	 * @return the object
	 */
	@RequestMapping(value = "/subscribeArticle")
	@ResponseBody
	public Object subscribeArticle(HttpServletRequest request) {
		String articleId = request.getParameter("articleId");
		String operateType = request.getParameter("operateType");
		if(SubscribeArticleType.SUBSCRIBE_COMMIT.equals(operateType)){
			SubscribeArticle sa = this.getsubscribeArticle(articleId, operateType);
			subscribeArticleService.insert(sa);
		}else{
			Map<String, String> ids = new HashMap<>();
			ids.put("id", articleId);
			subscribeArticleService.deleteByPrimaryKey(ids);
		}
		return ResponseUtils.sendSuccess();
	}

	private SubscribeArticle getsubscribeArticle(String articleId,
			String operateType) {
		Date date = new Date();
		SubscribeArticle sa = new SubscribeArticle();
		sa.setId(UUIDUtil.getUUID());
		sa.setArticleId(articleId);
		sa.setUserId(this.getMyselfId());
		sa.setCreateTime(date);
		sa.setSubscribeTime(date);
		return sa;
	}

	/**
	 * My subscribe article object.
	 *
	 * @param request the request
	 * @return the object
	 */
	@RequestMapping(value = "/mySubscribeArticle")
	@ResponseBody
	public Object mySubscribeArticle(HttpServletRequest request) {
		int pageNums = request.getParameter("pageNum")==null?pageNum:Integer.parseInt(request.getParameter("pageNum"));
		int pageSizes = request.getParameter("pageSize")==null?pageSize:Integer.parseInt(request.getParameter("pageSize"));
		Page<SubscribeArticle> mySubscribeArticle = subscribeArticleService.selectByUserIdAndPage(getMyselfId(), pageNums, pageSizes);
		return ResponseUtils.sendSuccess(mySubscribeArticle);
	}
}
