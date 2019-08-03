package com.sec.aidog.common;

import com.sec.aidog.dao.DistrictMapper;
import com.sec.aidog.util.NameConversionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictUtil {

    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private NameConversionUtil nameConversionUtil;

    public String getDistrictCode(String provincename, String cityname, String countyname, String villagename,String hamletname) {
        String districtcode = "";
        provincename =nameConversionUtil.EchartsAreaNameToGov(provincename);

        districtcode = districtMapper.getDistrictsByDistrictName(provincename).getDistrictcode();

        if (cityname != "")
        {
            cityname = nameConversionUtil.EchartsAreaNameToGov(cityname);
            String provincecode0to2 = districtcode.substring(0, 2);
            districtcode = districtMapper.getCityAndBelowDistrictsByDistrictName(cityname, provincecode0to2).getDistrictcode();
        }
        if (countyname != "")
        {
            countyname = nameConversionUtil.EchartsAreaNameToGov(countyname);
            String citycode0to4 = districtcode.substring(0, 4);
            districtcode = districtMapper.getCityAndBelowDistrictsByDistrictName(countyname, citycode0to4).getDistrictcode();
        }
        if (villagename != "")
        {
            villagename = nameConversionUtil.EchartsAreaNameToGov(villagename);
            String countycode0to6 = districtcode.substring(0, 6);
            districtcode = districtMapper.getCityAndBelowDistrictsByDistrictName(villagename, countycode0to6).getDistrictcode();
        }
        if (hamletname != "")
        {
            hamletname = nameConversionUtil.EchartsAreaNameToGov(hamletname);
            String villagecode0to9 = districtcode.substring(0, 9);
            districtcode = districtMapper.getCityAndBelowDistrictsByDistrictName(hamletname, villagecode0to9).getDistrictcode();
        }
        return districtcode;
    }
}
