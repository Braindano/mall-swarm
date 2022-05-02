package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ActRecommend implements Serializable {
    private Long id;

    @ApiModelProperty(value = "推荐类型：1-必玩、2-精选、3-特价")
    private Integer recType;

    @ApiModelProperty(value = "活动id")
    private Long actId;

    @ApiModelProperty(value = "推荐排序")
    private Integer sort;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRecType() {
        return recType;
    }

    public void setRecType(Integer recType) {
        this.recType = recType;
    }

    public Long getActId() {
        return actId;
    }

    public void setActId(Long actId) {
        this.actId = actId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", recType=").append(recType);
        sb.append(", actId=").append(actId);
        sb.append(", sort=").append(sort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}