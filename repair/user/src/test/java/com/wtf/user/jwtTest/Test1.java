package com.wtf.user.jwtTest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

/**
 * @author wangtengfei
 * @since 2020/5/1 23:58
 */
public class Test1 {
    public static void main(String[] args) {
        Claims claims= Jwts.parser().setSigningKey("aaaaaaa").parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiJoYWhhaGEiLCJpYXQiOjE1ODgzNDkxMDMsImV4cCI6MTU4ODM0OTEzMywicm9sZSI6MX0.wwoptFEO6v02xNOG98jiU2BunmZsT1cNi3giynqBhjU").getBody();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));

    }
}
