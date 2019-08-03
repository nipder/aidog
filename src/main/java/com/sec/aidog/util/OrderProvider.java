package com.sec.aidog.util;

import com.sec.aidog.pojo.PageBean;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.Map;

public class OrderProvider {

    public String combineNeckletAndAppDogListStr(Map<String, Object> paramsmap) {
        SQL sql = new SQL().SELECT("dog_id,dog_name,nec_id,app_id,manager_name").FROM("dog");
        String hamletCode = paramsmap.get("hamletCode").toString();
        if (StringUtils.hasText(hamletCode)) {
            sql.WHERE("districtcode = #{hamletCode}");
        }
        PageBean pageBean = (PageBean)paramsmap.get("pageBean1");
        if (pageBean != null) {
            return sql.toString()+" limit "+ paramsmap.get("pagestart")+","+paramsmap.get("pagesize");
        }
        return sql.toString();
    }
}
