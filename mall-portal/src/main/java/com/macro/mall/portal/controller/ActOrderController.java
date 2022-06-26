package com.macro.mall.portal.controller;


import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.common.config.ActOrderConstants;
import com.macro.mall.model.ActOrderReturn;
import com.macro.mall.model.UmsMember;
import com.macro.mall.model.dto.ActOrderInfoDto;
import com.macro.mall.model.dto.ActOrderReturnDto;
import com.macro.mall.model.dto.ActOrderWithItem;
import com.macro.mall.model.query.ActOrderReturnQuery;
import com.macro.mall.portal.domain.act.ActConfirmOrderResult;
import com.macro.mall.portal.domain.act.ActIdDto;
import com.macro.mall.portal.domain.act.ActOrderParam;
import com.macro.mall.portal.service.ActOrderService;
import com.macro.mall.portal.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(tags = "ActOrderController", description = "活动订单管理")
@RequestMapping("/actOrder")
public class ActOrderController {

    private static Logger logger = LoggerFactory.getLogger(ActOrderController.class);

    @Resource
    private ActOrderService actOrderService;

    @Resource
    private UmsMemberService memberService;

    @ApiOperation("生成活动确认单信息")
    @RequestMapping(value = "/generateConfirmOrder", method = RequestMethod.POST)
    public CommonResult<ActConfirmOrderResult> generateOrder(@RequestBody ActIdDto actIdDto) {
        ActConfirmOrderResult result = actOrderService.generateConfirmOrder(actIdDto.getActId());
        return CommonResult.success(result);
    }

    @ApiOperation("生成活动订单")
    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    public CommonResult generateOrder(@RequestBody ActOrderParam orderParam) {
        Map<String, Object> result = actOrderService.generateOrder(orderParam);
        return CommonResult.success(result, "下单成功");
    }

    @ApiOperation("微信预支付")
    @PostMapping("prepay")
    public CommonResult<WxPayMpOrderResult> prepay(@RequestBody String orderSn, HttpServletRequest request) {
        return CommonResult.success(actOrderService.prepay(orderSn, request));
    }

    @ApiOperation("用户支付成功的回调")
    @RequestMapping(value = "/paySuccess", method = RequestMethod.POST)
    public CommonResult paySuccess(@RequestParam String orderSn) {
        Integer count = actOrderService.paySuccess(orderSn);
        return CommonResult.success(count, "支付成功");
    }

    @ApiOperation("查询用户活动记录")
    @GetMapping(value = "/myAct")
    public CommonResult myAct() {
        UmsMember currentMember = memberService.getCurrentMember();
        Long memberId = currentMember.getId();
        return CommonResult.success(actOrderService.listOrderActByUser(memberId));
    }

    @ApiOperation("查询活动订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderStatus", value = "订单状态", required=false, dataType = "int", paramType = "query")
    })
    @GetMapping(value = "/getActOrderList")
    public CommonResult<List<ActOrderInfoDto>> getActOrderList(Integer orderStatus) {
        List<ActOrderInfoDto> actOrderInfoDtos = new ArrayList<>();
        UmsMember currentMember = memberService.getCurrentMember();
        Long memberId = currentMember.getId();
        List<ActOrderWithItem> actOrderWithItems = actOrderService.getOrderByStatus(memberId, orderStatus);
        if (CollectionUtils.isEmpty(actOrderWithItems)) {
            return CommonResult.success(actOrderInfoDtos);
        }
        actOrderWithItems.forEach(actOrderWithItem -> {
            ActOrderInfoDto actOrderInfoDto = new ActOrderInfoDto();
            actOrderInfoDto.setOrderWithItem(actOrderWithItem);
            actOrderInfoDto.setAct(actOrderService.getActById(actOrderWithItem.getActId()));
            actOrderInfoDtos.add(actOrderInfoDto);
        });
        return CommonResult.success(actOrderInfoDtos);
    }

    @ApiOperation("用户确认收货")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderSn", value = "订单号", required=true, dataType = "string", paramType = "query")
    })
    @GetMapping(value = "/confirmGet")
    public CommonResult confirmGet(@RequestParam("orderSn") String orderSn) {
        return CommonResult.success(actOrderService.confirmGet(orderSn));
    }

    @ApiOperation("发起活动订单退款")
    @PostMapping(value = "/orderReturn")
    public CommonResult orderReturn(@RequestBody ActOrderReturnDto query) {
        String orderSn = query.getOrderSn();
        Long userId = query.getUserId();
        if (StringUtils.isEmpty(orderSn) || StringUtils.isEmpty(userId)) {
            logger.error("退单申请参数异常：订单编号-{}， 用户id-{}", orderSn, userId);
            return CommonResult.failed("退单申请参数异常");
        }
        List<ActOrderReturn> orderReturns = actOrderService.getOrderReturn(orderSn, userId, 1);
        if (CollectionUtils.isNotEmpty(orderReturns)){
            return CommonResult.failed("该订单已存在退单申请，请等待商家审批");
        }
        ActOrderWithItem orderWithItem = actOrderService.getOrderByOrderSn(orderSn);
        if (Objects.isNull(orderWithItem)) {
            return CommonResult.failed("未查询到相关订单信息");
        }
        Integer status = orderWithItem.getStatus();
        if (ActOrderConstants.UN_RETURN_STATUS_LIST.contains(status)) {
            logger.error("退单申请失败：订单编号-{}， 用户id-{}", orderSn, userId);
            return CommonResult.failed("订单状态不满足申请退单条件");
        }
        ActOrderReturn actOrderReturn = ActOrderReturnDto.convert2do(query);
        actOrderReturn.setStatus(1);
        return CommonResult.success(actOrderService.orderReturn(actOrderReturn));
    }

}
