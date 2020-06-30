package com.example.demo.mapper;

import com.example.demo.entry.OldPerson;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName OldPersonMapper
 * @Description TODO
 * @Created by dengzhiwen
 * @Date 2020/6/30 12:14
 **/
@Mapper
public interface OldPersonMapper {

    @Select("select * from oldperson_info where username=#{username}")
    OldPerson selectByUserName(String username);

    @Insert("insert into oldperson_info(ORG_ID, CLIENT_ID, username, gender,phone,id_card,birthday,checkin_date, checkout_date, imgset_dir," +
            "profile_photo, room_number, firstguardian_name, firstguardian_relationship, firstguardian_phone," +
            "firstguardian_wechat, secondguardian_name, secondguardian_relationship, secondguardian_phone," +
            "secondguardian_wechat, health_state, DESCRIPTION, ISACTIVE, CREATED, CREATEBY, UPDATED, UPDATEBY, REMOVE) " +
            "values(1,1,#{username},#{gender},#{phone},#{idCard},#{birthday}, #{checkInDate}, #{checkOutDate}, #{imgSetDir}," +
            " #{profilePhotoDir},#{roomNumber}, #{firstGuardianName}, #{firstGuardianRelationship}, #{firstGuardianPhone}," +
            "#{firstGuardianWechat}, #{secondGuardianName}, #{secondGuardianRelationship}, #{secondGuardianPhone}," +
            "#{secondGuardianWechat}, #{healthState}, #{description}, #{isActive},#{createTime}, #{createBy}, #{updateTime}," +
            " #{updateBy},#{remove})")
    void add(OldPerson oldPerson);
}
