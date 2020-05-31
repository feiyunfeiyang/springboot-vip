package com.yunfei.mapper;

import com.yunfei.entity.TSysUserRoles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yunfei
 * @since 2020-01-19
 */
public interface TSysUserRolesMapper extends BaseMapper<TSysUserRoles> {

    TSysUserRoles findByUserId(Long userId);
}
