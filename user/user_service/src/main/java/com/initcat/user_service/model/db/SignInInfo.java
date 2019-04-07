package com.initcat.user_service.model.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sign_in_info")
@Data
public class SignInInfo implements Serializable {
    @Id
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
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
