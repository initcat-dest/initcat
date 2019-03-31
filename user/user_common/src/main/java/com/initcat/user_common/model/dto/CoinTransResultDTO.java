package com.initcat.user_common.model.dto;

import com.initcat.user_common.model.enums.CointransRecordEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoinTransResultDTO {
    /**
     * 交易结果
     */
    private CointransRecordEnum transResult;
    /**
     * 交易后账户信息
     */
    private CoinAccountInfoDTO coinAccountInfo;
}
