package com.macro.mall.service;

import com.macro.mall.model.ActRecommend;
import com.macro.mall.model.ActRecommendExample;
import com.macro.mall.model.dto.RecActDto;

import java.util.List;

public interface ActRecommendService {

    int add(ActRecommend config);

    int update(ActRecommend config);

    int delete(Long id);

    ActRecommend selectById(Long id);

    List<ActRecommend> listRecommend(ActRecommendExample example);

    List<RecActDto> listRecAct(Integer recType);

}
