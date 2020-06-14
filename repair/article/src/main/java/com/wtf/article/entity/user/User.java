package com.wtf.article.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wangtengfei
 * @since 2020/3/24 14:15
 */
@Data
@ApiModel
public class User implements Serializable {
    private Integer id;

    private String account;

    @JsonIgnore
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
