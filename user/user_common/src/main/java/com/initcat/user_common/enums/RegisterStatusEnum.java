package com.initcat.user_common.enums;

/**
 * 注册状态
 *
 * @author libo
 * @package com.initcat.user_common.model.enums
 * @company xmiles
 * @date 2019/3/18
 */
public enum RegisterStatusEnum {
	/**
	 * 注册成功
	 */
	REGISTER_SUCCESS(1000, "注册成功"),
	/**
	 * 注册失败
	 */
	REGISTER_FAIL(4001, "注册失败"),
	/**
	 * 用户名不存在
	 */
	INVALID_PHONE(4002, "手机号不存在"),
	/**
	 * 密码错误
	 */
	LOGIN_ERROR_PASSWORD(4003,"密码错误");

	private int code;
	private String msg;

	RegisterStatusEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
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
