package com.initcat.user_common.model.dto;

import com.initcat.user_common.model.enums.SignInfoEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInResultDTO {
    /**
     * 签到结果
     */
    private SignInfoEnum transResult;
    /**
     * 签到后账户信息
     */
    private SignInfoEnum signInAccountInfo;
}
