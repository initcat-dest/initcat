package com.initcat.user_common.model.enums;

import java.io.Serializable;

/**
 * class description
 *
 * @author libo
 * @package com.initcat.user_common.model.enums
 * @company xmiles
 * @date 2019/3/18
 */
public enum LoginStatusEnum implements Serializable {

	/**
	 * 登录成功
	 */
	LOGIN_SUCCESS(1000, "登录成功"),
	/**
	 * 登录失败
	 * TODO 详细拆分失败类型
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

	public int code;
	public String msg;

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
}
