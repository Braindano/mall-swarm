package com.macro.mall.model.dto;

import com.macro.mall.model.ActAct;

import java.io.Serializable;

public class RecActDto extends ActAct implements Serializable {

    private static final long serialVersionUID = -6382317008673165071L;

    /**
     * 推荐记录id
     */
    private Long recommendId;

    /**
     * 排序
     */
    private Integer sort;

    public Long getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(Long recommendId) {
        this.recommendId = recommendId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
