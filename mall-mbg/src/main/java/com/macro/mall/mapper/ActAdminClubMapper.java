package com.macro.mall.mapper;

import com.macro.mall.model.ActAdminClub;

import java.util.List;

public interface ActAdminClubMapper {

    int insert(ActAdminClub adminClub);

    ActAdminClub getByUserId(Long userId);

    List<ActAdminClub> getByClubId(Long clubId);

    int deleteByUserIdClubId(Long userId, Long clubId);

}