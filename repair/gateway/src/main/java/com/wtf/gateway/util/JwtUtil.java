//package com.wtf.gateway.util;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//
//import java.util.Date;
//
///**
// * @author wangtengfei
// * @since 2020/5/1 23:29
// */
//@Data
//@Slf4j
//@ConfigurationProperties("jwt.config")
//public class JwtUtil {
//    private String key;
//    private long expirationTime;
//
//    /**
//     *
//     * @param id
//     * @param subject
//     * @param role
//     * @return
//     */
//    public String createJWT(String id, String subject, Integer role) {
//        JwtBuilder builder= Jwts.builder().setId(id)
//                .setSubject(subject)
//                .signWith(SignatureAlgorithm.HS256,key)
//                .claim("role",role);
//        if(expirationTime>0){
//            builder.setExpiration(new Date(new Date().getTime()+expirationTime));
//        }
//        return builder.compact();
//    }
//
//    public Claims getJWT(String jwtStr){
//        try {
//            return Jwts.parser()
//                    .setSigningKey(key)
//                    .parseClaimsJws(jwtStr)
//                    .getBody();
//        }catch (Exception e){
//            log.error("><[令牌取出错误]");
//            return null;
//        }
//
//    }
//
//}
