package com.example.demo.service;

import com.example.demo.bo.ChangePasswordBo;
import com.example.demo.bo.EditSysUserInfoBo;
import com.example.demo.bo.LoginBo;
import com.example.demo.entry.SysUser;
import com.example.demo.mapper.SysUserMapper;
import com.example.demo.util.ResultReturn;
import com.example.demo.util.ResultReturnUtil;
import com.example.demo.util.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @ClassName SysUserService
 * @Description 系统用户的服务
 * @Created by dengzhiwen
 * @Date 2020/6/29 12:22
 **/
@Service
public class SysUserService{

    private Logger logger = LoggerFactory.getLogger(SysUserService.class);

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
//            redisService.setString(token, loginBo.getUsername(),3600L);
            redisService.setString(token, loginBo.getUsername(),60L);
            logger.info("登录：" + redisService.get(token).toString());
            return ResultReturnUtil.success("login success!", token);

        }
        else
            return ResultReturnUtil.fail("password error!");
    }

    public ResultReturn changePassword(ChangePasswordBo changePasswordBo){
        String token = changePasswordBo.getToken();
        String username = (String)redisService.get(token);
        SysUser user = sysUserMapper.selectByUsername(username);
        if (user == null)
            return ResultReturnUtil.fail("no such user!");

        if (user.getPassword().equals(changePasswordBo.getOldPassword())){
            //修改密码
            sysUserMapper.changePassword(changePasswordBo.getNewPassword(), username);
            return ResultReturnUtil.success("change success");
        }
        else
            return ResultReturnUtil.fail("password error!");
    }

    public ResultReturn editInfo(EditSysUserInfoBo sysUserInfoBo){
        String token = sysUserInfoBo.getToken();
        String username = (String)redisService.get(token);
        SysUser user = sysUserMapper.selectByUsername(username);
        if (user == null)
            return ResultReturnUtil.fail("no such user!");
        sysUserInfoBo.setUserName(username);
        sysUserMapper.updateSysUserInfo(sysUserInfoBo);
        return ResultReturnUtil.success("修改成功");
    }


}
