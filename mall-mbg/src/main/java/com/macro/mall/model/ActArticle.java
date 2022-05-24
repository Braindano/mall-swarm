package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ActArticle implements Serializable {
    private Long id;

    @ApiModelProperty(value = "创建的管理员id")
    private Long userId;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "文本内容")
    private String c1;

    @ApiModelProperty(value = "文本内容")
    private String c2;

    @ApiModelProperty(value = "文本内容")
    private String c3;

    @ApiModelProperty(value = "文本内容")
    private String c4;

    @ApiModelProperty(value = "文本内容")
    private String c5;

    @ApiModelProperty(value = "文本内容")
    private String c6;

    @ApiModelProperty(value = "文本内容")
    private String c7;

    @ApiModelProperty(value = "文本内容")
    private String c8;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }

    public String getC4() {
        return c4;
    }

    public void setC4(String c4) {
        this.c4 = c4;
    }

    public String getC5() {
        return c5;
    }

    public void setC5(String c5) {
        this.c5 = c5;
    }

    public String getC6() {
        return c6;
    }

    public void setC6(String c6) {
        this.c6 = c6;
    }

    public String getC7() {
        return c7;
    }

    public void setC7(String c7) {
        this.c7 = c7;
    }

    public String getC8() {
        return c8;
    }

    public void setC8(String c8) {
        this.c8 = c8;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", title=").append(title);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", c1=").append(c1);
        sb.append(", c2=").append(c2);
        sb.append(", c3=").append(c3);
        sb.append(", c4=").append(c4);
        sb.append(", c5=").append(c5);
        sb.append(", c6=").append(c6);
        sb.append(", c7=").append(c7);
        sb.append(", c8=").append(c8);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}