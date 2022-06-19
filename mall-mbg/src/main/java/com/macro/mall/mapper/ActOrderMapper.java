package com.macro.mall.mapper;

import com.macro.mall.model.ActOrder;
import com.macro.mall.model.ActOrderExample;
import java.util.List;

import com.macro.mall.model.dto.ActDto;
import com.macro.mall.model.dto.ActOrderWithItem;
import com.macro.mall.model.query.ActOrderQuery;
import org.apache.ibatis.annotations.Param;

public interface ActOrderMapper {
    long countByExample(ActOrderExample example);

    int deleteByExample(ActOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActOrder record);

    int insertSelective(ActOrder record);

    List<ActOrder> selectByExample(ActOrderExample example);

    ActOrder selectByPrimaryKey(Long id);

    ActOrder selectByOrderSn(String id);

    int updateByExampleSelective(@Param("record") ActOrder record, @Param("example") ActOrderExample example);

    int updateByExample(@Param("record") ActOrder record, @Param("example") ActOrderExample example);

    int updateByPrimaryKeySelective(ActOrder record);

    int updateByPrimaryKey(ActOrder record);

    int updateStatusByOrderSn(String orderSn, Integer status);

    ActDto getActInfoByActId(Long actId);

    /**
     * 查询参与该活动的用户id
     * @param actId 活动id
     * @return
     */
    List<Long> getMemberIdByActId(Long actId);

    /**
     * 查询超时订单
     * @param minute 超时分钟
     * @return
     */
    List<ActOrderWithItem> getTimeOutOrders(@Param("minute") Integer minute);

    void updateOrderStatus(List<Long> ids, Integer status);

    List<ActOrderWithItem> getOrderByStatus(Long memberId, Integer orderStatus);

    /**
     * 查订单列表
     * @param actOrderQuery
     * @return
     */
    List<ActOrderWithItem> listOrderWithItem(ActOrderQuery actOrderQuery);

}