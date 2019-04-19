package com.initcat.user_common.dto;

import lombok.Data;

import java.util.Date;
@Data
public class SignInInfoDTO {
    /**
     * 用户id
     */
    private int userId;
    /**
     * '最后签到时间'
     */
    private Date lastSignTime;
    /**
     * 连续签到天数
     */
    private int countSignDay;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
