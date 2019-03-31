package com.initcat.user_common.model.req;

import lombok.Data;

/**
 * lisong
 * 19/3/31
 */
@Data
public class CoinConsumeReq {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 金币账户状态 1：有效 ，非1：无效'
     */
    private int accountStatus;
    /**
     * 消费金额
     */
    private int operateCoin;
    /**
     * 交易码
     */
    private int transCode;
    /**
     * 交易描述码
     */
    private String transMsg;
    /**
     * 业务id
     */
    private Long businessId;
}
