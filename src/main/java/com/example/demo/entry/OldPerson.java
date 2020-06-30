package com.example.demo.entry;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @ClassName OldPerson
 * @Description TODO
 * @Created by dengzhiwen
 * @Date 2020/6/30 12:02
 **/

@Getter
@Setter
@ToString
public class OldPerson {

    private int id;
    private int orgId;
    private int clientId;
    private String username;
    private String gender;  //性别
    private String phone;
    private String idCard;
    private Date birthday;
    private Date checkInDate;
    private Date checkOutDate;
    private String imgSetDir;
    private String profilePhotoDir;
    private String roomNumber;
    private String firstGuardianName;
    private String firstRelationship;
    private String firstGuardianPhone;
    private String firstGuardianWechat;
    private String secondGuardianName;
    private String secondRelationship;
    private String secondGuardianPhone;
    private String secondGuardianWechat;

    private String healthState;
    private String description;
    private String isActive;
    private Date createTime;
    private int createBy;
    private Date updateTime;
    private int updateBy;
    private String remove; //删除标志
}
