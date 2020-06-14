package com.wtf.user.constant;

/**
 * @author wangtengfei
 * @since 2020/3/23 17:23
 */
public enum ResponseCode {
    success(200,"成功"),
    pwd_error(7001,"密码错误"),
    acc_error(7002,"账号或手机号不存在"),
    sign_err(7003,"账号已存在"),
    query_fail(7004,"查询异常"),
    update_fail(7005,"修改异常"),
    insert_fail(7006,"新增异常"),
    other_api_fail(6001,"调用其他服务接口异常");


    private Integer code;
    private String message;

    public static String getMessage(Integer code){
        for (ResponseCode r:ResponseCode.values()
             ) {
            if(code==r.code){
                return r.message;
            }
        }
        return "";
    }

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
