package com.initcat.user_common.model.req;

import lombok.Data;

/**
 * lisong
 * 19/3/31
 */
@Data
public class CoinRechargeReq {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 金币账户状态 1：有效 ，非1：无效'
     */
    // TODO song 这个不需要当做请求参数 - 请求参数要动脑子，考虑下需要不需要
    private int accountStatus;
    /**
     * 消费金额
     * TODO song 这里应该是充值金币数
     */
    // TODO song 这里应该是充值金币数，rechrgeCoin
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
