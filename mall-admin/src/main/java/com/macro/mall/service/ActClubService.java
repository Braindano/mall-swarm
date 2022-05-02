package com.macro.mall.service;

import com.macro.mall.model.ActClub;

import java.util.List;

public interface ActClubService {

    int add(ActClub club);

    int update(ActClub club);

    int delete(Long id);

    ActClub selectById(Long id);

    List<ActClub> listClub(String clubName, Integer pageNum, Integer pageSize);

}
