package com.wtf.service.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wtf.service.constant.ResponseCode;
import com.wtf.service.entity.dto.UserInfo;
import com.wtf.service.entity.po.RepairStatus;
import com.wtf.service.entity.vo.LogVO;
import com.wtf.service.entity.vo.OrderVO;
import com.wtf.service.entity.vo.RepairStatusVO;
import com.wtf.service.entity.vo.StatusCountVO;
import com.wtf.service.service.RepairOrderService;
import com.wtf.service.util.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author wangtengfei
 * @since 2020/3/23 15:01
 */
@RestController
@RequestMapping("api/service")
@Api("服务管理")
@Slf4j
public class ServiceController {

    @Autowired
    private RepairOrderService repairOrderService;

    @ApiOperation(value = "客户上报维修单", notes = "客户上报维修单")
    @PostMapping("report")
    public ResponseEntity<String> newRepairOrder(String account,
                                                 String type,
                                                 String problemDesc,
                                                 String appointTime,
                                                 String address,
                                                 String phone) {
        try {
            return ResponseEntity.success(repairOrderService.newRepairOrder(account, type, problemDesc, appointTime, address, phone));
        } catch (Exception e) {
            return ResponseEntity.failure(ResponseCode.insert_fail);
        }
    }

    @ApiOperation(value = "分派维修单", notes = "分派维修单")
    @PostMapping("assignServiceMan")
    public ResponseEntity<Integer> assignServiceMan(@RequestParam(value = "order") String order,
                                                    @RequestParam(value = "account") String account) {
        try {
            return ResponseEntity.success(repairOrderService.assignServiceMan(order, account));
        } catch (Exception e) {
            return ResponseEntity.failure(ResponseCode.update_fail);
        }
    }

    @ApiOperation(value = "维修人员修改维修单", notes = "维修人员修改维修单")
    @PostMapping("updateRepairStatus")
    public ResponseEntity<Integer> assignServiceMan(RepairStatusVO repairStatusVO) {
        try {
            return ResponseEntity.success(repairOrderService.updateStatus(repairStatusVO));
        } catch (Exception e) {
            return ResponseEntity.failure(ResponseCode.update_fail);
        }
    }

    @ApiOperation(value = "修改订单状态", notes = "修改订单状态")
    @PostMapping("signIn")
    public ResponseEntity<String> assignServiceMan(String repairOrder, Integer status) {
        try {
            return ResponseEntity.success(repairOrderService.signIn(repairOrder, status));
        } catch (Exception e) {
            return ResponseEntity.failure(ResponseCode.update_fail);
        }
    }

    @ApiOperation(value = "查询维修单状态", notes = "查询维修单状态")
    @GetMapping("getRepairStatus")
    public ResponseEntity<PageInfo<RepairStatus>> getRepairStatus(String order, Integer pageNum, Integer pageSize) {
        try {
            if (pageNum != null && pageSize != null) {
                return ResponseEntity.success(repairOrderService.getRepairStatus(order, pageNum, pageSize));
            } else {
                pageNum = 1;
                pageSize = 1;
                return ResponseEntity.success(repairOrderService.getRepairStatus(order, pageNum, pageSize));
            }
        } catch (Exception e) {
            return ResponseEntity.failure(ResponseCode.query_fail);
        }
    }

    @ApiOperation(value = "当前状态数统计", notes = "当前状态数统计")
    @GetMapping("getStatusCount")
    public ResponseEntity<List<StatusCountVO>> getStatusCount(@RequestParam(value = "status", required = false) Integer status) {
        try {
            return ResponseEntity.success(repairOrderService.getStatusCount(status));
        } catch (Exception e) {
            return ResponseEntity.failure(ResponseCode.query_fail);
        }
    }

    @ApiOperation(value = "获取维修人员自己的工单", notes = "获取维修人员自己的工单")
    @GetMapping("getOrderByServiceMan")
    public ResponseEntity<PageInfo<OrderVO>> getOrderByServiceMan(String account, Integer pageNum, Integer pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            return ResponseEntity.success(repairOrderService.getOrderByServiceMan(account));
        } catch (Exception e) {
            return ResponseEntity.failure(ResponseCode.query_fail);
        }
    }

//    @ApiOperation(value = "获取用户订单", notes = "获取用户订单")
//    @GetMapping("getOrderByAccount")
//    public ResponseEntity<PageInfo<OrderVO>> getOrderByAccount(@RequestParam(value = "account",required = false) String account,
//                                                               @RequestParam(value = "pageNum",required = false) Integer pageNum ,
//                                                               @RequestParam(value = "pageSize",required = false) Integer pageSize) {
//        try {
//            if(pageNum==null||pageSize==null){
//                pageNum=1;
//                pageSize=10;
//            }
//            PageHelper.startPage(pageNum, pageSize);
//            return ResponseEntity.success(repairOrderService.getOrderByAccount(account));
//        } catch (Exception e) {
//            return ResponseEntity.failure(ResponseCode.query_fail);
//        }
//    }

    @ApiOperation(value = "客户获取维修单", notes = "客户获取维修单")
    @GetMapping("getOrderByAccount")
    public ResponseEntity<PageInfo<OrderVO>> getOrderByAccount(String account, Integer pageNum, Integer pageSize) {
        try {
            if (pageNum == null || pageSize == null) {
                pageNum = 1;
                pageSize = 10;
            }
            PageHelper.startPage(pageNum, pageSize);
            return ResponseEntity.success(repairOrderService.getOrderByAccount(account));
        } catch (Exception e) {
            return ResponseEntity.failure(ResponseCode.query_fail);
        }
    }

    @ApiOperation(value = "获取所有维修单", notes = "获取所有维修单")
    @GetMapping("getAllOrder")
    public ResponseEntity<PageInfo<OrderVO>> getAllOrder(Integer pageNum, Integer pageSize) {
        try {
            if (pageNum == null || pageSize == null) {
                pageNum = 1;
                pageSize = 10;
            }
            PageHelper.startPage(pageNum, pageSize);
            return ResponseEntity.success(repairOrderService.getAllOrder());
        } catch (Exception e) {
            return ResponseEntity.failure(ResponseCode.query_fail);
        }
    }

    @ApiOperation(value = "获取用户订单日志", notes = "获取用户订单日志")
    @GetMapping("getOrderLog")
    public ResponseEntity<List<LogVO>> getOrderByAccount(String order) {
        try {
            return ResponseEntity.success(repairOrderService.getOrderLog(order));
        } catch (Exception e) {
            return ResponseEntity.failure(ResponseCode.query_fail);
        }
    }

    @ApiOperation(value = "维修退场", notes = "维修退场")
    @PostMapping("leave")
    public ResponseEntity<String> leave(String repairOrder, Integer status, String desc) {
        try {
            return ResponseEntity.success(repairOrderService.leave(repairOrder, status, desc));
        } catch (Exception e) {
            return ResponseEntity.failure(ResponseCode.update_fail);
        }
    }
}
