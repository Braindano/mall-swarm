package com.macro.mall.portal.domain.act;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 生成订单时传入的参数
 * Created by macro on 2018/8/30.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ActOrderParam {
    @ApiModelProperty("收获人姓名")
    private String receiverName;

    @ApiModelProperty("收货人电话")
    private String receiverPhone;

    @ApiModelProperty("收货地址")
    private String receiverDetailAddress;

    @ApiModelProperty("活动id")
    private Long actId;
}
