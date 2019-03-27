package com.initcat.user_common.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoinAccountInfoDTO {
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 零钱余额
     */
    private Integer coinBalance;

}
