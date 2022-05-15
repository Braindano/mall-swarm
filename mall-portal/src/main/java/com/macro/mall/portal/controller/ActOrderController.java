package com.macro.mall.portal.controller;


import com.macro.mall.common.api.CommonResult;
import com.macro.mall.portal.domain.OrderParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@Api(tags = "ActOrderController", description = "活动订单管理")
@RequestMapping("/actOrder")
public class ActOrderController {



    @ApiOperation("生成活动订单")
    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult generateOrder(@RequestBody OrderParam orderParam) {

//        Map<String, Object> result = portalOrderService.generateOrder(orderParam);
//        return CommonResult.success(result, "下单成功");
    }


}
