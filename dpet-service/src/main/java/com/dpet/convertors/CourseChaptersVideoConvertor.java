package com.dpet.convertors;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.dpet.commons.utils.DateUtil;
import com.dpet.model.CourseChaptersVideos;
import com.dpet.vo.CourseChaptersVideosVO;

@Component
public class CourseChaptersVideoConvertor implements
		BeanConvertor<CourseChaptersVideos, CourseChaptersVideosVO> {

	@Override
	public CourseChaptersVideos convertModel(CourseChaptersVideosVO vo) {
		if(vo==null)return null;
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
		if(model==null)return null;
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

	@Override
	public List<CourseChaptersVideos> convertModelList(
			List<CourseChaptersVideosVO> listvo) {
		if(CollectionUtils.isEmpty(listvo)){
			return new ArrayList<CourseChaptersVideos>();
		}
		List<CourseChaptersVideos> list = new ArrayList<CourseChaptersVideos>();
		listvo.forEach(c->list.add(convertModel(c)));
		return list;
	}

	@Override
	public List<CourseChaptersVideosVO> convertVOList(
			List<CourseChaptersVideos> listvo) {
		if(CollectionUtils.isEmpty(listvo)){
			return new ArrayList<CourseChaptersVideosVO>();
		}
		List<CourseChaptersVideosVO> list = new ArrayList<CourseChaptersVideosVO>();
		listvo.forEach(c->list.add(convertVO(c)));
		return list;
	}

}
