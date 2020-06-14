package com.wtf.user.entity.vo;

import lombok.Data;

/**
 * @author wangtengfei
 * @since 2020/5/3 1:34
 */
@Data
public class LoginVO {
    private String accountOrPhone;
    private String pwd;
}
