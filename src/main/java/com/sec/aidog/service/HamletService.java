package com.sec.aidog.service;

import com.sec.aidog.pojo.PageBean;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface HamletService {

    Map<String, Object> GetHamletMap(String province, String city, String county, String village, String hamlet, HttpServletRequest request) throws Exception;

    String GovToEchartsAreaName(String city) throws Exception;

    Map<String, Object> GetHamletFeederMap(String province, String city, String county, String village,
                                           String hamlet) throws Exception;

    Map<String, Object> GetLevel6AdminDogNum(String username) throws Exception;

    Map<String, Object> CombineNeckletAndFeederDogList(PageBean pageBean, String hamletCode) throws Exception;

    Integer CombineNeckletAndFeederDogTotal(String hamletCode) throws Exception;

    Map<String, Object> getCombineNeckletAndFeederDogByNeckletId(String neckletId, String hamletCode) throws Exception;

}
