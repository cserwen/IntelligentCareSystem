package com.example.demo.interceptor;

import com.example.demo.service.RedisService;
import com.example.demo.util.ResultReturnUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName AuthInterceptor
 * @Description TODO
 * @Created by dengzhiwen
 * @Date 2020/6/29 19:06
 **/
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Resource
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String token = request.getHeader("token");
        System.out.println(token);
        if (StringUtils.isEmpty(token)) {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json; charset=utf-8");
            String jsonStr = "{\"code\":-2,\"msg\":\"用户未登录！\"}";
            response.getWriter().write(jsonStr);
            return false;
        }
        Object loginStatus = redisService.get(token);
        if( Objects.isNull(loginStatus)){
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json; charset=utf-8");
            String jsonStr = "{\"code\":-2,\"msg\":\"token失效，请重新登陆！\"}";
            response.getWriter().write(jsonStr);
            return false;
        }
        return true;
    }
}
