package com.macro.mall.model.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel
@Data
public class ActOrderQuery implements Serializable {
    private static final long serialVersionUID = 4883728404496447606L;

    @ApiModelProperty("订单编号")
    private String orderSn;

    @ApiModelProperty("订单状态：0->待付款；1->已报名；3->已完成；4->已关闭；5->无效订单")
    private Integer orderStatus;

    @ApiModelProperty("用户id")
    private Long memberId;

    @ApiModelProperty("活动id")
    private Long actId;

    @ApiModelProperty("俱乐部Id(不传，查询所有俱乐部订单)")
    private Long clubId;

    private Integer pageNum;

    private Integer pageSize;

}
