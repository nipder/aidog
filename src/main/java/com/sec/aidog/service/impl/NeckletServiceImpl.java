package com.sec.aidog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sec.aidog.dao.*;
import com.sec.aidog.pojo.*;
import com.sec.aidog.service.NeckletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

@Service
public class NeckletServiceImpl implements NeckletService{

    @Autowired
    private NeckletMapper neckletMapper;

    @Autowired
    private DogMapper dogMapper;

    @Autowired
    private NecconfigMapper necconfigMapper;

    @Autowired
    private LastnecdosingMapper lastnecdosingMapper;

    @Autowired
    private LastnecareabackMapper lastnecareabackMapper;

    @Autowired
    private GuestInfoDao guestInfoDao;

    @Autowired
    private NecareabackMapper necareabackMapper;

    @Override
    public boolean batchNecRegister(List<Necklet> neclist) {
        boolean isSuccess = neckletMapper.insertBatchNecRegister(neclist)>0?true:false;
        return isSuccess;
    }

    @Override
    public boolean singleNecRegister(Necklet necklet) {
        boolean isSuccess = neckletMapper.insert(necklet)>0?true:false;
        return isSuccess;
    }


    @Override
    @Transactional
    public boolean bindNecklet(String necid, Integer dogid) {
        try{
            Dog dog = dogMapper.selectByPrimaryKey(dogid);
            Necklet necklet = neckletMapper.selectByNecId(necid);
            if(dog != null && necklet!= null){
                dog.setNecId(necid);
                boolean flag1 = dogMapper.updateByPrimaryKey(dog)!=0?true:false;
                necklet.setBindTime(new Date());
                necklet.setDistrictcode(dog.getDistrictcode());
                boolean flag2 = neckletMapper.updateByPrimaryKey(necklet)!=0?true:false;
                Necconfig necconfig = new Necconfig();
                necconfig.setNecId(necid);
                necconfig.setUpdatetime(new Date());
                boolean flag3 = necconfigMapper.insert(necconfig)!=0?true:false;
                Lastnecdosing lastnecdosing = new Lastnecdosing();
                lastnecdosing.setNecId(necid);
                lastnecdosing.setRealtime(new Date());
                lastnecdosing.setDistrictcode(dog.getDistrictcode());
                boolean flag4 = lastnecdosingMapper.insert(lastnecdosing)!=0?true:false;
                Lastnecareaback lastnecareaback = new Lastnecareaback();
                lastnecareaback.setNecId(necid);
                lastnecareaback.setRealtime(new Date());
                boolean flag5 = lastnecareabackMapper.insert(lastnecareaback)!=0?true:false;

                if(flag1 && flag2 && flag3 && flag4){
                    return true;
                }else{
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return false;
                }
            }else{
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }


    @Override
    public Map<String, Object> getHamletOwnerNecList(String hamletcode,Integer ownerid) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Dog> neckletList = dogMapper.getUseNecListByHamletcode(hamletcode,ownerid);
        int i=0;
        for (Dog item:neckletList)
        {
            Map<String, Object> maptemp = new HashMap<String, Object>();
            String type = "项圈管理";
            maptemp.put("managetype",type);
            maptemp.put("nec", item.getNecId());
            maptemp.put("id", item.getDogId());
            map.put(""+i, maptemp);
            i++;
        }
//        List<Dog> appList = dogMapper.getUseAppListByHamletcode(hamletcode,ownerid);

        return map;
    }

//    @Override
//    public Map<String, Object> getNeckletList(String districtcode, int startPage, int pageSize) {
//        Page page = PageHelper.startPage(startPage, pageSize);
//        List<NeckletView> neckletViewList = new ArrayList<>();
//        List<SysLaytime> SysLaytimelist = neckletMapper.selectViewLayTime(districtcode);
//        List<SysDeviceconf> sysDeviceconflist = neckletMapper.selectViewDeviceconf(districtcode);
//        List<SysLayconfig> sysLayconfiglist = neckletMapper.selectViewLayconfig(districtcode);
//
//        NeckletView neckletView = null;
//        for(int i=0;i<sysDeviceconflist.size();i++){
//            neckletView = new NeckletView();
//            neckletView.setNecId(SysLaytimelist.get(i).getMid());
//            neckletView.setPower(SysLaytimelist.get(i).getVoltage()==null?"未反馈":SysLaytimelist.get(i).getVoltage()+"");
//            neckletView.setTemperature(SysLaytimelist.get(i).getTemperature()==null?"未反馈":SysLaytimelist.get(i).getTemperature()+"");
//            neckletView.setPillcode("PL2306");
//            String devicestatus = changestatus(sysDeviceconflist.get(i).getStatus());   //投药状态加轮询状态
//            String dosingstatus = devicestatus.substring(0,12);
//            neckletView.setDosingstatus(dosingstatus.substring(0,4)+"-"+dosingstatus.substring(4,8)+"-"+dosingstatus.substring(8,12));
//            neckletView.setConfstatus("正常");
//            if(sysDeviceconflist.get(i).getUimodifyflag().equals(Byte.valueOf("1")) && sysDeviceconflist.get(i).getHardmodifyflag().equals(Byte.valueOf("0"))){
//                neckletView.setConfstatus("硬件接收信息中");
//            }else if(sysDeviceconflist.get(i).getUimodifyflag().equals(Byte.valueOf("0")) && sysDeviceconflist.get(i).getHardmodifyflag().equals(Byte.valueOf("0"))){
//                neckletView.setConfstatus("硬件已完成配置");
//            }
//            int countnum = 12;
//            for(int j = 11;j >=0;j--){
//                if(dosingstatus.charAt(j) == '0'){
//                    countnum--;
//                }else{
//                    break;
//                }
//            }
//            //同时设置最后一次投药表
//            Lastnecdosing lastnecdosing = lastnecdosingMapper.getLastnecdosing(SysLaytimelist.get(i).getMid());
//            switch(countnum){
//                case 12:
//                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getTwelve());
//                    neckletView.setNextDosingTime(null);
//                    neckletView.setLeftnum(0);
//
//                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getTwelve());
//                    lastnecdosing.setNextdosingTime(null);
//                    lastnecdosing.setLeftNum(0);
//                    lastnecdosing.setPower(neckletView.getPower());
//                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 11:
//                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getEleven());
//                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getTwelve());
//                    neckletView.setLeftnum(1);
//
//                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getEleven());
//                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getTwelve());
//                    lastnecdosing.setLeftNum(1);
//                    lastnecdosing.setPower(neckletView.getPower());
//                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 10:
//                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getTen());
//                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getEleven());
//                    neckletView.setLeftnum(2);
//
//                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getTen());
//                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getEleven());
//                    lastnecdosing.setLeftNum(2);
//                    lastnecdosing.setPower(neckletView.getPower());
//                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 9:
//                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getNine());
//                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getTen());
//                    neckletView.setLeftnum(3);
//
//                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getNine());
//                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getTen());
//                    lastnecdosing.setLeftNum(3);
//                    lastnecdosing.setPower(neckletView.getPower());
//                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 8:
//                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getEight());
//                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getNine());
//                    neckletView.setLeftnum(4);
//
//                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getEight());
//                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getNine());
//                    lastnecdosing.setLeftNum(4);
//                    lastnecdosing.setPower(neckletView.getPower());
//                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 7:
//                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getSeven());
//                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getEight());
//                    neckletView.setLeftnum(5);
//
//                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getSeven());
//                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getEight());
//                    lastnecdosing.setLeftNum(5);
//                    lastnecdosing.setPower(neckletView.getPower());
//                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 6:
//                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getSix());
//                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getSeven());
//                    neckletView.setLeftnum(6);
//
//                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getSix());
//                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getSeven());
//                    lastnecdosing.setLeftNum(6);
//                    lastnecdosing.setPower(neckletView.getPower());
//                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 5:
//                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getFive());
//                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getSix());
//                    neckletView.setLeftnum(7);
//
//                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getFive());
//                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getSix());
//                    lastnecdosing.setLeftNum(7);
//                    lastnecdosing.setPower(neckletView.getPower());
//                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 4:
//                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getFour());
//                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getFive());
//                    neckletView.setLeftnum(8);
//
//                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getFour());
//                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getFive());
//                    lastnecdosing.setLeftNum(8);
//                    lastnecdosing.setPower(neckletView.getPower());
//                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 3:
//                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getThree());
//                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getFour());
//                    neckletView.setLeftnum(9);
//
//                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getThree());
//                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getFour());
//                    lastnecdosing.setLeftNum(9);
//                    lastnecdosing.setPower(neckletView.getPower());
//                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 2:
//                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getTwo());
//                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getThree());
//                    neckletView.setLeftnum(10);
//
//                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getTwo());
//                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getThree());
//                    lastnecdosing.setLeftNum(10);
//                    lastnecdosing.setPower(neckletView.getPower());
//                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 1:
//                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getOne());
//                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getTwo());
//                    neckletView.setLeftnum(11);
//
//                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getOne());
//                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getTwo());
//                    lastnecdosing.setLeftNum(11);
//                    lastnecdosing.setPower(neckletView.getPower());
//                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 0:
//                    neckletView.setFirstDosingTime(null);
//                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getOne());
//                    neckletView.setLeftnum(12);
//
//                    lastnecdosing.setLastdosingTime(null);
//                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getOne());
//                    lastnecdosing.setLeftNum(12);
//                    lastnecdosing.setPower(neckletView.getPower());
//                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//            }
//            neckletViewList.add(neckletView);
//            lastnecdosingMapper.updateByPrimaryKey(lastnecdosing);
//
//        }
//        Map<String, Object> map = new HashMap<String,Object>();
//        //每页信息
//        map.put("data", neckletViewList);
//        //管理员总数
//        map.put("totalNum", page.getTotal());
//        return map;
//    }

    @Override
    public Map<String, Object> getNeckletList(String districtcode, int startPage, int pageSize) {
        Page page = PageHelper.startPage(startPage, pageSize);
        Map<String, Object> map = getCommonNeckletList(districtcode);
        //管理员总数
        map.put("totalNum", page.getTotal());
        return map;
    }

    @Override
    public Map<String, Object> getNeckletLngLat(String districtcode, Date begintime, Date endtime, String necid) {
        Map<String, Object> map = new HashMap<String,Object>();
        List<LngLat> lnglatlist = new ArrayList<>();

        if(necid == null || necid.trim().equals("")){
            lnglatlist = necareabackMapper.selectLngLatByDistrictcode(districtcode,begintime,endtime);
        }else{
            if(necid.contains("|")){
                String[] necarr = necid.split("\\|");
                List<LngLat> lnglatlisttemp;
                for(int i=0;i<necarr.length;i++){
                    lnglatlisttemp = new ArrayList<>();
                    lnglatlisttemp = necareabackMapper.selectLngLatByNecId(necarr[i],begintime,endtime);
                    lnglatlist.addAll(lnglatlisttemp);
                }
            }else{
                lnglatlist = necareabackMapper.selectLngLatByNecId(necid,begintime,endtime);
            }
        }
//        List<String> lnglatli = new ArrayList<>();
//        for (LngLat lnglat:lnglatlist) {
//            lnglatli.add("\'center\':\'"+lnglat.getLng()+","+lnglat.getLat()+"\'");
//        }
        map.put("lnglatlist", lnglatlist);
        return map;
    }

    @Override
    public Map<String, Object> getNeckletVolAndTemp(String districtcode, Date begintime, Date endtime, String necid) {
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("voltemplist", getNeckletVolAndTempVoltemplist(districtcode,begintime,endtime,necid));
        return map;
    }

    @Override
    public List<VolTemp> getNeckletVolAndTempVoltemplist(String districtcode, Date begintime, Date endtime, String necid) {
        List<VolTemp> voltemplist = new ArrayList<>();

        if(necid == null || necid.trim().equals("")){
            voltemplist = necareabackMapper.selectVolTempByDistrictcode(districtcode,begintime,endtime);
        }else{
            if(necid.contains("|")){
                String[] necarr = necid.split("\\|");
                List<VolTemp> voltemplisttemp;
                for(int i=0;i<necarr.length;i++){
                    voltemplisttemp = new ArrayList<>();
                    voltemplisttemp = necareabackMapper.selectVolTempByNecId(necarr[i],begintime,endtime);
                    voltemplist.addAll(voltemplisttemp);
                }
            }else{
                voltemplist = necareabackMapper.selectVolTempByNecId(necid,begintime,endtime);
            }
        }
        return voltemplist;
    }

    @Override
    public Map<String, Object> getNeckletTemp(String districtcode, Date begintime, Date endtime, String necid) {
        Map<String, Object> map = new HashMap<String,Object>();
        List<LngLat> lnglatlist = new ArrayList<>();

        if(necid == null || necid.trim().equals("")){
            lnglatlist = necareabackMapper.selectLngLatByDistrictcode(districtcode,begintime,endtime);
        }else{
            if(necid.contains("|")){
                String[] necarr = necid.split("\\|");
                List<LngLat> lnglatlisttemp;
                for(int i=0;i<necarr.length;i++){
                    lnglatlisttemp = new ArrayList<>();
                    lnglatlisttemp = necareabackMapper.selectLngLatByNecId(necarr[i],begintime,endtime);
                    lnglatlist.addAll(lnglatlisttemp);
                }
            }else{
                lnglatlist = necareabackMapper.selectLngLatByNecId(necid,begintime,endtime);
            }
        }
//        List<String> lnglatli = new ArrayList<>();
//        for (LngLat lnglat:lnglatlist) {
//            lnglatli.add("\'center\':\'"+lnglat.getLng()+","+lnglat.getLat()+"\'");
//        }
        map.put("lnglatlist", lnglatlist);
        return map;
    }

    @Override
    public Map<String, Object> getCommonNeckletList(String districtcode) {
        List<NeckletView> neckletViewList = new ArrayList<>();
        List<SysLaytime> SysLaytimelist = neckletMapper.selectViewLayTime(districtcode);
        List<SysDeviceconf> sysDeviceconflist = neckletMapper.selectViewDeviceconf(districtcode);
        List<SysLayconfig> sysLayconfiglist = neckletMapper.selectViewLayconfig(districtcode);

        NeckletView neckletView = null;
        for(int i=0;i<sysDeviceconflist.size();i++){
            neckletView = new NeckletView();
            neckletView.setNecId(SysLaytimelist.get(i).getMid());

            neckletView.setDistrictcode(neckletMapper.selectByNecId(SysLaytimelist.get(i).getMid()).getDistrictcode());

            neckletView.setPower(SysLaytimelist.get(i).getVoltage()==null?"未反馈":SysLaytimelist.get(i).getVoltage()+"");
            neckletView.setTemperature(SysLaytimelist.get(i).getTemperature()==null?"未反馈":SysLaytimelist.get(i).getTemperature()+"");
            neckletView.setPillcode("ER190901");
            String devicestatus = changestatus(sysDeviceconflist.get(i).getStatus());   //投药状态加轮询状态
            String dosingstatus = devicestatus.substring(0,12);
            neckletView.setDosingstatus(dosingstatus.substring(0,4)+"-"+dosingstatus.substring(4,8)+"-"+dosingstatus.substring(8,12));
            neckletView.setConfstatus("正常");
            if(sysDeviceconflist.get(i).getUimodifyflag().equals(Byte.valueOf("1")) && sysDeviceconflist.get(i).getHardmodifyflag().equals(Byte.valueOf("0"))){
                neckletView.setConfstatus("硬件接收配置中");
                if(!SysLaytimelist.get(i).getErr().equals("0")){
                    for (String key : ErrType.errmap.keySet()) {
                        //map.keySet()返回的是所有key的值
                        if(key.equals(SysLaytimelist.get(i).getErr())){
                            neckletView.setConfstatus(ErrType.errmap.get(key));
                        }
                    }
                }
            }else if(sysDeviceconflist.get(i).getUimodifyflag().equals(Byte.valueOf("0")) && sysDeviceconflist.get(i).getHardmodifyflag().equals(Byte.valueOf("0"))){
                neckletView.setConfstatus("硬件已完成配置");
                if(!SysLaytimelist.get(i).getErr().equals("0")){
                    for (String key : ErrType.errmap.keySet()) {
                        //map.keySet()返回的是所有key的值
                        if(key.equals(SysLaytimelist.get(i).getErr())){
                            neckletView.setConfstatus(ErrType.errmap.get(key));
                        }
                    }
                }
            }
            neckletView.setLastUpdateTime(SysLaytimelist.get(i).getUpdatetime());

            int countnum = 12;
            for(int j = 11;j >=0;j--){
                if(dosingstatus.charAt(j) == '0'){
                    countnum--;
                }else{
                    break;
                }
            }
            //同时设置最后一次投药表
            Lastnecdosing lastnecdosing = lastnecdosingMapper.getLastnecdosing(SysLaytimelist.get(i).getMid());
            switch(countnum){
                case 12:
                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getTwelve());
                    neckletView.setNextDosingTime(null);
                    neckletView.setLeftnum(0);

                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getTwelve());
                    lastnecdosing.setNextdosingTime(null);
                    lastnecdosing.setLeftNum(0);
                    lastnecdosing.setPower(neckletView.getPower());
                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                    //最近一次投药时间
                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                    break;
                case 11:
                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getEleven());
                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getTwelve());
                    neckletView.setLeftnum(1);

                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getEleven());
                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getTwelve());
                    lastnecdosing.setLeftNum(1);
                    lastnecdosing.setPower(neckletView.getPower());
                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                    //最近一次投药时间
                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                    break;
                case 10:
                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getTen());
                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getEleven());
                    neckletView.setLeftnum(2);

                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getTen());
                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getEleven());
                    lastnecdosing.setLeftNum(2);
                    lastnecdosing.setPower(neckletView.getPower());
                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                    //最近一次投药时间
                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                    break;
                case 9:
                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getNine());
                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getTen());
                    neckletView.setLeftnum(3);

                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getNine());
                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getTen());
                    lastnecdosing.setLeftNum(3);
                    lastnecdosing.setPower(neckletView.getPower());
                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                    //最近一次投药时间
                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                    break;
                case 8:
                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getEight());
                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getNine());
                    neckletView.setLeftnum(4);

                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getEight());
                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getNine());
                    lastnecdosing.setLeftNum(4);
                    lastnecdosing.setPower(neckletView.getPower());
                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                    //最近一次投药时间
                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                    break;
                case 7:
                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getSeven());
                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getEight());
                    neckletView.setLeftnum(5);

                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getSeven());
                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getEight());
                    lastnecdosing.setLeftNum(5);
                    lastnecdosing.setPower(neckletView.getPower());
                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                    //最近一次投药时间
                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                    break;
                case 6:
                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getSix());
                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getSeven());
                    neckletView.setLeftnum(6);

                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getSix());
                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getSeven());
                    lastnecdosing.setLeftNum(6);
                    lastnecdosing.setPower(neckletView.getPower());
                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                    //最近一次投药时间
                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                    break;
                case 5:
                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getFive());
                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getSix());
                    neckletView.setLeftnum(7);

                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getFive());
                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getSix());
                    lastnecdosing.setLeftNum(7);
                    lastnecdosing.setPower(neckletView.getPower());
                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                    //最近一次投药时间
                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                    break;
                case 4:
                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getFour());
                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getFive());
                    neckletView.setLeftnum(8);

                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getFour());
                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getFive());
                    lastnecdosing.setLeftNum(8);
                    lastnecdosing.setPower(neckletView.getPower());
                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                    //最近一次投药时间
                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                    break;
                case 3:
                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getThree());
                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getFour());
                    neckletView.setLeftnum(9);

                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getThree());
                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getFour());
                    lastnecdosing.setLeftNum(9);
                    lastnecdosing.setPower(neckletView.getPower());
                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                    //最近一次投药时间
                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                    break;
                case 2:
                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getTwo());
                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getThree());
                    neckletView.setLeftnum(10);

                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getTwo());
                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getThree());
                    lastnecdosing.setLeftNum(10);
                    lastnecdosing.setPower(neckletView.getPower());
                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                    //最近一次投药时间
                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                    break;
                case 1:
                    neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getOne());
                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getTwo());
                    neckletView.setLeftnum(11);

                    lastnecdosing.setLastdosingTime(sysLayconfiglist.get(i).getOne());
                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getTwo());
                    lastnecdosing.setLeftNum(11);
                    lastnecdosing.setPower(neckletView.getPower());
                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                    //最近一次投药时间
                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                    break;
                case 0:
                    neckletView.setFirstDosingTime(null);
                    neckletView.setNextDosingTime(sysLayconfiglist.get(i).getOne());
                    neckletView.setLeftnum(12);

                    lastnecdosing.setLastdosingTime(null);
                    lastnecdosing.setNextdosingTime(sysLayconfiglist.get(i).getOne());
                    lastnecdosing.setLeftNum(12);
                    lastnecdosing.setPower(neckletView.getPower());
                    lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                    lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                    lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                    //最近一次投药时间
                    lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                    break;
            }
            neckletViewList.add(neckletView);
            lastnecdosingMapper.updateByPrimaryKey(lastnecdosing);

        }
        Map<String, Object> map = new HashMap<String,Object>();
        //每页信息
        map.put("data", neckletViewList);
        return map;
    }


    public String changestatus(Integer int_status){
        String status = Integer.toBinaryString(int_status);
        byte[] bytes = status.getBytes();
        //倒置
        for (int l = 0, h = status.length() - 1; l < h; l++, h--) {
            // Swap values at l and h
            byte temp = bytes[l];
            bytes[l] = bytes[h];
            bytes[h] = temp;
        }
        status = new String(bytes);
        while(status.length()<16){
            status = status+"0";
        }
//        status = status.substring(0,4)+"-"+status.substring(4,8)+"-"+status.substring(8,12)+"-"+status.substring(12,16);
//        System.out.println(status);
        return status;
    }

}
