package com.macro.mall.model.dto;

import com.macro.mall.model.ActOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ActOrderWithItem extends ActOrder implements Serializable {
    private static final long serialVersionUID = -9189668865479846877L;

    @ApiModelProperty(value = "活动id")
    private Long actId;

    @ApiModelProperty(value = "活动名称")
    private String actName;

    @ApiModelProperty(value = "俱乐部id")
    private Long clubId;

}
