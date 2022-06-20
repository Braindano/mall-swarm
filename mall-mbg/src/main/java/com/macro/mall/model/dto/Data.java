package com.macro.mall.model.dto;

import com.macro.mall.model.ActAct;
import com.macro.mall.model.ActType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 首页数据
 */
@ApiModel
public class Data implements Serializable {
    private static final long serialVersionUID = -1196820526551332109L;

    /**
     * 活动类型集合
     */
    private List<ActType> actTypeList;

    /**
     * 轮播图链接
     */
    @ApiModelProperty(value = "轮播图对象列表")
    private List<HomeBanner> banner;

    /**
     * 轮播提醒文字
     */
    @ApiModelProperty(value = "轮播提醒文字")
    private List<String> noticeList;

    /**
     * 必玩活动列表
     */
    @ApiModelProperty(value = "必玩活动列表")
    private List<ActAct> needActList;

    /**
     * 精选活动列表
     */
    @ApiModelProperty(value = "精选活动列表")
    private List<ActAct> choiceActList;

    /**
     * 特惠活动列表
     */
    @ApiModelProperty(value = "特惠活动列表")
    private List<ActAct> discountActList;

    public List<ActType> getActTypeList() {
        return actTypeList;
    }

    public void setActTypeList(List<ActType> actTypeList) {
        this.actTypeList = actTypeList;
    }

    public List<HomeBanner> getBanner() {
        return banner;
    }

    public void setBanner(List<HomeBanner> banner) {
        this.banner = banner;
    }

    public List<String> getNoticeList() {
        return noticeList;
    }

    public void setNoticeList(List<String> noticeList) {
        this.noticeList = noticeList;
    }

    public List<ActAct> getNeedActList() {
        return needActList;
    }

    public void setNeedActList(List<ActAct> needActList) {
        this.needActList = needActList;
    }

    public List<ActAct> getChoiceActList() {
        return choiceActList;
    }

    public void setChoiceActList(List<ActAct> choiceActList) {
        this.choiceActList = choiceActList;
    }

    public List<ActAct> getDiscountActList() {
        return discountActList;
    }

    public void setDiscountActList(List<ActAct> discountActList) {
        this.discountActList = discountActList;
    }
}
