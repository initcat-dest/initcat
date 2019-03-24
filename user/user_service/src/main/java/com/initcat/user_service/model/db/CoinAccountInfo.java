package com.initcat.user_service.model.db;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class CoinAccountInfo implements Serializable {
    private Long id;
    private Long userId;
    private Long coinBalance;//'金币余额
    private Integer accountStatus;//金币账户状态 1：有效 ，非1：无效'
    private Date createTime;
    private Date updateTime;
}
