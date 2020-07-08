package com.sec.aidog.util;

import java.util.Random;

public class IdUtil {
    private static String digitArray[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N",
            "P", "Q", "R", "S", "T", "V", "W", "X", "Y", "Z" };

    public synchronized static String getUniqueId(int iReqLength) {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < iReqLength; i++) {
            str.append(digitArray[random.nextInt(digitArray.length)]);
        }
        return str.toString();
    }

    public synchronized static String getUniqueDigit(int iReqLength) {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < iReqLength; i++) {
            str.append(digitArray[random.nextInt(10)]);
        }
        return str.toString() ;
    }

    public static byte[] StringToHex(String s){
        byte[] data = new byte[s.length() / 2];

        for (int i =0;i < s.length()/2 ;i += 2){
            String sub = s.substring(i , i + 2);
            //data[i / 2] = Byte.parseByte(sub, 16);
            data[i / 2] = (byte)Integer.parseInt(sub, 16);
        }


        return data;
    }

    public static synchronized String generateRandomId(String prefix) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return prefix + String.valueOf(System.currentTimeMillis());
    }
}
