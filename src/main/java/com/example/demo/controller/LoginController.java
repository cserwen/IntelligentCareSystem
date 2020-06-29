package com.example.demo.controller;


import com.example.demo.bo.LoginBo;
import com.example.demo.service.SysUserService;
import com.example.demo.util.ResultReturn;
import com.example.demo.util.ResultReturnUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin(allowCredentials="true",maxAge = 3600)
public class LoginController {

    @Resource
    private SysUserService sysUserService;

    @RequestMapping("/login")
    public ResultReturn login(@RequestBody LoginBo loginBo){
        System.out.println(loginBo.toString());
        return sysUserService.login(loginBo);
    }

    @RequestMapping("/test")
    public ResultReturn test(@RequestBody LoginBo loginBo){
        System.out.println(loginBo.toString());
        return ResultReturnUtil.success("hello world!");
    }
}
