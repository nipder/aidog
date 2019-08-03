package com.sec.aidog.util;

public class ChangeTimeFormat {

    public static String changeTimeFormat(String time)
    {
        //String[] arr1 = time.Split(' ')[0].Split('/');
        String[] arr1 = time.split(" ")[0].split("/|-" );
        int year = Integer.parseInt(arr1[0]);
        int month = Integer.parseInt(arr1[1]);
        int date = Integer.parseInt(arr1[2]);
        String[] arr2 = time.split(" ")[1].split(":");
        int hour = Integer.parseInt(arr2[0]);
        int minute = Integer.parseInt(arr2[1]);
        int second = Integer.parseInt(arr2[2]);
        String time_stamp = "";
        if (month < 10)
        {
            time_stamp = "" + year + "0" + month;
        }
        else
        {
            time_stamp = "" + year + "" + month;
        }

        if (date < 10)
        {
            time_stamp = time_stamp + "0" + date;
        }
        else
        {
            time_stamp = time_stamp + "" + date;
        }

        if (hour < 10)
        {
            time_stamp = time_stamp + "0" + hour;
        }
        else
        {
            time_stamp = time_stamp + "" + hour;
        }

        if (minute < 10)
        {
            time_stamp = time_stamp + "0" + minute;
        }
        else
        {
            time_stamp = time_stamp + "" + minute;
        }

        if (second < 10)
        {
            time_stamp = time_stamp + "0" + second;
        }
        else
        {
            time_stamp = time_stamp + "" + second;
        }
        return time_stamp;
    }
}
