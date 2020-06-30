package com.example.demo.service;

import com.example.demo.entry.OldPerson;
import com.example.demo.mapper.OldPersonMapper;
import com.example.demo.util.ResultReturn;
import com.example.demo.util.ResultReturnUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName OldPersonService
 * @Description TODO
 * @Created by dengzhiwen
 * @Date 2020/6/30 12:14
 **/

@Service
public class OldPersonService {

    @Resource
    private OldPersonMapper oldPersonMapper;

    public ResultReturn add(OldPerson oldPerson){

        if (oldPerson.getUsername()==null||oldPerson.getUsername().equals(""))
            return ResultReturnUtil.fail("名字不能为空");

        OldPerson temp = oldPersonMapper.selectByUserName(oldPerson.getUsername());
        if (temp!=null){
            return ResultReturnUtil.fail("该位老人信息已存在");
        }

        oldPersonMapper.add(oldPerson);

        return ResultReturnUtil.success("添加成功");
    }
}
