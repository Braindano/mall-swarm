package com.macro.mall.mapper;

import com.macro.mall.model.ActClub;
import com.macro.mall.model.ActClubExample;
import com.macro.mall.model.dto.ActClubDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActClubMapper {
    long countByExample(ActClubExample example);

    int deleteByExample(ActClubExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActClub record);

    int insertSelective(ActClub record);

    List<ActClub> selectByExample(ActClubExample example);

    ActClub selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActClub record, @Param("example") ActClubExample example);

    int updateByExample(@Param("record") ActClub record, @Param("example") ActClubExample example);

    int updateByPrimaryKeySelective(ActClub record);

    int updateByPrimaryKey(ActClub record);

    List<ActClubDto> listByClubIds(List<Long> clubIds);

    List<ActClubDto> listClubActNums(List<Long> clubIds);
}