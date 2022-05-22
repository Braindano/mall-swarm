package com.macro.mall.portal.dao;

import com.macro.mall.portal.domain.UmsMemberWx;

/**
* @author Admin
* @description 针对表【ums_member_wx(会员关联微信表)】的数据库操作Mapper
* @createDate 2022-05-12 02:04:20
* @Entity generator.domain.UmsMemberWx
*/
public interface UmsMemberWxDao {

    int insert(UmsMemberWx record);

    int updateByOpenId(UmsMemberWx record);

    UmsMemberWx selectByOpenId(String id);

    UmsMemberWx selectByMemberId(Long memberId);

}
