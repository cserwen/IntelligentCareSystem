package com.example.demo.mapper;

import com.example.demo.entry.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName SysUserMapper
 * @Description TODO
 * @Created by dengzhiwen
 * @Date 2020/6/29 12:21
 **/
@Mapper
public interface SysUserMapper {

    @Select("select * from sys_user where UserName = #{username}")
    SysUser selectByUsername(String username);
}
