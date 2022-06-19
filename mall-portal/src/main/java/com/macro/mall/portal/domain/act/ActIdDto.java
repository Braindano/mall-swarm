package com.macro.mall.portal.domain.act;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ActIdDto implements Serializable {
    private static final long serialVersionUID = -2505657988337484229L;

    @ApiModelProperty("活动id")
    private Long actId;

}
