package com.wtf.service.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author wangtengfei
 * @since 2020/4/26 15:49
 */
@Data
public class RepairStatusVO {
    private String repairOrder;

    private String servicemanAccount;

    private Date presentTime;

    private String repairDuration;

    private String repairDesc;

    private Integer repairStatus;

    private String updateBy;
}
