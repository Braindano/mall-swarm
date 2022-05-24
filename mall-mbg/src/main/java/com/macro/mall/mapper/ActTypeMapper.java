package com.macro.mall.mapper;

import com.macro.mall.model.ActType;
import com.macro.mall.model.ActTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActTypeMapper {
    long countByExample(ActTypeExample example);

    int deleteByExample(ActTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActType record);

    int insertSelective(ActType record);

    List<ActType> selectByExample(ActTypeExample example);

    ActType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActType record, @Param("example") ActTypeExample example);

    int updateByExample(@Param("record") ActType record, @Param("example") ActTypeExample example);

    int updateByPrimaryKeySelective(ActType record);

    int updateByPrimaryKey(ActType record);
}