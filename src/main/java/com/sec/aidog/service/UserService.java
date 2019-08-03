package com.sec.aidog.service;

import com.sec.aidog.pojo.Manager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface UserService {
    Manager userLogin(String username, String pwd);

    Map<String, Integer> GetIndexLogoInfo(Manager resultUser) throws Exception;

    Map<String, Object> GetCountryMap() throws Exception;

    List<Map<String,String>> GetAllCities() throws Exception;

    List<Map<String,String>> GetAllCounties() throws Exception;

    List<Map<String,String>> GetAllVillages() throws Exception;

    List<Map<String,String>> GetAllHamlets() throws Exception;

    String addUser(String addtype, int privilegelevel, String username, String managername, String address, String identity, String area, String officecall, String tel, String password) throws Exception;

    List<Manager> getUnderManagers(Integer privilegelevel,String districtcode);

    Manager selectByPrimaryKey(Integer managerId);

    boolean activeManager(Integer manager_id);

    boolean freezeManager(Integer manager_id);

    boolean resetManagerPwd(Integer manager_id, String pwd);

    String modifyUser(String username, String manager_name, String workplace, String manager_identity, String officetel, String manager_tel, String manager_addr, String manager_email, String password,String token) throws Exception;

    Map<String, Object> getHamletManagerList(String hamletcode);

    Manager selectByNameAndDistrictcode(String managername,String districtcode);
}
