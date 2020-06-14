//package com.wtf.user.config;
//
//import com.wtf.user.entity.dto.UserRedis;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Map;
//
///**
// * @author wangtengfei
// * @since 2020/4/8 13:45
// */
//public class LoginInterceptor implements HandlerInterceptor {
//    @Autowired
//    private RedisTemplate redisTemplate;
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        UserInfo userInfo;
//        if (handler instanceof HandlerMethod) {
//            userInfo = ((HandlerMethod) handler).getMethodAnnotation(UserInfo.class);
//        }else {
//            return true;
//        }
//        String token = request.getHeader("token");
////        Object obj=redisTemplate.opsForValue().get(token);
////        request.getSession().setAttribute("UserInfo",obj);
////        if(obj!=null){
////            return true;
////        }
//        return false;
//    }
//}
