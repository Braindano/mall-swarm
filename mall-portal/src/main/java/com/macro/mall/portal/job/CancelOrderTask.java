package com.macro.mall.portal.job;

import com.macro.mall.portal.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CancelOrderTask {

    private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderTask.class);
    @Resource
    private OmsPortalOrderService portalOrderService;

    @Scheduled(cron = "0 0/2 * * * *")
    public void cancelOrder(){
        portalOrderService.cancelTimeOutOrder();
    }

}
