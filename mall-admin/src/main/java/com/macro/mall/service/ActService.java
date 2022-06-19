package com.macro.mall.service;

import com.macro.mall.model.ActAct;
import com.macro.mall.model.ActArticle;

import java.util.List;

public interface ActService {

    int add(ActAct act);

    int update(ActAct act);

    int delete(Long id);

    ActAct selectById(Long id);

    List<ActAct> listAct(Long clubId, Long actTypeId, Integer pageNum, Integer pageSize);

    int addArticle(ActArticle article);

    int updateArticle(ActArticle article);

    int deleteArticle(Long id);

    List<ActArticle> listArticle(String title, Integer pageNum, Integer pageSize);

    ActArticle getArticle(Long id);
}
