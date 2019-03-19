package com.dpet.core.web;

import com.dpet.convertors.ArticleInfoConvertor;
import com.dpet.model.ArticleInfo;
import com.dpet.service.inter.ArticleInfoService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Article web controller.
 * @author lijun
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping(value = "article")
public class ArticleWebController {

    @Autowired
    private ArticleInfoService articleInfoService;
    @Autowired
    private ArticleInfoConvertor articleInfoConvertor;

    @RequestMapping("/articlelist")
    public @ResponseBody
    Object list(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int pageNums = request.getParameter("pageNum") == null ? 10 : Integer.parseInt(request.getParameter("pageNum"));
        Page<ArticleInfo> articles = articleInfoService.selectByPage(pageNums, 10);
        mav.addObject("pageNum", articles.getPageNum());
        mav.addObject("pageSize", articles.getPageSize());
        mav.addObject("page", articles.getPages());
        mav.addObject("total", articles.getTotal());
        mav.addObject("articles", articleInfoConvertor.convertVOList(articles.getResult()));
        mav.setViewName("/articlelist");
        return mav;
    }
}
