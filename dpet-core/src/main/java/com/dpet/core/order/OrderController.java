package com.dpet.core.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dpet.commons.OrderStatus;
import com.dpet.commons.PayType;
import com.dpet.commons.utils.UUIDUtil;
import com.dpet.core.MyBaseController;
import com.dpet.framework.ResponseUtils;
import com.dpet.model.CourseInfo;
import com.dpet.model.OrderInfo;
import com.dpet.service.inter.CourseInfoService;
import com.dpet.service.inter.OrderInfoService;

/**
 * The type Order controller.
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping(value = "ipet/orderinfo")
public class OrderController extends MyBaseController {

    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private CourseInfoService courseInfoService;

    /**
     * 订单下单接口
     *
     * @param request the request
     * @return the object
     */
    @RequestMapping(value = "/prePayOrder", method = {RequestMethod.POST})
    @ResponseBody
    public Object prePayOrder(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String courseIds = request.getParameter("courseIds");
        List<CourseInfo> courseInfos = new ArrayList<CourseInfo>();
        String[] courseIdsArr = courseIds.split(",");
        for (int i = 0; i < courseIdsArr.length; i++) {
            CourseInfo courseInfo = courseInfoService
                    .selectByPrimaryKey(courseIdsArr[i]);
            courseInfos.add(courseInfo);
        }
        OrderInfo orderInfo = this.getOrderInfo(courseInfos, courseIds);
        orderInfoService.insert(orderInfo);
        return ResponseUtils.sendSuccess(resultMap);
    }

    private OrderInfo getOrderInfo(List<CourseInfo> courseInfos,
                                   String courseIds) {
        OrderInfo orderInfo = new OrderInfo();
        Date date = new Date();
        double courseCost = 0.00d;
        orderInfo.setId(UUIDUtil.getUUID());
        orderInfo.setBuyCourseId(courseIds);
        orderInfo.setCreateTime(date);
        orderInfo.setModifierId(getMyselfId());
        orderInfo.setModifyTime(date);
        for (CourseInfo courseInfo : courseInfos) {
            courseCost += courseInfo.getCourseCost();
        }
        orderInfo.setOrderAmount(courseCost);
        orderInfo.setOrderState(OrderStatus.PENDING_PAY);
        orderInfo.setPayType(PayType.WX_PAY);
        orderInfo.setUserId(getMyselfId());
        return orderInfo;
    }

}
