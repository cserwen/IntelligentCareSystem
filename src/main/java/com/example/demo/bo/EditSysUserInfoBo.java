package com.example.demo.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName EditSysUserInfoBo
 * @Description TODO
 * @Created by dengzhiwen
 * @Date 2020/6/30 11:28
 **/

@Getter
@Setter
@ToString
public class EditSysUserInfoBo {

    private String userName;
    private String realName;
    private String email;
    private String token;
    private String createTime;
}
