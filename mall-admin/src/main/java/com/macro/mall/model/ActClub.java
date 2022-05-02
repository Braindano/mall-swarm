package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ActClub implements Serializable {
    private Long id;

    private String name;

    private String backgroundImg;

    private String logoImg;

    private String introduce;

    @ApiModelProperty(value = "画册图片，连产品图片限制为5张，以逗号分割")
    private String clubPics;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(String backgroundImg) {
        this.backgroundImg = backgroundImg;
    }

    public String getLogoImg() {
        return logoImg;
    }

    public void setLogoImg(String logoImg) {
        this.logoImg = logoImg;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getClubPics() {
        return clubPics;
    }

    public void setClubPics(String clubPics) {
        this.clubPics = clubPics;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", backgroundImg=").append(backgroundImg);
        sb.append(", logoImg=").append(logoImg);
        sb.append(", introduce=").append(introduce);
        sb.append(", clubPics=").append(clubPics);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}