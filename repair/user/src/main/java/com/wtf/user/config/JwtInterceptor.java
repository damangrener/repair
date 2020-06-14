package com.wtf.user.config;

import com.wtf.user.util.JwtUtil;
import com.wtf.user.util.ResponseEntity;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangtengfei
 * @since 2020/5/2 14:15
 */
@Component
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("><[进入拦截器：9091：{api-user}]");
        //
        String header = request.getHeader("Authorization");
        if (!StringUtils.isBlank(header)) {
            try {
                Claims claims = jwtUtil.getJWT(header);
                Integer role = (Integer) claims.get("role");
                if (role != null && role == 0) {
                    request.setAttribute("admin", header);
                }
                if (role != null && role == 1) {
                    request.setAttribute("serviceMan", header);
                }
                if (role != null && role == 2) {
                    request.setAttribute("client", header);
                }
            } catch (Exception e) {
                log.error("令牌有误");
                throw new RuntimeException("令牌有误");
            }

        }else{
            log.error("><[token不存在]");
            return true;
//            throw new RuntimeException("token不存在");
        }
        return true;
    }
}
