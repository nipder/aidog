package com.sec.aidog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sec.aidog.api.Analyse;
import com.sec.aidog.dao.*;
import com.sec.aidog.pojo.*;
import com.sec.aidog.service.NeckletService;
import com.sec.aidog.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

@Service
public class NeckletServiceImpl implements NeckletService{

    @Autowired
    private SysDeviceconfMapper sysDeviceconfMapper;

    @Autowired
    private RedisService redisService;

    @Autowired
    private SysLayconfigMapper sysLayconfigMapper;

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
                necconfig.setAreacycle(4320);
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

                //设置默认周期
                Date now = new Date();
                Date firsttime = new Date(now.getTime()+300000);
                firsttime.setSeconds(0);
                Date twotime,threetime,fourtime,fivetime,sixtime,seventime,eighttime,ninetime,tentime,eleventime,twelvetime;
                Calendar cal = Calendar.getInstance();
                if(Calendar.DAY_OF_MONTH == 28 || Calendar.DAY_OF_MONTH == 29 || Calendar.DAY_OF_MONTH == 30){
                    cal.set(Calendar.DAY_OF_MONTH,28);
                    cal.add(Calendar.MONTH,1);
                    twotime = cal.getTime();
                    twotime.setHours(6);
                    twotime.setMinutes(0);
                    twotime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,28);
                    cal.add(Calendar.MONTH,1);
                    threetime = cal.getTime();
                    threetime.setHours(6);
                    threetime.setMinutes(0);
                    threetime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,28);
                    cal.add(Calendar.MONTH,1);
                    fourtime = cal.getTime();
                    fourtime.setHours(6);
                    fourtime.setMinutes(0);
                    fourtime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,28);
                    cal.add(Calendar.MONTH,1);
                    fivetime = cal.getTime();
                    fivetime.setHours(6);
                    fivetime.setMinutes(0);
                    fivetime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,28);
                    cal.add(Calendar.MONTH,1);
                    sixtime = cal.getTime();
                    sixtime.setHours(6);
                    sixtime.setMinutes(0);
                    sixtime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,28);
                    cal.add(Calendar.MONTH,1);
                    seventime = cal.getTime();
                    seventime.setHours(6);
                    seventime.setMinutes(0);
                    seventime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,28);
                    cal.add(Calendar.MONTH,1);
                    eighttime = cal.getTime();
                    eighttime.setHours(6);
                    eighttime.setMinutes(0);
                    eighttime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,28);
                    cal.add(Calendar.MONTH,1);
                    ninetime = cal.getTime();
                    ninetime.setHours(6);
                    ninetime.setMinutes(0);
                    ninetime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,28);
                    cal.add(Calendar.MONTH,1);
                    tentime = cal.getTime();
                    tentime.setHours(6);
                    tentime.setMinutes(0);
                    tentime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,28);
                    cal.add(Calendar.MONTH,1);
                    eleventime = cal.getTime();
                    eleventime.setHours(6);
                    eleventime.setMinutes(0);
                    eleventime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,28);
                    cal.add(Calendar.MONTH,1);
                    twelvetime = cal.getTime();
                    twelvetime.setHours(6);
                    twelvetime.setMinutes(0);
                    twelvetime.setSeconds(0);
                }else{
                    cal.set(Calendar.DAY_OF_MONTH,Calendar.DAY_OF_MONTH+1);
                    cal.add(Calendar.MONTH,1);
                    twotime = cal.getTime();
                    twotime.setHours(6);
                    twotime.setMinutes(0);
                    twotime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,Calendar.DAY_OF_MONTH+1);
                    cal.add(Calendar.MONTH,1);
                    threetime = cal.getTime();
                    threetime.setHours(6);
                    threetime.setMinutes(0);
                    threetime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,Calendar.DAY_OF_MONTH+1);
                    cal.add(Calendar.MONTH,1);
                    fourtime = cal.getTime();
                    fourtime.setHours(6);
                    fourtime.setMinutes(0);
                    fourtime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,Calendar.DAY_OF_MONTH+1);
                    cal.add(Calendar.MONTH,1);
                    fivetime = cal.getTime();
                    fivetime.setHours(6);
                    fivetime.setMinutes(0);
                    fivetime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,Calendar.DAY_OF_MONTH+1);
                    cal.add(Calendar.MONTH,1);
                    sixtime = cal.getTime();
                    sixtime.setHours(6);
                    sixtime.setMinutes(0);
                    sixtime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,Calendar.DAY_OF_MONTH+1);
                    cal.add(Calendar.MONTH,1);
                    seventime = cal.getTime();
                    seventime.setHours(6);
                    seventime.setMinutes(0);
                    seventime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,Calendar.DAY_OF_MONTH+1);
                    cal.add(Calendar.MONTH,1);
                    eighttime = cal.getTime();
                    eighttime.setHours(6);
                    eighttime.setMinutes(0);
                    eighttime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,Calendar.DAY_OF_MONTH+1);
                    cal.add(Calendar.MONTH,1);
                    ninetime = cal.getTime();
                    ninetime.setHours(6);
                    ninetime.setMinutes(0);
                    ninetime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,Calendar.DAY_OF_MONTH+1);
                    cal.add(Calendar.MONTH,1);
                    tentime = cal.getTime();
                    tentime.setHours(6);
                    tentime.setMinutes(0);
                    tentime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,Calendar.DAY_OF_MONTH+1);
                    cal.add(Calendar.MONTH,1);
                    eleventime = cal.getTime();
                    eleventime.setHours(6);
                    eleventime.setMinutes(0);
                    eleventime.setSeconds(0);
                    cal.set(Calendar.DAY_OF_MONTH,Calendar.DAY_OF_MONTH+1);
                    cal.add(Calendar.MONTH,1);
                    twelvetime = cal.getTime();
                    twelvetime.setHours(6);
                    twelvetime.setMinutes(0);
                    twelvetime.setSeconds(0);
                }
                boolean flag6 = false;
                SysLayconfig layconfig = sysLayconfigMapper.selectLayConfigByMid(necid);
                if(layconfig==null){
                    layconfig = new SysLayconfig();
                    layconfig.setId(0);
                    layconfig.setMid(necid);
                    layconfig.setOne(firsttime);
                    layconfig.setTwo(twotime);
                    layconfig.setThree(threetime);
                    layconfig.setFour(fourtime);
                    layconfig.setFive(fivetime);
                    layconfig.setSix(sixtime);
                    layconfig.setSeven(seventime);
                    layconfig.setEight(eighttime);
                    layconfig.setNine(ninetime);
                    layconfig.setTen(tentime);
                    layconfig.setEleven(eleventime);
                    layconfig.setTwelve(twelvetime);
                    layconfig.setUimodifyflag(Byte.valueOf("1"));
                    layconfig.setHardmodifyflag(Byte.valueOf("0"));
                    layconfig.setUpdatetime(new Date());
                    flag6 = sysLayconfigMapper.insert(layconfig)==1?true:false;
                }else{
                    layconfig.setOne(firsttime);
                    layconfig.setTwo(twotime);
                    layconfig.setThree(threetime);
                    layconfig.setFour(fourtime);
                    layconfig.setFive(fivetime);
                    layconfig.setSix(sixtime);
                    layconfig.setSeven(seventime);
                    layconfig.setEight(eighttime);
                    layconfig.setNine(ninetime);
                    layconfig.setTen(tentime);
                    layconfig.setEleven(eleventime);
                    layconfig.setTwelve(twelvetime);
                    layconfig.setUimodifyflag(Byte.valueOf("1"));
                    layconfig.setHardmodifyflag(Byte.valueOf("0"));
                    layconfig.setUpdatetime(new Date());
                    flag6 = sysLayconfigMapper.updateByPrimaryKey(layconfig)==1?true:false;
                }
                boolean flag7  = false;
                if(flag6) {
                    String command02 = Analyse.Command_02_Send(layconfig);
                    redisService.remove("time_"+necid);
                    flag7  = redisService.setpersist("time_"+necid, command02);
                }

                SysDeviceconf sysDeviceconf = sysDeviceconfMapper.selectDeviceConfigByMid(necid);
                boolean flag8 = false;
                if(sysDeviceconf!=null){
                    sysDeviceconf.setInfoupdatecycle(4320);
                    sysDeviceconf.setUimodifyflag(Byte.valueOf("1"));
                    sysDeviceconf.setHardmodifyflag(Byte.valueOf("0"));
                    sysDeviceconf.setUpdatetime(new Date());
                    sysDeviceconf.setClearerr(Byte.valueOf("1"));
                    flag8 = sysDeviceconfMapper.updateByPrimaryKey(sysDeviceconf)==1?true:false;
                }else{
                    sysDeviceconf = new SysDeviceconf();
                    sysDeviceconf.setMid(necid);
                    sysDeviceconf.setStatus(0);
                    sysDeviceconf.setInfoupdatecycle(4320);
                    sysDeviceconf.setUimodifyflag(Byte.valueOf("1"));
                    sysDeviceconf.setHardmodifyflag(Byte.valueOf("0"));
                    sysDeviceconf.setUpdatetime(new Date());
                    //默认值
                    sysDeviceconf.setIp("119.3.177.203");
                    sysDeviceconf.setPort(59999);
                    sysDeviceconf.setTickcycle(30);
                    sysDeviceconf.setFactory(Byte.valueOf("0"));
                    sysDeviceconf.setBastimes(Byte.valueOf("20"));
                    sysDeviceconf.setGpstimes(Byte.valueOf("60"));
                    sysDeviceconf.setClearerr(Byte.valueOf("1"));
                    flag8 = sysDeviceconfMapper.insert(sysDeviceconf)==1?true:false;
                }
                if(flag8) {
                    String command03 = Analyse.Command_03_Send(sysDeviceconf);
                    redisService.remove("device_"+necid);
                    redisService.setpersist("device_"+necid, command03);
                }

                if(flag1 && flag2 && flag3 && flag4 && flag7 && flag8){
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

            neckletView.setNecId(sysDeviceconflist.get(i).getMid());

            neckletView.setPillcode("ER190901");
            String devicestatus = changestatus(sysDeviceconflist.get(i).getStatus());   //投药状态加轮询状态
            String dosingstatus = devicestatus.substring(0,12);
            neckletView.setDosingstatus(dosingstatus.substring(0,4)+"-"+dosingstatus.substring(4,8)+"-"+dosingstatus.substring(8,12));
            neckletView.setConfstatus("正常");

            //统一项圈id
            SysLaytime sysLaytime = null;
            for(int j=0;j<SysLaytimelist.size();j++){
                if(SysLaytimelist.get(j).getMid().equals(sysDeviceconflist.get(i).getMid())){
                    sysLaytime = SysLaytimelist.get(j);
                    break;
                }
            }

            if(sysLaytime != null){
                neckletView.setDistrictcode(neckletMapper.selectByNecId(sysLaytime.getMid()).getDistrictcode());
                neckletView.setPower(sysLaytime.getVoltage()==null?"未反馈":sysLaytime.getVoltage()+"");
                neckletView.setTemperature(sysLaytime.getTemperature()==null?"未反馈":sysLaytime.getTemperature()+"");
                if(sysDeviceconflist.get(i).getUimodifyflag().equals(Byte.valueOf("1")) && sysDeviceconflist.get(i).getHardmodifyflag().equals(Byte.valueOf("0"))){
                    neckletView.setConfstatus("硬件接收配置中");
                    if(sysLaytime.getErr()!=null && !sysLaytime.getErr().equals("0")){
                        for (String key : ErrType.errmap.keySet()) {
                            //map.keySet()返回的是所有key的值
                            if(key.equals(sysLaytime.getErr())){
                                neckletView.setConfstatus(ErrType.errmap.get(key));
                            }
                        }
                    }
                }else if(sysDeviceconflist.get(i).getUimodifyflag().equals(Byte.valueOf("0")) && sysDeviceconflist.get(i).getHardmodifyflag().equals(Byte.valueOf("0"))){
                    neckletView.setConfstatus("硬件已完成配置");
                    if(sysLaytime.getErr() == null){
                        neckletView.setConfstatus("无数据反馈");
                    }else{
                        if(!sysLaytime.getErr().equals("0")){
                            for (String key : ErrType.errmap.keySet()) {
                                //map.keySet()返回的是所有key的值
                                if(key.equals(sysLaytime.getErr())){
                                    neckletView.setConfstatus(ErrType.errmap.get(key));
                                }
                            }
                        }
                    }
                }
                neckletView.setLastUpdateTime(sysLaytime.getUpdatetime());
            }



            for(int k=0;k<sysLayconfiglist.size();k++){
                if(sysLayconfiglist.get(k).getMid().equals(sysDeviceconflist.get(i).getMid())){

                    int countnum = 12;
                    for(int j = 11;j >=0;j--){
                        if(dosingstatus.charAt(j) == '0'){
                            countnum--;
                        }else{
                            break;
                        }
                    }

                    //同时设置最后一次投药表
                    Lastnecdosing lastnecdosing = lastnecdosingMapper.getLastnecdosing(sysDeviceconflist.get(i).getMid());

                    if(sysLaytime!=null) {
                        lastnecdosing.setLng(sysLaytime.getLongitude());
                        lastnecdosing.setLat(sysLaytime.getLatitude());
                        lastnecdosing.setTemperature(sysLaytime.getTemperature() == null ? null : sysLaytime.getTemperature() + "");
                    }

                    switch(countnum){
                        case 12:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getTwelve());
                            neckletView.setNextDosingTime(null);
                            neckletView.setLeftnum(0);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getTwelve());
                            lastnecdosing.setNextdosingTime(null);
                            lastnecdosing.setLeftNum(0);
                            lastnecdosing.setPower(neckletView.getPower());
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 11:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getEleven());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getTwelve());
                            neckletView.setLeftnum(1);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getEleven());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getTwelve());
                            lastnecdosing.setLeftNum(1);
                            lastnecdosing.setPower(neckletView.getPower());
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 10:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(i).getTen());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getEleven());
                            neckletView.setLeftnum(2);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getTen());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getEleven());
                            lastnecdosing.setLeftNum(2);
                            lastnecdosing.setPower(neckletView.getPower());
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 9:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getNine());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getTen());
                            neckletView.setLeftnum(3);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getNine());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getTen());
                            lastnecdosing.setLeftNum(3);
                            lastnecdosing.setPower(neckletView.getPower());
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 8:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getEight());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getNine());
                            neckletView.setLeftnum(4);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getEight());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getNine());
                            lastnecdosing.setLeftNum(4);
                            lastnecdosing.setPower(neckletView.getPower());
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 7:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getSeven());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getEight());
                            neckletView.setLeftnum(5);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getSeven());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getEight());
                            lastnecdosing.setLeftNum(5);
                            lastnecdosing.setPower(neckletView.getPower());
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 6:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getSix());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getSeven());
                            neckletView.setLeftnum(6);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getSix());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getSeven());
                            lastnecdosing.setLeftNum(6);
                            lastnecdosing.setPower(neckletView.getPower());
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 5:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getFive());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getSix());
                            neckletView.setLeftnum(7);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getFive());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getSix());
                            lastnecdosing.setLeftNum(7);
                            lastnecdosing.setPower(neckletView.getPower());
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 4:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getFour());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getFive());
                            neckletView.setLeftnum(8);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getFour());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getFive());
                            lastnecdosing.setLeftNum(8);
                            lastnecdosing.setPower(neckletView.getPower());
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 3:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getThree());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getFour());
                            neckletView.setLeftnum(9);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getThree());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getFour());
                            lastnecdosing.setLeftNum(9);
                            lastnecdosing.setPower(neckletView.getPower());
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 2:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getTwo());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getThree());
                            neckletView.setLeftnum(10);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getTwo());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getThree());
                            lastnecdosing.setLeftNum(10);
                            lastnecdosing.setPower(neckletView.getPower());
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 1:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getOne());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getTwo());
                            neckletView.setLeftnum(11);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getOne());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getTwo());
                            lastnecdosing.setLeftNum(11);
                            lastnecdosing.setPower(neckletView.getPower());
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 0:
                            neckletView.setFirstDosingTime(null);
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getOne());
                            neckletView.setLeftnum(12);

                            lastnecdosing.setLastdosingTime(null);
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getOne());
                            lastnecdosing.setLeftNum(12);
                            lastnecdosing.setPower(neckletView.getPower());
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                    }
                    lastnecdosingMapper.updateByPrimaryKey(lastnecdosing);
                }
            }
            neckletViewList.add(neckletView);
        }
        Map<String, Object> map = new HashMap<String,Object>();
        //每页信息
        map.put("data", neckletViewList);
        return map;
    }
    /*public Map<String, Object> getCommonNeckletList(String districtcode) {
        List<NeckletView> neckletViewList = new ArrayList<>();
        List<SysLaytime> SysLaytimelist = neckletMapper.selectViewLayTime(districtcode);
        List<SysDeviceconf> sysDeviceconflist = neckletMapper.selectViewDeviceconf(districtcode);
        List<SysLayconfig> sysLayconfiglist = neckletMapper.selectViewLayconfig(districtcode);

        NeckletView neckletView = null;
        for(int i=0;i<sysDeviceconflist.size();i++){
//            if(sysDeviceconflist.get(i).getMid().equals("1909010481")){
//                System.out.println("aa");
//            }
            neckletView = new NeckletView();
            //neckletView.setNecId(SysLaytimelist.get(i).getMid());
            neckletView.setNecId(sysDeviceconflist.get(i).getMid());


            neckletView.setPillcode("ER190901");
            String devicestatus = changestatus(sysDeviceconflist.get(i).getStatus());   //投药状态加轮询状态
            String dosingstatus = devicestatus.substring(0,12);
            neckletView.setDosingstatus(dosingstatus.substring(0,4)+"-"+dosingstatus.substring(4,8)+"-"+dosingstatus.substring(8,12));
            neckletView.setConfstatus("正常");

            //统一项圈id
            for(int j=0;j<SysLaytimelist.size();j++){
                if(SysLaytimelist.get(j).getMid().equals(sysDeviceconflist.get(i).getMid())){
                    neckletView.setDistrictcode(neckletMapper.selectByNecId(SysLaytimelist.get(i).getMid()).getDistrictcode());
                    neckletView.setPower(SysLaytimelist.get(i).getVoltage()==null?"未反馈":SysLaytimelist.get(i).getVoltage()+"");
                    neckletView.setTemperature(SysLaytimelist.get(i).getTemperature()==null?"未反馈":SysLaytimelist.get(i).getTemperature()+"");
                    if(sysDeviceconflist.get(i).getUimodifyflag().equals(Byte.valueOf("1")) && sysDeviceconflist.get(i).getHardmodifyflag().equals(Byte.valueOf("0"))){
                        neckletView.setConfstatus("硬件接收配置中");
                        if(SysLaytimelist.get(j).getErr()!=null && !SysLaytimelist.get(j).getErr().equals("0")){
                            for (String key : ErrType.errmap.keySet()) {
                                //map.keySet()返回的是所有key的值
                                if(key.equals(SysLaytimelist.get(i).getErr())){
                                    neckletView.setConfstatus(ErrType.errmap.get(key));
                                }
                            }
                        }
                    }else if(sysDeviceconflist.get(i).getUimodifyflag().equals(Byte.valueOf("0")) && sysDeviceconflist.get(i).getHardmodifyflag().equals(Byte.valueOf("0"))){
                        neckletView.setConfstatus("硬件已完成配置");
                        if(SysLaytimelist.get(j).getErr() == null){
                            neckletView.setConfstatus("无数据反馈");
                        }else{
                            if(!SysLaytimelist.get(j).getErr().equals("0")){
                                for (String key : ErrType.errmap.keySet()) {
                                    //map.keySet()返回的是所有key的值
                                    if(key.equals(SysLaytimelist.get(j).getErr())){
                                        neckletView.setConfstatus(ErrType.errmap.get(key));
                                    }
                                }
                            }
                        }
                    }
                    neckletView.setLastUpdateTime(SysLaytimelist.get(j).getUpdatetime());
                }
            }
            for(int k=0;k<sysLayconfiglist.size();k++){
                if(sysLayconfiglist.get(k).getMid().equals(sysDeviceconflist.get(i).getMid())){

                    int countnum = 12;
                    for(int j = 11;j >=0;j--){
                        if(dosingstatus.charAt(j) == '0'){
                            countnum--;
                        }else{
                            break;
                        }
                    }

                    //同时设置最后一次投药表
                    Lastnecdosing lastnecdosing = lastnecdosingMapper.getLastnecdosing(sysDeviceconflist.get(i).getMid());
//            Lastnecdosing lastnecdosing = lastnecdosingMapper.getLastnecdosing(SysLaytimelist.get(i).getMid());
                    switch(countnum){
                        case 12:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getTwelve());
                            neckletView.setNextDosingTime(null);
                            neckletView.setLeftnum(0);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getTwelve());
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
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getEleven());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getTwelve());
                            neckletView.setLeftnum(1);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getEleven());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getTwelve());
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
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getEleven());
                            neckletView.setLeftnum(2);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getTen());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getEleven());
                            lastnecdosing.setLeftNum(2);
                            lastnecdosing.setPower(neckletView.getPower());
                            lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 9:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getNine());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getTen());
                            neckletView.setLeftnum(3);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getNine());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getTen());
                            lastnecdosing.setLeftNum(3);
                            lastnecdosing.setPower(neckletView.getPower());
                            lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 8:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getEight());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getNine());
                            neckletView.setLeftnum(4);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getEight());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getNine());
                            lastnecdosing.setLeftNum(4);
                            lastnecdosing.setPower(neckletView.getPower());
                            lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 7:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getSeven());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getEight());
                            neckletView.setLeftnum(5);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getSeven());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getEight());
                            lastnecdosing.setLeftNum(5);
                            lastnecdosing.setPower(neckletView.getPower());
                            lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 6:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getSix());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getSeven());
                            neckletView.setLeftnum(6);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getSix());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getSeven());
                            lastnecdosing.setLeftNum(6);
                            lastnecdosing.setPower(neckletView.getPower());
                            lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 5:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getFive());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getSix());
                            neckletView.setLeftnum(7);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getFive());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getSix());
                            lastnecdosing.setLeftNum(7);
                            lastnecdosing.setPower(neckletView.getPower());
                            lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 4:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getFour());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getFive());
                            neckletView.setLeftnum(8);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getFour());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getFive());
                            lastnecdosing.setLeftNum(8);
                            lastnecdosing.setPower(neckletView.getPower());
                            lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 3:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getThree());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getFour());
                            neckletView.setLeftnum(9);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getThree());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getFour());
                            lastnecdosing.setLeftNum(9);
                            lastnecdosing.setPower(neckletView.getPower());
                            lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 2:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getTwo());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getThree());
                            neckletView.setLeftnum(10);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getTwo());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getThree());
                            lastnecdosing.setLeftNum(10);
                            lastnecdosing.setPower(neckletView.getPower());
                            lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 1:
                            neckletView.setFirstDosingTime(sysLayconfiglist.get(k).getOne());
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getTwo());
                            neckletView.setLeftnum(11);

                            lastnecdosing.setLastdosingTime(sysLayconfiglist.get(k).getOne());
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getTwo());
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
                            neckletView.setNextDosingTime(sysLayconfiglist.get(k).getOne());
                            neckletView.setLeftnum(12);

                            lastnecdosing.setLastdosingTime(null);
                            lastnecdosing.setNextdosingTime(sysLayconfiglist.get(k).getOne());
                            lastnecdosing.setLeftNum(12);
                            lastnecdosing.setPower(neckletView.getPower());
                            lastnecdosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastnecdosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastnecdosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastnecdosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                    }
                    lastnecdosingMapper.updateByPrimaryKey(lastnecdosing);
                }
            }
            neckletViewList.add(neckletView);

//            neckletView.setDistrictcode(neckletMapper.selectByNecId(SysLaytimelist.get(i).getMid()).getDistrictcode());
//            neckletView.setPower(SysLaytimelist.get(i).getVoltage()==null?"未反馈":SysLaytimelist.get(i).getVoltage()+"");
//            neckletView.setTemperature(SysLaytimelist.get(i).getTemperature()==null?"未反馈":SysLaytimelist.get(i).getTemperature()+"");
//            neckletView.setPillcode("ER190901");
//            String devicestatus = changestatus(sysDeviceconflist.get(i).getStatus());   //投药状态加轮询状态
//            String dosingstatus = devicestatus.substring(0,12);
//            neckletView.setDosingstatus(dosingstatus.substring(0,4)+"-"+dosingstatus.substring(4,8)+"-"+dosingstatus.substring(8,12));
//            neckletView.setConfstatus("正常");
//            if(sysDeviceconflist.get(i).getUimodifyflag().equals(Byte.valueOf("1")) && sysDeviceconflist.get(i).getHardmodifyflag().equals(Byte.valueOf("0"))){
//                neckletView.setConfstatus("硬件接收配置中");
//                if(SysLaytimelist.get(i).getErr()!=null && !SysLaytimelist.get(i).getErr().equals("0")){
//                    for (String key : ErrType.errmap.keySet()) {
//                        //map.keySet()返回的是所有key的值
//                        if(key.equals(SysLaytimelist.get(i).getErr())){
//                            neckletView.setConfstatus(ErrType.errmap.get(key));
//                        }
//                    }
//                }
//            }else if(sysDeviceconflist.get(i).getUimodifyflag().equals(Byte.valueOf("0")) && sysDeviceconflist.get(i).getHardmodifyflag().equals(Byte.valueOf("0"))){
//                neckletView.setConfstatus("硬件已完成配置");
//                if(SysLaytimelist.get(i).getErr() == null){
//                    neckletView.setConfstatus("无数据反馈");
//                }else{
//                    if(!SysLaytimelist.get(i).getErr().equals("0")){
//                        for (String key : ErrType.errmap.keySet()) {
//                            //map.keySet()返回的是所有key的值
//                            if(key.equals(SysLaytimelist.get(i).getErr())){
//                                neckletView.setConfstatus(ErrType.errmap.get(key));
//                            }
//                        }
//                    }
//                }
//            }
//            neckletView.setLastUpdateTime(SysLaytimelist.get(i).getUpdatetime());

//            int countnum = 12;
//            for(int j = 11;j >=0;j--){
//                if(dosingstatus.charAt(j) == '0'){
//                    countnum--;
//                }else{
//                    break;
//                }
//            }
//            //同时设置最后一次投药表
//            Lastnecdosing lastnecdosing = lastnecdosingMapper.getLastnecdosing(sysDeviceconflist.get(i).getMid());
////            Lastnecdosing lastnecdosing = lastnecdosingMapper.getLastnecdosing(SysLaytimelist.get(i).getMid());
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

        }
        Map<String, Object> map = new HashMap<String,Object>();
        //每页信息
        map.put("data", neckletViewList);
        return map;
    }*/


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
