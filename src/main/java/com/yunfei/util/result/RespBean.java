package com.yunfei.util.result;

import java.util.HashMap;

public class RespBean extends HashMap {
    public static  String SUCCESS_CODE="200";
    public static String ERROR_CODE="500";
    public static String DATA_KEY = "data";
    public static String MSG_KEY = "msg";

    private RespBean(){

    }

    public RespBean set(String key, Object object){
        super.put(key,object);
        return  this;
    }

    private  static RespBean ok(){
        return new RespBean();
    }

    public static RespBean success(){

        return RespBean.ok().set("code", RespBean.SUCCESS_CODE).set(RespBean.MSG_KEY,"操作成功");
    }

    public static RespBean success(String msg){

        return RespBean.ok().set("code", RespBean.SUCCESS_CODE).set(RespBean.MSG_KEY,msg);
    }

    public static RespBean success(String msg, Object object){

        return RespBean.ok().set("code", RespBean.SUCCESS_CODE).set(RespBean.MSG_KEY,msg).set(RespBean.DATA_KEY,object);
    }

    public RespBean data(Object obj){
        return this.set("data",obj);
    }

    public static RespBean error(){
        return RespBean.ok().set(RespBean.MSG_KEY,"操作失败").set("code", RespBean.ERROR_CODE);
    }

    public static RespBean error(String msg){
        return RespBean.ok().set(RespBean.MSG_KEY,msg).set("code", RespBean.ERROR_CODE);
    }

    public static RespBean error(String msg, Object object){
        return RespBean.ok().set(RespBean.MSG_KEY,msg).set(RespBean.DATA_KEY,object).set("code", RespBean.ERROR_CODE);
    }
}
