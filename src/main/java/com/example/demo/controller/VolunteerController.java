package com.example.demo.controller;

import com.example.demo.bo.DeleteByIdBo;
import com.example.demo.entry.Volunteer;
import com.example.demo.service.VolunteerService;
import com.example.demo.util.ResultReturn;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.jvm.hotspot.debugger.ReadResult;

import javax.annotation.Resource;

/**
 * @author dengzhiwen <dengzhiwen@kuaishou.com>
 * Created on 2020-07-01
 */
@RestController
@RequestMapping("/volunteer")
public class VolunteerController {

    @Resource
    private VolunteerService volunteerService;

    @RequestMapping("/add")
    public ResultReturn add(@RequestBody Volunteer volunteer){
        return volunteerService.add(volunteer);
    }

    @RequestMapping("/update")
    public ResultReturn update(@RequestBody Volunteer volunteer){
        return volunteerService.update(volunteer);
    }

    @RequestMapping("/delete")
    public ResultReturn delete(@RequestBody DeleteByIdBo id){
        return volunteerService.delete(id.getId());
    }

    @RequestMapping("/getAll")
    public ResultReturn getAll(){
        return volunteerService.getAll();
    }
}
