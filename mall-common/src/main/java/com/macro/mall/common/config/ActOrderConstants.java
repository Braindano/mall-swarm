package com.macro.mall.common.config;

import com.google.common.collect.Lists;

import java.util.List;

public class ActOrderConstants {

    /** 订单状态 */
    public static Integer ORDER_NEED_PAY = 0;
    public static Integer ORDER_NEED_SEND = 1;
    public static Integer ORDER_ALREADY_SEND = 2;
    public static Integer ORDER_COMPLETE = 3;
    public static Integer ORDER_CLOSE = 4;
    public static Integer ORDER_INVALID = 5;

    /**
     * 无法退单的订单状态集合
     */
    public static List<Integer> UN_RETURN_STATUS_LIST = Lists.newArrayList(ORDER_NEED_PAY, ORDER_CLOSE, ORDER_INVALID);


}
