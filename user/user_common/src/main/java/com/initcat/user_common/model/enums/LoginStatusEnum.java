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
	LOGIN_FAIL(4001, "登录失败");

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
