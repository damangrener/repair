package com.wtf.service.constant;

/**
 * @author wangtengfei
 * @since 2020/6/1 15:55
 */
public enum IceTypeEnum {
    gua(0,"挂机"),
    gui(1,"柜机"),
    zy(2,"中央空调"),
    other(3,"其他");


    private Integer status;
    private String desc;

    public static String getValueByCode(int code) {
        for (IceTypeEnum e : IceTypeEnum.values()) {
            if (e.getStatus() == code) {
                return e.getDesc();
            }
        }
        return "";
    }

    IceTypeEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
