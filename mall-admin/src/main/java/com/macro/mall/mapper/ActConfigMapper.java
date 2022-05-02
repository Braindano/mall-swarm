package com.macro.mall.mapper;

import com.macro.mall.model.ActConfig;
import com.macro.mall.model.ActConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActConfigMapper {
    long countByExample(ActConfigExample example);

    int deleteByExample(ActConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActConfig record);

    int insertSelective(ActConfig record);

    List<ActConfig> selectByExampleWithBLOBs(ActConfigExample example);

    List<ActConfig> selectByExample(ActConfigExample example);

    ActConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActConfig record, @Param("example") ActConfigExample example);

    int updateByExampleWithBLOBs(@Param("record") ActConfig record, @Param("example") ActConfigExample example);

    int updateByExample(@Param("record") ActConfig record, @Param("example") ActConfigExample example);

    int updateByPrimaryKeySelective(ActConfig record);

    int updateByPrimaryKeyWithBLOBs(ActConfig record);

    int updateByPrimaryKey(ActConfig record);
}