package com.macro.mall.model.query;

import cn.hutool.core.bean.BeanUtil;
import com.macro.mall.model.ActOrderReturn;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ActOrderReturnQuery implements Serializable {

    private static final long serialVersionUID = 8050258870902026882L;
    @ApiModelProperty(value = "订单编号")
    private String orderSn;

    @ApiModelProperty(value = "活动id")
    private Long actId;

    @ApiModelProperty(value = "活动名称")
    private String actName;

    @ApiModelProperty(value = "付款价格")
    private BigDecimal payPrice;

    @ApiModelProperty(value = "俱乐部id")
    private Long clubId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "页码")
    private Integer pageNum;

    @ApiModelProperty(value = "分页大小")
    private Integer pageSize;

    public static ActOrderReturn convert2do(ActOrderReturnQuery query){
        ActOrderReturn actOrderReturn = new ActOrderReturn();
        BeanUtil.copyProperties(query, actOrderReturn);
        return actOrderReturn;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getActId() {
        return actId;
    }

    public void setActId(Long actId) {
        this.actId = actId;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "ActOrderReturnQuery{" +
                "orderSn='" + orderSn + '\'' +
                ", actId=" + actId +
                ", actName='" + actName + '\'' +
                ", payPrice=" + payPrice +
                ", clubId=" + clubId +
                ", userId=" + userId +
                '}';
    }
}