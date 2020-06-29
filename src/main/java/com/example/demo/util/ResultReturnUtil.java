package com.example.demo.util;

/**
 * @ClassName ResultReturnUtil
 * @Description TODO
 * @Created by dengzhiwen
 * @Date 2020/6/29 11:48
 **/
public class ResultReturnUtil {
    public static ResultReturn success(String msg){
        return new ResultReturn(0, msg);
    }

    public static ResultReturn success(String msg, Object data){
        return  new ResultReturn(0,msg,data);
    }

    public static ResultReturn fail(String msg){
        return new ResultReturn(-1,msg);
    }

    public static ResultReturn fail(int code,String msg){
        return new ResultReturn(code,msg);
    }
}
