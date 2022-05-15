package com.macro.mall.portal.service;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.common.domain.UserDto;
import com.macro.mall.model.UmsMember;
import com.macro.mall.portal.domain.UmsMemberWx;
import com.macro.mall.portal.domain.UserInfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会员管理Service
 * Created by macro on 2018/8/3.
 */
public interface UmsMemberService {
    /**
     * 根据用户名获取会员
     */
    UmsMember getByUsername(String username);

    /**
     * 根据会员编号获取会员
     */
    UmsMember getById(Long id);

    /**
     * 用户注册
     */
    @Transactional
    void register(String username, String password, String telephone, String authCode);

    /**
     * 微信小程序登录自动注册
     * @param userInfo
     * @param openId
     * @param sessionKey
     */
    @Transactional
    void registerByWxLogin(UserInfo userInfo, String openId, String sessionKey);

    /**
     * 根据openid获取用户
     * @param openId
     * @return
     */
    UmsMemberWx getByOpenId(String openId);

    /**
     * 更新
     * @return
     */
    Integer updateByOpenId(UmsMemberWx umsMemberWx);

    /**
     * 生成验证码
     */
    String generateAuthCode(String telephone);

    /**
     * 修改密码
     */
    @Transactional
    void updatePassword(String telephone, String password, String authCode);

    /**
     * 获取当前登录会员
     */
    UmsMember getCurrentMember();

    /**
     * 根据会员id修改会员积分
     */
    void updateIntegration(Long id,Integer integration);


    /**
     * 获取用户信息
     */
    UserDto loadUserByUsername(String username);

    /**
     * 登录后获取token
     */
    CommonResult login(String username, String password);
}
