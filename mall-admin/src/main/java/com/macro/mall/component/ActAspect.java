package com.macro.mall.component;


import com.macro.mall.common.api.ResultCode;
import com.macro.mall.common.exception.ApiException;
import com.macro.mall.mapper.ActAdminClubMapper;
import com.macro.mall.model.ActAdminClub;
import com.macro.mall.model.UmsAdmin;
import com.macro.mall.model.UmsRole;
import com.macro.mall.service.UmsAdminService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Aspect
@Component
public class ActAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActAspect.class);

    @Resource
    private UmsAdminService umsAdminService;

    @Resource
    private ActAdminClubMapper actAdminClubMapper;

    private Long offDutyAdminId = 5L;

    @Pointcut("execution(public * com.macro.mall.controller.Act*.*(..))")
    public void act() {
    }

    @Around("act()")
    public Object doBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        UmsAdmin currentAdmin = umsAdminService.getCurrentAdmin();
        Long adminId = currentAdmin.getId();

        List<UmsRole> roleList = umsAdminService.getRoleList(adminId);
        List<Long> roleIds = roleList.stream().map(UmsRole::getId).collect(Collectors.toList());
        if (roleIds.contains(offDutyAdminId)) {
            // offDuty管理员，不做限制
        } else {
            // 非管理员，校验是否绑定俱乐部
            ActAdminClub adminClub = actAdminClubMapper.getByUserId(adminId);
            if (Objects.isNull(adminClub)) {
                throw new ApiException("用户未绑定俱乐部");
            }
        }
        Object result = joinPoint.proceed();
        return result;
    }

}
