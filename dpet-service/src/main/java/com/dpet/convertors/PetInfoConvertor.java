package com.dpet.convertors;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.dpet.commons.utils.DateUtil;
import com.dpet.model.PetInfo;
import com.dpet.vo.PetInfoVO;

@Component
public class PetInfoConvertor implements BeanConvertor<PetInfo, PetInfoVO> {

	@Override
	public PetInfo convertModel(PetInfoVO vo) {
		if (vo == null) {
			return null;
		}
		PetInfo p = new PetInfo();

		p.setId(vo.getId());
		p.setPetName(vo.getPetName());
		p.setPetType(StringUtils.isBlank(vo.getPetType()) ? StringUtils.EMPTY
				: vo.getPetType());
		p.setPetBrithday(DateUtil.formatStringToDate(vo.getPetBrithday(),
				DateUtil.Y_M_D));
		p.setHomeDay(DateUtil.formatStringToDate(vo.getHomeDay(),
				DateUtil.Y_M_D));
		p.setPetHeight(StringUtils.isBlank(vo.getPetHeight()) ? null : Double
				.parseDouble(vo.getPetHeight()));
		p.setPetLength(StringUtils.isBlank(vo.getPetLength()) ? null : Double
				.parseDouble(vo.getPetLength()));
		p.setPetSex(StringUtils.isBlank(vo.getPetSex()) ? null : Integer
				.parseInt(vo.getPetSex()));
		p.setPetWeight(StringUtils.isBlank(vo.getPetWeight()) ? null : Double
				.parseDouble(vo.getPetWeight()));
		p.setSterilizationCondition(StringUtils.isBlank(vo
				.getSterilizationCondition()) ? null : Integer.parseInt(vo
				.getSterilizationCondition()));
		p.setAnthelminticCondition(StringUtils.isBlank(vo
				.getAnthelminticCondition()) ? null : Integer.parseInt(vo
				.getAnthelminticCondition()));
		p.setVaccineCondition(StringUtils.isBlank(vo.getVaccineCondition()) ? null
				: Integer.parseInt(vo.getVaccineCondition()));
		p.setCreateTime(DateUtil.formatStringToDate(vo.getCreateTime(),
				DateUtil.Y_M_D_HMS));
		p.setModifyTime(DateUtil.formatStringToDate(vo.getModifyTime(),
				DateUtil.Y_M_D_HMS));
		return p;
	}

	@Override
	public PetInfoVO convertVO(PetInfo model) {
		if (model == null) {
			return null;
		}
		PetInfoVO vo = new PetInfoVO();
		vo.setId(String.valueOf(model.getId()));
		vo.setUserId(model.getUserId());
		vo.setPetImageId(model.getPetImageId());

		vo.setPetName(model.getPetName());
		vo.setPetType(model.getPetType());
		vo.setPetBrithday(DateUtil.formatDateToString(model.getPetBrithday(),
				DateUtil.Y_M_D));
		vo.setHomeDay(DateUtil.formatDateToString(model.getHomeDay(),
				DateUtil.Y_M_D));
		vo.setPetHeight(String.valueOf(model.getPetHeight()));
		vo.setPetLength(String.valueOf(model.getPetLength()));
		vo.setPetSex(String.valueOf(model.getPetSex()));
		vo.setPetWeight(String.valueOf(model.getPetWeight()));
		vo.setSterilizationCondition(String.valueOf(model
				.getSterilizationCondition()));
		vo.setAnthelminticCondition(String.valueOf(model
				.getAnthelminticCondition()));
		vo.setVaccineCondition(String.valueOf(model.getVaccineCondition()));

		vo.setCreateTime(DateUtil.formatDateToString(model.getCreateTime(),
				DateUtil.Y_M_D_HMS));
		vo.setModifyTime(DateUtil.formatDateToString(model.getModifyTime(),
				DateUtil.Y_M_D_HMS));
		return vo;
	}

	@Override
	public List<PetInfo> convertModelList(List<PetInfoVO> listvo) {
		if (CollectionUtils.isEmpty(listvo)) {
			return new ArrayList<PetInfo>();
		}
		List<PetInfo> petInfos = new ArrayList<>();
		for (PetInfoVO vo : listvo) {
			petInfos.add(convertModel(vo));
		}
		return petInfos;
	}

	@Override
	public List<PetInfoVO> convertVOList(List<PetInfo> listvo) {
		if (CollectionUtils.isEmpty(listvo)) {
			return new ArrayList<PetInfoVO>();
		}
		List<PetInfoVO> PetInfoVOS = new ArrayList<>();
		for (PetInfo model : listvo) {
			PetInfoVOS.add(convertVO(model));
		}
		return PetInfoVOS;
	}
}
