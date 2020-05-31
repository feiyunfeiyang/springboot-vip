package com.yunfei.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@Component
public class RolesOrFilter extends AuthorizationFilter{

    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request,response);
        String[] roles = (String[]) mappedValue;
        if (null==roles || roles.length == 0){
            return true;
        }
        for(String role:roles){
            if (subject.hasRole(role)){
                return true;
            }
        }
        return false;
    }
}
