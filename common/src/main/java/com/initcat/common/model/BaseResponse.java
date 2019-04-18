package com.initcat.common.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 基础返回对象
 *
 * @author libo
 * @package com.initcat.common.model
 * @company xmiles
 * @date 2019/4/18
 */
@Data
@Builder
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 2149679294479741133L;

    private String msg;

    private int code;

    private T data;


    /**
     * 创建成功的响应
     *
     * @return BaseResponse
     */
    public static BaseResponse createSuccess() {
        return BaseResponse.builder()
                .code(BaseResult.SUCCESS.getCode())
                .msg(BaseResult.SUCCESS.getMsg())
                .build();
    }

    /**
     * 创建成功的响应
     *
     * @param data 返回具体内容
     * @return BaseResponse
     */
    public static BaseResponse createSuccess(Object data) {
        return BaseResponse.builder()
                .code(BaseResult.SUCCESS.getCode())
                .msg(BaseResult.SUCCESS.getMsg())
                .data(data)
                .build();
    }


    /**
     * 创建失败的响应
     *
     * @return BaseResponse
     */
    public static BaseResponse createFailure(String msg) {
        return BaseResponse.builder()
                .code(BaseResult.FAILURE.getCode())
                .msg(msg)
                .build();
    }

    /**
     * 创建失败的响应
     *
     * @param msg  错误信息
     * @param data 返回具体内容
     * @return BaseResponse
     */
    public static BaseResponse createFailure(String msg, Object data) {
        return BaseResponse.builder()
                .code(BaseResult.FAILURE.getCode())
                .msg(msg)
                .data(data)
                .build();
    }

    /**
     * 创建特定的result
     *
     * @param result 自定义的result
     * @param data   返回具体内容
     * @return BaseResponse
     */
    public static BaseResponse createResult(BaseResult result, Object data) {
        return BaseResponse.builder()
                .code(result.getCode())
                .msg(result.getMsg())
                .data(data)
                .build();
    }

    public boolean isSuccess() {
        return BaseResult.SUCCESS.getCode() == this.code;
    }


}
