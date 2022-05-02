package com.macro.mall.service;

import com.macro.mall.model.ActType;

import java.util.List;

public interface ActTypeService {

    int add(ActType type);

    int update(ActType type);

    int delete(Long id);

    ActType selectById(Long id);

    List<ActType> listActType(String typeName, Integer pageNum, Integer pageSize);
    
}
