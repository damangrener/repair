package com.wtf.user.entity.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author wangtengfei
 * @since 2020/4/8 16:40
 */
@Data
public class UserInfo {
    private Integer id;

    private String account;

    private String name;

    private Integer sex;

    private String phone;

    private Integer role;

    private Date createTime;

    private Integer delFlag;

    private Date updateTime;
}
