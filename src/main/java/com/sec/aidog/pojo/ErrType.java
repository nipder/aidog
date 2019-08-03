package com.sec.aidog.pojo;

import java.util.HashMap;
import java.util.Map;

public class ErrType {

//    ZERO("正常","0"),ONE("药盒未安装", "1"), TWO("关门堵转过流", "2"), THREE("关门超时", "3"), FOUR("开门堵转过流", "4"),
//    FIVE("开门超时","5"),SIX("开门堵转过流，第二次","6"),SEVEN("关门超时，第二次","7"),EIGHT("电池电压低于3.3V","8"),NINE("药已发完","16");

    public final static Map<String,String> errmap;

    static {
        errmap = new HashMap<String,String>();
        errmap.put("0","正常");
        errmap.put("1","药盒未安装");
        errmap.put("2","关门堵转过流");
        errmap.put("3","关门超时");
        errmap.put("4","开门堵转过流");
        errmap.put("5","开门超时");
        errmap.put("6","二次开门堵转过流");
        errmap.put("7","二次关门超时");
        errmap.put("8","电池电压低于3.3V");
        errmap.put("16","药已发完");
    }
}
