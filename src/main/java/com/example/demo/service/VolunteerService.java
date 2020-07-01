package com.example.demo.service;

import com.example.demo.entry.Volunteer;
import com.example.demo.mapper.VolunteerMapper;
import com.example.demo.util.ResultReturn;
import com.example.demo.util.ResultReturnUtil;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.debugger.ReadResult;

import javax.annotation.Resource;

/**
 * @author dengzhiwen <dengzhiwen@kuaishou.com>
 * Created on 2020-07-01
 */
@Service
public class VolunteerService {

    @Resource
    private VolunteerMapper volunteerMapper;

    public ResultReturn add(Volunteer volunteer){
        if (volunteer.getName() == null || "".equals(volunteer.getName())){
            return ResultReturnUtil.fail("名字不能为空");
        }

        Volunteer temp = volunteerMapper.selectByUserName(volunteer.getName());
        if (temp != null)
            return ResultReturnUtil.fail("该义工信息已存在");

        volunteerMapper.add(volunteer);
        return ResultReturnUtil.success("添加成功");
    }

    public ResultReturn update(Volunteer volunteer){
        if (volunteer.getName() == null || "".equals(volunteer.getName())){
            return ResultReturnUtil.fail("名字不能为空");
        }

        Volunteer temp = volunteerMapper.selectByUserName(volunteer.getName());
        if (temp == null)
            return ResultReturnUtil.fail("该义工信息不存在");

        volunteerMapper.update(volunteer);
        return ResultReturnUtil.success("修改成功");
    }
}
