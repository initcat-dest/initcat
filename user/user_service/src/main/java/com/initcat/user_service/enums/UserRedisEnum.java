package com.initcat.user_service.enums;

import java.text.MessageFormat;

/**
 * 用户缓存Constant
 *
 * @author libo
 * @package com.initcat.constant
 * @company xmiles
 * @date 2018/11/27
 */
public enum UserRedisEnum {
    /**
     * 用户信息
     */
    USER_INFO("commUser:info", 1),
    /**
     * 用户注册缓存锁
     */
    USER_REGISTER_FREQUENCY_LOCK("commUser:registerLock", 1);

    private String key;

    private int parameterCount;

    public String getKey(Object... info) throws Exception {
        String result = key;
        int count = parameterCount;
        if (count > 0) {
            if (null != info && info.length == count) {
                for (int i = 0; i < count; i++) {
                    result += ":{" + i + "}";
                }
                return MessageFormat.format(result, info);
            } else {
                throw new Exception("缓存key参数异常");
            }
        }
        return result;
    }

    UserRedisEnum(String key, int parameterCount) {
        this.key = key;
        this.parameterCount = parameterCount;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public static void main(String[] args) throws Exception {
        String libo = USER_INFO.getKey("dest", "hehe");
        System.out.println(libo);
    }
}
