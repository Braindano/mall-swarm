package com.macro.mall.model.dto;

import cn.hutool.core.bean.BeanUtil;
import com.macro.mall.model.ActOrderReturn;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class ActOrderReturnDto implements Serializable {
    private static final long serialVersionUID = -2189670445928885154L;
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

    public static ActOrderReturn convert2do(ActOrderReturnDto query){
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