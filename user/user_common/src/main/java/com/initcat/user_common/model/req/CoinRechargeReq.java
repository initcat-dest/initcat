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
     * 充值金币
     */
    private int rechargeCoin;
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
