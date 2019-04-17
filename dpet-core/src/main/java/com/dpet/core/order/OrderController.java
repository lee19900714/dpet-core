package com.dpet.core.order;

import com.dpet.commons.OrderStatus;
import com.dpet.commons.PayType;
import com.dpet.commons.utils.DateUtil;
import com.dpet.commons.utils.StringUtil;
import com.dpet.commons.utils.UUIDUtil;
import com.dpet.convertors.CourseInfoConvertor;
import com.dpet.convertors.OrderInfoConvert;
import com.dpet.core.MyBaseController;
import com.dpet.framework.ResponseUtils;
import com.dpet.model.CourseInfo;
import com.dpet.model.OrderInfo;
import com.dpet.model.UserInfo;
import com.dpet.paycenter.wechat.cfg.WechatConfig;
import com.dpet.paycenter.wechat.exception.WeiXinPayException;
import com.dpet.paycenter.wechat.utils.CommonUtil;
import com.dpet.paycenter.wechat.utils.JSAPIUtils;
import com.dpet.paycenter.wechat.utils.XMLUtil;
import com.dpet.paycenter.wechat.vo.JSPayParam;
import com.dpet.service.inter.CourseInfoService;
import com.dpet.service.inter.OrderInfoService;
import com.dpet.service.inter.UserInfoService;
import com.dpet.vo.CourseInfoVO;
import com.dpet.vo.OrderInfoVO;
import com.github.pagehelper.Page;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;

/**
 * The type Order controller.
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping(value = "ipet/orderinfo")
public class OrderController extends MyBaseController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private CourseInfoService courseInfoService;

    @Autowired
    private OrderInfoConvert orderInfoConvert;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private CourseInfoConvertor courseInfoConvertor;

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
        resultMap.put("orderInfo", orderInfo);
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
        String orderStatus = request.getParameter("orderStatus");
        Page<OrderInfo> page = orderInfoService.selectByUserId(getMyselfId(), orderStatus, pageNums, pageSizes);
        List<OrderInfoVO> orderInfoVOS = orderInfoConvert.convertVOList(page.getResult());
        orderInfoVOS.forEach(s -> {
            //支付类型转换
            s.setPayType(PayType.getValue(Integer.parseInt(s.getPayType())));
            //订单状态
            s.setOrderState(OrderStatus.getValue(Integer.parseInt(s.getOrderState())));
            String buyCourseId = s.getBuyCourseId();
            if (StringUtils.isBlank(buyCourseId)) {
                return;
            }
            List<String> courseIds = Arrays.asList(buyCourseId.split(","));
            if (CollectionUtils.isEmpty(courseIds)) {
                return;
            }
            List<CourseInfoVO> courseInfoVOList = new ArrayList<>();
            courseIds.forEach(c -> {
                CourseInfo courseInfo = courseInfoService.selectByPrimaryKey(c);
                courseInfoVOList.add(courseInfoConvertor.convertVO(courseInfo));
            });
            s.setCourseInfoVOS(courseInfoVOList);
        });
        resultMap.put("orders", orderInfoVOS);
        resultMap.put("pageNum", page.getPageNum());
        resultMap.put("pageSize", page.getPageSize());
        resultMap.put("page", page.getPages());
        resultMap.put("total", page.getTotal());
        return ResponseUtils.sendSuccess(resultMap);
    }

    // 微信支付统一下单预处理（拉起微信支付）
    @RequestMapping(value = "/payment")
    public @ResponseBody
    Object ajaxPay(HttpServletRequest request) {
        String orderId = request.getParameter("orderId");
        if (StringUtil.isEmpty(orderId)) {
            return ResponseUtils.sendFailure("订单号为空");
        }

        OrderInfo order = orderInfoService.selectByPrimaryKey(orderId);
        if (order == null) {
            return ResponseUtils.sendFailure("订单已经不存在");
        }

        // 防止重复支付
        if (order.getOrderState() != OrderStatus.PENDING_PAY) {
            return ResponseUtils.sendFailure("不符合的订单状态：" + order.getOrderState());
        }

        UserInfo userInfo = userInfoService.selectByPrimaryKey(getMyselfId());
        String openId = userInfo.getOpenId();

        Map<String, Object> datas = new HashMap<String, Object>();
        // 微信预支付创建
        logger.info("微信订单创建--->userId-----------" + userInfo.getId());

        SortedMap<String, String> paramMap = new TreeMap<String, String>();
        // 公众账号ID
        paramMap.put("appid", WechatConfig.appId);
        // 商户号
        paramMap.put("mch_id", WechatConfig.mchId);
        // 随机字符串
        paramMap.put("nonce_str", CommonUtil.CreateNoncestr());
        // 商品描述
        String body = "宠到-商城";

        paramMap.put("body", body);
        // 商户支付订单号
        paramMap.put("out_trade_no", order.getId());

        String total_fee = new BigDecimal(order.getOrderAmount()).multiply(new BigDecimal("100")).intValue() + "";
        paramMap.put("total_fee", total_fee);
        // 终端IP
        paramMap.put("spbill_create_ip", WechatConfig.spbillCreateIp);
        // 交易起始时间
        paramMap.put("time_start", DateUtil.formatDate(order.getCreateTime(), "yyyyMMddHHmmss"));
        // 通知地址
        paramMap.put("notify_url", WechatConfig.notifyUrl);
        // 交易类型
        paramMap.put("trade_type", WechatConfig.tradeType);
        // 微信用户的openid
        paramMap.put("openid", openId);

        logger.info("拉起支付请求-------" + paramMap);

        // 签名
        paramMap.put("sign", CommonUtil.createSign("UTF-8", paramMap));
        String returnStr = CommonUtil.httpsRequest(WechatConfig.unifiedorderUrl, "POST",
                CommonUtil.getRequestXml(paramMap));

        logger.info("拉起支付返回-------" + returnStr);

        try {
            Map<String, String> xmlMap = XMLUtil.doXMLParse(returnStr);
            String return_code = xmlMap.get("return_code");
            if ("SUCCESS".equals(return_code)) {
                String result_code = xmlMap.get("result_code");
                if ("SUCCESS".equals(result_code)) {
                    String prepay_id = xmlMap.get("prepay_id");
                    JSPayParam payParam = JSAPIUtils.createPayParam(prepay_id);
                    datas.put("appId", WechatConfig.appId);
                    datas.put("timeStamp", payParam.getTimeStamp());
                    datas.put("nonceStr", payParam.getNonceStr());
                    datas.put("package", payParam.getPk());
                    datas.put("signType", payParam.getSignType());
                    datas.put("paySign", payParam.getPaySign());
                } else {
                    logger.error("调用微信支付失败：result_code：" + result_code);
                    return ResponseUtils.sendFailure("调用微信支付失败:01");
                }
            } else {
                String return_msg = xmlMap.get("return_msg");
                logger.error("调用微信支付失败：" + return_msg);
                return ResponseUtils.sendFailure("调用微信支付失败:02");
            }
        } catch (Exception e) {
            logger.error("调用微信支付失败：" + e.getMessage());
            return ResponseUtils.sendFailure("调用微信支付失败:03");
        }
        return ResponseUtils.sendSuccess(datas);
    }


    // 微信支付回调通知
    @RequestMapping(value = "/notify")
    public void notify(HttpServletRequest request, HttpServletResponse response) {
        logger.info("-------------微信支付回调通知---------");
        String orderId = null;
        String transactionId = null;
        try {
            InputStream in = request.getInputStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.close();
            in.close();
            String result = new String(out.toByteArray(), "utf-8");
            // 解析xml成map
            Map<String, String> map = XMLUtil.doXMLParse(result);
            orderId = map.get("out_trade_no");
            transactionId = map.get("transaction_id");

            if (map.get("return_code").equalsIgnoreCase("SUCCESS")) {
                if (map.get("result_code").equalsIgnoreCase("SUCCESS")) {
                    // 支付成功
                    logger.info("-------------回复微信回调通知SUCCESS---------orderId：" + orderId);
                    response.getWriter().write(CommonUtil.setXML("SUCCESS", ""));

                    OrderInfo order = orderInfoService.selectByPrimaryKey(orderId);
                    if (order == null) {
                        throw new WeiXinPayException(
                                "Wechat result_code is SUCCESS, but the order is not exist|orderId" + orderId);
                    } else {
                        // 防止重复处理
                        if (order.getOrderState() != OrderStatus.PENDING_PAY) {
                            return;
                        }
                        // 支付成功业务处理部分
                        // 1.更改订单状态
                        order.setOrderState(OrderStatus.COMPELETED);
                        orderInfoService.updateByPrimaryKey(order);
                    }
                } else {
                    String return_msg = map.get("return_msg");
                    throw new WeiXinPayException("Wechat result_code is FAIL,return_msg:" + return_msg);
                }
            } else {
                throw new WeiXinPayException("Wechat return_code is FAIL");
            }
        } catch (WeiXinPayException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
