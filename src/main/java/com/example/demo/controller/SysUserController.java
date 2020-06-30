package com.example.demo.controller;


import com.example.demo.bo.ChangePasswordBo;
import com.example.demo.bo.LoginBo;
import com.example.demo.service.SysUserService;
import com.example.demo.util.ResultReturn;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(allowCredentials="true",maxAge = 3600)
@RequestMapping("/sysUser")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @RequestMapping("/login")
    public ResultReturn login(@RequestBody LoginBo loginBo){
        System.out.println(loginBo.toString());
        return sysUserService.login(loginBo);
    }

    @RequestMapping("/changePassword")
    public ResultReturn test(@RequestBody ChangePasswordBo changePasswordBo, @RequestHeader("token") String token){
        changePasswordBo.setToken(token);
        System.out.println(changePasswordBo.toString());
        return sysUserService.changePassword(changePasswordBo);
    }
}
