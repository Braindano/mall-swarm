package com.macro.mall.service;

import com.macro.mall.model.ActOrderReturn;
import com.macro.mall.model.dto.ActOrderWithItem;
import com.macro.mall.model.query.ActOrderQuery;
import com.macro.mall.model.query.ActOrderReturnQuery;

import java.util.List;

public interface ActOrderService {

    List<ActOrderWithItem> listOrder(ActOrderQuery actOrderQuery);

    List<ActOrderReturn> listOrderReturn(ActOrderReturnQuery query);

}
