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
    // TODO song 为什么使用 loginResult 命名
    private SignInfoEnum loginResult;
}
