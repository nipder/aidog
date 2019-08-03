package com.sec.aidog.service;

import java.util.Map;

public interface VillageService {

    Map<String, Integer> GetIndexLogoInfo(String provinceName, String cityName, String countyName, String villagename) throws Exception;
    Map<String, Object> GetVillageMap(String provinceName, String cityName, String countyName,String villagename) throws Exception;
    Map<String, Object> GetDistrictcode(String provinceName, String cityName, String countyName,String villagename) throws Exception;

}
