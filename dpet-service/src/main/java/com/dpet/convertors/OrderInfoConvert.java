package com.dpet.convertors;

import com.dpet.commons.utils.DateUtil;
import com.dpet.model.OrderInfo;
import com.dpet.vo.OrderInfoVO;
import org.springframework.stereotype.Component;

@Component
public class OrderInfoConvert implements BeanConvertor<OrderInfo, OrderInfoVO> {
    @Override
    public OrderInfo convertModel(OrderInfoVO vo) {
        OrderInfo model = new OrderInfo();
        model.setId(vo.getId());
        model.setOrderNo(vo.getOrderNo());
        model.setModifierId(vo.getModifierId());
        model.setOrderAmount(Double.valueOf(vo.getOrderAmount()));
        model.setOrderState(Integer.parseInt(vo.getOrderState()));
        model.setPayType(vo.getPayType());
        model.setBuyCourseId(vo.getBuyCourseId());
        model.setUserId(vo.getUserId());
        model.setCreateTime(DateUtil.formatStringToDate(vo.getCreateTime(), DateUtil.Y_M_D_HMS));
        model.setModifyTime(DateUtil.formatStringToDate(vo.getModifyTime(), DateUtil.Y_M_D_HMS));
        return model;
    }

    @Override
    public OrderInfoVO convertVO(OrderInfo model) {
        OrderInfoVO vo = new OrderInfoVO();
        vo.setId(model.getId());
        vo.setOrderNo(model.getOrderNo());
        vo.setModifierId(model.getModifierId());
        vo.setOrderAmount(model.getOrderAmount() + "");
        vo.setOrderState(model.getOrderState() + "");
        vo.setPayType(model.getPayType());
        vo.setBuyCourseId(model.getBuyCourseId());
        vo.setUserId(model.getUserId());
        vo.setCreateTime(DateUtil.formatDateToString(model.getCreateTime(), DateUtil.Y_M_D_HMS));
        vo.setModifyTime(DateUtil.formatDateToString(model.getModifyTime(), DateUtil.Y_M_D_HMS));
        return vo;
    }

}
