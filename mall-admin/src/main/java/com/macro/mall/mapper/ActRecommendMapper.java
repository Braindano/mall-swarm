package com.macro.mall.mapper;

import com.macro.mall.model.ActRecommend;
import com.macro.mall.model.ActRecommendExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActRecommendMapper {
    long countByExample(ActRecommendExample example);

    int deleteByExample(ActRecommendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActRecommend record);

    int insertSelective(ActRecommend record);

    List<ActRecommend> selectByExample(ActRecommendExample example);

    ActRecommend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActRecommend record, @Param("example") ActRecommendExample example);

    int updateByExample(@Param("record") ActRecommend record, @Param("example") ActRecommendExample example);

    int updateByPrimaryKeySelective(ActRecommend record);

    int updateByPrimaryKey(ActRecommend record);
}