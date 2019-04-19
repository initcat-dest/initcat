package com.initcat.user_common.dto;

import com.initcat.user_common.enums.SignInStatusEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInResultDTO {

    /**
     * 签到结果
     */
    private SignInStatusEnum signInResult;
}
