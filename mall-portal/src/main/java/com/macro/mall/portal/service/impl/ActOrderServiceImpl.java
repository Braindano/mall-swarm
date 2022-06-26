package com.macro.mall.portal.service.impl;

import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.service.WxPayService;
import com.google.common.collect.Lists;
import com.macro.mall.common.config.ActOrderConstants;
import com.macro.mall.common.exception.ApiException;
import com.macro.mall.common.exception.Asserts;
import com.macro.mall.common.service.RedisService;
import com.macro.mall.mapper.*;
import com.macro.mall.model.*;
import com.macro.mall.model.dto.ActDto;
import com.macro.mall.model.dto.ActOrderWithItem;
import com.macro.mall.model.query.ActOrderQuery;
import com.macro.mall.portal.dao.UmsMemberWxDao;
import com.macro.mall.portal.domain.UmsMemberWx;
import com.macro.mall.portal.domain.act.ActConfirmOrderResult;
import com.macro.mall.portal.domain.act.ActOrderParam;
import com.macro.mall.portal.service.ActOrderService;
import com.macro.mall.portal.service.UmsMemberService;
import com.macro.mall.portal.util.IpUtil;
import javafx.stage.Screen;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ActOrderServiceImpl implements ActOrderService {


    @Resource
    private UmsMemberService memberService;

    @Resource
    private ActActMapper actMapper;

    @Resource
    private ActOrderMapper orderMapper;

    @Resource
    private ActOrderItemMapper orderItemMapper;

    @Resource
    private UmsMemberWxDao umsMemberWxDao;

    @Resource
    private RedisService redisService;

    @Resource
    private WxPayService wxPayService;

    @Resource
    private OmsOrderSettingMapper orderSettingMapper;

    @Resource
    private ActOrderReturnMapper orderReturnMapper;

    @Value("${redis.key.orderId}")
    private String REDIS_KEY_ORDER_ID;
    @Value("${redis.database}")
    private String REDIS_DATABASE;


    @Override
    public ActConfirmOrderResult generateConfirmOrder(Long actId) {
        ActConfirmOrderResult result = new ActConfirmOrderResult();

        ActAct actAct = actMapper.selectByPrimaryKey(actId);
        result.setAct(actAct);

        ActConfirmOrderResult.CalcAmount calcAmount = new ActConfirmOrderResult.CalcAmount();
        calcAmount.setTotalAmount(actAct.getOriginalPrice());
        calcAmount.setPromotionAmount(actAct.getOriginalPrice().subtract(actAct.getPromotionPrice()));
        calcAmount.setPayAmount(actAct.getPromotionPrice());
        result.setCalcAmount(calcAmount);
        return result;
    }

    @Override
    @Transactional
    public Map<String, Object> generateOrder(ActOrderParam orderParam) {
        UmsMember currentMember = memberService.getCurrentMember();

        // 1、判断活动商品库存、锁库存
        ActAct actAct = actMapper.selectForUpdate(orderParam.getActId());
        if (actAct.getInventory() <= 0) {
            Asserts.fail("库存不足，无法下单");
        }

        // 2、扣减库存
        actAct.setInventory(actAct.getInventory() - 1);
        actMapper.updateByPrimaryKeySelective(actAct);

        // 3、生成订单信息
        ActOrder order = new ActOrder();

        //转化为订单信息并插入数据库
        order.setMemberId(currentMember.getId());
        order.setCreateTime(new Date());
        order.setMemberUsername(currentMember.getUsername());
        //支付方式：0->未支付；1->支付宝；2->微信
        order.setPayType(2);
        //订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
        order.setStatus(0);
        //收货人信息：姓名、电话、邮编、地址
        order.setReceiverName(orderParam.getReceiverName());
        order.setReceiverPhone(orderParam.getReceiverPhone());
        order.setReceiverDetailAddress(orderParam.getReceiverDetailAddress());
        //0->未确认；1->已确认
        order.setConfirmStatus(0);
        order.setDeleteStatus(0);
        // 记录价格
        order.setTotalAmount(actAct.getOriginalPrice());
        order.setPromotionAmount(actAct.getOriginalPrice().subtract(actAct.getPromotionPrice()));
        order.setPayAmount(actAct.getPromotionPrice());

        //生成订单号
        order.setOrderSn(generateOrderSn(order));
        //插入order表和order_item表
        orderMapper.insert(order);

        ActOrderItem item = new ActOrderItem();
        item.setOrderId(order.getId());
        item.setOrderSn(order.getOrderSn());
        item.setActId(actAct.getId());
        item.setActName(actAct.getActName());
        item.setPayPrice(actAct.getPromotionPrice());
        item.setClubId(actAct.getClubId());
        orderItemMapper.insert(item);

        //发送延迟消息取消订单
        //定时任务清理未完成订单

        Map<String, Object> result = new HashMap<>();
        result.put("order", order);
        result.put("orderItem", item);
        return result;
    }

    @Override
    public WxPayMpOrderResult prepay(String orderSn, HttpServletRequest request) {
        UmsMember currentMember = memberService.getCurrentMember();
        Long memberId = currentMember.getId();
        ActOrder order = orderMapper.selectByOrderSn(orderSn);
        if (order == null) {
            throw new ApiException("订单不存在");
        }
        if (!order.getMemberId().equals(memberId)) {
            throw new ApiException("登录用户非当前订单用户");
        }
        if (order.getStatus() != 0) {
            throw new ApiException("订单已支付");
        }
        UmsMemberWx umsMemberWx = umsMemberWxDao.selectByMemberId(memberId);
        String openId = umsMemberWx.getOpenId();

        WxPayMpOrderResult result = null;
        try {
            WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
            orderRequest.setOutTradeNo(order.getOrderSn());
            orderRequest.setOpenid(openId);
            orderRequest.setBody("订单：" + order.getOrderSn());
            // 元转成分
            int fee = 0;
            BigDecimal actualPrice = order.getPayAmount();
            fee = actualPrice.multiply(new BigDecimal(100)).intValue();
            orderRequest.setTotalFee(fee);
            orderRequest.setSpbillCreateIp(IpUtil.getIpAddr(request));
            result = wxPayService.createOrder(orderRequest);
        } catch (Exception e) {
            throw new ApiException("调用微信支付失败");
        }
        return result;
    }

    @Override
    public Integer paySuccess(String orderSn) {
        ActOrder actOrder = orderMapper.selectByOrderSn(orderSn);
        //修改订单支付状态
        ActOrder order = new ActOrder();
        order.setId(actOrder.getId());
        order.setStatus(1);
        order.setPaymentTime(new Date());

        //报名用户+1
        ActOrderItem item = orderItemMapper.selectByOrderSn(orderSn);
        actMapper.incSaleCnt(item.getActId());

        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public List<ActOrder> listOrderByUser(Long memberId) {
        ActOrderExample example = new ActOrderExample();
        ActOrderExample.Criteria criteria = example.createCriteria();
        criteria.andMemberIdEqualTo(memberId);
        // 过滤无效订单
        criteria.andStatusNotIn(Lists.newArrayList(4,5));
        example.setOrderByClause("order by id desc");
        return orderMapper.selectByExample(example);
    }

    private String generateOrderSn(ActOrder order) {
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String key = REDIS_DATABASE+":"+ REDIS_KEY_ORDER_ID + date;
        Long increment = redisService.incr(key, 1);
        sb.append(date);
        sb.append(String.format("%04d", order.getPayType()));
        String incrementStr = increment.toString();
        if (incrementStr.length() <= 6) {
            sb.append(String.format("%06d", increment));
        } else {
            sb.append(incrementStr);
        }
        return sb.toString();
    }

    @Override
    public List<ActDto> listOrderActByUser(Long memberId) {
        return actMapper.selectOrderActByUser(memberId);
    }

    @Override
    public int confirmGet(String orderSn) {
        return orderMapper.updateStatusByOrderSn(orderSn, ActOrderConstants.ORDER_COMPLETE);
    }

    @Override
    public Integer cancelTimeOutOrder() {
        System.err.println("--------------------------------------取消过期订单-----------------------------------");
        Integer count=0;
        OmsOrderSetting orderSetting = orderSettingMapper.selectByPrimaryKey(1L);
        //查询超时、未支付的订单及订单详情
        List<ActOrderWithItem> timeOutOrders = orderMapper.getTimeOutOrders(orderSetting.getNormalOrderOvertime());
        if (CollectionUtils.isEmpty(timeOutOrders)) {
            return count;
        }
        //修改订单状态为交易取消
        List<Long> ids = timeOutOrders.stream().map(ActOrder::getId).collect(Collectors.toList());
        orderMapper.updateOrderStatus(ids, 4);
        for (ActOrderWithItem order: timeOutOrders) {
            Long actId = order.getActId();
            ActAct actAct = actMapper.selectForUpdate(actId);
            actAct.setInventory(actAct.getInventory() + 1);
            actMapper.updateByPrimaryKeySelective(actAct);
        }
        return count;
    }

    @Override
    public List<ActOrderWithItem> getOrderByStatus(Long memberId, Integer orderStatus) {
        return orderMapper.getOrderByStatus(memberId, orderStatus);
    }

    @Override
    public ActOrderWithItem getOrderByOrderSn(String orderSn) {
        ActOrderQuery actOrderQuery = new ActOrderQuery();
        actOrderQuery.setOrderSn(orderSn);
        List<ActOrderWithItem> actOrderWithItems = orderMapper.listOrderWithItem(actOrderQuery);
        if (CollectionUtils.isNotEmpty(actOrderWithItems)) {
            return actOrderWithItems.get(0);
        }
        return null;
    }

    @Override
    public ActAct getActById(Long actId) {
        return actMapper.selectByPrimaryKey(actId);
    }

    @Override
    public Integer orderReturn(ActOrderReturn actOrderReturn) {
        return orderReturnMapper.insertSelective(actOrderReturn);
    }

    @Override
    public List<ActOrderReturn> getOrderReturn(String orderSn, Long userId, Integer status) {
        ActOrderReturnExample example = new ActOrderReturnExample();
        ActOrderReturnExample.Criteria criteria = example.createCriteria();
        criteria.andOrderSnEqualTo(orderSn);
        criteria.andStatusEqualTo(status);
        criteria.andUserIdEqualTo(userId);
        return orderReturnMapper.selectByExample(example);
    }
}
