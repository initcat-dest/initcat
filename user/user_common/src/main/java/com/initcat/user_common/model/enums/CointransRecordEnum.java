package com.initcat.user_common.model.enums;

public enum  CointransRecordEnum {
    /**
     * 成功
     */
    SUCCESS(1000, "成功"),
    /**
     * 请求参数非法
     */
    PARAMETER_ILLEGAL(1001, "参数非法"),
    /**
     * 账户非法（不存在，或冻结）
     */
    ACCOUNT_ILLEGAL(1002, "账户非法"),
    /**
     * 金币账户余额不足
     */
    LACK_BALANCE(1003, "余额不足"),
    /**
     * 保存交易记录异常
     */
    SAVE_RECORD_ERROR(1004, "保存交易记录异常"),
    /**
     * 更新账户异常
     */
    UPDATE_ACCOUNT_ERROR(1005, "更新账户异常"),
    /**
     * 重复请求
     */
    REPEAT_REQUEST(1006, "重复请求"),
    /**
     * 服务异常（报错）
     */
    SERVICE_ERROR(1007, "服务异常");


    private int code;
    private String msg;

    CointransRecordEnum(int code, String msg) {
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
