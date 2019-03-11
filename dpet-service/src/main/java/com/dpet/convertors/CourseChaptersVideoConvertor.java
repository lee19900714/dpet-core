package com.dpet.convertors;

import com.dpet.commons.utils.DateUtil;
import com.dpet.model.CourseChaptersVideos;
import com.dpet.vo.CourseChaptersVideosVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class CourseChaptersVideoConvertor implements
        BeanConvertor<CourseChaptersVideos, CourseChaptersVideosVO> {

    @Override
    public CourseChaptersVideos convertModel(CourseChaptersVideosVO vo) {
        if (vo == null) return null;
        CourseChaptersVideos courseChaptersVideos = new CourseChaptersVideos();
        courseChaptersVideos.setCourseChaptersId(vo.getCourseChaptersId());
        courseChaptersVideos.setCreateId(vo.getCreateId());
        courseChaptersVideos.setCreateTime(DateUtil.formatStringToDate(
                vo.getCreateTime(), DateUtil.Y_M_D_HMS));
        courseChaptersVideos.setId(vo.getId());
        courseChaptersVideos.setModifyTime(DateUtil.formatStringToDate(
                vo.getModifyTime(), DateUtil.Y_M_D_HMS));
        courseChaptersVideos.setPointPicUrl(vo.getPointPicUrl());
        courseChaptersVideos.setPoints(vo.getPoints());
        courseChaptersVideos.setVideoImageUrl(vo.getVideoImageUrl());
        courseChaptersVideos.setVideoLengthTime(Integer.parseInt(vo
                .getVideoLengthTime()));
        courseChaptersVideos.setVideoName(vo.getVideoName());
        courseChaptersVideos
                .setVideoOrder(Integer.parseInt(vo.getVideoOrder()));
        courseChaptersVideos.setVideoUrl(vo.getVideoUrl());
        return courseChaptersVideos;
    }

    @Override
    public CourseChaptersVideosVO convertVO(CourseChaptersVideos model) {
        if (model == null) return null;
        CourseChaptersVideosVO courseChaptersVideosVO = new CourseChaptersVideosVO();
        courseChaptersVideosVO.setCourseChaptersId(model.getCourseChaptersId());
        courseChaptersVideosVO.setCreateId(model.getCreateId());
        courseChaptersVideosVO.setCreateTime(DateUtil.formatDateToString(
                model.getCreateTime(), DateUtil.Y_M_D_HMS));
        courseChaptersVideosVO.setId(model.getId());
        courseChaptersVideosVO.setModifyTime(DateUtil.formatDateToString(
                model.getModifyTime(), DateUtil.Y_M_D_HMS));
        courseChaptersVideosVO.setPointPicUrl(model.getPointPicUrl());
        courseChaptersVideosVO.setPoints(model.getPoints());
        courseChaptersVideosVO.setVideoImageUrl(model.getVideoImageUrl());
        courseChaptersVideosVO.setVideoLengthTime(model.getVideoLengthTime()
                + StringUtils.EMPTY);
        courseChaptersVideosVO.setVideoName(model.getVideoName());
        courseChaptersVideosVO.setVideoOrder(model.getVideoOrder()
                + StringUtils.EMPTY);
        courseChaptersVideosVO.setVideoUrl(model.getVideoUrl());
        return courseChaptersVideosVO;
    }


}
