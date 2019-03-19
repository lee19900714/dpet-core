package com.dpet.convertors;

import com.dpet.commons.utils.DateUtil;
import com.dpet.model.CourseInfo;
import com.dpet.vo.CourseInfoVO;
import org.springframework.stereotype.Component;

@Component
public class CourseInfoConvertor implements BeanConvertor<CourseInfo, CourseInfoVO> {

	@Override
	public CourseInfo convertModel(CourseInfoVO vo) {
		if(vo==null){
			return null;
		}
		CourseInfo courseInfo = new CourseInfo();
		courseInfo.setCourseCost(Double.valueOf(vo.getCourseCost()));
		courseInfo.setCourseDesc(vo.getCourseDesc());
		courseInfo.setCourseImage(vo.getCourseImage());
		courseInfo.setCourseLabel(vo.getCourseLabel());
		courseInfo.setCourseLengthTime(Integer.parseInt(vo.getCourseLengthTime()));
		courseInfo.setCourseName(vo.getCourseName());
		courseInfo.setCourseOrder(Integer.parseInt(vo.getCourseOrder()));
		courseInfo.setCourseTitle(vo.getCourseTitle());
		courseInfo.setCourseType(Integer.parseInt(vo.getCourseType()));
		courseInfo.setCreateId(vo.getCreateId());
		courseInfo.setCreateTime(DateUtil.formatStringToDate(vo.getCreateTime(), DateUtil.Y_M_D_HMS));
		courseInfo.setId(vo.getId());
		courseInfo.setLearningStep(vo.getLearningStep());
		courseInfo.setLevel(Integer.parseInt(vo.getLevel()));
		courseInfo.setModifyTime(DateUtil.formatStringToDate(vo.getModifyTime(), DateUtil.Y_M_D_HMS));
		courseInfo.setSaleState(Integer.parseInt(vo.getSaleState()));
		courseInfo.setTrainerInfo(vo.getTrainerInfo());
		return courseInfo;
	}

	@Override
	public CourseInfoVO convertVO(CourseInfo model) {
		if(model==null){
			return null;
		}
		CourseInfoVO vo = new CourseInfoVO();
		vo.setCourseCost(model.getCourseCost()+"");
		vo.setCourseDesc(model.getCourseDesc());
		vo.setCourseImage(model.getCourseImage());
		vo.setCourseLabel(model.getCourseLabel());
		vo.setCourseLengthTime(model.getCourseLengthTime()+"");
		vo.setCourseName(model.getCourseName());
		vo.setCourseOrder(model.getCourseOrder()+"");
		vo.setCourseTitle(model.getCourseTitle());
		vo.setCourseType(model.getCourseType()+"");
		vo.setCreateId(model.getCreateId());
		vo.setCreateTime(DateUtil.formatDateToString(model.getCreateTime(), DateUtil.Y_M_D_HMS));
		vo.setId(model.getId());
		vo.setJoinerCount(model.getJoinerCount()+"");
		vo.setLearningStep(model.getLearningStep());
		vo.setLearningTimes(model.getLearningTimes()+"");
		vo.setLevel(model.getLevel()+"");
		vo.setModifyTime(DateUtil.formatDateToString(model.getModifyTime(), DateUtil.Y_M_D_HMS));
		vo.setSaleState(model.getSaleState()+"");
		vo.setTrainerInfo(model.getTrainerInfo());
		return vo;
	}
}
