package com.macro.mall.portal.service;

import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.macro.mall.model.ActAct;
import com.macro.mall.model.ActOrder;
import com.macro.mall.model.ActOrderReturn;
import com.macro.mall.model.dto.ActDto;
import com.macro.mall.model.dto.ActOrderWithItem;
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
    WxPayMpOrderResult prepay(String orderId, HttpServletRequest request);

    /**
     * 支付成功回调
     * @param orderSn 订单流水号
     * @return
     */
    Integer paySuccess(String orderSn);

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

    /**
     * 取消超时订单
     */
    Integer cancelTimeOutOrder();

    /**
     * 获取用户订单记录
     * @param memberId 用户id
     * @param orderStatus 订单状态
     * @return
     */
    List<ActOrderWithItem> getOrderByStatus(Long memberId, Integer orderStatus);

    ActOrderWithItem getOrderByOrderSn(String orderSn);

    ActAct getActById(Long actId);

    /**
     * 活动退单申请
     * @param actOrderReturn
     * @return
     */
    Integer orderReturn(ActOrderReturn actOrderReturn);


    /**
     * 查询退单申请
     * @param orderSn
     * @param userId
     * @param status
     * @return
     */
    List<ActOrderReturn>  getOrderReturn(String orderSn, Long userId, Integer status);
}
