package com.yunfei.controller;

import com.yunfei.entity.TSysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/")
@Controller
public class LoginController {

    @RequestMapping(value = "/subLogin" ,method = RequestMethod.POST ,produces="application/json;charset=utf-8")
    public String subLogin(TSysUser user, boolean rememberMe){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassword());
        try{
            token.setRememberMe(rememberMe);
            subject.login(token);
        }catch (Exception e){
            e.printStackTrace();
            return  e.getMessage();
        }
        return "redirect:index";
    }

    //@RequiresRoles("admin")
    @RequestMapping(value = "/testRole",method=RequestMethod.GET)
    @ResponseBody
    public String testRole(){
        return "testRole success";
    }

    //@RequiresRoles("admin1")
    @RequestMapping(value = "/testRole1",method=RequestMethod.GET)
    @ResponseBody
    public String testRole1(){
        return "testRole success";
    }

    @RequestMapping(value = "/testPerms",method=RequestMethod.GET)
    @ResponseBody
    public String testPerms(){
        return "testPerms success";
    }

    @RequestMapping(value = "/testPerms1",method=RequestMethod.GET)
    @ResponseBody
    public String testPerms1(){
        return "testPerms1 success";
    }
}
