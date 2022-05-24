package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.mapper.ActActMapper;
import com.macro.mall.mapper.ActArticleMapper;
import com.macro.mall.model.ActAct;
import com.macro.mall.model.ActActExample;
import com.macro.mall.model.ActArticle;
import com.macro.mall.model.ActArticleExample;
import com.macro.mall.service.ActService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class ActServiceImpl implements ActService {

    @Resource
    private ActActMapper actMapper;

    @Resource
    private ActArticleMapper actArticleMapper;

    @Override
    public int add(ActAct act) {
        return actMapper.insert(act);
    }

    @Override
    public int update(ActAct act) {
        return actMapper.updateByPrimaryKey(act);
    }

    @Override
    public int delete(Long id) {
        return actMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ActAct selectById(Long id) {
        return actMapper.selectByPrimaryKey(id);
    }

    @Override

    public List<ActAct> listAct(Long clubId, Long actTypeId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        ActActExample example = new ActActExample();
        ActActExample.Criteria criteria = example.createCriteria();
        if (Objects.nonNull(clubId)) {
            criteria.andClubIdEqualTo(clubId);
        }
        if (!StringUtils.isEmpty(actTypeId)) {
            criteria.andActTypeIdEqualTo(actTypeId);
        }
        example.setOrderByClause("id desc");
        return actMapper.selectByExample(example);
    }

    @Override
    public int addArticle(ActArticle article) {
        return actArticleMapper.insert(article);
    }

    @Override
    public int updateArticle(ActArticle article) {
        return actArticleMapper.updateByPrimaryKey(article);
    }

    @Override
    public int deleteArticle(Long id) {
        return actArticleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ActArticle> listArticle(String title, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        ActArticleExample example = new ActArticleExample();
        ActArticleExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        return actArticleMapper.selectByExampleWithBLOBs(example);
    }
}
