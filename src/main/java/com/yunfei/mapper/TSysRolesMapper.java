package com.yunfei.mapper;

import com.yunfei.entity.TSysRoles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author yunfei
 * @since 2020-01-19
 */
public interface TSysRolesMapper extends BaseMapper<TSysRoles> {
    TSysRoles findById(Long roleId);
}
