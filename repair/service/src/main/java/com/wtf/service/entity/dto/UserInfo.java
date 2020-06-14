package com.wtf.service.entity.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author wangtengfei
 * @since 2020/4/7 14:34
 */
@Data
public class UserInfo {
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
}
