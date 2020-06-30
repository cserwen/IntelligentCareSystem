package com.example.demo.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName ChangePasswordBo
 * @Description 修改密码的实体类
 * @Created by dengzhiwen
 * @Date 2020/6/30 10:21
 **/
@Getter
@Setter
@ToString
public class ChangePasswordBo {

    private String token;
    private String oldPassword;
    private String newPassword;
}
