package com.sec.aidog.service;

import java.util.Date;
import java.util.Map;

public interface ManureService {

    Map<String, Object> getManureList(String districtcode, int startPage, int pageSize);

    boolean addManure(String dogmanure_code, Integer dogowner_id, Integer dog_id,String collection_person,String districtcode,Date date,String managetype);

    boolean modifyManure(Integer manureid, String testmethod, Date testdate, String testresult,String testperson);
}
