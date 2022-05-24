package com.macro.mall.portal.service;

import com.macro.mall.model.ActAct;
import com.macro.mall.model.ActArticle;
import com.macro.mall.model.UmsMember;
import com.macro.mall.model.dto.ActClubDto;
import com.macro.mall.model.dto.ActDto;
import com.macro.mall.model.query.ActQuery;

import java.util.List;

public interface ActHomeService {

    /**
     * 根据活动类型获取活动列表
     * @param query
     * @return
     */
    List<ActAct> getActList(ActQuery query);

    /**
     * 根据推荐类型获取活动列表
     * @param recommendType
     * @return
     */
    List<ActAct> getRecActList(Integer recommendType);

    /**
     * 获取活动详情
     * @param actId 活动id
     * @return
     */
    ActDto getActInfo(Long actId);

    List<UmsMember> getActMembers(Long actId);

    /**
     * 获取后台参数配置
     * @return
     */
    String getConfig(String configName);


    /**
     * 查用户关注的俱乐部
     * @param memberId
     * @return
     */
    List<ActClubDto> listAttentionClub(Long memberId);

    /**
     * 获取文章信息
     * @param articleId 文章id
     * @return
     */
    ActArticle getArticleById(Long articleId);
}
