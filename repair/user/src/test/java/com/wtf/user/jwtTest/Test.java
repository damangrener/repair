package com.wtf.user.jwtTest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangtengfei
 * @since 2020/5/1 23:36
 */
public class Test {
    public static void main(String[] args) {
        JwtBuilder jwtBuilder= Jwts.builder()
                .setId("666")//当前用户登陆的id
                .setSubject("hahaha")//用户名
                .setIssuedAt(new Date())//时间
                .signWith(SignatureAlgorithm.HS256,"aaaaaaa")//s 不能太短
                .setExpiration(new Date(new Date().getTime()+30*1*1000))//过期时间
                .claim("role",1);
        System.out.println(jwtBuilder.compact());
//        Claims claims=Jwts.parser().setSigningKey("aaaaaaa").parseClaimsJws(jwtBuilder.compact()).getBody();
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));

    }
}
