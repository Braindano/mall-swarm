package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.mapper.ActActMapper;
import com.macro.mall.model.ActAct;
import com.macro.mall.model.ActActExample;
import com.macro.mall.service.ActService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class ActServiceImpl implements ActService {

    @Resource
    private ActActMapper actMapper;

    @Override
    public int add(ActAct act) {
        return actMapper.insert(act);
    }

    @Override
    public int update(ActAct act) {
        return actMapper.updateByPrimaryKey(act);
    }

    @Override
    public int delete(Long id) {
        return actMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ActAct selectById(Long id) {
        return actMapper.selectByPrimaryKey(id);
    }

    @Override

    public List<ActAct> listAct(Long clubId, Long actTypeId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        ActActExample example = new ActActExample();
        ActActExample.Criteria criteria = example.createCriteria();
        if (Objects.nonNull(clubId)) {
            criteria.andClubIdEqualTo(clubId);
        }
        if (!StringUtils.isEmpty(actTypeId)) {
            criteria.andActTypeIdEqualTo(actTypeId);
        }
        example.setOrderByClause("id desc");
        return actMapper.selectByExample(example);
    }
}
