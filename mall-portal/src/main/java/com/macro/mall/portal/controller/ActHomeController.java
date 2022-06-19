package com.macro.mall.portal.controller;

import com.google.common.collect.Lists;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.common.config.ActConstants;
import com.macro.mall.common.constant.AuthConstant;
import com.macro.mall.mapper.ActConfigMapper;
import com.macro.mall.mapper.ActUserClubMapper;
import com.macro.mall.model.ActAct;
import com.macro.mall.model.ActArticle;
import com.macro.mall.model.ActConfig;
import com.macro.mall.model.UmsMember;
import com.macro.mall.model.dto.ActClubDto;
import com.macro.mall.model.dto.ActDto;
import com.macro.mall.model.dto.Data;
import com.macro.mall.model.query.ActQuery;
import com.macro.mall.model.query.ActQueryForRest;
import com.macro.mall.portal.feign.FeignAdminService;
import com.macro.mall.portal.service.ActHomeService;
import com.macro.mall.portal.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @Resource
    private UmsMemberService memberService;

    @Resource
    private ActUserClubMapper userClubMapper;

    @Resource
    private HttpServletRequest request;

    @Resource
    private ActConfigMapper configMapper;

    @ApiOperation("获取首页数据")
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Data> content() {
        Data data = new Data();
        String[] bannerArr = actHomeService.getConfig(ActConstants.ACT_CONFIG_BANNER).split(",");
        data.setBanner(Lists.newArrayList(bannerArr));
        data.setActTypeList(actHomeService.listActType());
        String[] noticeArr = actHomeService.getConfig(ActConstants.ACT_CONFIG_NOTICE).split(",");
        data.setNoticeList(Lists.newArrayList(noticeArr));
        data.setNeedActList(actHomeService.getRecActList(ActConstants.ACT_REC_TYPE_NEED));
        data.setChoiceActList(actHomeService.getRecActList(ActConstants.ACT_REC_TYPE_CHOICE));
        data.setDiscountActList(actHomeService.getRecActList(ActConstants.ACT_REC_TYPE_DISCOUNT));
        return CommonResult.success(data);
    }

    @ApiOperation("根据configCode查询配置详情")
    @RequestMapping(value = "/getDetailByCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ActConfig> getDetailByCode(String configCode) {
        ActConfig config = configMapper.getByConfigCode(configCode);
        return CommonResult.success(config);
    }

    @ApiOperation("按条件获取活动列表")
    @RequestMapping(value = "/listActByQuery", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ActAct>> getActList(@ModelAttribute ActQueryForRest queryForRest) {
        queryForRest.setPageNum(Optional.ofNullable(queryForRest.getPageNum()).orElse(1));
        queryForRest.setPageSize(Optional.ofNullable(queryForRest.getPageSize()).orElse(10));
        ActQuery query = ActQueryForRest.convert(queryForRest);
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

    @ApiOperation("获取活动详情")
    @RequestMapping(value = "/getActInfo", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "actId", value = "活动id", required=true, dataType = "long", paramType = "query")
    })
    @ResponseBody
    public CommonResult<ActDto> getActInfo(@RequestParam Long actId) {
        ActDto actDto = actHomeService.getActInfo(actId);
        return CommonResult.success(actDto);
    }

    @ApiOperation("获取俱乐部详情")
    @RequestMapping(value = "/getClubInfo", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "clubId", value = "俱乐部id", required=true, dataType = "long", paramType = "query")
    })
    @ResponseBody
    public CommonResult<ActClubDto> getClubInfo(@RequestParam Long clubId, HttpServletRequest request) {
        String loginToken = request.getHeader(AuthConstant.JWT_TOKEN_HEADER);
        String realToken = loginToken.replace(AuthConstant.JWT_TOKEN_PREFIX, "");
        ActClubDto actClubDto = actHomeService.getClubInfo(clubId, realToken);
        return CommonResult.success(actClubDto);
    }

    @ApiOperation("按获取活动参与人")
    @RequestMapping(value = "/getActMembers", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "actId", value = "活动id", required=true, dataType = "long", paramType = "query")
    })
    @ResponseBody
    public CommonResult<List<UmsMember>> getActMembers(@RequestParam Long actId) {
        return CommonResult.success( actHomeService.getActMembers(actId));
    }

    @ApiOperation("获取活动文章")
    @RequestMapping(value = "/getActArticle", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章id", required=true, dataType = "long", paramType = "query")
    })
    @ResponseBody
    public CommonResult<ActArticle> getActArticle(@RequestParam Long articleId) {
        return CommonResult.success(actHomeService.getArticleById(articleId));
    }


}
