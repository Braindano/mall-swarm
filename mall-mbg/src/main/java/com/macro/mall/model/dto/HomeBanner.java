package com.macro.mall.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class HomeBanner implements Serializable {

    @ApiModelProperty(value = "banner图地址")
    private String imgUrl;

    @ApiModelProperty(value = "跳转链接")
    private String hrefUrl;

    @ApiModelProperty(value = "跳转链接")
    private Long articleId;

}
