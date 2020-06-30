package com.example.demo.bo;

import com.example.demo.entry.SysUser;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName LoginBo
 * @Description 用户登录的业务模型
 * @Created by dengzhiwen
 * @Date 2020/6/29 11:41
 **/

@Getter
@Setter
@ToString
public class LoginBo {

    private String username;
    private String password;

    public LoginBo(){

    }

    public LoginBo(SysUser sysUser){
        this.username = sysUser.getUsername();
        this.password = sysUser.getPassword();
    }

}
