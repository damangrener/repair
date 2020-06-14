package com.wtf.user.controller;

import com.wtf.user.constant.ResponseCode;
import com.wtf.user.entity.dto.UserRedis;
import com.wtf.user.entity.po.UserPO;
import com.wtf.user.service.UserService;
import com.wtf.user.util.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wangtengfei
 * @since 2020/3/23 15:01
 */
@RestController
@RequestMapping("api/user")
@Api("用户管理")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取随机账号", notes = "获取随机账号")
    @GetMapping("getAccount")
    public ResponseEntity<String> getAccount() {
        return ResponseEntity.success(userService.getAccount());
    }

    @ApiOperation(value = "注册", notes = "注册")
    @PostMapping("signIn")
    public ResponseEntity<UserPO> signIn(String surname,
                                         String name,
                                         Integer sex,
                                         String phone,
                                         String account,
                                         String pwd) {
        try {
            return ResponseEntity.success(userService.signIn(surname, name, sex, phone, account, pwd));
        } catch (Exception e) {
            return ResponseEntity.failure(ResponseCode.sign_err);
        }
    }

    @ApiOperation(value = "验证账号", notes = "验证账号")
    @GetMapping("verifyAcc")
    public ResponseEntity<UserPO> verifyAcc(@RequestParam(value = "accountOrPhone") String accountOrPhone) {
        UserPO user = userService.verifyAcc(accountOrPhone);
        if (user != null) {
            return ResponseEntity.success(userService.verifyAcc(accountOrPhone));
        } else {
            return ResponseEntity.failure(ResponseCode.acc_error);
        }
    }

    @ApiOperation(value = "登录", notes = "登录")
    @PostMapping("loginIn")
    public ResponseEntity<UserRedis> loginIn(String accountOrPhone,
                                             String pwd) {
        UserRedis user = userService.loginIn(accountOrPhone, pwd);
        if (user!=null) {
            return ResponseEntity.success(user);
        } else {
            return ResponseEntity.failure(ResponseCode.pwd_error);
        }
    }

}
