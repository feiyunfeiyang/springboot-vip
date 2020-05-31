package com.yunfei.util;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    
    private static Environment environment;
    
    public static String getProperty(String key) {
        return environment.getProperty(key);
    }
    
    @Resource
    public void setEnvironment(Environment environment) {
        SpringUtils.environment = environment;
    }

    /**
     * @param applicationContext the applicationContext to set
     */
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringUtils.applicationContext = applicationContext;
    }
    
    @SuppressWarnings("unchecked")
	public static <T> T get(String name){
        return (T)applicationContext.getBean(name);
    }
    
    public static <T> T get(String name, Class<T> clz){
        return applicationContext.getBean(name, clz);
    }
    
    public static <T> T get(Class<T> clz){
        return applicationContext.getBean(clz);
    }
}
