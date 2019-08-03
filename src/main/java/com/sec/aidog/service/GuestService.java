package com.sec.aidog.service;

import java.util.List;
import java.util.Map;

public interface GuestService {

    List<Map<String,Object>> GetNeckletDogNear(double lng, double lat) throws Exception;

    List<Map<String,Object>> GetFeederDogNear(double lng, double lat) throws Exception;
}
