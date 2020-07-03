package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author dengzhiwen <dengzhiwen@kuaishou.com>
 * Created on 2020-07-03
 */

@Mapper
public interface PicturesMapper {

    @Insert("insert into pic_dirs(type, username, dir) values(#{type}, #{username}, #{dir})")
    void savePictures(String type, String username, String dir);
}
