package com.macro.mall.service.impl;

import com.macro.mall.mapper.ActOrderMapper;
import com.macro.mall.mapper.ActOrderReturnMapper;
import com.macro.mall.model.ActOrderReturn;
import com.macro.mall.model.dto.ActOrderWithItem;
import com.macro.mall.model.query.ActOrderQuery;
import com.macro.mall.model.query.ActOrderReturnQuery;
import com.macro.mall.service.ActOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActOrderServiceImpl implements ActOrderService {

    @Resource
    private ActOrderMapper orderMapper;

    @Resource
    private ActOrderReturnMapper orderReturnMapper;

    @Override
    public List<ActOrderWithItem> listOrder(ActOrderQuery actOrderQuery) {
        return orderMapper.listOrderWithItem(actOrderQuery);
    }

    @Override
    public List<ActOrderReturn> listOrderReturn(ActOrderReturnQuery query) {
        List<ActOrderReturn> actOrderReturns = orderReturnMapper.listByQuery(query);
        return actOrderReturns;
    }
}
