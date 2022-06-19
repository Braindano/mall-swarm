package com.macro.mall.model.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@ApiModel
public class
ActQuery implements Serializable {
    private static final long serialVersionUID = 6641181777696003632L;

    @ApiModelProperty(value = "俱乐部id")
    private Long clubId;

    /**
     * 活动类型
     */
    @ApiModelProperty(value = "活动类型id")
    private Long actTypeId;

    /**
     * 活动名称
     */
    @ApiModelProperty(value = "活动名称")
    private String actName;

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
    @ApiModelProperty(value = "活动查询的开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date queryStartTime;

    /**
     * 活动查询的结束时间
     */
    @ApiModelProperty(value = "活动查询的结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date queryEndTime;

    public Long getActTypeId() {
        return actTypeId;
    }

    public void setActTypeId(Long actTypeId) {
        this.actTypeId = actTypeId;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
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

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }
}
