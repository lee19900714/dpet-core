package com.dpet.convertors;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.dpet.commons.utils.DateUtil;
import com.dpet.model.CourseChapters;
import com.dpet.vo.CourseChaptersVO;

@Component
public class CourseChaptersConvertor implements BeanConvertor<CourseChapters, CourseChaptersVO> {

	@Override
	public CourseChapters convertModel(CourseChaptersVO vo) {
		if(vo==null)return null;
		CourseChapters courseChapters = new CourseChapters();
		courseChapters.setChapterOrder(Integer.parseInt(vo.getChapterOrder()));
		courseChapters.setCourseChapters(vo.getCourseChapters());
		courseChapters.setCourseId(vo.getCourseId());
		courseChapters.setCreateId(vo.getCreateId());
		courseChapters.setCreateTime(DateUtil.formatStringToDate(vo.getCreateTime(), DateUtil.Y_M_D_HMS));
		courseChapters.setId(vo.getId());
		courseChapters.setModifyTime(DateUtil.formatStringToDate(vo.getModifyTime(), DateUtil.Y_M_D_HMS));
		return courseChapters;
	}

	@Override
	public CourseChaptersVO convertVO(CourseChapters model) {
		if(model==null)return null;
		CourseChaptersVO courseChaptersVO = new CourseChaptersVO();
		courseChaptersVO.setChapterOrder(model.getChapterOrder()+StringUtils.EMPTY);
		courseChaptersVO.setCourseChapters(model.getCourseChapters());
		courseChaptersVO.setCourseId(model.getCourseId());
		courseChaptersVO.setCreateId(model.getCreateId());
		courseChaptersVO.setCreateTime(DateUtil.formatDateToString(model.getCreateTime(), DateUtil.Y_M_D_HMS));
		courseChaptersVO.setId(model.getId());
		courseChaptersVO.setModifyTime(DateUtil.formatDateToString(model.getModifyTime(), DateUtil.Y_M_D_HMS));
		return courseChaptersVO;
	}

	@Override
	public List<CourseChapters> convertModelList(List<CourseChaptersVO> listvo) {
		if(CollectionUtils.isEmpty(listvo)){
			return new ArrayList<CourseChapters>();
		}
		List<CourseChapters> list = new ArrayList<CourseChapters>();
		listvo.forEach(s->list.add(convertModel(s)));
		return list;
	}

	@Override
	public List<CourseChaptersVO> convertVOList(List<CourseChapters> listvo) {
		if(CollectionUtils.isEmpty(listvo)){
			return new ArrayList<CourseChaptersVO>();
		}
		List<CourseChaptersVO> list = new ArrayList<CourseChaptersVO>();
		listvo.forEach(s->list.add(convertVO(s)));
		return list;
	}
	
}
