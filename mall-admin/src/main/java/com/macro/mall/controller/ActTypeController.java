package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.ActType;
import com.macro.mall.service.ActTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 活动类型管理
 */
@RestController
@Api(tags = "ActTypeController", value = "活动类型管理")
@RequestMapping("/actType")
public class ActTypeController {
    @Resource
    private ActTypeService actTypeService;

    @ApiOperation("添加活动类型")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResult add(@RequestBody ActType actType) {
        int add = actTypeService.add(actType);
        return CommonResult.success(add);
    }

    @ApiOperation("修改活动类型")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult update(@RequestBody ActType actType) {
        int update = actTypeService.update(actType);
        return CommonResult.success(update);
    }

    @ApiOperation("删除活动类型")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public CommonResult delete(Long id) {
        int delete = actTypeService.delete(id);
        return CommonResult.success(delete);
    }

    @ApiOperation("查询活动类型列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<ActType>> list(@RequestParam(value = "typeName", required = false) String typeName,
                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<ActType> ActTypes = actTypeService.listActType(typeName, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(ActTypes));
    }

    @ApiOperation("查询活动类型详情")
    @RequestMapping(value = "/getDetail", method = RequestMethod.GET)
    public CommonResult<ActType> getDetail(Long id) {
        ActType ActType = actTypeService.selectById(id);
        return CommonResult.success(ActType);
    }

}
