package com.macro.mall.model.dto;

import com.macro.mall.model.ActClub;
import lombok.Data;

@Data
public class ActClubDto extends ActClub {
    private static final long serialVersionUID = 6167009484983467573L;

    /**
     * 活动数
     */
    private Integer actCnt;

    /**
     * 粉丝数
     */
    private Integer fansCnt;
}
