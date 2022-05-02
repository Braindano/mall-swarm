package com.macro.mall.service.impl;

import com.macro.mall.mapper.ActClubMapper;
import com.macro.mall.model.ActClub;
import com.macro.mall.model.ActClubExample;
import com.macro.mall.service.ActClubService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActClubServiceImpl implements ActClubService {

    @Resource
    private ActClubMapper clubMapper;

    @Override
    public int add(ActClub club) {
        return clubMapper.insert(club);
    }

    @Override
    public int update(ActClub club) {
        return clubMapper.updateByPrimaryKey(club);
    }

    @Override
    public int delete(Long id) {
        return clubMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ActClub selectById(Long id) {
        return clubMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ActClub> listClub(String clubName, Integer pageNum, Integer pageSize) {
        ActClubExample example = new ActClubExample();
        if (StringUtils.isNotEmpty(clubName)) {
            example.createCriteria().andNameLike("%" + clubName + "%");
        }
        example.setOrderByClause("update_time desc");
        return clubMapper.selectByExample(example);
    }
}
