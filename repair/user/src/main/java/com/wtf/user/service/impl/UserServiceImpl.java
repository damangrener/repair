package com.wtf.user.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wtf.user.entity.dto.UserInfo;
import com.wtf.user.entity.dto.UserRedis;
import com.wtf.user.entity.po.UserPO;
import com.wtf.user.entity.po.UserPOExample;
import com.wtf.user.mapper.UserPOMapper;
import com.wtf.user.service.UserService;
import com.wtf.user.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author wangtengfei
 * @since 2020/3/23 14:59
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserPOMapper userPOMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    //生成账号
    @Override
    public String getAccount() {
        String account = "WTF-";
        String model = "0123456789ABCDEFG0123456789HIJKLMN0123456789OPQRSTUVWXYZ0123456789";
        char[] chars = model.toCharArray();
        for (int i = 0; i < 6; i++) {
            char c = chars[(int) (Math.random() * 66)];
            account += c;
        }
        //判断账号是否重复
        UserPOExample example = new UserPOExample();
        example.createCriteria().andAccountEqualTo(account);
        int count = userPOMapper.countByExample(example);
        return count > 0 ? getAccount() : account;
    }

    //注册
    @Override
    public UserPO signIn(String surname, String name, Integer sex, String phone, String account, String pwd) {
        UserPO user = new UserPO();
        user.setSurname(surname);
        user.setName(name);
        user.setSex(sex);
        user.setPhone(phone);
        user.setAccount(account);
        user.setPassword(bCryptPasswordEncoder.encode(pwd));
        UserPO user1 = verifyAcc(phone);
        if (user1 == null) {
            int a = userPOMapper.insertSelective(user);
            if (a == 1) {
                return user;
            }
        }
        if(user1!=null){
            return new UserPO("2");
        }
        return null;
    }

    //验证账号或手机号是否存在
    @Override
    public UserPO verifyAcc(String accountOrPhone) {
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andAccountEqualTo(accountOrPhone);
        List<UserPO> as = userPOMapper.selectByExample(userPOExample);
        userPOExample.clear();
        userPOExample.createCriteria().andPhoneEqualTo(accountOrPhone);
        List<UserPO> bs = userPOMapper.selectByExample(userPOExample);
        if (as.size() == 1 || bs.size() == 1) {
            return as.size() == 0 ? bs.get(0) : as.get(0);
        }
//        if (as.size() == 0 && bs.size() == 0) {
//            return new UserPO("isNull");
//        }

        return null;
    }

    //登录
    @Override
    public UserRedis loginIn(String accountOrPhone, String pwd) {
//        String uuid = "wtf-token-" + UUID.randomUUID().toString().toLowerCase();
        UserPO user = verifyAcc(accountOrPhone);
        if (user != null && bCryptPasswordEncoder.matches(pwd, user.getPassword())) {
            UserRedis userRedis = new UserRedis();
            userRedis.setAccount(user.getAccount());
            userRedis.setUserName(user.getSurname() + user.getName());
            userRedis.setPhone(user.getPhone());
            userRedis.setSex(user.getSex());
            userRedis.setRole(user.getRole());
            Set<String> keys = redisTemplate.keys(userRedis.getAccount() + "<>*");
            if (!CollectionUtils.isEmpty(keys)) {
                redisTemplate.delete(keys);
            }

            //生成令牌
            String token = jwtUtil.createJWT(user.getId().toString(), userRedis.toString(), userRedis.getRole());
            redisTemplate.opsForValue().set(userRedis.getAccount() + "<>" + token, JSONObject.toJSONString(userRedis), 60, TimeUnit.MINUTES);
            Object obj = redisTemplate.opsForValue().get(userRedis.getAccount() + "<>" + token);
            if (obj != null) {
                UserRedis userRedis1 = JSONArray.parseObject(obj.toString(), UserRedis.class);
                System.out.println(userRedis1);
                log.info("><[用户信息]= {}" + userRedis1);
                Map<String, Object> map = Maps.newHashMap();
                map.put("token", token);
                map.put("role", userRedis1.getRole());
                userRedis.setMap(map);
                return userRedis;
            }


        }
//            log.info("><[密码错误]");
//        log.info("><[账号或手机号不存在]= {}",accountOrPhone);
        return null;
    }

    @Override
    public int setRole(String account, Integer role) {
        UserPOExample userPOExample = new UserPOExample();
        UserPO user = new UserPO();
        user.setRole(role);
        userPOExample.clear();
        userPOExample.createCriteria().andAccountEqualTo(account);
        return userPOMapper.updateByExampleSelective(user, userPOExample);
    }

    @Override
    public PageInfo<UserInfo> getAllUser(String account, String surname, String name, String phone, Integer role) {
        List<UserPO> userPOS = userPOMapper.getAllUser(account, surname, name, phone, role);

//        for (int i = 0; i < userPOS.size(); i++) {
//            log.info("><[用户信息]{}", userPOS.get(i).toString());
//        }
        List<UserInfo> userInfos = Lists.newArrayList();
        userPOS.forEach(x -> {
            UserInfo userInfo = new UserInfo();
            userInfo.setAccount(x.getAccount());
            userInfo.setName(x.getSurname() + x.getName());
            userInfo.setPhone(x.getPhone());
            userInfo.setCreateTime(x.getCreateTime());
            userInfo.setDelFlag(x.getDelFlag());
            userInfo.setSex(x.getSex());
            userInfo.setRole(x.getRole());
            userInfo.setUpdateTime(x.getUpdateTime());
            userInfos.add(userInfo);
        });
        log.info("[用户信息条数]{}", userInfos.size());
        PageInfo pageInfo = new PageInfo(userInfos);
        return pageInfo;
    }

    @Override
    public String getPhone(String account) {
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andAccountEqualTo(account);
        if (!CollectionUtils.isEmpty(userPOMapper.selectByExample(userPOExample))) {
            return userPOMapper.selectByExample(userPOExample).get(0).getPhone();
        }
        return "";
    }


//    @Autowired
//    HttpSender httpSender;
//
//    @Override
//    public String getWxToken() {
//        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
//        String appId="&appid=wx6751e9395d9cd089";
//        String secret="&secret=0530b19a7a2d703e0db634f7124759a8";
//        Map<String,String> map=JSONObject.parseObject(httpSender.sendGet(url,appId+secret),Map.class);
//        return map.get("access_token");
//    }
}
