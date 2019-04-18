package com.initcat.common.model;

/**
 * 基础result
 *
 * @author libo
 * @package com.initcat.common.model
 * @company xmiles
 * @date 2019/4/18
 */
public enum BaseResult {

    /**
     * 成功
     */
    SUCCESS(1000, "成功"),
    /**
     * 失败
     */
    FAILURE(-1, "失败");

    private int code;

    private String msg;

    BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
