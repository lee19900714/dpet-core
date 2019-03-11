package com.dpet.core.order;

import com.dpet.commons.OrderStatus;
import com.dpet.commons.PayType;
import com.dpet.commons.utils.DateUtil;
import com.dpet.commons.utils.UUIDUtil;
import com.dpet.convertors.OrderInfoConvert;
import com.dpet.core.MyBaseController;
import com.dpet.framework.ResponseUtils;
import com.dpet.model.CourseInfo;
import com.dpet.model.OrderInfo;
import com.dpet.service.inter.CourseInfoService;
import com.dpet.service.inter.OrderInfoService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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

    @Autowired
    private OrderInfoConvert orderInfoConvert;

    /**
     * 订单下单接口
     *
     * @param request the request
     * @return the object
     */
    @RequestMapping(value = "/prePayOrder", method = {RequestMethod.POST})
    @ResponseBody
    public Object prePayOrder(@RequestBody Map<String, String> map) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String courseIds = map.get("courseIds");
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
        orderInfo.setOrderNo(DateUtil.formatDate(date, DateUtil.YMDHMS) + getMyselfId() + new Random().nextInt(10000));
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


    /**
     * 我的订单接口
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/myOrderInfo", method = {RequestMethod.GET})
    @ResponseBody
    public Object prePayOrder(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int pageNums = request.getParameter("pageNum") == null ? pageNum : Integer.parseInt(request.getParameter("pageNum"));
        int pageSizes = request.getParameter("pageSize") == null ? pageSize : Integer.parseInt(request.getParameter("pageSize"));
        Page<OrderInfo> page = orderInfoService.selectByUserId(getMyselfId(), pageNums, pageSizes);
        resultMap.put("orders", orderInfoConvert.convertVOList(page.getResult()));
        resultMap.put("pageNum", page.getPageNum());
        resultMap.put("pageSize", page.getPageSize());
        resultMap.put("page", page.getPages());
        resultMap.put("total", page.getTotal());
        return ResponseUtils.sendSuccess(resultMap);
    }

}
