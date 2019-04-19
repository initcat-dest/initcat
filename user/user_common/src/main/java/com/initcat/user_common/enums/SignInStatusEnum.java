package com.initcat.user_common.enums;

public enum SignInStatusEnum {

    /**
     * 成功
     */
    SUCCESS(1000, "成功"),
    /**
     * 重复请求
     */
    REPEAT_REQUEST(1006, "重复请求");
    private int code;
    private String msg;

    SignInStatusEnum(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
