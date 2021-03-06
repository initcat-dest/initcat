package com.initcat.user_common.dto;

import com.initcat.user_common.enums.CoinTransRecordEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoinTransResultDTO {
    /**
     * 交易结果
     */
    private CoinTransRecordEnum transResult;
    /**
     * 交易后账户信息
     */
    private CoinAccountInfoDTO coinAccountInfo;
}
