package com.macro.mall.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.ActAdminClubMapper;
import com.macro.mall.model.ActAdminClub;
import com.macro.mall.model.ActClub;
import com.macro.mall.model.UmsAdmin;
import com.macro.mall.service.ActClubService;
import com.macro.mall.service.UmsAdminService;
import com.macro.mall.util.AdminClubUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 活动管理
 */
@RestController
@Api(tags = "ActClubController", value = "俱乐部管理")
@RequestMapping("/club")
public class ActClubController {
    @Resource
    private ActClubService clubService;

    @Resource
    private ActAdminClubMapper adminClubMapper;

    @Resource
    private AdminClubUtil adminClubUtil;

    @Resource
    private UmsAdminService adminService;

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
        adminClubUtil.checkSuperAdmin();
        List<ActClub> actClubs = clubService.listClub(clubName, pageNum, pageSize);
        return CommonResult.success(actClubs);
    }

    @ApiOperation("俱乐部添加管理员")
    @RequestMapping(value = "/addClubAdmin", method = RequestMethod.POST)
    public CommonResult addAdminClub(@RequestBody ActAdminClub actAdminClub) {
        adminClubUtil.checkSuperAdmin();
        int add = adminClubMapper.insert(actAdminClub);
        return CommonResult.success(add);
    }

    @ApiOperation("俱乐部移除管理员")
    @RequestMapping(value = "/deleteClubAdmin", method = RequestMethod.POST)
    public CommonResult deleteAdminClub(@RequestParam(value = "clubId", required = false) Long clubId,
                            @RequestParam(value = "userId", defaultValue = "1") Long userId) {
        adminClubUtil.checkSuperAdmin();
        int add = adminClubMapper.deleteByUserIdClubId(userId, clubId);
        return CommonResult.success(add);
    }

    @ApiOperation("查询俱乐部管理员列表")
    @RequestMapping(value = "/listClubAdmin", method = RequestMethod.GET)
    public CommonResult<List<UmsAdmin>> listAdminClub(@RequestParam("clubId") Long clubId) {
        List<ActAdminClub> adminClubList = adminClubMapper.getByClubId(clubId);
        List<UmsAdmin> adminList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(adminClubList)) {
            List<Long> adminIds = adminClubList.stream().map(ActAdminClub::getUserId).collect(Collectors.toList());
            adminList = adminService.listAdminByIds(adminIds);
        }
        return CommonResult.success(adminList);
    }

}
