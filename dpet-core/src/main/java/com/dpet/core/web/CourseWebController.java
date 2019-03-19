package com.dpet.core.web;

import com.dpet.commons.utils.FileUtil;
import com.dpet.commons.utils.UUIDUtil;
import com.dpet.convertors.CourseInfoConvertor;
import com.dpet.core.MyBaseController;
import com.dpet.model.CourseInfo;
import com.dpet.service.inter.CourseInfoService;
import com.dpet.vo.CourseInfoVO;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;

/**
 * @author lijun
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping(value = "course")
public class CourseWebController extends MyBaseController {

    @Value("${image.petImageFilePath}")
    private String petImageFilePath;

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

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    public @ResponseBody
    Object insert(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        //自动生成图片名
        MultipartFile courseImage = multiRequest.getFile("courseImage");
        String contentType = courseImage.getContentType().split("/")[1];
        String fileName = UUIDUtil.getUUID() + "." + contentType;
        FileUtil.uploadFile(courseImage.getBytes(), petImageFilePath, fileName);
        CourseInfoVO courseInfoVO = getCourseInfoVO(multiRequest);
        CourseInfo courseInfo = courseInfoConvertor.convertModel(courseInfoVO);
        String uuid = UUIDUtil.getUUID();
        Date date = new Date();
        courseInfo.setId(uuid);
        courseInfo.setModifyTime(date);
        courseInfo.setCreateTime(date);
        courseInfo.setCourseImage(petImageFilePath + fileName);
        courseInfo.setCreateId("admin");
        int insert = courseInfoService.insert(courseInfo);
        return true;
    }

    private CourseInfoVO getCourseInfoVO(MultipartHttpServletRequest multiRequest) throws IllegalAccessException {
        CourseInfoVO vo = new CourseInfoVO();
        Map<String, String[]> parameterMap = multiRequest.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            Class cls = vo.getClass();
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field f : declaredFields) {
                if (f.getName().equals(entry.getKey())) {
                    f.setAccessible(true);
                    f.set(vo, entry.getValue()[0]);
                }
            }
        }
        return vo;
    }

    /**
     * Gets pet image file path.
     *
     * @return the pet image file path
     */
    public String getPetImageFilePath() {
        return petImageFilePath;
    }

    /**
     * Sets pet image file path.
     *
     * @param petImageFilePath the pet image file path
     */
    public void setPetImageFilePath(String petImageFilePath) {
        this.petImageFilePath = petImageFilePath;
    }
}
