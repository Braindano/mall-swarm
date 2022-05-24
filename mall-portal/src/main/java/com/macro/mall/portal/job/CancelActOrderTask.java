package com.macro.mall.portal.job;

import com.macro.mall.portal.service.ActOrderService;
import com.macro.mall.portal.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CancelActOrderTask {

    private static Logger LOGGER = LoggerFactory.getLogger(CancelActOrderTask.class);
    @Resource
    private ActOrderService actOrderService;

    @Scheduled(cron = "0 0/5 * * * *")
    public void cancelOrder(){
        actOrderService.cancelTimeOutOrder();
    }

}
