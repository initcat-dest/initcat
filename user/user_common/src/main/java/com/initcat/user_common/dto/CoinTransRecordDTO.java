package com.initcat.user_common.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CoinTransRecordDTO {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 操作类型 1：充值 ，2：消费
     */
    private Integer operateType;
    /**
     * 交易余额（单位：分）
     */
    private Integer operateCoin;
    /**
     * 交易完成后余额（单位：分）
     */
    private Integer tradeCoin;
    /**
     * 交易信息
     */
    private String transMsg;
    /**
     * 创建时间
     */
    private Date createTime;
}
