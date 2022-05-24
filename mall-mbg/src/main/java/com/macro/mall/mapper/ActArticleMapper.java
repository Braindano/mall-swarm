package com.macro.mall.mapper;

import com.macro.mall.model.ActArticle;
import com.macro.mall.model.ActArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActArticleMapper {
    long countByExample(ActArticleExample example);

    int deleteByExample(ActArticleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActArticle record);

    int insertSelective(ActArticle record);

    List<ActArticle> selectByExampleWithBLOBs(ActArticleExample example);

    List<ActArticle> selectByExample(ActArticleExample example);

    ActArticle selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActArticle record, @Param("example") ActArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") ActArticle record, @Param("example") ActArticleExample example);

    int updateByExample(@Param("record") ActArticle record, @Param("example") ActArticleExample example);

    int updateByPrimaryKeySelective(ActArticle record);

    int updateByPrimaryKeyWithBLOBs(ActArticle record);

    int updateByPrimaryKey(ActArticle record);
}