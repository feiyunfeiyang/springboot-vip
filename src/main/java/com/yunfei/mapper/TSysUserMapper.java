package com.yunfei.mapper;

import com.yunfei.entity.TSysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author yunfei
 * @since 2020-01-19
 */
public interface TSysUserMapper extends BaseMapper<TSysUser> {

    TSysUser findByLogin(String username);

    String findPassWordByLogin(String username);
}
