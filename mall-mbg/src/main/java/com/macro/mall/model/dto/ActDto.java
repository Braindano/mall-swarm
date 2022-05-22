package com.macro.mall.model.dto;

import com.macro.mall.model.ActAct;
import lombok.Data;

import java.io.Serializable;

@Data
public class ActDto extends ActAct implements Serializable {
    private static final long serialVersionUID = 5002283096306229235L;

    /**
     * 参与的男生数量
     */
    private Integer maleCnt;

    /**
     * 参与的女生数量
     */
    private Integer femaleCnt;

    /**
     * 未知性别数量
     */
    private Integer unknownCnt;

}
