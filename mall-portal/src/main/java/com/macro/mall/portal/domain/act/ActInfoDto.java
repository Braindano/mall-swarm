package com.macro.mall.portal.domain.act;

import com.macro.mall.model.ActAct;
import lombok.Data;

@Data
public class ActInfoDto extends ActAct {

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
