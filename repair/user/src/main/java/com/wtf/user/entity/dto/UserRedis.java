package com.wtf.user.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author wangtengfei
 * @since 2020/4/7 17:36
 */
@Data
public class UserRedis implements Serializable {

    private String account;

    private String userName;

    private Integer sex;

    private String phone;

    private Integer role;

    private Date createTime;

    private Map<String, Object> map;
}
