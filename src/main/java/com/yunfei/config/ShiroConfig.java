package com.yunfei.config;

import com.yunfei.filter.MyLogoutFiter;
import com.yunfei.filter.RolesOrFilter;
import com.yunfei.filter.UserAccessControlFilter;
import com.yunfei.properties.ShiroProperties;
import com.yunfei.shiro.CustomRealm;
import com.yunfei.shiro.CustomSessionManager;
import com.yunfei.shiro.RedisCacheManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;
import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Resource
    private CustomRealm customRealm;
    @Resource
    private CustomSessionManager sessionManager;
    @Resource
    private RedisCacheManager redisCacheManager;
    @Resource
    private RolesOrFilter rolesOrFilter;
    //@Resource
    //private MyLogoutFiter myLogoutFiter;
    @Resource
    private UserAccessControlFilter userAccessControlFilter;
    @Resource
    private ShiroProperties shiroProperties;

    @Bean
    public JedisPoolConfig getJedisPoolConfig(){
        return new JedisPoolConfig();
    }

    @Bean
    public JedisPool getJedisPool(){
        JedisPool jedisPool = new JedisPool(getJedisPoolConfig(),"127.0.0.1",6379);
        return jedisPool;
    }

    @Bean
    public HashedCredentialsMatcher getCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(1);
        return credentialsMatcher;
    }

    @Bean
    public Cookie getCookie(){
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        cookie.setMaxAge(20000000);
        return cookie;
    }
    @Bean
    public CookieRememberMeManager getCookieRememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(getCookie());
        return cookieRememberMeManager;
    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm);
        securityManager.setSessionManager(sessionManager);
        securityManager.setCacheManager(redisCacheManager);
        securityManager.setRememberMeManager(getCookieRememberMeManager());
        return securityManager;
    }


    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(getDefaultWebSecurityManager());
        shiroFilter.setLoginUrl(shiroProperties.getLoginUrl());// 没认证后重定向位置
        shiroFilter.setSuccessUrl(shiroProperties.getSuccessUrl());// 登录成功后跳转位置
        shiroFilter.setUnauthorizedUrl(shiroProperties.getUnauthorizedUrl());// 没有权限跳转的位置
        Map<String, String> definitionMap = new HashMap<>();
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(shiroProperties.getAnonUrl(), ",");
        for (String url : anonUrls) {
            definitionMap.put(url,"anon");
        }
        // 配置退出过滤器，其中具体的退出代码 Shiro已经替我们实现了
        definitionMap.put(shiroProperties.getLogoutUrl(), "logout");
        definitionMap.put("/*","authc");
        //definitionMap.put("/logout","logout");
        shiroFilter.setFilterChainDefinitionMap(definitionMap);
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("rolesOr",rolesOrFilter);
        shiroFilter.setFilters(filterMap);
        return shiroFilter;
    }
}
