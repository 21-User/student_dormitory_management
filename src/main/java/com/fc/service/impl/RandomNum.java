package com.fc.service.impl;

import java.util.Random;

public class RandomNum {
    public static final String[] POOL = new String[]{"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};

    /**
     * 生成字符串
     * @return 生成的32位长度的16进制字符串
     */
    public static String generateNiceString(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            sb.append(POOL[random.nextInt(POOL.length)]);
        }
        return sb.toString();
    }
}
