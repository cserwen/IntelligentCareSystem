package com.example.demo.controller;

import com.example.demo.bo.DeleteByIdBo;
import com.example.demo.entry.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.util.ResultReturn;
import com.example.demo.util.ResultReturnUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName EmployeeController
 * @Description TODO
 * @Created by dengzhiwen
 * Created on 2020-07-01
 */

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @RequestMapping("/add")
    public ResultReturn add(@RequestBody Employee employee){
        return employeeService.add(employee);
    }

    @RequestMapping("/update")
    public ResultReturn update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @RequestMapping("/delete")
    public ResultReturn delete(@RequestBody DeleteByIdBo id){
        return employeeService.delete(id.getId());
    }

    @RequestMapping("/getAll")
    public ResultReturn getAll(){
        return employeeService.getAll();
    }

}
