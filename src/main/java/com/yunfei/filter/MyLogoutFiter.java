package com.yunfei.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@Slf4j
//@Component
public class MyLogoutFiter {//extends LogoutFilter {



    //@Override
    /*protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {

        Subject subject = getSubject(request, response);
        // String redirectUrl = getRedirectUrl(request, response, subject);
        String redirectUrl = "/login.html";
        ServletContext servletContext = request.getServletContext();
        try{
            subject.logout();
            servletContext.removeAttribute("error");
        } catch (SessionException e) {
            //log.error("logoutFiter",e);
            e.printStackTrace();
        }
        issueRedirect(request,response,redirectUrl);
        return false;
        //return super.preHandle(request, response);
    }*/
}
