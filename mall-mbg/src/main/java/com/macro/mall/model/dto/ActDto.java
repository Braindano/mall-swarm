package com.macro.mall.model.dto;

import com.macro.mall.model.ActAct;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ActDto extends ActAct implements Serializable {
    private static final long serialVersionUID = 5002283096306229235L;

    @ApiModelProperty(value = "参与的男生数量")
    private Integer maleCnt;

    @ApiModelProperty(value = "参与的女生数量")
    private Integer femaleCnt;

    @ApiModelProperty(value = "未知性别数量")
    private Integer unknownCnt;

}
