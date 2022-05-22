package com.macro.mall.portal.service;

import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.macro.mall.model.ActOrder;
import com.macro.mall.model.dto.ActDto;
import com.macro.mall.portal.domain.act.ActConfirmOrderResult;
import com.macro.mall.portal.domain.act.ActOrderParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 活动订单
 */
public interface ActOrderService {

    /**
     * 确认订单信息
     * @param actId
     * @return
     */
    ActConfirmOrderResult generateConfirmOrder(Long actId);

    /**
     * 根据提交信息生成订单
     */

    Map<String, Object> generateOrder(ActOrderParam orderParam);

    /**
     * 预支付信息
     * @param orderId
     * @param request
     */
    WxPayMpOrderResult prepay(Long orderId, HttpServletRequest request);

    /**
     * 支付成功回调
     * @param orderId 订单id
     * @return
     */
    Integer paySuccess(Long orderId);

    /**
     * 获取用户订单记录
     * @param memberId
     * @return
     */
    List<ActOrder> listOrderByUser(Long memberId);

    /**
     * 获取用户下单活动列表
     * @param memberId
     * @return
     */
    List<ActDto> listOrderActByUser(Long memberId);

    /**
     * 订单确认收获
     * @param orderSn
     * @return
     */
    int confirmGet(String orderSn);
}
