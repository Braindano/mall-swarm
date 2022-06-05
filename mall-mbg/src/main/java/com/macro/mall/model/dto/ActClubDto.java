package com.macro.mall.model.dto;

import com.macro.mall.model.ActClub;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ActClubDto extends ActClub {
    private static final long serialVersionUID = 6167009484983467573L;

    /**
     * 活动数
     */
    @ApiModelProperty("发布的活动数")
    private Integer actCnt;

    /**
     * 粉丝数
     */
    @ApiModelProperty("粉丝数")
    private Integer fansCnt;

    /**
     * 是否关注
     */
    @ApiModelProperty("是否关注")
    private Boolean focus;
}
