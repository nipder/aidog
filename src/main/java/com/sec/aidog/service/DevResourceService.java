package com.sec.aidog.service;

import com.sec.aidog.pojo.DevResource;

import java.util.List;
import java.util.Map;

public interface DevResourceService {
    int addResourceForUpload(String id, Integer num, String ccid, String sFilePath, String fileUrl, String extentionName, String resName);
    List<DevResource> getDevVideoResList(String mid);
}
