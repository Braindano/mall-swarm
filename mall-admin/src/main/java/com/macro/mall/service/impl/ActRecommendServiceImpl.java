package com.macro.mall.service.impl;

import com.macro.mall.mapper.ActActMapper;
import com.macro.mall.mapper.ActRecommendMapper;
import com.macro.mall.model.ActRecommend;
import com.macro.mall.model.ActRecommendExample;
import com.macro.mall.model.dto.RecActDto;
import com.macro.mall.service.ActRecommendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActRecommendServiceImpl implements ActRecommendService {

    @Resource
    private ActRecommendMapper recommendMapper;

    @Resource
    private ActActMapper actMapper;

    @Override
    public int add(ActRecommend recommend) {
        return recommendMapper.insert(recommend);
    }

    @Override
    public int update(ActRecommend recommend) {
        return recommendMapper.updateByPrimaryKey(recommend);
    }

    @Override
    public int delete(Long id) {
        return recommendMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ActRecommend selectById(Long id) {
        return recommendMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ActRecommend> listRecommend(ActRecommendExample example) {
        return recommendMapper.selectByExample(example);
    }

    @Override
    public List<RecActDto> listRecAct(Integer recType) {
        return actMapper.listRecAct(recType);
    }
}
