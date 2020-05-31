package com.yunfei.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CountHandleIntercept  implements HandlerInterceptor {

    private final ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof org.springframework.web.servlet.resource.ResourceHttpRequestHandler) {
            return true;
        }
        if(handler instanceof org.springframework.web.method.HandlerMethod) {
            org.springframework.web.method.HandlerMethod handlerMethod = (org.springframework.web.method.HandlerMethod)handler;
            String url = request.getRequestURI();
            System.out.println("执行方法之前，方法名称：{}" + handlerMethod.getMethod().getName());
            System.out.println("执行方法之前，路径：{}" + url);
        }
        threadLocal.set(System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long aLong = threadLocal.get();
        if (null != aLong){
            long time = System.currentTimeMillis() - threadLocal.get();
            System.out.println("方法执行之后，耗时" + time + "毫秒");
        }
        threadLocal.remove();
    }
}
