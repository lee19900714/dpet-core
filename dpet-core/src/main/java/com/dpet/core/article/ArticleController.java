package com.dpet.core.article;

import com.dpet.commons.SubscribeArticleType;
import com.dpet.commons.utils.UUIDUtil;
import com.dpet.convertors.ArticleInfoConvertor;
import com.dpet.convertors.SubscribeArticleInfoConvert;
import com.dpet.core.MyBaseController;
import com.dpet.framework.ResponseUtils;
import com.dpet.model.ArticleInfo;
import com.dpet.model.SubscribeArticle;
import com.dpet.model.UserInfo;
import com.dpet.service.inter.ArticleInfoService;
import com.dpet.service.inter.SubscribeArticleService;
import com.dpet.service.inter.UserInfoService;
import com.dpet.vo.ArticleInfoVO;
import com.dpet.vo.SubscribeArticleVO;
import com.github.pagehelper.Page;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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
    @Autowired
    private UserInfoService userInfoService;

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
        List<ArticleInfoVO> articleInfoVOS = articleInfoConvertor.convertVOList(articleInfos.getResult());
        if (!CollectionUtils.isEmpty(articleInfoVOS)) {
            articleInfoVOS.forEach(s -> {
                String createId = s.getCreateId();
                if (StringUtils.isBlank(createId)) {
                    s.setCreateName(null);
                }
                UserInfo userInfo = userInfoService.selectByPrimaryKey(createId);
                if (userInfo == null) {
                    s.setCreateName(null);
                } else {
                    s.setCreateName(userInfo.getUserName());
                }
                SubscribeArticle subscribeArticle = subscribeArticleService.selectByArticleId(s.getId(), getMyselfId());
                if (subscribeArticle != null) {
                    s.setCollect(true);
                }
            });
        }
        resultMap.put("articles", articleInfoVOS);
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
        List<SubscribeArticleVO> subscribeArticleVOS = subscribeArticleInfoConvert.convertVOList(mySubscribeArticle.getResult());
        List<ArticleInfo> articleInfos = new ArrayList<>();
        subscribeArticleVOS.forEach(s -> {
            String articleId = s.getArticleId();
            if (StringUtils.isBlank(articleId)) {
                return;
            }
            ArticleInfo articleInfo = articleInfoService.selectByPrimaryKey(articleId);
            if (articleInfo == null) {
                return;
            }
            articleInfos.add(articleInfo);
        });
        List<ArticleInfoVO> articleInfoVOS = articleInfoConvertor.convertVOList(articleInfos);
        if (!CollectionUtils.isEmpty(articleInfoVOS)) {
            articleInfoVOS.forEach(s -> {
                String createId = s.getCreateId();
                if (StringUtils.isBlank(createId)) {
                    s.setCreateName(null);
                }
                UserInfo userInfo = userInfoService.selectByPrimaryKey(createId);
                if (userInfo == null) {
                    s.setCreateName(null);
                } else {
                    s.setCreateName(userInfo.getUserName());
                }
                SubscribeArticle subscribeArticle = subscribeArticleService.selectByArticleId(s.getId(), getMyselfId());
                if (subscribeArticle != null) {
                    s.setCollect(true);
                }
            });
        }
        resultMap.put("articles", articleInfoVOS);
        resultMap.put("pageNum", mySubscribeArticle.getPageNum());
        resultMap.put("pageSize", mySubscribeArticle.getPageSize());
        resultMap.put("page", mySubscribeArticle.getPages());
        resultMap.put("total", mySubscribeArticle.getTotal());
        return ResponseUtils.sendSuccess(resultMap);
    }
}
