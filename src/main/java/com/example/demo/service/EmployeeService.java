package com.example.demo.service;

import com.example.demo.entry.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.util.ResultReturn;
import com.example.demo.util.ResultReturnUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengzhiwen <dengzhiwen@kuaishou.com>
 * Created on 2020-07-01
 */

@Service
public class EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    public ResultReturn add(Employee employee){

        if (employee.getUsername() == null || employee.getUsername().equals("")){
            return ResultReturnUtil.fail("名字不能为空");
        }

        Employee temp = employeeMapper.selectByUserName(employee.getUsername());
        if (temp != null){
            return ResultReturnUtil.fail("该员工信息已存在");
        }

        employeeMapper.add(employee);
        return ResultReturnUtil.success("添加成功");
    }

    public ResultReturn update(Employee employee){
        if (employee.getUsername() == null || employee.getUsername().equals("")){
            return ResultReturnUtil.fail("名字不能为空");
        }

        Employee temp = employeeMapper.selectByUserName(employee.getUsername());
        if (temp == null){
            return ResultReturnUtil.fail("该员工不存在");
        }

        employeeMapper.update(employee);
        return ResultReturnUtil.success("修改成功");
    }

    public ResultReturn delete(int id){

        Employee employee = employeeMapper.selectById(id);
        if (employee == null)
            return ResultReturnUtil.fail("该员工不存在");

        employeeMapper.delete(id);
        return ResultReturnUtil.success("删除成功");
    };

    public ResultReturn getAll(){
        List<Employee> employees = employeeMapper.getAll();
        return ResultReturnUtil.success("查询成功", employees);
    }

}
