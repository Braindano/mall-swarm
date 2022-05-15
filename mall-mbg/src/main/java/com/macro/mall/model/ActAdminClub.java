package com.macro.mall.model;

import java.io.Serializable;

public class ActAdminClub implements Serializable {

    private static final long serialVersionUID = -8809543015102702642L;

    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 俱乐部id
     */
    private Long clubId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }
}
