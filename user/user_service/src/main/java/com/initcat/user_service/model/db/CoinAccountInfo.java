package com.initcat.user_service.model.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "coin_account_info")
@Data
public class CoinAccountInfo implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 金币余额
     */
    private Integer coinBalance;//'金币余额
    /**
     * 金币账户状态 1：有效 ，非1：无效'
     */
    private Integer accountStatus;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
