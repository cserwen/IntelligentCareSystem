package com.example.demo.controller;

import com.example.demo.bo.DeleteByIdBo;
import com.example.demo.bo.LoginBo;
import com.example.demo.bo.PicturesBo;
import com.example.demo.entry.Volunteer;
import com.example.demo.service.PicturesService;
import com.example.demo.service.VolunteerService;
import com.example.demo.util.ResultReturn;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author dengzhiwen <dengzhiwen@kuaishou.com>
 * Created on 2020-07-01 18：00
 */
@RestController
@RequestMapping("/volunteer")
public class VolunteerController {

    @Resource
    private VolunteerService volunteerService;

    @Resource
    private PicturesService picturesService;

    @RequestMapping("login")
    public ResultReturn login(@RequestBody LoginBo loginBo){
        return volunteerService.login(loginBo);
    }

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

    @RequestMapping("/pictures")
    public ResultReturn submitPictures(@RequestBody MultipartFile[] pictures, @RequestHeader("token") String token){
        PicturesBo picturesBo = new PicturesBo();
        picturesBo.setPictures(pictures);
        picturesBo.setToken(token);
        picturesBo.setType("volunteer");

        System.out.println(picturesBo.toString());
        return picturesService.savePictures(picturesBo);
    }
}
