package com.dpet.validators;

import java.util.HashMap;
import java.util.Map;

import com.dpet.commons.PetValidConstants;
import com.dpet.commons.utils.StringUtil;
import com.dpet.vo.PetInfoVO;

public class PetInfoValidator {

	public static Map<String, String> validate(PetInfoVO petInfo) {
		Map<String, String> validateMap = new HashMap<String, String>();
		if (petInfo == null) {
			validateMap.put("validCode", "false");
			validateMap.put("validMessage", PetValidConstants.PET_NULL);
			return validateMap;
		}
		if (StringUtil.isEmpty(petInfo.getPetName())) {
			validateMap.put("validCode", "false");
			validateMap.put("validMessage", PetValidConstants.PET_NAME_NULL);
			return validateMap;
		}
		if (StringUtil.isEmpty(petInfo.getPetType())) {
			validateMap.put("validCode", "false");
			validateMap.put("validMessage", PetValidConstants.PET_TYPE_NULL);
			return validateMap;
		}
		if (StringUtil.isEmpty(petInfo.getPetSex())) {
			validateMap.put("validCode", "false");
			validateMap.put("validMessage", PetValidConstants.PET_SEX_NULL);
			return validateMap;
		}
		if (StringUtil.isEmpty(petInfo.getPetBrithday())) {
			validateMap.put("validCode", "false");
			validateMap
					.put("validMessage", PetValidConstants.PET_BIRTHDAY_NULL);
			return validateMap;
		}
		if (StringUtil.isEmpty(petInfo.getHomeDay())) {
			validateMap.put("validCode", "false");
			validateMap.put("validMessage", PetValidConstants.HOME_DAY);
			return validateMap;
		}
		if (StringUtil.isEmpty(petInfo.getPetWeight())) {
			validateMap.put("validCode", "false");
			validateMap.put("validMessage", PetValidConstants.PET_WEIGHT_NULL);
			return validateMap;
		}
		if (StringUtil.isEmpty(petInfo.getPetHeight())) {
			validateMap.put("validCode", "false");
			validateMap.put("validMessage", PetValidConstants.PET_HEIGHT_NULL);
			return validateMap;
		}
		if (StringUtil.isEmpty(petInfo.getPetLength())) {
			validateMap.put("validCode", "false");
			validateMap.put("validMessage", PetValidConstants.PET_LENGTH_NULL);
			return validateMap;
		}
		if (StringUtil.isEmpty(petInfo.getAnthelminticCondition())) {
			validateMap.put("validCode", "false");
			validateMap.put("validMessage",
					PetValidConstants.ANTHELMINTICCONDITION_null);
			return validateMap;
		}
		if (StringUtil.isEmpty(petInfo.getSterilizationCondition())) {
			validateMap.put("validCode", "false");
			validateMap.put("validMessage",
					PetValidConstants.STERILIZATIONCONTIDITION_NULL);
			return validateMap;
		}
		if (StringUtil.isEmpty(petInfo.getVaccineCondition())) {
			validateMap.put("validCode", "false");
			validateMap.put("validMessage",
					PetValidConstants.VACCINECONDOTION_NULL);
			return validateMap;
		}
		validateMap.put("validCode", "true");
		return validateMap;
	}

}
