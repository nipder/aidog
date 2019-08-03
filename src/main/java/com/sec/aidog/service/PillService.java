package com.sec.aidog.service;

import java.util.Map;

public interface PillService {

    Map<String, Object> getPillList(String districtcode, int startPage, int pageSize);
}
