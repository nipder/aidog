package com.sec.aidog.common;

import com.sec.aidog.dao.DistrictMapper;
import com.sec.aidog.pojo.District;
import com.sec.aidog.util.NameConversionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistrictCommon {

    @Autowired
    private NameConversionUtil nameConversionUtil;

    @Autowired
    private DistrictMapper districtMapper;

    public District GetDistrictcode(String province, String city, String county, String village,
                                  String hamlet){
        province = nameConversionUtil.EchartsAreaNameToGov(province);
        city = nameConversionUtil.EchartsAreaNameToGov(city);
        county = nameConversionUtil.EchartsAreaNameToGov(county);
        village = nameConversionUtil.EchartsAreaNameToGov(village);
        hamlet = nameConversionUtil.EchartsAreaNameToGov(hamlet);
        //获得该地区地区编码前两位(省)
        String provinceCode0to2 = districtMapper.getDistrictsByDistrictName(province).getDistrictcode().substring(0,2);
        //获得该地区地区编码前四位(市)
        String cityCode0to4 = districtMapper.getCityAndBelowDistrictsByDistrictName(city, provinceCode0to2).getDistrictcode().substring(0,4);
        //获得该地区地区编码前六位(县)
        String countyCode0to6 = districtMapper.getCityAndBelowDistrictsByDistrictName(county, cityCode0to4).getDistrictcode().substring(0,6);
        //获得该地区地区编码前九位(乡)
        String villageCode0to9 = districtMapper.getCityAndBelowDistrictsByDistrictName(village, countyCode0to6).getDistrictcode().substring(0,9);
        //获得该地区地区编码前12位(村)
        District thishamlet = districtMapper.getCityAndBelowDistrictsByDistrictName(hamlet, villageCode0to9);
        return thishamlet;
    }
}
