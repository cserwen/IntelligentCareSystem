package com.example.demo.mapper;

import com.example.demo.entry.Employee;
import com.example.demo.entry.OldPerson;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author dengzhiwen <dengzhiwen@kuaishou.com>
 * Created on 2020-07-01
 */

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee_info where username=#{username}")
    Employee selectByUserName(String username);


    @Insert("insert into employee_info(ORG_ID, CLIENT_ID, username, gender,phone,id_card,birthday,hire_date, resign_date, imgset_dir," +
            "profile_photo, DESCRIPTION, ISACTIVE, CREATED, CREATEBY, UPDATED, UPDATEBY, REMOVE) " +
            "values(1,1,#{username},#{gender},#{phone},#{idCard},#{birthday}, #{hireDate}, #{resignDate}, #{imgSetDir}," +
            " #{profilePhotoDir}, #{description}, #{isActive},#{createTime}, #{createBy}, #{updateTime}," +
            " #{updateBy},#{remove})")
    void add(Employee employee);

    @Update("update employee_info set username=#{username}, gender=#{gender}, phone=#{phone}, id_card=#{idCard}," +
            "birthday=#{birthday}, hire_date=#{hireDate}, resign_date=#{resignDate}, imgset_dir=#{imgSetDir}, " +
            "profile_photo=#{profilePhotoDir}, DESCRIPTION=#{description}, ISACTIVE=#{isActive}," +
            "CREATED=#{createTime}, CREATEBY=#{createBy}, UPDATED=#{updateTime}, UPDATEBY=#{updateBy}, REMOVE=#{remove} " +
            "where username=#{username}")
    void update(Employee employee);
}
