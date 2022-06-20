package com.macro.mall.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.ActConfig;
import com.macro.mall.model.ActConfigExample;
import com.macro.mall.service.ActConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 活动配置管理
 */
@RestController
@Api(tags = "ActConfigController", value = "配置管理")
@RequestMapping("/config")
public class ActConfigController {

    @Resource
    private ActConfigService configService;

    @ApiOperation("添加配置")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResult add(@RequestBody ActConfig config) {
        int add = configService.add(config);
        return CommonResult.success(add);
    }

    @ApiOperation("修改配置")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult update(@RequestBody ActConfig config) {
        int update = configService.update(config);
        return CommonResult.success(update);
    }

    @ApiOperation("删除配置")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public CommonResult delete(Long id) {
        int delete = configService.delete(id);
        return CommonResult.success(delete);
    }

    @ApiOperation("查询配置列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<List<ActConfig>> list() {
        List<ActConfig> actConfigs = configService.listConfig();
        return CommonResult.success(actConfigs);
    }

    @ApiOperation("查询配置详情")
    @RequestMapping(value = "/getDetail", method = RequestMethod.GET)
    public CommonResult<ActConfig> getDetail(Long id) {
        ActConfig ActConfig = configService.selectById(id);
        return CommonResult.success(ActConfig);
    }

    @ApiOperation("根据configCode查询配置详情")
    @RequestMapping(value = "/getDetailByCode", method = RequestMethod.GET)
    public CommonResult<ActConfig> getDetailByCode(String configCode) {
        ActConfig ActConfig = configService.selectByConfigCode(configCode);
        return CommonResult.success(ActConfig);
    }

}
