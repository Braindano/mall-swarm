package com.macro.mall.portal.controller;


import com.macro.mall.common.api.CommonResult;
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


}
