package com.macro.mall.model.query;

import io.swagger.annotations.ApiModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@ApiModel
public class RecActQuery implements Serializable {
    private static final long serialVersionUID = 6641181777696003632L;

    /**
     * 推荐类型
     */
    private Integer recTypeId;
    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 分页大小
     */
    private Integer pageSize;

    /**
     * 活动查询的开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date queryStartTime;

    /**
     * 活动查询的结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date queryEndTime;

    public Integer getRecTypeId() {
        return recTypeId;
    }

    public void setRecTypeId(Integer recTypeId) {
        this.recTypeId = recTypeId;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Date getQueryStartTime() {
        return queryStartTime;
    }

    public void setQueryStartTime(Date queryStartTime) {
        this.queryStartTime = queryStartTime;
    }

    public Date getQueryEndTime() {
        return queryEndTime;
    }

    public void setQueryEndTime(Date queryEndTime) {
        this.queryEndTime = queryEndTime;
    }
}
