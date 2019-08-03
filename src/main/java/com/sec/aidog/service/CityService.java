package com.sec.aidog.service;

import java.util.Map;

public interface CityService {

    Map<String, Integer> GetIndexLogoInfo(String provincename, String cityname) throws Exception;
    Map<String, Integer> GetDivisionIndexLogo(String provincename,String cityname) throws Exception;
    Map<String, Object> GetCityMap(String provincename,String cityname) throws Exception;
    Map<String, Object> GetArmyCityMap(String provincename,String cityname) throws Exception;
    Map<String, Object> GetDistrictcode(String provincename,String cityname) throws Exception;
}
