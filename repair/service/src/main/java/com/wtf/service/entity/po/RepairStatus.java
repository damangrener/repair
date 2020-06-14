package com.wtf.service.entity.po;

import lombok.Data;

import java.util.Date;

@Data
public class RepairStatus {
    private Integer id;

    private String repairOrder;

    private String servicemanAccount;

    private Date presentTime;

    private String repairDuration;

    private String repairDesc;

    private Integer repairStatus;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private String statusName;

    private String name;
    private String phone;

}