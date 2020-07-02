package com.example.demo.service;

import com.example.demo.bo.PicturesBo;
import com.example.demo.util.ResultReturn;
import com.example.demo.util.ResultReturnUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author dengzhiwen <dengzhiwen@kuaishou.com>
 * Created on 2020-07-02
 */
@Service
public class PicturesService {

    @Resource
    private RedisService redisService;

    public ResultReturn savePictures(PicturesBo picturesBo){
        if (picturesBo.getPictures().length == 0)
            return ResultReturnUtil.fail("图片为空");

        for (int i = 0; i < picturesBo.getPictures().length; i++) {
            String contentType = picturesBo.getPictures()[i].getContentType();
            if (contentType != null && !contentType.split("/")[0].equals("image"))
                return ResultReturnUtil.fail("文件类型错误");
        }

        //TODO 保存文件
        save(picturesBo);

        return ResultReturnUtil.success("success");
    }

    private void save(PicturesBo picturesBo){
        MultipartFile[] pictures = picturesBo.getPictures();
        String type = picturesBo.getType();
        String token = picturesBo.getToken();

        String username = (String)redisService.get(token);
        String path = "/root/pictures/" + type + "/" + username;
        for (int i = 0; i < pictures.length; i++) {

        }
    }
}
