package com.initcat.user_common.model.req;

import lombok.Data;

import java.util.Date;

/**
 * song 19/4/5
 */
@Data
public class SignInReq {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * '最后签到时间'
     */
    private Date lastSignTime;
    /**
     * 连续签到天数
     */
    private int countSignDay;
    /**
     * 更新时间
     */
    private Date updateTime;
}
