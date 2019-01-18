package com.dpet.core.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dpet.convertors.CourseChaptersConvertor;
import com.dpet.convertors.CourseChaptersVideoConvertor;
import com.dpet.convertors.CourseInfoConvertor;
import com.dpet.core.MyBaseController;
import com.dpet.framework.ResponseUtils;
import com.dpet.model.CourseChapters;
import com.dpet.model.CourseChaptersVideos;
import com.dpet.model.CourseInfo;
import com.dpet.model.SubscribeCourse;
import com.dpet.service.inter.CourseChaptersService;
import com.dpet.service.inter.CourseChaptersVideosService;
import com.dpet.service.inter.CourseInfoService;
import com.dpet.service.inter.SubscribeCourseService;
import com.dpet.vo.CourseChaptersVO;
import com.dpet.vo.CourseInfoVO;
import com.dpet.vo.CourseVO;
import com.dpet.vo.CourseVideosVO;
import com.github.pagehelper.Page;

@RestController
@RequestMapping(value = "ipet/courseinfo")
public class CourseInfoController extends MyBaseController {

	private static Log logger = LogFactory.getLog(CourseInfoController.class);

	@Autowired
	private CourseInfoService courseInfoService;

	@Autowired
	private CourseChaptersService courseChaptersService;

	@Autowired
	private CourseChaptersVideosService courseChaptersVideosService;

	@Autowired
	private SubscribeCourseService subscribeCourseService;

	@Autowired
	private CourseInfoConvertor courseInfoConvertor;

	@Autowired
	private CourseChaptersConvertor courseChaptersConvertor;

	@Autowired
	private CourseChaptersVideoConvertor courseChaptersVideoConvertor;

	/*
	 * 课程基本信息列表
	 */
	@RequestMapping(value = "/queryCourseList")
	@ResponseBody
	public Object queryCourseList(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, String> paramMap = new HashMap<String, String>();
		String courseType = request.getParameter("courseType");
		int pageNums = request.getParameter("pageNum") == null ? pageNum
				: Integer.parseInt(request.getParameter("pageNum"));
		int pageSizes = request.getParameter("pageSize") == null ? pageSize
				: Integer.parseInt(request.getParameter("pageSize"));
		paramMap.put("courseType", courseType);
		Page<CourseInfo> page = courseInfoService.getCourseInfoByType(paramMap,
				pageNums, pageSizes);
		resultMap.put("pageNum", page.getPageNum());
		resultMap.put("pageSize", page.getPageSize());
		resultMap.put("page", page.getPages());
		resultMap.put("total", page.getTotal());
		resultMap.put("courseInfoList",
				courseInfoConvertor.convertVOList(page.getResult()));
		return ResponseUtils.sendSuccess(resultMap);
	}

	/*
	 * 课程详情信息 包括课程 章节 以及视频信息
	 */
	@RequestMapping(value = "/queryCourseChaptersVideos")
	@ResponseBody
	public Object queryCourseInfo(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String id = request.getParameter("courseId");
		CourseVO courseVO = new CourseVO();
		CourseInfo courseInfo = courseInfoService.selectByPrimaryKey(id);
		courseVO.setCourseInfoVO((CourseInfoVO) courseInfoConvertor
				.convertVO(courseInfo));
		List<CourseChapters> courseChaptersList = courseChaptersService
				.selectByCourseId(id);
		List<CourseVideosVO> courseVideosVOS = new ArrayList<CourseVideosVO>();
		courseChaptersList
				.forEach(c -> {
					CourseVideosVO courseVideosVO = new CourseVideosVO();
					List<CourseChaptersVideos> courseChaptersVideos = courseChaptersVideosService
							.selectByCourseChaptersId(c.getId());
					courseVideosVO
							.setCourseChaptersVO((CourseChaptersVO) courseChaptersConvertor
									.convertVO(c));
					courseVideosVO
							.setCourseChaptersVideosVOS(courseChaptersVideoConvertor
									.convertVOList(courseChaptersVideos));
					courseVideosVOS.add(courseVideosVO);
				});
		courseVO.setCourseVideosVOS(courseVideosVOS);
		resultMap.put("courseVO", courseVO);
		return ResponseUtils.sendSuccess(resultMap);
	}

	/*
	 * 用户参加课程
	 */
	@RequestMapping(value = "/subscribeCourse")
	@ResponseBody
	public Object subscribeCourse(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<CourseInfo> courseInfoList = new ArrayList<CourseInfo>();
		int pageNums = request.getParameter("pageNum") == null ? pageNum
				: Integer.parseInt(request.getParameter("pageNum"));
		int pageSizes = request.getParameter("pageSize") == null ? pageSize
				: Integer.parseInt(request.getParameter("pageSize"));
		Page<SubscribeCourse> page = subscribeCourseService
				.selectByUserIdAndPage(getMyselfId(), pageNums, pageSizes);
		if (CollectionUtils.isNotEmpty(page.getResult())) {
			page.getResult().forEach(
					p -> {
						CourseInfo courseInfo = courseInfoService
								.selectByPrimaryKey(p.getCourseId());
						if (courseInfo == null) {
							logger.info("courseId:" + p.getCourseId()
									+ ",课程信息不存在");
						} else {
							courseInfoList.add(courseInfo);
						}
					});
		}
		resultMap.put("pageNum", page.getPageNum());
		resultMap.put("pageSize", page.getPageSize());
		resultMap.put("page", page.getPages());
		resultMap.put("total", page.getTotal());
		resultMap.put("courseInfoList",
				courseInfoConvertor.convertVOList(courseInfoList));
		return ResponseUtils.sendSuccess(resultMap);
	}
}
