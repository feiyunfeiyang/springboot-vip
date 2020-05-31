package com.yunfei.service.impl;

import com.yunfei.entity.TSysUser;
import com.yunfei.mapper.TSysUserMapper;
import com.yunfei.service.TSysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author yunfei
 * @since 2020-01-19
 */
@Service
public class TSysUserServiceImpl extends ServiceImpl<TSysUserMapper, TSysUser> implements TSysUserService {

    @Resource
    private TSysUserMapper userMapper;

    public TSysUser findByLogin(String userName){
        TSysUser user = userMapper.findByLogin(userName);
        if(null != user) {
            return user;
        }
        return null;
    }

    @Override
    public String findPassWordByLogin(String userName) {
        return userMapper.findPassWordByLogin(userName);
    }

}
