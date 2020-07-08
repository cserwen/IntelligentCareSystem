package com.example.demo.entry;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String password;
    private String gender;  //性别
    private String phone;
    private String idCard;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date hireDate;  //入职

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date resignDate;  //离职

    private String imgSetDir;
    private String profilePhotoDir;

    private String description;
    private String isActive;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private int createBy;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private int updateBy;
    private String remove; //删除标志

}
