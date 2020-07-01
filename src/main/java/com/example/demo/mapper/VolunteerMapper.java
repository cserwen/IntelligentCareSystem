package com.example.demo.mapper;

import com.example.demo.entry.Employee;
import com.example.demo.entry.Volunteer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author dengzhiwen <dengzhiwen@kuaishou.com>
 * Created on 2020-07-01
 */
@Mapper
public interface VolunteerMapper {

    @Select("select * from volunteer_info where name=#{username}")
    Volunteer selectByUserName(String username);

    @Select("select * from volunteer_info where id=#{id}")
    Volunteer selectById(int id);

    @Insert("insert into volunteer_info(ORG_ID, CLIENT_ID, name, gender,phone,id_card,birthday,checkin_date, checkout_date, imgset_dir," +
            "profile_photo, DESCRIPTION, ISACTIVE, CREATED, CREATEBY, UPDATED, UPDATEBY, REMOVE) " +
            "values(1,1,#{name},#{gender},#{phone},#{idCard},#{birthday}, #{checkInDate}, #{checkOutDate}, #{imgSetDir}," +
            " #{profilePhotoDir}, #{description}, #{isActive},#{createTime}, #{createBy}, #{updateTime}," +
            " #{updateBy},#{remove})")
    void add(Volunteer volunteer);

    @Update("update volunteer_info set name=#{name}, gender=#{gender}, phone=#{phone}, id_card=#{idCard}," +
            "birthday=#{birthday}, checkin_date=#{checkInDate}, checkout_date=#{checkOutDate}, imgset_dir=#{imgSetDir}, " +
            "profile_photo=#{profilePhotoDir}, DESCRIPTION=#{description}, ISACTIVE=#{isActive}," +
            "CREATED=#{createTime}, CREATEBY=#{createBy}, UPDATED=#{updateTime}, UPDATEBY=#{updateBy}, REMOVE=#{remove} " +
            "where name=#{name}")
    void update(Volunteer volunteer);
}
