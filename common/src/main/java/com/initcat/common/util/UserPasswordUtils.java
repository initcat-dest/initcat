package com.initcat.common.util;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;

/**
 * class description
 *
 * @author libo
 * @package com.initcat.common
 * @company xmiles
 * @date 2019/4/2
 */
public class UserPasswordUtils {

    /**
     * 十六进制下数字到字符的映射数组
     */
    private final static String[] hexDigits = {"0", "1", "2", "3", "4",
            "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * 给用户的密码加密
     *
     * @param password 用户密码
     * @return 加密后的密码
     */
    public static String encryptPassword(String password) throws Exception {
        return encodeByMD5(password);
    }

    /**
     * 验证输入的密码是否正确
     *
     * @param encryptPassword 加密后的密码
     * @param password        输入的密码
     * @return 验证结果，TRUE:正确 FALSE:错误
     */
    public static boolean validatePassword(String encryptPassword, String password) throws Exception {
        return StringUtils.isNotBlank(encryptPassword)
                && StringUtils.isNotBlank(password)
                && encryptPassword.equals(encodeByMD5(password));
    }

    /**
     * 对字符串进行MD5加密
     */
    private static String encodeByMD5(String originString) throws Exception {
        //创建具有指定算法名称的信息摘要
        MessageDigest md = MessageDigest.getInstance("MD5");
        //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
        byte[] results = md.digest(originString.getBytes());
        //将得到的字节数组变成字符串返回
        String resultString = byteArrayToHexString(results);
        return resultString.toUpperCase();

    }

    /**
     * 转换字节数组为十六进制字符串
     *
     * @param b 字节数组
     * @return 十六进制字符串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (byte aB : b) {
            resultSb.append(byteToHexString(aB));
        }
        return resultSb.toString();
    }

    /**
     * 将一个字节转化成十六进制形式的字符串
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

}
