package com.macro.mall.service.impl;

import com.macro.mall.mapper.ActActMapper;
import com.macro.mall.mapper.ActTypeMapper;
import com.macro.mall.model.ActType;
import com.macro.mall.model.ActTypeExample;
import com.macro.mall.service.ActTypeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActTypeServiceImpl implements ActTypeService {

    @Resource
    private ActTypeMapper actTypeMapper;

    @Resource
    private ActActMapper actMapper;

    @Override
    public int add(ActType type) {
        return actTypeMapper.insert(type);
    }

    @Override
    public int update(ActType type) {
        if (StringUtils.isNotEmpty(type.getTypeName())) {
            actMapper.updateActTypeName(type.getId(), type.getTypeName());
        }
        return actTypeMapper.updateByPrimaryKey(type);
    }

    @Override
    public int delete(Long id) {
        return actTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ActType selectById(Long id) {
        return actTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ActType> listActType(String typeName, Integer pageNum, Integer pageSize) {
        ActTypeExample example = new ActTypeExample();
        if (StringUtils.isNotBlank(typeName)){
            example.createCriteria().andTypeNameLike("%" + typeName + "%");
        }
        example.setOrderByClause("sort desc");
        return actTypeMapper.selectByExample(example);
    }
}
