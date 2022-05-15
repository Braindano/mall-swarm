package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.ActAct;
import com.macro.mall.model.ActRecommend;
import com.macro.mall.model.dto.RecActDto;
import com.macro.mall.service.ActRecommendService;
import com.macro.mall.service.ActService;
import com.macro.mall.util.AdminClubUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 活动管理
 */
@RestController
@Api(tags = "ActController", value = "活动管理")
@RequestMapping("/act")
public class ActController {
    @Resource
    private ActService actService;

    @Resource
    private ActRecommendService recommendService;

    @Resource
    private AdminClubUtil adminClubUtil;

    @ApiOperation("添加活动")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResult add(@RequestBody ActAct act) {
        int add = actService.add(act);
        return CommonResult.success(add);
    }

    @ApiOperation("修改活动")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult update(@RequestBody ActAct act) {
        int update = actService.update(act);
        return CommonResult.success(update);
    }

    @ApiOperation("删除活动")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public CommonResult delete(Long id) {
        int delete = actService.delete(id);
        return CommonResult.success(delete);
    }

    @ApiOperation("查询活动列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<ActAct>> list(@RequestParam(value = "actTypeId", required = false) Long actTypeId,
                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Long clubId = adminClubUtil.getCurrentAminClubId();
        List<ActAct> actActs = actService.listAct(clubId, actTypeId, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(actActs));
    }

    @ApiOperation("查询活动详情")
    @RequestMapping(value = "/getDetail", method = RequestMethod.GET)
    public CommonResult<ActAct> getDetail(Long id) {
        ActAct actAct = actService.selectById(id);
        return CommonResult.success(actAct);
    }

    @ApiOperation("添加活动推荐")
    @RequestMapping(value = "/recommend/add", method = RequestMethod.POST)
    public CommonResult addRecommend(@RequestBody ActRecommend recommend) {
        int add = recommendService.add(recommend);
        return CommonResult.success(add);
    }

    @ApiOperation("修改活动推荐")
    @RequestMapping(value = "/recommend/update", method = RequestMethod.POST)
    public CommonResult updateRecommend(@RequestBody ActRecommend recommend) {
        int update = recommendService.update(recommend);
        return CommonResult.success(update);
    }

    @ApiOperation("删除活动推荐")
    @RequestMapping(value = "/recommend/delete", method = RequestMethod.GET)
    public CommonResult deleteRecommend(Long id) {
        int update = recommendService.delete(id);
        return CommonResult.success(update);
    }

    @ApiOperation("查询推荐活动列表")
    @RequestMapping(value = "/recommend/list", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "recType", value = "推荐类型：1-必玩、2-精选、3-特价",required=true, dataType = "int", paramType = "query")
    })
    public CommonResult<CommonPage<RecActDto>> listRecAct(@RequestParam(value = "recType", required = false) Integer recType) {
        List<RecActDto> recActDtoList = recommendService.listRecAct(recType);
        return CommonResult.success(CommonPage.restPage(recActDtoList));
    }

}
