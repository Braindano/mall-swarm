package com.macro.mall.portal.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.macro.mall.mapper.*;
import com.macro.mall.model.*;
import com.macro.mall.model.dto.ActClubDto;
import com.macro.mall.model.dto.ActDto;
import com.macro.mall.model.query.ActQuery;
import com.macro.mall.portal.service.ActHomeService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
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
    private ActArticleMapper articleMapper;

    @Override
    public List<ActAct> getActList(ActQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        ActActExample example = new ActActExample();
        ActActExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(query.getActTypeId())) {
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
}
