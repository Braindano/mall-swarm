package com.macro.mall.portal.controller;


import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.UmsMember;
import com.macro.mall.portal.domain.act.ActConfirmOrderResult;
import com.macro.mall.portal.domain.act.ActOrderParam;
import com.macro.mall.portal.service.ActOrderService;
import com.macro.mall.portal.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@Api(tags = "ActOrderController", description = "活动订单管理")
@RequestMapping("/actOrder")
public class ActOrderController {

    @Resource
    private ActOrderService actOrderService;

    @Resource
    private UmsMemberService memberService;

    @ApiOperation("生成活动确认单信息")
    @RequestMapping(value = "/generateConfirmOrder", method = RequestMethod.POST)
    public CommonResult<ActConfirmOrderResult> generateOrder(@RequestParam Long actId) {
        ActConfirmOrderResult result = actOrderService.generateConfirmOrder(actId);
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
    public WxPayMpOrderResult prepay(@RequestBody Long orderId, HttpServletRequest request) {
        return actOrderService.prepay(orderId, request);
    }

    @ApiOperation("用户支付成功的回调")
    @RequestMapping(value = "/paySuccess", method = RequestMethod.POST)
    public CommonResult paySuccess(@RequestParam Long orderId) {
        Integer count = actOrderService.paySuccess(orderId);
        return CommonResult.success(count, "支付成功");
    }

    @ApiOperation("查询用户活动记录")
    @GetMapping(value = "/myAct")
    public CommonResult myAct() {
        UmsMember currentMember = memberService.getCurrentMember();
        Long memberId = currentMember.getId();
        return CommonResult.success(actOrderService.listOrderActByUser(memberId));
    }

    @ApiOperation("用户确认收货")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderSn", value = "订单号", required=true, dataType = "string", paramType = "query")
    })
    @GetMapping(value = "/confirmGet")
    public CommonResult confirmGet(@RequestParam("orderSn") String orderSn) {
        return CommonResult.success(actOrderService.confirmGet(orderSn));
    }
}
