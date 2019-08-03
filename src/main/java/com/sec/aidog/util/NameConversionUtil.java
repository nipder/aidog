package com.sec.aidog.util;

import com.sec.aidog.dao.DistrictMapper;
import com.sec.aidog.dao.DistrictsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NameConversionUtil {

    @Autowired
    private DistrictMapper districtMapper;

    public String GovToEchartsAreaName(String districtName) {
        String echartsareaname =  districtMapper.getEchartsareanametempByDistrictName(districtName);
        return echartsareaname;
    }

    public String EchartsAreaNameToGov(String districtName) {
        String govareaname = districtMapper.getGovareanametempByDistrictName(districtName) ;
        return govareaname;
    }

}
