package com.yunfei.service;

import com.yunfei.entity.TSysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author yunfei
 * @since 2020-01-19
 */
public interface TSysUserService extends IService<TSysUser> {

    TSysUser findByLogin(String userName);

    String findPassWordByLogin(String userName);
}
