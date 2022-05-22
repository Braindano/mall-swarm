package com.macro.mall.mapper;

import com.macro.mall.model.ActOrderItem;
import com.macro.mall.model.ActOrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActOrderItemMapper {
    long countByExample(ActOrderItemExample example);

    int deleteByExample(ActOrderItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActOrderItem record);

    int insertSelective(ActOrderItem record);

    List<ActOrderItem> selectByExample(ActOrderItemExample example);

    ActOrderItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActOrderItem record, @Param("example") ActOrderItemExample example);

    int updateByExample(@Param("record") ActOrderItem record, @Param("example") ActOrderItemExample example);

    int updateByPrimaryKeySelective(ActOrderItem record);

    int updateByPrimaryKey(ActOrderItem record);
}