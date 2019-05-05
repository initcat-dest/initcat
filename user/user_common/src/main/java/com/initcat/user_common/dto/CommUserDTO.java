package com.initcat.user_common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户DTO
 *
 * @author libo
 * @package com.initcat.user_common.model.dto
 * @company xmiles
 * @date 2019/3/18
 */
@Data
@ApiModel(value = "用户DTO")
public class CommUserDTO implements Serializable {
	@ApiModelProperty(value = "用户ID")
	private Long id;
	@ApiModelProperty(value = "用户手机号")
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
