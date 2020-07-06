package com.example.demo.controller;

import com.example.demo.bo.DeleteByIdBo;
import com.example.demo.bo.LoginBo;
import com.example.demo.bo.PicturesBo;
import com.example.demo.entry.Volunteer;
import com.example.demo.service.PicturesService;
import com.example.demo.service.VolunteerService;
import com.example.demo.util.ResultReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(VolunteerController.class);

    @Resource
    private VolunteerService volunteerService;

    @Resource
    private PicturesService picturesService;

    @RequestMapping("login")
    public ResultReturn login(@RequestBody LoginBo loginBo){
        logger.info("义工登陆：" + loginBo);
        return volunteerService.login(loginBo);
    }

    @RequestMapping("/add")
    public ResultReturn add(@RequestBody Volunteer volunteer){
        logger.info("添加义工信息：" + volunteer);
        return volunteerService.add(volunteer);
    }

    @RequestMapping("/update")
    public ResultReturn update(@RequestBody Volunteer volunteer){

        logger.info("更新义工信息：" + volunteer);
        return volunteerService.update(volunteer);
    }

    @RequestMapping("/delete")
    public ResultReturn delete(@RequestBody DeleteByIdBo id){

        logger.info("删除义工信息：" + id);
        return volunteerService.delete(id.getId());
    }

    @RequestMapping("/getAll")
    public ResultReturn getAll(){

        logger.info("查询所有义工信息");
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
