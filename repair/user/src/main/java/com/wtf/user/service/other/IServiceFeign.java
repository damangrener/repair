package com.wtf.user.service.other;

import com.wtf.user.constant.ResponseCode;
import com.wtf.user.entity.vo.GoodServiceManVO;
import com.wtf.user.entity.vo.StatusCountVO;
import com.wtf.user.util.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author wangtengfei
 * @since 2020/4/27 20:30
 */
@FeignClient(value = "api-service", fallback = ServiceFallBack.class)
public interface IServiceFeign {
    @RequestMapping(value = "api/service/getStatusCount",method = RequestMethod.GET)
    ResponseEntity<List<StatusCountVO>> getStatusCount(@RequestParam(value = "status", required = false) Integer status);
}

@Component
class ServiceFallBack implements IServiceFeign {

    @Override
    public ResponseEntity<List<StatusCountVO>> getStatusCount(@RequestParam(value = "status", required = false) Integer status) {
        return ResponseEntity.failure(ResponseCode.other_api_fail);
    }
}