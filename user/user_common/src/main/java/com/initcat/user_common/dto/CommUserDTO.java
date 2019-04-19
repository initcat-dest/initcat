package com.initcat.user_common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * class description
 *
 * @author libo
 * @package com.initcat.user_common.model.dto
 * @company xmiles
 * @date 2019/3/18
 */
@Data
public class CommUserDTO implements Serializable {
	private Long id;
	private String phone;
	private String password;
	private String name;
	private Integer six;
	private Integer age;
	private Integer activateStatus;
	private Date createTime;
	private Date activateTime;
	private Date updateTime;

}
