package com.example.demo.mapper;

import com.example.demo.entry.OldPerson;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

    @Select("select * from oldperson_info where ID=#{id}")
    OldPerson selectByID(int id);

    @Select("select * from oldperson_info")
    List<OldPerson> getAll();

    @Insert("insert into oldperson_info(ORG_ID, CLIENT_ID, username, gender,phone,id_card,birthday,checkin_date, checkout_date, imgset_dir," +
            "profile_photo, room_number, firstguardian_name, firstguardian_relationship, firstguardian_phone," +
            "firstguardian_wechat, secondguardian_name, secondguardian_relationship, secondguardian_phone," +
            "secondguardian_wechat, health_state, DESCRIPTION, ISACTIVE, CREATED, CREATEBY, UPDATED, UPDATEBY, REMOVE) " +
            "values(1,1,#{username},#{gender},#{phone},#{idCard},#{birthday}, #{checkInDate}, #{checkOutDate}, #{imgSetDir}," +
            " #{profilePhotoDir},#{roomNumber}, #{firstGuardianName}, #{firstRelationship}, #{firstGuardianPhone}," +
            "#{firstGuardianWechat}, #{secondGuardianName}, #{secondRelationship}, #{secondGuardianPhone}," +
            "#{secondGuardianWechat}, #{healthState}, #{description}, #{isActive},#{createTime}, #{createBy}, #{updateTime}," +
            " #{updateBy},#{remove})")
    void add(OldPerson oldPerson);

    @Update("update oldperson_info set username=#{username}, gender=#{gender}, phone=#{phone}, id_card=#{idCard}," +
            "birthday=#{birthday}, checkin_date=#{checkInDate}, checkout_date=#{checkOutDate}, imgset_dir=#{imgSetDir}, " +
            "profile_photo=#{profilePhotoDir}, room_number=#{roomNumber}, firstguardian_name=#{firstGuardianName},"+
            "firstguardian_relationship=#{firstRelationship}, firstguardian_phone=#{firstGuardianPhone}," +
            "firstguardian_wechat=#{firstGuardianWechat}, secondguardian_name=#{secondGuardianName},secondguardian_relationship=" +
            "#{secondRelationship}, secondguardian_phone=#{secondGuardianPhone}, secondguardian_wechat=" +
            "#{secondGuardianWechat}, health_state=#{healthState}, DESCRIPTION=#{description}, ISACTIVE=#{isActive}," +
            "CREATED=#{createTime}, CREATEBY=#{createBy}, UPDATED=#{updateTime}, UPDATEBY=#{updateBy}, REMOVE=#{remove} " +
            "where username=#{username}")
    void update(OldPerson oldPerson);

    @Delete("delete from oldperson_info where ID=#{id}")
    void delete(int id);
}
