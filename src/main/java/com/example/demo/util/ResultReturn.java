package com.example.demo.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @ClassName ResultReturn
 * @Description 返回结果的json数据实体类
 * @Created by dengzhiwen
 * @Date 2020/6/29 11:49
 **/

@Getter
@Setter
@ToString
public class ResultReturn {
    private int code;
    private String msg;
    private Object data;

    public ResultReturn(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultReturn(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String toJsonString(){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"code\":");
        stringBuilder.append(code);
        stringBuilder.append(", \"msg\":\"");
        stringBuilder.append(msg);
        stringBuilder.append("\", \"data\":");
        stringBuilder.append(data);
        stringBuilder.append("}");


        return stringBuilder.toString();
    }
}
