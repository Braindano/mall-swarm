package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ActAct implements Serializable {
    private Long id;

    @ApiModelProperty(value = "俱乐部id")
    private Long clubId;

    @ApiModelProperty(value = "活动名称")
    private String actName;

    @ApiModelProperty(value = "画册图片，连产品图片限制为5张，以逗号分割")
    private String actPics;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "活动地点")
    private String address;

    @ApiModelProperty(value = "详细地址")
    private String addressDetail;

    @ApiModelProperty(value = "提供的服务")
    private String provideService;

    @ApiModelProperty(value = "地址-经度")
    private BigDecimal latitude;

    @ApiModelProperty(value = "地址-维度")
    private BigDecimal longitude;

    @ApiModelProperty(value = "市场价")
    private BigDecimal originalPrice;

    @ApiModelProperty(value = "促销价")
    private BigDecimal promotionPrice;

    @ApiModelProperty(value = "活动详情")
    private String actDetail;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getActPics() {
        return actPics;
    }

    public void setActPics(String actPics) {
        this.actPics = actPics;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getProvideService() {
        return provideService;
    }

    public void setProvideService(String provideService) {
        this.provideService = provideService;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public String getActDetail() {
        return actDetail;
    }

    public void setActDetail(String actDetail) {
        this.actDetail = actDetail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", clubId=").append(clubId);
        sb.append(", actName=").append(actName);
        sb.append(", actPics=").append(actPics);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", address=").append(address);
        sb.append(", addressDetail=").append(addressDetail);
        sb.append(", provideService=").append(provideService);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", originalPrice=").append(originalPrice);
        sb.append(", promotionPrice=").append(promotionPrice);
        sb.append(", actDetail=").append(actDetail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}