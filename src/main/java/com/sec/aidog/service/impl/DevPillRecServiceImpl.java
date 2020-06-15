package com.sec.aidog.service.impl;

import com.sec.aidog.dao.DevPillRecMapper;
import com.sec.aidog.pojo.DevPillRecView;
import com.sec.aidog.service.DevPillRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevPillRecServiceImpl implements DevPillRecService {
    @Autowired
    private  DevPillRecMapper devPillRecMapper;

    @Override
    public List<DevPillRecView> GetPillBindRecList(String mid) {
        return devPillRecMapper.selectBindRecViewLayMid(mid);
    }
}
