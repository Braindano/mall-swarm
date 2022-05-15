package com.macro.mall.mapper;

import com.macro.mall.model.ActAdminClub;

public interface ActAdminClubMapper {

    int insert(ActAdminClub adminClub);

    ActAdminClub getByUserId(Long userId);

    int deleteByUserIdClubId(Long userId, Long clubId);

}