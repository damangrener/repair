package com.wtf.service.entity.vo;

import lombok.Data;

/**
 * @author wangtengfei
 * @since 2020/5/21 13:42
 */
@Data
public class OrderDetailVO {

    private String account;
    private String serviceMan;
    private String createTime;
    private Integer status;
    private String statusValue;
}
