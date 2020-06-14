package com.wtf.service.entity.po;

import lombok.Data;

import java.util.Date;

@Data
public class UserPO {
    private Integer id;

    private String account;

    private String password;

    private String surname;

    private String name;

    private Integer sex;

    private String phone;

    private Integer role;

    private Date createTime;

    private Integer delFlag;

    private Date updateTime;

    public UserPO(String account) {
        this.account = account;
    }

    public UserPO() {
    }
}