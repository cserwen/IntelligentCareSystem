package com.example.demo.controller;

import com.example.demo.entry.OldPerson;
import com.example.demo.service.OldPersonService;
import com.example.demo.util.ResultReturn;
import com.example.demo.util.ResultReturnUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName OldPersonController
 * @Description TODO
 * @Created by dengzhiwen
 * @Date 2020/6/30 12:11
 **/
@RestController
@CrossOrigin(allowCredentials="true",maxAge = 3600)
@RequestMapping("/oldPerson")
public class OldPersonController {

    @Resource
    private OldPersonService oldPersonService;

    @RequestMapping("/add")
    public ResultReturn add(@RequestBody OldPerson oldPerson){
        return oldPersonService.add(oldPerson);
    }
}
