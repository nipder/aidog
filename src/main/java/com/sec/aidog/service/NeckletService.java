package com.sec.aidog.service;

import com.sec.aidog.pojo.Necklet;
import com.sec.aidog.pojo.VolTemp;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface NeckletService {

    boolean batchNecRegister(List<Necklet> neclist);

    boolean singleNecRegister(Necklet necklet);

    boolean bindNecklet(String necid, Integer dogid);

    Map<String, Object> getHamletOwnerNecList(String hamletcode,Integer ownerid);

    Map<String, Object> getNeckletList(String districtcode, int startPage, int pageSize);

    Map<String,Object> getNeckletLngLat(String districtcode, Date begintime, Date endtime,String necid);

    Map<String, Object> getCommonNeckletList(String districtcode);

    List<VolTemp> getNeckletVolAndTempVoltemplist(String districtcode, Date begintime, Date endtime, String necid);

    Map<String,Object> getNeckletVolAndTemp(String districtcode, Date begintime, Date endtime,String necid);

    Map<String,Object> getNeckletTemp(String districtcode, Date begintime, Date endtime,String necid);
}
