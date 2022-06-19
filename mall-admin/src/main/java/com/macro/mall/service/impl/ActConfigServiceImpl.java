package com.macro.mall.service.impl;

import com.macro.mall.mapper.ActConfigMapper;
import com.macro.mall.model.ActConfig;
import com.macro.mall.model.ActConfigExample;
import com.macro.mall.service.ActConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActConfigServiceImpl implements ActConfigService {

    @Resource
    private ActConfigMapper actConfigMapper;

    @Override
    public int add(ActConfig config) {
        return actConfigMapper.insert(config);
    }

    @Override
    public int update(ActConfig config) {
        return actConfigMapper.updateByPrimaryKeyWithBLOBs(config);
    }

    @Override
    public int delete(Long id) {
        return actConfigMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ActConfig selectById(Long id) {
        return actConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public ActConfig selectByConfigCode(String configCode) {
        return actConfigMapper.getByConfigCode(configCode);
    }

    @Override
    public List<ActConfig> listConfig() {
        ActConfigExample example = new ActConfigExample();
        return actConfigMapper.selectByExample(example);
    }
}
