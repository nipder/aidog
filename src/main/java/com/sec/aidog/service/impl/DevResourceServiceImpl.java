package com.sec.aidog.service.impl;

import com.sec.aidog.dao.DevResourceMapper;
import com.sec.aidog.pojo.DevResource;
import com.sec.aidog.service.DevResourceService;
import com.sec.aidog.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DevResourceServiceImpl implements DevResourceService {
    @Autowired
    private DevResourceMapper devResourceMapper;

    @Override
    public int addResourceForUpload(String id, Integer num, String ccid, String sFilePath, String fileUrl, String extentionName, String resName) {
        int rtn = 0;

        DevResource rec = new DevResource();

        DevResource lastrec = devResourceMapper.selectLastResByMid(id);
        if(lastrec != null && lastrec.getNum() == num) {
            rec.setPath(sFilePath);
            rec.setUrl(fileUrl);
            rec.setUpdatetime(new Date());
            rtn = devResourceMapper.updateByPrimaryKey(rec);
        }else {
            rec.setId(IdUtil.generateRandomId("RES"));
            rec.setMid(id);
            rec.setNum(num);
            rec.setExtension(extentionName);
            rec.setName(resName);
            rec.setCcid(ccid);
            rec.setPath(sFilePath);
            rec.setUrl(fileUrl);
            rec.setCreatetime(new Date());
            rtn = devResourceMapper.insert(rec);
        }
        return rtn;
    }

    @Override
    public List<DevResource> getDevVideoResList(String mid) {
        List<DevResource> list = null;
        list = devResourceMapper.selectDevResByMid(mid);
        return list;
    }
}
