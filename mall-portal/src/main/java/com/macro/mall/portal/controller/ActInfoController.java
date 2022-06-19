package com.macro.mall.portal.controller;


import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.ActUserClubMapper;
import com.macro.mall.model.ActUserClub;
import com.macro.mall.model.UmsMember;
import com.macro.mall.model.dto.ActClubDto;
import com.macro.mall.portal.service.ActHomeService;
import com.macro.mall.portal.service.ActOrderService;
import com.macro.mall.portal.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
@Api(tags = "ActInfoController", description = "用户信息")
@RequestMapping("/actInfo")
public class ActInfoController {

    @Resource
    private ActOrderService actOrderService;

    @Resource
    private UmsMemberService memberService;

    @Resource
    private ActHomeService actHomeService;

    @Resource
    private ActUserClubMapper userClubMapper;

    @ApiOperation("查询用户参与活动记录")
    @GetMapping(value = "/myAct")
    public CommonResult myAct() {
        UmsMember currentMember = memberService.getCurrentMember();
        Long memberId = currentMember.getId();
        return CommonResult.success(actOrderService.listOrderActByUser(memberId));
    }

    @ApiOperation("查询用户关注的俱乐部")
    @RequestMapping(value = "/listAttentionClub", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ActClubDto>> getRecActList() {
        UmsMember currentMember = memberService.getCurrentMember();
        Long memberId = currentMember.getId();
        List<ActClubDto> actClubDtoList = actHomeService.listAttentionClub(memberId);
        return CommonResult.success(actClubDtoList);
    }

    @ApiOperation("用户关注俱乐部")
    @RequestMapping(value = "/addClubAttention", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addClubAttention(@RequestBody ActUserClub userClub) {
        UmsMember currentMember = memberService.getCurrentMember();
        Long memberId = currentMember.getId();
        userClub.setUserId(memberId);
        ActUserClub exitUserAndClub = userClubMapper.getByUserAndClub(memberId, userClub.getClubId());
        if (Objects.nonNull(exitUserAndClub)) {
            return CommonResult.failed("用户已关注该俱乐部");
        }
        return CommonResult.success(userClubMapper.insert(userClub));
    }

    @ApiOperation("用户取消关注俱乐部")
    @RequestMapping(value = "/deleteClubAttention", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteClubAttention(@RequestBody ActUserClub userClub) {
        UmsMember currentMember = memberService.getCurrentMember();
        Long memberId = currentMember.getId();
        userClub.setUserId(memberId);
        ActUserClub exitUserAndClub = userClubMapper.getByUserAndClub(memberId, userClub.getClubId());
        if (Objects.isNull(exitUserAndClub)) {
            return CommonResult.failed("用户未关注该俱乐部");
        }
        return CommonResult.success(userClubMapper.deleteByPrimaryKey(exitUserAndClub.getId()));
    }


}
