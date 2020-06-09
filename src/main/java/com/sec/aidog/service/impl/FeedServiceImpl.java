package com.sec.aidog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sec.aidog.api.Analyse;
import com.sec.aidog.dao.*;
import com.sec.aidog.pojo.*;
import com.sec.aidog.service.FeedService;
import com.sec.aidog.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

@Service
public class FeedServiceImpl implements FeedService {
    @Autowired
    private SysDeviceconfMapper sysDeviceconfMapper;

    @Autowired
    private RedisService redisService;

    @Autowired
    private SysLayconfigMapper sysLayconfigMapper;

    @Autowired
    private FeedMapper feedMapper;

    @Autowired
    private DogMapper dogMapper;

    @Autowired
    private FeedconfigMapper feedconfigMapper;

    @Autowired
    private LastfeeddosingMapper lastfeeddosingMapper;

    @Autowired
    private LastfeedareabackMapper lastfeedareabackMapper;

    @Autowired
    private GuestInfoDao guestInfoDao;

    @Autowired
    private FeedareabackMapper feedareabackMapper;

    @Override
    public boolean batchFeedRegister(List<Feed> feedlist) {
        boolean isSuccess = feedMapper.insertBatchFeedRegister(feedlist)>0?true:false;
        return isSuccess;
    }

    @Override
    public boolean singleFeedRegister(Feed feed) {
        boolean isSuccess = feedMapper.insert(feed)>0?true:false;
        return isSuccess;
    }


    @Override
    @Transactional
    public boolean bindFeed(String feedid, Integer dogid) {
        try{
            Dog dog = dogMapper.selectByPrimaryKey(dogid);
            Feed feed = feedMapper.selectByFeedId(feedid);
            if(dog != null && feed!= null){
                dog.setAppId(feedid);
                boolean flag1 = dogMapper.updateByPrimaryKey(dog)!=0?true:false;
                feed.setBindTime(new Date());
                feed.setDistrictcode(dog.getDistrictcode());
                boolean flag2 = feedMapper.updateByPrimaryKey(feed)!=0?true:false;
                Feedconfig feedconfig = new Feedconfig();
                feedconfig.setFeedId(feedid);
                feedconfig.setAreacycle(4320);
                feedconfig.setUpdatetime(new Date());
                boolean flag3 = feedconfigMapper.insert(feedconfig)!=0?true:false;
                Lastfeeddosing lastfeeddosing = new Lastfeeddosing();
                lastfeeddosing.setFeedId(feedid);
                lastfeeddosing.setRealtime(new Date());
                lastfeeddosing.setDistrictcode(dog.getDistrictcode());
                boolean flag4 = lastfeeddosingMapper.insert(lastfeeddosing)!=0?true:false;
                Lastfeedareaback lastfeedareaback = new Lastfeedareaback();
                lastfeedareaback.setFeedId(feedid);
                lastfeedareaback.setRealtime(new Date());
                boolean flag5 = lastfeedareabackMapper.insert(lastfeedareaback)!=0?true:false;

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
                SysLayconfig layconfig = sysLayconfigMapper.selectLayConfigByMid(feedid);
                if(layconfig==null){
                    layconfig = new SysLayconfig();
                    layconfig.setId(0);
                    layconfig.setMid(feedid);
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
                    redisService.remove("time_"+feedid);
                    flag7  = redisService.setpersist("time_"+feedid, command02);
                }

                SysDeviceconf sysDeviceconf = sysDeviceconfMapper.selectDeviceConfigByMid(feedid);
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
                    sysDeviceconf.setMid(feedid);
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
                    redisService.remove("device_"+feedid);
                    redisService.setpersist("device_"+feedid, command03);
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
    public Map<String, Object> getHamletOwnerFeedList(String hamletcode,Integer ownerid) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Dog> feedList = dogMapper.getUseAppListByHamletcode(hamletcode,ownerid);
        int i=0;
        for (Dog item:feedList)
        {
            Map<String, Object> maptemp = new HashMap<String, Object>();
            String type = "喂饲器管理";
            maptemp.put("managetype",type);
            maptemp.put("feed", item.getAppId());
            maptemp.put("id", item.getDogId());
            map.put(""+i, maptemp);
            i++;
        }
//        List<Dog> appList = dogMapper.getUseAppListByHamletcode(hamletcode,ownerid);

        return map;
    }

//    @Override
//    public Map<String, Object> getFeedList(String districtcode, int startPage, int pageSize) {
//        Page page = PageHelper.startPage(startPage, pageSize);
//        List<FeedView> feedViewList = new ArrayList<>();
//        List<SysLaytime> SysLaytimelist = feedMapper.selectViewLayTime(districtcode);
//        List<SysDeviceconf> sysDeviceconflist = feedMapper.selectViewDeviceconf(districtcode);
//        List<SysLayconfig> sysLayconfiglist = feedMapper.selectViewLayconfig(districtcode);
//
//        FeedView feedView = null;
//        for(int i=0;i<sysDeviceconflist.size();i++){
//            feedView = new FeedView();
//            feedView.setFeedId(SysLaytimelist.get(i).getMid());
//            feedView.setPower(SysLaytimelist.get(i).getVoltage()==null?"未反馈":SysLaytimelist.get(i).getVoltage()+"");
//            feedView.setTemperature(SysLaytimelist.get(i).getTemperature()==null?"未反馈":SysLaytimelist.get(i).getTemperature()+"");
//            feedView.setPillcode("PL2306");
//            String devicestatus = changestatus(sysDeviceconflist.get(i).getStatus());   //投药状态加轮询状态
//            String dosingstatus = devicestatus.substring(0,12);
//            feedView.setDosingstatus(dosingstatus.substring(0,4)+"-"+dosingstatus.substring(4,8)+"-"+dosingstatus.substring(8,12));
//            feedView.setConfstatus("正常");
//            if(sysDeviceconflist.get(i).getUimodifyflag().equals(Byte.valueOf("1")) && sysDeviceconflist.get(i).getHardmodifyflag().equals(Byte.valueOf("0"))){
//                feedView.setConfstatus("硬件接收信息中");
//            }else if(sysDeviceconflist.get(i).getUimodifyflag().equals(Byte.valueOf("0")) && sysDeviceconflist.get(i).getHardmodifyflag().equals(Byte.valueOf("0"))){
//                feedView.setConfstatus("硬件已完成配置");
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
//            Lastfeeddosing lastfeeddosing = lastfeeddosingMapper.getLastfeeddosing(SysLaytimelist.get(i).getMid());
//            switch(countnum){
//                case 12:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getTwelve());
//                    feedView.setNextDosingTime(null);
//                    feedView.setLeftnum(0);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getTwelve());
//                    lastfeeddosing.setNextdosingTime(null);
//                    lastfeeddosing.setLeftNum(0);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 11:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getEleven());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getTwelve());
//                    feedView.setLeftnum(1);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getEleven());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getTwelve());
//                    lastfeeddosing.setLeftNum(1);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 10:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getTen());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getEleven());
//                    feedView.setLeftnum(2);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getTen());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getEleven());
//                    lastfeeddosing.setLeftNum(2);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 9:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getNine());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getTen());
//                    feedView.setLeftnum(3);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getNine());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getTen());
//                    lastfeeddosing.setLeftNum(3);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 8:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getEight());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getNine());
//                    feedView.setLeftnum(4);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getEight());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getNine());
//                    lastfeeddosing.setLeftNum(4);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 7:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getSeven());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getEight());
//                    feedView.setLeftnum(5);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getSeven());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getEight());
//                    lastfeeddosing.setLeftNum(5);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 6:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getSix());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getSeven());
//                    feedView.setLeftnum(6);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getSix());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getSeven());
//                    lastfeeddosing.setLeftNum(6);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 5:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getFive());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getSix());
//                    feedView.setLeftnum(7);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getFive());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getSix());
//                    lastfeeddosing.setLeftNum(7);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 4:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getFour());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getFive());
//                    feedView.setLeftnum(8);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getFour());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getFive());
//                    lastfeeddosing.setLeftNum(8);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 3:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getThree());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getFour());
//                    feedView.setLeftnum(9);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getThree());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getFour());
//                    lastfeeddosing.setLeftNum(9);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 2:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getTwo());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getThree());
//                    feedView.setLeftnum(10);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getTwo());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getThree());
//                    lastfeeddosing.setLeftNum(10);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 1:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getOne());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getTwo());
//                    feedView.setLeftnum(11);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getOne());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getTwo());
//                    lastfeeddosing.setLeftNum(11);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 0:
//                    feedView.setFirstDosingTime(null);
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getOne());
//                    feedView.setLeftnum(12);
//
//                    lastfeeddosing.setLastdosingTime(null);
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getOne());
//                    lastfeeddosing.setLeftNum(12);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//            }
//            feedViewList.add(feedView);
//            lastfeeddosingMapper.updateByPrimaryKey(lastfeeddosing);
//
//        }
//        Map<String, Object> map = new HashMap<String,Object>();
//        //每页信息
//        map.put("data", feedViewList);
//        //管理员总数
//        map.put("totalNum", page.getTotal());
//        return map;
//    }

    @Override
    public Map<String, Object> getFeedList(String districtcode, int startPage, int pageSize) {
        Page page = PageHelper.startPage(startPage, pageSize);
        Map<String, Object> map = getCommonFeedList(districtcode);
        //管理员总数
        map.put("totalNum", page.getTotal());
        return map;
    }

    @Override
    public Map<String, Object> getFeedLngLat(String districtcode, Date begintime, Date endtime, String feedid) {
        Map<String, Object> map = new HashMap<String,Object>();
        List<LngLat> lnglatlist = new ArrayList<>();

        if(feedid == null || feedid.trim().equals("")){
            lnglatlist = feedareabackMapper.selectLngLatByDistrictcode(districtcode,begintime,endtime);
        }else{
            if(feedid.contains("|")){
                String[] feedarr = feedid.split("\\|");
                List<LngLat> lnglatlisttemp;
                for(int i=0;i<feedarr.length;i++){
                    lnglatlisttemp = new ArrayList<>();
                    lnglatlisttemp = feedareabackMapper.selectLngLatByFeedId(feedarr[i],begintime,endtime);
                    lnglatlist.addAll(lnglatlisttemp);
                }
            }else{
                lnglatlist = feedareabackMapper.selectLngLatByFeedId(feedid,begintime,endtime);
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
    public Map<String, Object> getFeedVolAndTemp(String districtcode, Date begintime, Date endtime, String feedid) {
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("voltemplist", getFeedVolAndTempVoltemplist(districtcode,begintime,endtime,feedid));
        return map;
    }

    @Override
    public List<VolTemp> getFeedVolAndTempVoltemplist(String districtcode, Date begintime, Date endtime, String feedid) {
        List<VolTemp> voltemplist = new ArrayList<>();

        if(feedid == null || feedid.trim().equals("")){
            voltemplist = feedareabackMapper.selectVolTempByDistrictcode(districtcode,begintime,endtime);
        }else{
            if(feedid.contains("|")){
                String[] feedarr = feedid.split("\\|");
                List<VolTemp> voltemplisttemp;
                for(int i=0;i<feedarr.length;i++){
                    voltemplisttemp = new ArrayList<>();
                    voltemplisttemp = feedareabackMapper.selectVolTempByFeedId(feedarr[i],begintime,endtime);
                    voltemplist.addAll(voltemplisttemp);
                }
            }else{
                voltemplist = feedareabackMapper.selectVolTempByFeedId(feedid,begintime,endtime);
            }
        }
        return voltemplist;
    }

    @Override
    public Map<String, Object> getFeedTemp(String districtcode, Date begintime, Date endtime, String feedid) {
        Map<String, Object> map = new HashMap<String,Object>();
        List<LngLat> lnglatlist = new ArrayList<>();

        if(feedid == null || feedid.trim().equals("")){
            lnglatlist = feedareabackMapper.selectLngLatByDistrictcode(districtcode,begintime,endtime);
        }else{
            if(feedid.contains("|")){
                String[] feedarr = feedid.split("\\|");
                List<LngLat> lnglatlisttemp;
                for(int i=0;i<feedarr.length;i++){
                    lnglatlisttemp = new ArrayList<>();
                    lnglatlisttemp = feedareabackMapper.selectLngLatByFeedId(feedarr[i],begintime,endtime);
                    lnglatlist.addAll(lnglatlisttemp);
                }
            }else{
                lnglatlist = feedareabackMapper.selectLngLatByFeedId(feedid,begintime,endtime);
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
    public Map<String, Object> getCommonFeedList(String districtcode) {
        List<FeedView> feedViewList = new ArrayList<>();
        List<SysLaytime> SysLaytimelist = feedMapper.selectViewLayTime(districtcode);
        List<SysDeviceconf> sysDeviceconflist = feedMapper.selectViewDeviceconf(districtcode);
        List<SysLayconfig> sysLayconfiglist = feedMapper.selectViewLayconfig(districtcode);

        FeedView feedView = null;
        for(int i=0;i<sysDeviceconflist.size();i++){

            feedView = new FeedView();

            feedView.setFeedId(sysDeviceconflist.get(i).getMid());

            feedView.setPillcode("{}");
            String devicestatus = changestatus(sysDeviceconflist.get(i).getStatus());   //投药状态加轮询状态
            String dosingstatus = devicestatus.substring(0,12);
            String dosingvideo = "0000-0000-0000";
            feedView.setDosingvideo(dosingvideo);
            feedView.setDosingstatus(dosingstatus.substring(0,4)+"-"+dosingstatus.substring(4,8)+"-"+dosingstatus.substring(8,12));
            feedView.setConfstatus("正常");

            Feed feedInfo = feedMapper.selectByFeedId(sysDeviceconflist.get(i).getMid());
            if(feedInfo!=null){
                if(feedInfo.getPillCode()!=null && feedInfo.getPillCode().length()>0)
                {
                    feedView.setPillcode(feedInfo.getPillCode());
                }
            }

            //统一喂饲器id
            SysLaytime sysLaytime = null;
            for(int j=0;j<SysLaytimelist.size();j++){
                if(SysLaytimelist.get(j).getMid().equals(sysDeviceconflist.get(i).getMid())){
                    sysLaytime = SysLaytimelist.get(j);
                    break;
                }
            }

            if(sysLaytime != null){
                if(feedInfo != null){
                    feedView.setDistrictcode(feedInfo.getDistrictcode());
                }
                feedView.setPower(sysLaytime.getVoltage()==null?"未反馈":sysLaytime.getVoltage()+"");
                feedView.setTemperature(sysLaytime.getTemperature()==null?"未反馈":sysLaytime.getTemperature()+"");
                if(sysDeviceconflist.get(i).getUimodifyflag().equals(Byte.valueOf("1")) && sysDeviceconflist.get(i).getHardmodifyflag().equals(Byte.valueOf("0"))){
                    feedView.setConfstatus("硬件接收配置中");
                    if(sysLaytime.getErr()!=null && !sysLaytime.getErr().equals("0")){
                        for (String key : ErrType.errmap.keySet()) {
                            //map.keySet()返回的是所有key的值
                            if(key.equals(sysLaytime.getErr())){
                                feedView.setConfstatus(ErrType.errmap.get(key));
                            }
                        }
                    }
                }else if(sysDeviceconflist.get(i).getUimodifyflag().equals(Byte.valueOf("0")) && sysDeviceconflist.get(i).getHardmodifyflag().equals(Byte.valueOf("0"))){
                    feedView.setConfstatus("硬件已完成配置");
                    if(sysLaytime.getErr() == null){
                        feedView.setConfstatus("无数据反馈");
                    }else{
                        if(!sysLaytime.getErr().equals("0")){
                            for (String key : ErrType.errmap.keySet()) {
                                //map.keySet()返回的是所有key的值
                                if(key.equals(sysLaytime.getErr())){
                                    feedView.setConfstatus(ErrType.errmap.get(key));
                                }
                            }
                        }
                    }
                }
                feedView.setLastUpdateTime(sysLaytime.getUpdatetime());
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
                    Lastfeeddosing lastfeeddosing = lastfeeddosingMapper.getLastfeeddosing(sysDeviceconflist.get(i).getMid());

                    if(sysLaytime!=null) {
                        lastfeeddosing.setLng(sysLaytime.getLongitude());
                        lastfeeddosing.setLat(sysLaytime.getLatitude());
                        lastfeeddosing.setTemperature(sysLaytime.getTemperature() == null ? null : sysLaytime.getTemperature() + "");
                    }

                    switch(countnum){
                        case 12:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getTwelve());
                            feedView.setNextDosingTime(null);
                            feedView.setLeftnum(0);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getTwelve());
                            lastfeeddosing.setNextdosingTime(null);
                            lastfeeddosing.setLeftNum(0);
                            lastfeeddosing.setPower(feedView.getPower());
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 11:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getEleven());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getTwelve());
                            feedView.setLeftnum(1);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getEleven());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getTwelve());
                            lastfeeddosing.setLeftNum(1);
                            lastfeeddosing.setPower(feedView.getPower());
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 10:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(i).getTen());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getEleven());
                            feedView.setLeftnum(2);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getTen());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getEleven());
                            lastfeeddosing.setLeftNum(2);
                            lastfeeddosing.setPower(feedView.getPower());
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 9:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getNine());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getTen());
                            feedView.setLeftnum(3);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getNine());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getTen());
                            lastfeeddosing.setLeftNum(3);
                            lastfeeddosing.setPower(feedView.getPower());
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 8:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getEight());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getNine());
                            feedView.setLeftnum(4);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getEight());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getNine());
                            lastfeeddosing.setLeftNum(4);
                            lastfeeddosing.setPower(feedView.getPower());
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 7:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getSeven());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getEight());
                            feedView.setLeftnum(5);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getSeven());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getEight());
                            lastfeeddosing.setLeftNum(5);
                            lastfeeddosing.setPower(feedView.getPower());
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 6:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getSix());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getSeven());
                            feedView.setLeftnum(6);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getSix());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getSeven());
                            lastfeeddosing.setLeftNum(6);
                            lastfeeddosing.setPower(feedView.getPower());
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 5:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getFive());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getSix());
                            feedView.setLeftnum(7);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getFive());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getSix());
                            lastfeeddosing.setLeftNum(7);
                            lastfeeddosing.setPower(feedView.getPower());
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 4:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getFour());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getFive());
                            feedView.setLeftnum(8);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getFour());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getFive());
                            lastfeeddosing.setLeftNum(8);
                            lastfeeddosing.setPower(feedView.getPower());
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 3:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getThree());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getFour());
                            feedView.setLeftnum(9);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getThree());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getFour());
                            lastfeeddosing.setLeftNum(9);
                            lastfeeddosing.setPower(feedView.getPower());
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 2:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getTwo());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getThree());
                            feedView.setLeftnum(10);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getTwo());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getThree());
                            lastfeeddosing.setLeftNum(10);
                            lastfeeddosing.setPower(feedView.getPower());
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 1:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getOne());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getTwo());
                            feedView.setLeftnum(11);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getOne());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getTwo());
                            lastfeeddosing.setLeftNum(11);
                            lastfeeddosing.setPower(feedView.getPower());
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 0:
                            feedView.setFirstDosingTime(null);
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getOne());
                            feedView.setLeftnum(12);

                            lastfeeddosing.setLastdosingTime(null);
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getOne());
                            lastfeeddosing.setLeftNum(12);
                            lastfeeddosing.setPower(feedView.getPower());
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                    }
                    lastfeeddosingMapper.updateByPrimaryKey(lastfeeddosing);
                }
            }
            feedViewList.add(feedView);
        }
        Map<String, Object> map = new HashMap<String,Object>();
        //每页信息
        map.put("data", feedViewList);
        return map;
    }
    /*public Map<String, Object> getCommonFeedList(String districtcode) {
        List<FeedView> feedViewList = new ArrayList<>();
        List<SysLaytime> SysLaytimelist = feedMapper.selectViewLayTime(districtcode);
        List<SysDeviceconf> sysDeviceconflist = feedMapper.selectViewDeviceconf(districtcode);
        List<SysLayconfig> sysLayconfiglist = feedMapper.selectViewLayconfig(districtcode);

        FeedView feedView = null;
        for(int i=0;i<sysDeviceconflist.size();i++){
//            if(sysDeviceconflist.get(i).getMid().equals("1909010481")){
//                System.out.println("aa");
//            }
            feedView = new FeedView();
            //feedView.setFeedId(SysLaytimelist.get(i).getMid());
            feedView.setFeedId(sysDeviceconflist.get(i).getMid());


            feedView.setPillcode("ER190901");
            String devicestatus = changestatus(sysDeviceconflist.get(i).getStatus());   //投药状态加轮询状态
            String dosingstatus = devicestatus.substring(0,12);
            feedView.setDosingstatus(dosingstatus.substring(0,4)+"-"+dosingstatus.substring(4,8)+"-"+dosingstatus.substring(8,12));
            feedView.setConfstatus("正常");

            //统一喂饲器id
            for(int j=0;j<SysLaytimelist.size();j++){
                if(SysLaytimelist.get(j).getMid().equals(sysDeviceconflist.get(i).getMid())){
                    feedView.setDistrictcode(feedMapper.selectByFeedId(SysLaytimelist.get(i).getMid()).getDistrictcode());
                    feedView.setPower(SysLaytimelist.get(i).getVoltage()==null?"未反馈":SysLaytimelist.get(i).getVoltage()+"");
                    feedView.setTemperature(SysLaytimelist.get(i).getTemperature()==null?"未反馈":SysLaytimelist.get(i).getTemperature()+"");
                    if(sysDeviceconflist.get(i).getUimodifyflag().equals(Byte.valueOf("1")) && sysDeviceconflist.get(i).getHardmodifyflag().equals(Byte.valueOf("0"))){
                        feedView.setConfstatus("硬件接收配置中");
                        if(SysLaytimelist.get(j).getErr()!=null && !SysLaytimelist.get(j).getErr().equals("0")){
                            for (String key : ErrType.errmap.keySet()) {
                                //map.keySet()返回的是所有key的值
                                if(key.equals(SysLaytimelist.get(i).getErr())){
                                    feedView.setConfstatus(ErrType.errmap.get(key));
                                }
                            }
                        }
                    }else if(sysDeviceconflist.get(i).getUimodifyflag().equals(Byte.valueOf("0")) && sysDeviceconflist.get(i).getHardmodifyflag().equals(Byte.valueOf("0"))){
                        feedView.setConfstatus("硬件已完成配置");
                        if(SysLaytimelist.get(j).getErr() == null){
                            feedView.setConfstatus("无数据反馈");
                        }else{
                            if(!SysLaytimelist.get(j).getErr().equals("0")){
                                for (String key : ErrType.errmap.keySet()) {
                                    //map.keySet()返回的是所有key的值
                                    if(key.equals(SysLaytimelist.get(j).getErr())){
                                        feedView.setConfstatus(ErrType.errmap.get(key));
                                    }
                                }
                            }
                        }
                    }
                    feedView.setLastUpdateTime(SysLaytimelist.get(j).getUpdatetime());
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
                    Lastfeeddosing lastfeeddosing = lastfeeddosingMapper.getLastfeeddosing(sysDeviceconflist.get(i).getMid());
//            Lastfeeddosing lastfeeddosing = lastfeeddosingMapper.getLastfeeddosing(SysLaytimelist.get(i).getMid());
                    switch(countnum){
                        case 12:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getTwelve());
                            feedView.setNextDosingTime(null);
                            feedView.setLeftnum(0);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getTwelve());
                            lastfeeddosing.setNextdosingTime(null);
                            lastfeeddosing.setLeftNum(0);
                            lastfeeddosing.setPower(feedView.getPower());
                            lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 11:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getEleven());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getTwelve());
                            feedView.setLeftnum(1);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getEleven());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getTwelve());
                            lastfeeddosing.setLeftNum(1);
                            lastfeeddosing.setPower(feedView.getPower());
                            lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 10:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(i).getTen());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getEleven());
                            feedView.setLeftnum(2);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getTen());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getEleven());
                            lastfeeddosing.setLeftNum(2);
                            lastfeeddosing.setPower(feedView.getPower());
                            lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 9:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getNine());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getTen());
                            feedView.setLeftnum(3);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getNine());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getTen());
                            lastfeeddosing.setLeftNum(3);
                            lastfeeddosing.setPower(feedView.getPower());
                            lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 8:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getEight());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getNine());
                            feedView.setLeftnum(4);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getEight());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getNine());
                            lastfeeddosing.setLeftNum(4);
                            lastfeeddosing.setPower(feedView.getPower());
                            lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 7:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getSeven());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getEight());
                            feedView.setLeftnum(5);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getSeven());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getEight());
                            lastfeeddosing.setLeftNum(5);
                            lastfeeddosing.setPower(feedView.getPower());
                            lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 6:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getSix());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getSeven());
                            feedView.setLeftnum(6);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getSix());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getSeven());
                            lastfeeddosing.setLeftNum(6);
                            lastfeeddosing.setPower(feedView.getPower());
                            lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 5:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getFive());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getSix());
                            feedView.setLeftnum(7);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getFive());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getSix());
                            lastfeeddosing.setLeftNum(7);
                            lastfeeddosing.setPower(feedView.getPower());
                            lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 4:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getFour());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getFive());
                            feedView.setLeftnum(8);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getFour());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getFive());
                            lastfeeddosing.setLeftNum(8);
                            lastfeeddosing.setPower(feedView.getPower());
                            lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 3:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getThree());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getFour());
                            feedView.setLeftnum(9);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getThree());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getFour());
                            lastfeeddosing.setLeftNum(9);
                            lastfeeddosing.setPower(feedView.getPower());
                            lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 2:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getTwo());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getThree());
                            feedView.setLeftnum(10);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getTwo());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getThree());
                            lastfeeddosing.setLeftNum(10);
                            lastfeeddosing.setPower(feedView.getPower());
                            lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 1:
                            feedView.setFirstDosingTime(sysLayconfiglist.get(k).getOne());
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getTwo());
                            feedView.setLeftnum(11);

                            lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(k).getOne());
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getTwo());
                            lastfeeddosing.setLeftNum(11);
                            lastfeeddosing.setPower(feedView.getPower());
                            lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                        case 0:
                            feedView.setFirstDosingTime(null);
                            feedView.setNextDosingTime(sysLayconfiglist.get(k).getOne());
                            feedView.setLeftnum(12);

                            lastfeeddosing.setLastdosingTime(null);
                            lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(k).getOne());
                            lastfeeddosing.setLeftNum(12);
                            lastfeeddosing.setPower(feedView.getPower());
                            lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
                            lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
                            lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
                            //最近一次投药时间
                            lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
                            break;
                    }
                    lastfeeddosingMapper.updateByPrimaryKey(lastfeeddosing);
                }
            }
            feedViewList.add(feedView);

//            feedView.setDistrictcode(feedMapper.selectByFeedId(SysLaytimelist.get(i).getMid()).getDistrictcode());
//            feedView.setPower(SysLaytimelist.get(i).getVoltage()==null?"未反馈":SysLaytimelist.get(i).getVoltage()+"");
//            feedView.setTemperature(SysLaytimelist.get(i).getTemperature()==null?"未反馈":SysLaytimelist.get(i).getTemperature()+"");
//            feedView.setPillcode("ER190901");
//            String devicestatus = changestatus(sysDeviceconflist.get(i).getStatus());   //投药状态加轮询状态
//            String dosingstatus = devicestatus.substring(0,12);
//            feedView.setDosingstatus(dosingstatus.substring(0,4)+"-"+dosingstatus.substring(4,8)+"-"+dosingstatus.substring(8,12));
//            feedView.setConfstatus("正常");
//            if(sysDeviceconflist.get(i).getUimodifyflag().equals(Byte.valueOf("1")) && sysDeviceconflist.get(i).getHardmodifyflag().equals(Byte.valueOf("0"))){
//                feedView.setConfstatus("硬件接收配置中");
//                if(SysLaytimelist.get(i).getErr()!=null && !SysLaytimelist.get(i).getErr().equals("0")){
//                    for (String key : ErrType.errmap.keySet()) {
//                        //map.keySet()返回的是所有key的值
//                        if(key.equals(SysLaytimelist.get(i).getErr())){
//                            feedView.setConfstatus(ErrType.errmap.get(key));
//                        }
//                    }
//                }
//            }else if(sysDeviceconflist.get(i).getUimodifyflag().equals(Byte.valueOf("0")) && sysDeviceconflist.get(i).getHardmodifyflag().equals(Byte.valueOf("0"))){
//                feedView.setConfstatus("硬件已完成配置");
//                if(SysLaytimelist.get(i).getErr() == null){
//                    feedView.setConfstatus("无数据反馈");
//                }else{
//                    if(!SysLaytimelist.get(i).getErr().equals("0")){
//                        for (String key : ErrType.errmap.keySet()) {
//                            //map.keySet()返回的是所有key的值
//                            if(key.equals(SysLaytimelist.get(i).getErr())){
//                                feedView.setConfstatus(ErrType.errmap.get(key));
//                            }
//                        }
//                    }
//                }
//            }
//            feedView.setLastUpdateTime(SysLaytimelist.get(i).getUpdatetime());

//            int countnum = 12;
//            for(int j = 11;j >=0;j--){
//                if(dosingstatus.charAt(j) == '0'){
//                    countnum--;
//                }else{
//                    break;
//                }
//            }
//            //同时设置最后一次投药表
//            Lastfeeddosing lastfeeddosing = lastfeeddosingMapper.getLastfeeddosing(sysDeviceconflist.get(i).getMid());
////            Lastfeeddosing lastfeeddosing = lastfeeddosingMapper.getLastfeeddosing(SysLaytimelist.get(i).getMid());
//            switch(countnum){
//                case 12:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getTwelve());
//                    feedView.setNextDosingTime(null);
//                    feedView.setLeftnum(0);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getTwelve());
//                    lastfeeddosing.setNextdosingTime(null);
//                    lastfeeddosing.setLeftNum(0);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 11:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getEleven());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getTwelve());
//                    feedView.setLeftnum(1);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getEleven());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getTwelve());
//                    lastfeeddosing.setLeftNum(1);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 10:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getTen());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getEleven());
//                    feedView.setLeftnum(2);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getTen());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getEleven());
//                    lastfeeddosing.setLeftNum(2);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 9:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getNine());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getTen());
//                    feedView.setLeftnum(3);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getNine());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getTen());
//                    lastfeeddosing.setLeftNum(3);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 8:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getEight());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getNine());
//                    feedView.setLeftnum(4);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getEight());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getNine());
//                    lastfeeddosing.setLeftNum(4);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 7:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getSeven());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getEight());
//                    feedView.setLeftnum(5);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getSeven());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getEight());
//                    lastfeeddosing.setLeftNum(5);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 6:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getSix());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getSeven());
//                    feedView.setLeftnum(6);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getSix());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getSeven());
//                    lastfeeddosing.setLeftNum(6);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 5:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getFive());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getSix());
//                    feedView.setLeftnum(7);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getFive());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getSix());
//                    lastfeeddosing.setLeftNum(7);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 4:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getFour());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getFive());
//                    feedView.setLeftnum(8);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getFour());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getFive());
//                    lastfeeddosing.setLeftNum(8);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 3:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getThree());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getFour());
//                    feedView.setLeftnum(9);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getThree());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getFour());
//                    lastfeeddosing.setLeftNum(9);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 2:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getTwo());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getThree());
//                    feedView.setLeftnum(10);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getTwo());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getThree());
//                    lastfeeddosing.setLeftNum(10);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 1:
//                    feedView.setFirstDosingTime(sysLayconfiglist.get(i).getOne());
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getTwo());
//                    feedView.setLeftnum(11);
//
//                    lastfeeddosing.setLastdosingTime(sysLayconfiglist.get(i).getOne());
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getTwo());
//                    lastfeeddosing.setLeftNum(11);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//                case 0:
//                    feedView.setFirstDosingTime(null);
//                    feedView.setNextDosingTime(sysLayconfiglist.get(i).getOne());
//                    feedView.setLeftnum(12);
//
//                    lastfeeddosing.setLastdosingTime(null);
//                    lastfeeddosing.setNextdosingTime(sysLayconfiglist.get(i).getOne());
//                    lastfeeddosing.setLeftNum(12);
//                    lastfeeddosing.setPower(feedView.getPower());
//                    lastfeeddosing.setLng(SysLaytimelist.get(i).getLongitude());
//                    lastfeeddosing.setLat(SysLaytimelist.get(i).getLatitude());
//                    lastfeeddosing.setTemperature(SysLaytimelist.get(i).getTemperature()==null?null:SysLaytimelist.get(i).getTemperature()+"");
//                    //最近一次投药时间
//                    lastfeeddosing.setRealtime(sysDeviceconflist.get(i).getUpdatetime());
//                    break;
//            }
//            feedViewList.add(feedView);
//            lastfeeddosingMapper.updateByPrimaryKey(lastfeeddosing);

        }
        Map<String, Object> map = new HashMap<String,Object>();
        //每页信息
        map.put("data", feedViewList);
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

