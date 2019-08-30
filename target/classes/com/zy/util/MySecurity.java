package com.zy.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @ClassName MySecurity
 * @Author zy
 * @Description shiro加密等工具类
 * @Date 11:10 2019/8/28
 * @Version 1.0
 **/
public class MySecurity {
    private static int hashIterations=5;

    /**
     * @Author zy
     * @Description md5加密，加密内容source,带盐加密salt，指定加密次数：hashIterations
     * @Date 11:10 2019/8/28
     * @Param [source, salt]
     * @return java.lang.String
     **/
    public static String encryptUserPassword(String source, String salt){
        return new Md5Hash(source, salt, hashIterations).toBase64();
    }
}