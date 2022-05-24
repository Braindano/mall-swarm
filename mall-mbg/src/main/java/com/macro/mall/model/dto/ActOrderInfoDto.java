package com.macro.mall.model.dto;

import com.macro.mall.model.ActAct;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ActOrderInfoDto implements Serializable {
    private static final long serialVersionUID = -2885789794268074797L;

    @ApiModelProperty("活动信息")
    private ActAct act;

    @ApiModelProperty("订单和订单明细")
    private ActOrderWithItem orderWithItem;

}
