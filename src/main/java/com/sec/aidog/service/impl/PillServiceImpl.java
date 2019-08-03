package com.sec.aidog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sec.aidog.dao.PillMapper;
import com.sec.aidog.pojo.Pill;
import com.sec.aidog.service.PillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("pillService")
public class PillServiceImpl implements PillService{

    @Autowired
    private PillMapper pillMapper;

    @Override
    public Map<String, Object> getPillList(String districtcode, int startPage, int pageSize) {
        Page page = PageHelper.startPage(startPage, pageSize);
        List<Pill> pilllist = pillMapper.getPillListByDistrictcode(districtcode);
        Map<String, Object> map = new HashMap<String,Object>();
        //每页信息
        map.put("data", pilllist);
        //管理员总数
        map.put("totalNum", page.getTotal());
        return map;
    }
}
