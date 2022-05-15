package com.macro.mall.portal.domain;

import java.io.Serializable;

/**
 * 会员关联微信表
 * @TableName ums_member_wx
 */
public class UmsMemberWx implements Serializable {

    private static final long serialVersionUID = 5023637371067471215L;

    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long memberId;

    /**
     * 微信openId
     */
    private String openId;

    /**
     * 微信sessionKey
     */
    private String sessionKey;


    /**
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * 微信openId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 微信openId
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 微信sessionKey
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * 微信sessionKey
     */
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}