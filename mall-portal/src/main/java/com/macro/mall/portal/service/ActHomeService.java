package com.macro.mall.portal.service;

import com.macro.mall.model.ActAct;
import com.macro.mall.model.query.ActQuery;

import java.util.List;

public interface ActHomeService {

    /**
     * 根据活动类型获取活动列表
     * @param query
     * @return
     */
    List<ActAct> getActList(ActQuery query);

    /**
     * 根据推荐类型获取活动列表
     * @param recommendType
     * @return
     */
    List<ActAct> getRecActList(Integer recommendType);

    /**
     * 获取后台参数配置
     * @return
     */
    String getConfig(String configName);

}
