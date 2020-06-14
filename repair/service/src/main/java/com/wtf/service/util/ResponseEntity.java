package com.wtf.service.util;import com.wtf.service.constant.ResponseCode;import lombok.Data;/** * @author wangtengfei * @since 2020/3/14 15:07 */@Datapublic class ResponseEntity<T> {    private T Data;    private String message;    private Integer Code;    private boolean success;    public static <T> ResponseEntity<T> success(T data){        ResponseEntity<T> responseEntity=new ResponseEntity<>();        responseEntity.setData(data);        responseEntity.setCode(200);        responseEntity.setSuccess(true);        responseEntity.setMessage("成功");        return responseEntity;    }    public static <T> ResponseEntity<T> failure(ResponseCode code){        ResponseEntity<T> responseEntity=new ResponseEntity<>();        responseEntity.setMessage(code.getMessage());        responseEntity.setSuccess(false);        responseEntity.setCode(code.getCode());        return responseEntity;    }}