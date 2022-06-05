package com.macro.mall.mapper;

import com.macro.mall.model.ActOrderReturn;
import com.macro.mall.model.ActOrderReturnExample;
import java.util.List;

import com.macro.mall.model.query.ActOrderReturnQuery;
import org.apache.ibatis.annotations.Param;

public interface ActOrderReturnMapper {
    long countByExample(ActOrderReturnExample example);

    int deleteByExample(ActOrderReturnExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActOrderReturn record);

    int insertSelective(ActOrderReturn record);

    List<ActOrderReturn> selectByExample(ActOrderReturnExample example);

    ActOrderReturn selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActOrderReturn record, @Param("example") ActOrderReturnExample example);

    int updateByExample(@Param("record") ActOrderReturn record, @Param("example") ActOrderReturnExample example);

    int updateByPrimaryKeySelective(ActOrderReturn record);

    int updateByPrimaryKey(ActOrderReturn record);

    List<ActOrderReturn> listByQuery(ActOrderReturnQuery query);
}