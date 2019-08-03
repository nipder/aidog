package com.sec.aidog.service;

import java.util.Map;

public interface CountyService {

    Map<String, Integer> GetIndexLogoInfo(String provinceName, String cityName, String countyName) throws Exception;
    Map<String, Object> GetCountyMap(String provinceName,String cityName,String countyName) throws Exception;
    Map<String, Object> GetDistrictcode(String provinceName,String cityName,String countyName) throws Exception;

}
