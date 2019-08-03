package com.sec.aidog.service;

import java.util.Map;

public interface ProvinceService {

    Map<String, Integer> GetIndexLogoInfo(String provincename) throws Exception;
    Map<String, Integer> GetArmyIndexLogo(String provincename) throws Exception;
    Map<String, Object> GetProvinceMap(String provincename) throws Exception;
    Map<String, Object> GetArmyProvinceMap(String provincename) throws Exception;
    Map<String, Object> GetDistrictcode(String provincename) throws Exception;
}

