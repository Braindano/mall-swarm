package com.macro.mall.portal.service.impl;


import com.github.pagehelper.PageHelper;
import com.macro.mall.mapper.ActActMapper;
import com.macro.mall.mapper.ActConfigMapper;
import com.macro.mall.model.ActAct;
import com.macro.mall.model.ActActExample;
import com.macro.mall.model.ActConfig;
import com.macro.mall.model.ActConfigExample;
import com.macro.mall.model.query.ActQuery;
import com.macro.mall.model.query.RecActQuery;
import com.macro.mall.portal.service.ActHomeService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ActHomeServiceImpl implements ActHomeService {

    @Resource
    private ActActMapper actMapper;

    @Resource
    private ActConfigMapper configMapper;

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
    public String getConfig(String configCode) {
        ActConfig config = configMapper.getByConfigCode(configCode);
        return config.getConfigValue();
    }
}
