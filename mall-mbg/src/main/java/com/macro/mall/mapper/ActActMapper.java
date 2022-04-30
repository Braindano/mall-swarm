package com.macro.mall.mapper;

import com.macro.mall.model.ActAct;
import com.macro.mall.model.ActActExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActActMapper {
    long countByExample(ActActExample example);

    int deleteByExample(ActActExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActAct record);

    int insertSelective(ActAct record);

    List<ActAct> selectByExampleWithBLOBs(ActActExample example);

    List<ActAct> selectByExample(ActActExample example);

    ActAct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActAct record, @Param("example") ActActExample example);

    int updateByExampleWithBLOBs(@Param("record") ActAct record, @Param("example") ActActExample example);

    int updateByExample(@Param("record") ActAct record, @Param("example") ActActExample example);

    int updateByPrimaryKeySelective(ActAct record);

    int updateByPrimaryKeyWithBLOBs(ActAct record);

    int updateByPrimaryKey(ActAct record);
}