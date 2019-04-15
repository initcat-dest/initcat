package com.initcat.user_common.model.enums;

// TODO song 为什么用SignInfoEnum命名
public enum  SignInfoEnum{
    /**
     * 成功
     */
    SUCCESS(1000, "成功"),
    /**
     * 请求参数非法
     * TODO song 这个是否有用
     */
    PARAMETER_ILLEGAL(1001, "参数非法"),
    /**
     * 账户非法（不存在，或冻结）
     * TODO song 这个是否有用
     */
    ACCOUNT_ILLEGAL(1002, "账户非法"),

    /**
     * 保存签到记录异常
     * TODO song 这个为什么用在已签到的返回状态
     */
    SAVE_RECORD_ERROR(1004, "保存交易记录异常"),
    /**
     * 更新账户异常
     * TODO song 这个是否有用
     */
    UPDATE_ACCOUNT_ERROR(1005, "更新账户异常"),
    /**
     * 重复请求
     */
    REPEAT_REQUEST(1006, "重复请求"),
    /**
     * 服务异常（报错）
     * TODO song 这个是否有用
     */
    SERVICE_ERROR(1007, "服务异常");

    private int code;
    private String msg;

    SignInfoEnum(int code, String msg) {
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
