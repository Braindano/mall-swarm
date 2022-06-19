package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.ActAct;
import com.macro.mall.model.ActOrderReturn;
import com.macro.mall.model.dto.ActOrderWithItem;
import com.macro.mall.model.query.ActOrderQuery;
import com.macro.mall.model.query.ActOrderReturnQuery;
import com.macro.mall.service.ActOrderService;
import com.macro.mall.service.ActService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单管理
 */
@RestController
@Api(tags = "ActOrderController", value = "订单管理")
@RequestMapping("/actOrder")
public class ActOrderController {
    @Resource
    private ActService actService;

    @Resource
    private ActOrderService orderService;


    @ApiOperation("查询订单列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public CommonResult<CommonPage<ActOrderWithItem>> list(@RequestBody ActOrderQuery actOrderQuery) {
        List<ActOrderWithItem> actOrderWithItems = orderService.listOrder(actOrderQuery);
        return CommonResult.success(CommonPage.restPage(actOrderWithItems));
    }

    @ApiOperation("查询活动退单列表")
    @RequestMapping(value = "/return/list", method = RequestMethod.POST)
    public CommonResult<CommonPage<ActOrderReturn>> returnOrderList(@RequestBody ActOrderReturnQuery query) {
        List<ActOrderReturn> actOrderReturns = orderService.listOrderReturn(query);
        return CommonResult.success(CommonPage.restPage(actOrderReturns));
    }



}
