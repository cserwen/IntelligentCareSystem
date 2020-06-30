package com.example.demo.mapper;

import com.example.demo.bo.EditSysUserInfoBo;
import com.example.demo.entry.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @ClassName SysUserMapper
 * @Description 系统用户mapper
 * @Created by dengzhiwen
 * @Date 2020/6/29 12:21
 **/
@Mapper
public interface SysUserMapper {

    @Select("select * from sys_user where UserName = #{username}")
    SysUser selectByUsername(String username);

    @Update("update sys_user set Password=#{password} where UserName = #{username}")
    void changePassword(String password, String username);

    @Update("update sys_user set REAL_NAME=#{realName}, EMAIL=#{email}, CREATED=#{createTime} where UserName = #{userName}")
    void updateSysUserInfo(EditSysUserInfoBo sysUserInfoBo);
}
