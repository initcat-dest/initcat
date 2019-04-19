package com.initcat.user_common.enums;

/**
 * class description
 *
 * @author libo
 * @package com.initcat.user_common.model.enums
 * @company xmiles
 * @date 2019/3/18
 */
public enum LoginStatusEnum {
	/**
	 * 登录成功
	 */
	LOGIN_SUCCESS(1000, "登录成功"),
	/**
	 * 登录失败
	 */
	LOGIN_FAIL(4001, "登录失败"),
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

	LoginStatusEnum(int code, String msg) {
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
