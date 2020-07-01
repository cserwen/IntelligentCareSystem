package com.example.demo.entry;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @ClassName Employee
 * @Description TODO
 * @Created by dengzhiwen
 * Created on 2020-07-01
 */

@Getter
@Setter
@ToString
public class Employee {

    private int id;
    private int orgId;
    private int clientId;
    private String username;
    private String gender;  //性别
    private String phone;
    private String idCard;
    private Date birthday;
    private Date hireDate;  //入职
    private Date resignDate;  //离职
    private String imgSetDir;
    private String profilePhotoDir;

    private String description;
    private String isActive;
    private Date createTime;
    private int createBy;
    private Date updateTime;
    private int updateBy;
    private String remove; //删除标志

}
