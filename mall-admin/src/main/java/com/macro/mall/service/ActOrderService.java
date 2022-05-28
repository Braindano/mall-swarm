package com.macro.mall.service;

import com.macro.mall.model.dto.ActOrderWithItem;
import com.macro.mall.model.query.ActOrderQuery;

import java.util.List;

public interface ActOrderService {

    List<ActOrderWithItem> listOrder(ActOrderQuery actOrderQuery);


}
