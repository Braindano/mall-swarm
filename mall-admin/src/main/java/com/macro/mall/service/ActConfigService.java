package com.macro.mall.service;

import com.macro.mall.model.ActConfig;
import com.macro.mall.model.ActConfigExample;

import java.util.List;

public interface ActConfigService {

    int add(ActConfig config);

    int update(ActConfig config);

    int delete(Long id);

    ActConfig selectById(Long id);

    List<ActConfig> listConfig(ActConfigExample example);

}
