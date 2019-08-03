package com.sec.aidog.service.impl;

import com.sec.aidog.dao.GuestInfoDao;
import com.sec.aidog.pojo.Guestinfo;
import com.sec.aidog.service.GuestService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("guestService")
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestInfoDao guestInfoDao;


    @Override
    public List<Map<String, Object>> GetNeckletDogNear(double lng, double lat) throws Exception {
        // TODO Auto-generated method stub
        //double lngtemp = 0.15 / Math.Cos(lat * Math.PI / 180);

        double radius = 8; // 半径，单位km
        double degree = radius / 111;

        double lngtemp = degree / Math.cos(lat * 0.01745);

        List<Guestinfo> allneckletdog = guestInfoDao.getGuestNeckletInfo();
        List<Guestinfo> validneckletinfo = new ArrayList<Guestinfo>();
        for (Guestinfo m : allneckletdog) {
            if (Math.abs(m.lng - lng) <= degree && Math.abs(m.lat - lat) <= lngtemp) {
                validneckletinfo.add(m);
            }
        }

        List<Map<String, Object>> neckletlist = new ArrayList<Map<String, Object>>();
        if (!validneckletinfo.isEmpty()) {
            Map<String, Object> maptemp = null;
            JSONObject object = null;
            for (Guestinfo n : validneckletinfo) {
                maptemp = new HashMap<String, Object>();
                maptemp.put("dogid", n.getDogid());
                maptemp.put("lng", n.getLng());
                maptemp.put("lat", n.getLat());
                maptemp.put("neckletid", n.getNeckletid());
                maptemp.put("managerphone", n.getManagerphone());
                maptemp.put("managername", n.getManagername());
                maptemp.put("ownername", n.getOwnername());
                maptemp.put("ownerphone", n.getOwnerphone());
                maptemp.put("healthy", n.getDevicehealthy());
                neckletlist.add(maptemp);
            }
            return neckletlist;
        }
        return neckletlist;
    }


    @Override
    public List<Map<String, Object>> GetFeederDogNear(double lng, double lat) throws Exception {
        // TODO Auto-generated method stub
        //double lngtemp = 0.15 / Math.Cos(lat * Math.PI / 180);

        double radius = 5; // 半径，单位km
        double degree = radius / 111;
        double lngtemp = degree / Math.cos(lat * 0.01745);

        List<Guestinfo> allfeederdog = guestInfoDao.getGuestFeederInfo();
        List<Guestinfo> validfeederinfo = new ArrayList<Guestinfo>();
        for (Guestinfo m : allfeederdog) {
            if (Math.abs(m.lng - lng) <= degree && Math.abs(m.lat - lat) <= lngtemp) {
                validfeederinfo.add(m);
            }
        }

        List<Map<String, Object>> feederlist = new ArrayList<Map<String, Object>>();
        if (!validfeederinfo.isEmpty()) {
            Map<String, Object> maptemp = null;
            JSONObject object = null;
            for (Guestinfo n : validfeederinfo) {
                maptemp = new HashMap<String, Object>();
                maptemp.put("dogid", n.getDogid());
                maptemp.put("lng", n.getLng());
                maptemp.put("lat", n.getLat());
                maptemp.put("neckletid", n.getNeckletid());
                maptemp.put("managerphone", n.getManagerphone());
                maptemp.put("managername", n.getManagername());
                maptemp.put("ownername", n.getOwnername());
                maptemp.put("ownerphone", n.getOwnerphone());
                maptemp.put("healthy", n.getDevicehealthy());
                feederlist.add(maptemp);
            }
            return feederlist;
        }
        return feederlist;
    }
}
