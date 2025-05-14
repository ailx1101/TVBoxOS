package com.github.tvbox.osc.util;


import androidx.annotation.NonNull;

import com.github.tvbox.osc.util.js.Crypto;

import java.util.Random;

/**
 * @author shzlx
 * @date :2025/05/14
 * @description: 适用站点【47.108.190.232:666】
 */
public class PrivateUtils {

    /// 解密接口返回数据
    public static String encode(@NonNull String text){
        if(text.startsWith("{") || text.startsWith("["))return text;
        text=text.replace("https://baidu.con/","").replace("lvDou+","").replace("\\/","/").replace("\"","");
        String key = text.substring(0,16);
        String content = text.substring(16);
        return Crypto.aes("AES/CBC/PKCS5",false,content,true, key, key,false);
    }

    /// 返回随机长度的小写加数字字符串
    public static String generateRandomString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        return sb.toString();
    }


}
