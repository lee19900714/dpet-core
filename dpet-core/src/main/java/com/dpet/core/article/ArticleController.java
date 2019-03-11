package com.dpet.core.article;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.dpet.convertors.SubscribeArticleInfoConvert;
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
@SuppressWarnings("ALL")
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
    @Autowired
    private SubscribeArticleInfoConvert subscribeArticleInfoConvert;

    /**
     * 文章列表
     *
     * @param request the request
     * @return the object
     */
    @RequestMapping(value = "/articleList")
    @ResponseBody
    public Object articleList(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int pageNums = request.getParameter("pageNum") == null ? pageNum : Integer.parseInt(request.getParameter("pageNum"));
        int pageSizes = request.getParameter("pageSize") == null ? pageSize : Integer.parseInt(request.getParameter("pageSize"));
        Page<ArticleInfo> articleInfos = articleInfoService.selectByPage(pageNums, pageSizes);
        resultMap.put("pageNum", articleInfos.getPageNum());
        resultMap.put("pageSize", articleInfos.getPageSize());
        resultMap.put("page", articleInfos.getPages());
        resultMap.put("total", articleInfos.getTotal());
        resultMap.put("articles",articleInfoConvertor.convertVOList(articleInfos.getResult()));
        return ResponseUtils.sendSuccess(resultMap);
    }

    /**
     * 文章详情
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
     * 收藏文章
     *
     * @param request the request
     * @return the object
     */
    @RequestMapping(value = "/subscribeArticle")
    @ResponseBody
    public Object subscribeArticle(HttpServletRequest request) {
        String articleId = request.getParameter("articleId");
        String operateType = request.getParameter("operateType");
        if (SubscribeArticleType.SUBSCRIBE_COMMIT.equals(operateType)) {
            SubscribeArticle sa = this.getsubscribeArticle(articleId, operateType);
            subscribeArticleService.insert(sa);
        } else {
            Map<String, String> ids = new HashMap<>(1);
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
     * 我收藏的文章
     *
     * @param request the request
     * @return the object
     */
    @RequestMapping(value = "/mySubscribeArticle")
    @ResponseBody
    public Object mySubscribeArticle(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int pageNums = request.getParameter("pageNum") == null ? pageNum : Integer.parseInt(request.getParameter("pageNum"));
        int pageSizes = request.getParameter("pageSize") == null ? pageSize : Integer.parseInt(request.getParameter("pageSize"));
        Page<SubscribeArticle> mySubscribeArticle = subscribeArticleService.selectByUserIdAndPage(getMyselfId(), pageNums, pageSizes);
        resultMap.put("articles",subscribeArticleInfoConvert.convertVOList(mySubscribeArticle.getResult()));
        resultMap.put("pageNum", mySubscribeArticle.getPageNum());
        resultMap.put("pageSize", mySubscribeArticle.getPageSize());
        resultMap.put("page", mySubscribeArticle.getPages());
        resultMap.put("total", mySubscribeArticle.getTotal());
        return ResponseUtils.sendSuccess(resultMap);
    }
}
