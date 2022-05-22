package com.macro.mall.portal.domain.act;

import com.macro.mall.model.ActAct;
import com.macro.mall.model.UmsMemberReceiveAddress;

import java.math.BigDecimal;
import java.util.List;

/**
 * 确认单信息封装
 * Created by macro on 2018/8/30.
 */
public class ActConfirmOrderResult {
    //用户收货地址列表
    private List<UmsMemberReceiveAddress> memberReceiveAddressList;

    /**
     * 活动信息
     */
    private ActAct act;

    //计算的金额
    private CalcAmount calcAmount;

    public List<UmsMemberReceiveAddress> getMemberReceiveAddressList() {
        return memberReceiveAddressList;
    }

    public void setMemberReceiveAddressList(List<UmsMemberReceiveAddress> memberReceiveAddressList) {
        this.memberReceiveAddressList = memberReceiveAddressList;
    }

    public ActAct getAct() {
        return act;
    }

    public void setAct(ActAct act) {
        this.act = act;
    }

    public CalcAmount getCalcAmount() {
        return calcAmount;
    }

    public void setCalcAmount(CalcAmount calcAmount) {
        this.calcAmount = calcAmount;
    }

    public static class CalcAmount{
        //订单商品总金额
        private BigDecimal totalAmount;

        //活动优惠
        private BigDecimal promotionAmount;
        //应付金额
        private BigDecimal payAmount;

        public BigDecimal getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
        }

        public BigDecimal getPromotionAmount() {
            return promotionAmount;
        }

        public void setPromotionAmount(BigDecimal promotionAmount) {
            this.promotionAmount = promotionAmount;
        }

        public BigDecimal getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(BigDecimal payAmount) {
            this.payAmount = payAmount;
        }
    }
}
