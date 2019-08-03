package com.sec.aidog.service;

import com.sec.aidog.pojo.Dogowner;

import java.util.Map;

public interface OwnerService {

    Dogowner addOwner(String ownername, String owneridentity, String ownersex,String ownerhamletcode, int ownerage, String ownerjob, String homeaddress, String telphone) throws Exception;

    Map<String, Object> getHamletOwnersList(String hamletcode);

    Map<String,Object> checkOwner(String ownername, String owneridentity,String ownerhamletcode, String telphone);
}
