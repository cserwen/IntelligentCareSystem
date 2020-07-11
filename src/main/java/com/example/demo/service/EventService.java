package com.example.demo.service;

import com.example.demo.entry.Event;
import com.example.demo.mapper.EventMapper;
import com.example.demo.mapper.PicturesMapper;
import com.example.demo.util.ResultReturn;
import com.example.demo.util.ResultReturnUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName EventService
 * @Description TODO
 * @Created by dengzhiwen
 * @Date 2020/7/11 23:40
 **/
@Service
public class EventService {

    @Resource
    private EventMapper eventMapper;

    @Resource
    private PicturesMapper picturesMapper;

    public ResultReturn addEvent(Event event){
        eventMapper.addEvent(event);

        String id = eventMapper.getIdByDate(event.getEventDate(), event.getOldPerson());
        return ResultReturnUtil.success("添加成功", id);
    }

    public ResultReturn addPicture(MultipartFile picture, String id){

        if (picture == null)
            return ResultReturnUtil.fail("图片为空");

        String contentType = picture.getContentType();
        if (contentType != null && !contentType.split("/")[0].equals("image"))
            return ResultReturnUtil.fail("文件类型错误");

        return save(picture, id);
    }

    private ResultReturn save(MultipartFile picture, String id){
        String basePath = "/root/java/eventPics";
        File file = new File(basePath);
        if (!file.exists())
            file.mkdirs();

        try {

            String filename = picture.getOriginalFilename();
            assert filename != null;
            if (picturesMapper.getPictureByDir(basePath + File.separator  + filename)!=null)
                return ResultReturnUtil.success("图片已存在");
            picture.transferTo(new File(basePath + File.separator  + filename));   //保存在磁盘上
            picturesMapper.savePictures(id, basePath + File.separator  + filename);
        }catch (IOException e){
            e.printStackTrace();
        }

        return ResultReturnUtil.success("图片添加成功");
    }



}
