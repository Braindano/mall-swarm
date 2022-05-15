package com.macro.mall.service;

import com.macro.mall.model.ActAct;

import java.util.List;

public interface ActService {

    int add(ActAct act);

    int update(ActAct act);

    int delete(Long id);

    ActAct selectById(Long id);

    List<ActAct> listAct(Long clubId, Long actTypeId, Integer pageNum, Integer pageSize);

}
