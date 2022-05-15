package com.macro.mall.portal.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.google.gson.JsonObject;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.common.config.ActConstants;
import com.macro.mall.model.ActAct;
import com.macro.mall.model.dto.Data;
import com.macro.mall.model.query.ActQuery;
import com.macro.mall.model.query.RecActQuery;
import com.macro.mall.portal.feign.ActService;
import com.macro.mall.portal.service.ActHomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 活动首页
 */
@Controller
@Api(tags = "ActHomeController", description = "活动首页")
@RequestMapping("/act/home")
public class ActHomeController {

    @Resource
    private ActHomeService actHomeService;


    @ApiOperation("获取首页数据")
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Data> content() {
        Data data = new Data();
        String config = actHomeService.getConfig(ActConstants.ACT_CONFIG_BANNER);
        JSONArray bannerArr = JSONUtil.parseArray(config);
        data.setBanner(JSONUtil.toList(bannerArr, String.class));
        JSONArray noticeArr = JSONUtil.parseArray(actHomeService.getConfig(ActConstants.ACT_CONFIG_NOTICE));
        data.setNoticeList(JSONUtil.toList(noticeArr, String.class));
        data.setNeedActList(actHomeService.getRecActList(ActConstants.ACT_REC_TYPE_NEED));
        data.setChoiceActList(actHomeService.getRecActList(ActConstants.ACT_REC_TYPE_CHOICE));
        data.setDiscountActList(actHomeService.getRecActList(ActConstants.ACT_REC_TYPE_DISCOUNT));
        return CommonResult.success(data);
    }

    @ApiOperation("按条件获取活动列表")
    @RequestMapping(value = "/listActByQuery", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ActAct>> getActList(@ModelAttribute ActQuery query) {
        query.setPageNum(Optional.ofNullable(query.getPageNum()).orElse(1));
        query.setPageSize(Optional.ofNullable(query.getPageSize()).orElse(10));
        List<ActAct> actList = actHomeService.getActList(query);
        return CommonResult.success(CommonPage.restPage(actList));
    }

    @ApiOperation("按推荐类型获取活动列表")
    @RequestMapping(value = "/listByRecommendType", method = RequestMethod.GET)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "recommendType", value = "推荐类型：1-必玩、2-精选、3-特价", required=true, dataType = "int", paramType = "query")
    })
    @ResponseBody
    public CommonResult<List<ActAct>> getRecActList(@RequestParam Integer recommendType) {
        List<ActAct> actList = actHomeService.getRecActList(recommendType);
        return CommonResult.success(actList);
    }



}
