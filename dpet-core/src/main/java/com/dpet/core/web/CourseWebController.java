package com.dpet.core.web;

import com.dpet.convertors.CourseInfoConvertor;
import com.dpet.model.CourseInfo;
import com.dpet.service.inter.CourseInfoService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lijun
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping(value = "course")
public class CourseWebController {


    @Autowired
    private CourseInfoService courseInfoService;

    @Autowired
    private CourseInfoConvertor courseInfoConvertor;

    @RequestMapping("/courselist")
    public @ResponseBody
    Object list(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int pageNums = request.getParameter("pageNum") == null ? 10 : Integer.parseInt(request.getParameter("pageNum"));
        Page<CourseInfo> courses = courseInfoService.getCourseInfoByType(null, pageNums, 10);
        mav.addObject("pageNum", courses.getPageNum());
        mav.addObject("pageSize", courses.getPageSize());
        mav.addObject("page", courses.getPages());
        mav.addObject("total", courses.getTotal());
        mav.addObject("courses", courseInfoConvertor.convertVOList(courses.getResult()));
        mav.setViewName("/courselist");
        return mav;
    }

}
