package com.macro.mall.portal.feign;


import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.ActAct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("mall-admin")
public interface ActService {

    @RequestMapping("/act/getDetail")
    CommonResult<ActAct> getDetail(@RequestParam Long id);

}
