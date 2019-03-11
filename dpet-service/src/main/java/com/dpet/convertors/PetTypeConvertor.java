package com.dpet.convertors;

import com.dpet.commons.utils.DateUtil;
import com.dpet.commons.utils.UUIDUtil;
import com.dpet.model.PetTypeInfo;
import com.dpet.vo.PetTypeInfoVO;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PetTypeConvertor implements BeanConvertor<PetTypeInfo, PetTypeInfoVO> {

    @Override
    public PetTypeInfo convertModel(PetTypeInfoVO vo) {
        if (vo == null) return null;
        PetTypeInfo petTypeInfo = new PetTypeInfo();
        Date date = new Date();
        petTypeInfo.setId(UUIDUtil.getUUID());
        petTypeInfo.setIsEnable("true");
        petTypeInfo.setPetTypeName(vo.getPetTypeName());
        petTypeInfo.setPetIcon(vo.getPetIcon());
        petTypeInfo.setPetTypeNo(Integer.parseInt(vo.getPetTypeNo()));
        petTypeInfo.setCreateId(vo.getCreateId());
        petTypeInfo.setCreateTime(date);
        petTypeInfo.setModifyTime(date);
        return petTypeInfo;
    }

    @Override
    public PetTypeInfoVO convertVO(PetTypeInfo model) {
        if (model == null) return null;
        PetTypeInfoVO vo = new PetTypeInfoVO();
        vo.setId(model.getId());
        vo.setIsEnable(model.getIsEnable());
        vo.setPetTypeName(model.getPetTypeName());
        vo.setPetIcon(model.getPetIcon());
        vo.setPetTypeNo(model.getPetTypeNo() + "");
        vo.setCreateId(model.getCreateId());
        vo.setCreateTime(DateUtil.formatDate(model.getCreateTime(), DateUtil.Y_M_D_HMS));
        vo.setModifyTime(DateUtil.formatDate(model.getModifyTime(), DateUtil.Y_M_D_HMS));
        return vo;
    }

}
