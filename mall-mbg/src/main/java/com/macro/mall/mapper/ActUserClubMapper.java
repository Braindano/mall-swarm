package com.macro.mall.mapper;

import com.macro.mall.model.ActUserClub;
import com.macro.mall.model.ActUserClubExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActUserClubMapper {
    long countByExample(ActUserClubExample example);

    int deleteByExample(ActUserClubExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActUserClub record);

    int insertSelective(ActUserClub record);

    List<ActUserClub> selectByExample(ActUserClubExample example);

    ActUserClub selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActUserClub record, @Param("example") ActUserClubExample example);

    int updateByExample(@Param("record") ActUserClub record, @Param("example") ActUserClubExample example);

    int updateByPrimaryKeySelective(ActUserClub record);

    int updateByPrimaryKey(ActUserClub record);


}