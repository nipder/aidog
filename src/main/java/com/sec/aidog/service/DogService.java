package com.sec.aidog.service;

import com.sec.aidog.pojo.Dog;

import java.util.Map;

public interface DogService {

    Dog addDog(String username, String dogname, String dogsex, String dogbelonghamlet, String ownerhamletcode, int dogownerid,
               String dogweight, String dogcolor, int dogage, String govcode)  throws Exception;

    Map<String, Object> getDogList(String districtcode, int startPage, int pageSize);

    Map<String, Object> getDogInfo(Integer dogid);

    String modifyDog(Integer dogid, String dogname, String dogsex, String dogweight, String dogcolor, Integer dogage);

    Map<String, Object> getDogStaList(String districtcode, int startPage, int pageSize);

    Map<String, Object> getIllStaList(String districtcode, int startPage, int pageSize);

    Map<String, Object> getBillStaList(String districtcode, int startPage, int pageSize);

    Map<String, Object> getChildCheckList(String districtcode, int startPage, int pageSize);

    Map<String, Object> getChildIllList(String districtcode, int startPage, int pageSize);

    Map<String, Object> getAnimalillList(String districtcode, int startPage, int pageSize);

    Map<String, Object> getAnaBillStaList(String districtcode, int startPage, int pageSize);

    Map<String, Object> getAnaChildCheckStaList(String districtcode, int startPage, int pageSize);
}
