package com.wtf.service.entity.po;

import lombok.Data;

import java.util.Date;
@Data
public class CustomerRepairOrderPO {
	private Integer id;

	private String repairOrder;

	private String account;

	private String type;

	private String problemDesc;

	private String appointTime;

	private Date createTime;

	private String createBy;

	private Date updateTime;

	private String updateBy;

	private String address;

	private String phone;

}