package com.macro.mall.util;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.macro.mall.common.api.ResultCode;
import com.macro.mall.common.exception.ApiException;
import com.macro.mall.mapper.ActAdminClubMapper;
import com.macro.mall.model.ActAdminClub;
import com.macro.mall.model.UmsAdmin;
import com.macro.mall.model.UmsRole;
import com.macro.mall.service.UmsAdminService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AdminClubUtil {

    private Long offDutyAdminId = 5L;

    @Resource
    private UmsAdminService umsAdminService;

    @Resource
    private ActAdminClubMapper actAdminClubMapper;

    /**
     * 获取当前登录用户关联的俱乐部id
     * @return
     */
    public Long getCurrentAminClubId(){
        UmsAdmin currentAdmin = umsAdminService.getCurrentAdmin();
        ActAdminClub adminClub = actAdminClubMapper.getByUserId(currentAdmin.getId());
        if (Objects.isNull(adminClub)) {
            throw new ApiException("用户未绑定俱乐部");
        }
        List<UmsRole> roleList = umsAdminService.getRoleList(currentAdmin.getId());
        List<Long> roleIds = roleList.stream().map(UmsRole::getId).collect(Collectors.toList());
        // offDuty管理员角色返回空，查询所有俱乐部数据
        if (roleIds.contains(offDutyAdminId)) {
            return null;
        }
        return adminClub.getClubId();
    }

    /**
     * 超管鉴权
     */
    public void checkSuperAdmin(){
        UmsAdmin umsAdmin = umsAdminService.getCurrentAdmin();
        List<UmsRole> roleList = umsAdminService.getRoleList(umsAdmin.getId());
        List<Long> roleIds = roleList.stream().map(UmsRole::getId).collect(Collectors.toList());
        if (!roleIds.contains(offDutyAdminId)) {
            throw new ApiException(ResultCode.FORBIDDEN);
        }
    }

}
