package com.yunfei.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionKey;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import java.io.Serializable;

@Component
public class CustomSessionManager extends DefaultWebSessionManager{

    @Resource
    private RedisSessionDao sessionDao;

    @Override
    protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException{
        Serializable sessionId = getSessionId(sessionKey);
        ServletRequest request = null;
        if(sessionKey instanceof WebSessionKey){
            request = ((WebSessionKey)sessionKey).getServletRequest();
        }
        if(null!=request && sessionId!=null){
            Session session = (Session)request.getAttribute(sessionId.toString());
            if (null != session){
                return session;
            }
        }
        Session session = super.retrieveSession(sessionKey);
        if(request != null && sessionId!=null){
            request.setAttribute(sessionId.toString(),session);
        }
        return session;
    }
}
