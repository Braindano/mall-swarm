package com.macro.mall.portal.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.ResultCode;
import com.macro.mall.common.constant.AuthConstant;
import com.macro.mall.common.domain.UserDto;
import com.macro.mall.common.exception.Asserts;
import com.macro.mall.mapper.*;
import com.macro.mall.model.*;
import com.macro.mall.model.dto.ActClubDto;
import com.macro.mall.model.dto.ActDto;
import com.macro.mall.model.query.ActQuery;
import com.macro.mall.portal.service.ActHomeService;
import com.macro.mall.portal.service.UmsMemberService;
import com.nimbusds.jose.JWSObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ActHomeServiceImpl implements ActHomeService {

    @Resource
    private ActActMapper actMapper;

    @Resource
    private ActConfigMapper configMapper;

    @Resource
    private ActClubMapper clubMapper;

    @Resource
    private ActUserClubMapper userClubMapper;

    @Resource
    private ActOrderMapper orderMapper;

    @Resource
    private UmsMemberMapper memberMapper;

    @Resource
    private ActTypeMapper actTypeMapper;

    @Resource
    private ActArticleMapper articleMapper;

    @Resource
    private UmsMemberService memberService;

    @Resource
    private HttpServletRequest request;

    @Override
    public List<ActAct> getActList(ActQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        ActActExample example = new ActActExample();
        ActActExample.Criteria criteria = example.createCriteria();
        if (Objects.nonNull(query.getClubId())) {
            criteria.andClubIdEqualTo(query.getClubId());
        }
        if (Objects.nonNull(query.getActTypeId())) {
            criteria.andActTypeIdEqualTo(query.getActTypeId());
        }
        if (Objects.nonNull(query.getActName())) {
            criteria.andActNameLike("%" + query.getActName() + "%");
        }
        if (Objects.nonNull(query.getQueryStartTime()) && Objects.nonNull(query.getQueryEndTime())){
            criteria.andStartTimeBetween(query.getQueryStartTime(), query.getQueryEndTime());
        }
        example.setOrderByClause("id desc");
        return actMapper.selectByExample(example);
    }

    @Override
    public List<ActAct> getRecActList(Integer recommendType) {
        return actMapper.listByRecType(recommendType);
    }

    @Override
    public ActDto getActInfo(Long actId) {
        ActAct actAct = actMapper.selectByPrimaryKey(actId);
        ActDto actDto = new ActDto();
        BeanUtil.copyProperties(actAct, actDto);
        actDto.setMaleCnt(0);
        actDto.setFemaleCnt(0);
        actDto.setUnknownCnt(0);
        List<Long> memberIds = orderMapper.getMemberIdByActId(actId);
        if (!CollectionUtils.isEmpty(memberIds)){
            List<UmsMember> umsMembers = memberMapper.selectByMemberIds(memberIds);
            umsMembers.forEach(member -> {
                if (member.getGender() == 1 ) {
                    actDto.setMaleCnt(actDto.getMaleCnt() + 1);
                } else if (member.getGender() == 2) {
                    actDto.setFemaleCnt(actDto.getFemaleCnt() + 1);
                } else {
                    actDto.setUnknownCnt(actDto.getUnknownCnt() + 1);
                }
            });
        }
        return actDto;
    }


    @Override
    public ActClubDto getClubInfo(Long clubId, String token) {
        ActClubDto clubInfo = clubMapper.getClubInfo(clubId);
        clubInfo.setActCnt(clubMapper.getClubActCnt(clubId));
        clubInfo.setFocus(Boolean.FALSE);

        if (StringUtils.isNotEmpty(token)) {
            try {
                JWSObject jwsObject = JWSObject.parse(token);
                String userStr = jwsObject.getPayload().toString();
                UserDto userDto = JSONUtil.toBean(userStr, UserDto.class);
                Long memberId = userDto.getId();
                ActUserClub userClub = userClubMapper.getByUserAndClub(memberId, clubId);
                if (Objects.nonNull(userClub)) {
                    clubInfo.setFocus(Boolean.TRUE);
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return clubInfo;
    }

    @Override
    public List<UmsMember> getActMembers(Long actId) {
        List<Long> memberIds = orderMapper.getMemberIdByActId(actId);
        if (CollectionUtils.isEmpty(memberIds)) {
            return new ArrayList<>();
        }
        return memberMapper.selectByMemberIds(memberIds);
    }

    @Override
    public String getConfig(String configCode) {
        ActConfig config = configMapper.getByConfigCode(configCode);
        return config.getConfigValue();
    }

    @Override
    public List<ActClubDto> listAttentionClub(Long memberId) {
        ActUserClubExample example = new ActUserClubExample();
        ActUserClubExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(memberId);
        example.setOrderByClause("create_time desc");
        List<ActUserClub> actUserClubs = userClubMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(actUserClubs)) {
            return new ArrayList<>();
        }
        List<Long> clubIds = actUserClubs.stream().map(ActUserClub::getClubId).collect(Collectors.toList());
        List<ActClubDto> actClubDtoList = clubMapper.listByClubIds(clubIds);
        List<ActClubDto> clubActNums = clubMapper.listClubActNums(clubIds);
        Map<Long, Integer> clubActNumsMap = clubActNums.stream().collect(Collectors.toMap(ActClubDto::getId, ActClubDto::getActCnt));
        actClubDtoList.forEach(actClubDto -> actClubDto.setActCnt(clubActNumsMap.get(actClubDto.getId())));
        return actClubDtoList;
    }

    @Override
    public ActArticle getArticleById(Long articleId) {
        return articleMapper.selectByPrimaryKey(articleId);
    }

    @Override
    public List<ActType> listActType() {
        ActTypeExample example = new ActTypeExample();
        example.setOrderByClause("sort asc");
        return actTypeMapper.selectByExample(example);
    }
}
