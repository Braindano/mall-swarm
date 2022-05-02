package com.macro.mall.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.ActClub;
import com.macro.mall.service.ActClubService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 活动管理
 */
@RestController
@Api(tags = "ActClubController", value = "俱乐部管理")
@RequestMapping("/club")
public class ActClubController {
    @Resource
    private ActClubService clubService;

    @ApiOperation("添加俱乐部")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResult add(@RequestBody ActClub club) {
        int add = clubService.add(club);
        return CommonResult.success(add);
    }

    @ApiOperation("修改俱乐部")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult update(@RequestBody ActClub club) {
        int update = clubService.update(club);
        return CommonResult.success(update);
    }

    @ApiOperation("删除俱乐部")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public CommonResult delete(Long id) {
        int delete = clubService.delete(id);
        return CommonResult.success(delete);
    }

    @ApiOperation("查询俱乐部详情")
    @RequestMapping(value = "/getDetail", method = RequestMethod.GET)
    public CommonResult<ActClub> getDetail(Long id) {
        ActClub actClub = clubService.selectById(id);
        return CommonResult.success(actClub);
    }

    @ApiOperation("查询俱乐部列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<List<ActClub>> list(@RequestParam(value = "clubName", required = false) String clubName,
                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {

        List<ActClub> actClubs = clubService.listClub(clubName, pageNum, pageSize);
        return CommonResult.success(actClubs);
    }

}
