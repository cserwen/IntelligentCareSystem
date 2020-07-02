package com.example.demo.controller;

import com.example.demo.bo.DeleteByIdBo;
import com.example.demo.bo.LoginBo;
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
//@CrossOrigin(allowCredentials="true",maxAge = 3600, origins = "*")
@RequestMapping("/oldPerson")
public class OldPersonController {

    @Resource
    private OldPersonService oldPersonService;

    @RequestMapping("/login")
    public ResultReturn login(@RequestBody LoginBo loginBo){
        return oldPersonService.login(loginBo);
    }

    @RequestMapping("/add")
    public ResultReturn add(@RequestBody OldPerson oldPerson){
        return oldPersonService.add(oldPerson);
    }

    @RequestMapping("/update")
    public ResultReturn update(@RequestBody OldPerson oldPerson){
        return oldPersonService.update(oldPerson);
    }

    @RequestMapping("/delete")
    public ResultReturn delete(@RequestBody DeleteByIdBo id){
        return oldPersonService.delete(id.getId());
    }

    @RequestMapping("/getAll")
    public ResultReturn getAll(){
        return oldPersonService.getAll();
    }
}
