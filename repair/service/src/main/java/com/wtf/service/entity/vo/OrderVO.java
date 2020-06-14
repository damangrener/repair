package com.wtf.service.entity.vo;

import lombok.Data;

/**
 * @author wangtengfei
 * @since 2020/5/4 19:41
 */
@Data
public class OrderVO {
    private String repairOrder;
    private String createTime;
    private String account;
    private Integer status;
    private String statusValue;
    private String address;
    private String appointTime;
    private String appointPhone;
    private Integer typeE;
    private String typeName;
    private String descC;
}
