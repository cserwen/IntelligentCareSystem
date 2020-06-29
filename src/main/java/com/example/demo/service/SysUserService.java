package com.example.demo.service;

import com.example.demo.bo.LoginBo;
import com.example.demo.entry.SysUser;
import com.example.demo.mapper.SysUserMapper;
import com.example.demo.util.ResultReturn;
import com.example.demo.util.ResultReturnUtil;
import com.example.demo.util.TokenUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @ClassName SysUserService
 * @Description TODO
 * @Created by dengzhiwen
 * @Date 2020/6/29 12:22
 **/
@Service
public class SysUserService{

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private RedisService redisService;

    public ResultReturn login(LoginBo loginBo){
        SysUser user = sysUserMapper.selectByUsername(loginBo.getUsername());
        if (user == null)
            return ResultReturnUtil.fail("no such user!");

        if (user.getPassword().equals(loginBo.getPassword())){
            String token = TokenUtil.getToken();
//            System.out.println(token + " " + loginBo.toString());
            redisService.setString(token, loginBo.getUsername(),60L);
            System.out.println(redisService.get(token));
            return ResultReturnUtil.success("login success!", token);

        }
        else
            return ResultReturnUtil.fail("password error!");
    }


}
