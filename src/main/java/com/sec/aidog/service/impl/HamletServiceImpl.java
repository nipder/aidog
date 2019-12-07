package com.sec.aidog.service.impl;

import com.sec.aidog.common.Constant;
import com.sec.aidog.common.DistrictCommon;
import com.sec.aidog.dao.*;
import com.sec.aidog.pojo.*;
import com.sec.aidog.service.HamletService;
import com.sec.aidog.service.NeckletService;
import com.sec.aidog.util.NameConversionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("hamletService")
public class HamletServiceImpl implements HamletService {

    @Autowired
    private NameConversionUtil nameConversionUtil;

    @Autowired
    private DistrictMapper districtMapper;

    @Autowired
    private DogMapper dogMapper;

    @Autowired
    private LastnecareabackMapper lastnecareabackMapper;

    @Autowired
    private LastnecdosingMapper lastnecdosingMapper;

    @Autowired
    private LastappareabackMapper lastappareabackMapper;

    @Autowired
    private LastappdosingMapper lastappdosingMapper;

    @Autowired
    private NecconfigMapper necconfigMapper;

    @Autowired
    private AppconfigMapper appconfigMapper;

    @Autowired
    private DistrictCommon districtCommon;

    @Autowired
    private NeckletService neckletService;

    @Override
    public Map<String, Object> GetHamletMap(String province, String city, String county, String village,
                                            String hamlet,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Map<String,Object> GetHamletMap = new HashMap<String,Object>();
        try {
            District thishamlet = districtCommon.GetDistrictcode(province,city,county,village,hamlet);
            String hamletcode = thishamlet.getDistrictcode();

            //进行相关数据表的刷新
            // @CHG ZYJ 2019.12.05 BEGIN
            //neckletService.getCommonNeckletList(hamletcode);
            List<NeckletView> neckletViewList = null;
            Map<String, Object> NeckletMap = neckletService.getCommonNeckletList(hamletcode);
            if(NeckletMap!=null && NeckletMap.containsKey("data")) {
                neckletViewList = (List<NeckletView>)NeckletMap.get("data");
            }
            // @CHG ZYJ 2019.12.05 END
            session.setAttribute("hamletcode", hamletcode);
            List<Dog> doginfo = new ArrayList<Dog>();
            doginfo = dogMapper.getHamletDogs(hamletcode);
            int i = 0;
            for(Dog each:doginfo) {
                Map<String, Object> maptemp = new HashMap<String,Object>();
                maptemp.put("dogid", each.getDogId());
                maptemp.put("neckletid", each.getNecId());

                // @ADD ZYJ 2019.12.05 BEGIN
                if(neckletViewList!=null && neckletViewList.size()>0){
                    for(int n=0;n<neckletViewList.size();n++){
                        if(neckletViewList.get(n).getNecId().equals(each.getNecId())){
                            maptemp.put("neckletConfstatus", neckletViewList.get(n).getConfstatus());
                            break;
                        }
                    }
                }
                // @ADD ZYJ 2019.12.05 END

                maptemp.put("dogname", each.getDogName());
                Lastnecareaback lr = lastnecareabackMapper.getLastnecareaback(each.getNecId());
                if(lr!=null && lr.getLng()!=null && lr.getLat()!=null) {
                    maptemp.put("lng", Double.parseDouble(lr.getLng()));
                    maptemp.put("lat", Double.parseDouble(lr.getLat()));
                }else {
                    maptemp.put("lng", Double.parseDouble(thishamlet.getLng()));
                    maptemp.put("lat", Double.parseDouble(thishamlet.getLat()));
                }
                Lastnecdosing lb = lastnecdosingMapper.getLastnecdosing(each.getNecId());
                maptemp.put("nextmedtime", lb.getNextdosingTime());
                maptemp.put("manager", each.getManagerName());
                maptemp.put("hamletname", hamlet);
                maptemp.put("lastupdatetime",lr.getRealtime());
                GetHamletMap.put(""+i, maptemp);
                i++;
            }
        }catch(Exception e) {
            return null;
        }
        return GetHamletMap;
    }

    @Override
    public String GovToEchartsAreaName(String city) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Object> GetHamletFeederMap(String province, String city, String county, String village,
                                                  String hamlet) {
        Map<String,Object> GetHamletFeederMap = new HashMap<String,Object>();
        Map<String,Object> GetHamletMap = new HashMap<String,Object>();
        try {
            province = nameConversionUtil.EchartsAreaNameToGov(province);
            city = nameConversionUtil.EchartsAreaNameToGov(city);
            county = nameConversionUtil.EchartsAreaNameToGov(county);
            village = nameConversionUtil.EchartsAreaNameToGov(village);
            hamlet = nameConversionUtil.EchartsAreaNameToGov(hamlet);
            //获得该地区地区编码前两位(省)
            String provinceCode0to2 = districtMapper.getDistrictsByDistrictName(province).getDistrictcode().substring(0, 2);
            //获得该地区地区编码前四位(市)
            String cityCode0to4 = districtMapper.getCityAndBelowDistrictsByDistrictName(city, provinceCode0to2).getDistrictcode().substring(0, 4);
            //获得该地区地区编码前六位(县)
            String countyCode0to6 = districtMapper.getCityAndBelowDistrictsByDistrictName(county, cityCode0to4).getDistrictcode().substring(0, 6);
            //获得该地区地区编码前九位(乡)
            String villageCode0to9 = districtMapper.getCityAndBelowDistrictsByDistrictName(village, countyCode0to6).getDistrictcode().substring(0, 9);
            //获得该地区地区编码前12位(村)
            District thishamlet = districtMapper.getCityAndBelowDistrictsByDistrictName(hamlet, villageCode0to9);
            String hamletcode = thishamlet.getDistrictcode();
            List<Dog> doginfo = new ArrayList<Dog>();
            doginfo = dogMapper.getFarmDogAppList(hamletcode);
            int i = 0;
            Map<String, Object> maptemp = new HashMap<String,Object>();
            for(Dog each:doginfo) {
                maptemp.put("dogid", each.getDogId());
                maptemp.put("feederid", each.getAppId());
                maptemp.put("dogname", each.getDogName());
                Lastappareaback lu = lastappareabackMapper.getLastappareaback(each.getAppId());
                if(lu!=null) {
                    maptemp.put("lng", Double.parseDouble(lu.getLng()));
                    maptemp.put("lat", Double.parseDouble(lu.getLat()));
                }else {
                    maptemp.put("lng", Double.parseDouble(thishamlet.getLng()));
                    maptemp.put("lat", Double.parseDouble(thishamlet.getLat()));
                }
                Lastappdosing lb = lastappdosingMapper.getLastappdosing(each.getAppId());
                maptemp.put("nextmedtime", lb.getNextdosingTime());
                maptemp.put("manager", each.getManagerName());
                maptemp.put("hamletname", hamlet);
                GetHamletFeederMap.put(""+i, maptemp);
                i++;
            }
        }catch (Exception e){
            return null;
        }
        return GetHamletFeederMap;
    }

    @Override
    public Map<String, Object> GetLevel6AdminDogNum(String username) {
        Map<String,Object> GetLevel6AdminDogNum = new HashMap<String,Object>();
        List<Dog> thisadmin = dogMapper.getLevel6AdminDogNum(username);
        if(thisadmin.size() ==0) {
            GetLevel6AdminDogNum.put("dogtotalnum", 0);
            GetLevel6AdminDogNum.put("neckletedtotal", 0);
        }
        else {
            GetLevel6AdminDogNum.put("dogtotalnum", thisadmin.size());
            int i = 0;
            for(Dog each:thisadmin) {
                if(!each.getNecId().equals("-1")) {
                    i++;
                }
            }
            GetLevel6AdminDogNum.put("neckletedtotal", i);
        }
        return GetLevel6AdminDogNum;
    }

    @Override
    public Map<String, Object> CombineNeckletAndFeederDogList(PageBean pageBean, String hamletCode) {
        Map<String,Object> combineneckletandfeederdoglist = new HashMap<String,Object>();
        Map<String, Object> paramsmap = new HashMap<String, Object>();
        paramsmap.put("pageBean1", pageBean);
        if(pageBean!=null){
            paramsmap.put("pagestart", pageBean.getStart());
            paramsmap.put("pagesize", pageBean.getPageSize());
        }
        paramsmap.put("hamletCode", hamletCode);
        List<Dog> doglist = new ArrayList<Dog>();
        doglist = dogMapper.combineNeckletAndAppDogList(paramsmap);
        int i = 0;
        for(Dog each:doglist) {
            Map<String, Object> maptemp = new HashMap<String,Object>();
            maptemp.put("dogid", each.getDogId());
            maptemp.put("dogname", each.getDogName());
            String neckletid = each.getNecId();
            String apparatusid = each.getAppId();
            if(apparatusid.equals("-1") && !neckletid.equals("-1")) {
                Lastnecdosing lb = lastnecdosingMapper.getLastnecdosing(neckletid);
                if(lb != null) {
                    maptemp.put("neckletid",  neckletid);
                    Necconfig feedback = necconfigMapper.getNecconfig(neckletid);
                    maptemp.put("firstmedtime",  feedback.getFirstdosingTime());
                    maptemp.put("lastmed",  lb.getRealtime());
                    maptemp.put("timemed",  feedback.getDosingtotal() - lb.getLeftNum());
                    maptemp.put("nextmed",  lb.getNextdosingTime());
                    maptemp.put("exhibitcycle", feedback.getDosingcycle()/1440.00+"");
                }else {
                    maptemp.put("neckletid",  "----");
                    maptemp.put("firstmedtime",  "");
                    maptemp.put("lastmed",  "");
                    maptemp.put("timemed",  0);
                    maptemp.put("nextmed",  "");
                    maptemp.put("exhibitcycle","10000");
                }
            }else if(!apparatusid.equals("-1") && neckletid.equals("-1")){
                Lastappdosing le = lastappdosingMapper.getLastappdosing(apparatusid);
                if(le!=null) {
                    maptemp.put("feederid", apparatusid);
                    Appconfig fb = appconfigMapper.getAppconfig(apparatusid);
                    maptemp.put("firstmedtime", fb.getFirstdosingTime());
                    maptemp.put("lastmed", le.getRealtime());
                    maptemp.put("timemed", fb.getDosingtotal()-le.getLeftNum());
                    maptemp.put("nextmed", le.getNextdosingTime());
                    maptemp.put("exhibitcycle", "10000");
                }else {
                    maptemp.put("feederid", "----");
                    maptemp.put("firstmedtime", "");
                    maptemp.put("lastmed", "");
                    maptemp.put("timemed", 0);
                    maptemp.put("nextmed", "");
                    maptemp.put("exhibitcycle","10000");
                }
            }
            combineneckletandfeederdoglist.put(""+i, maptemp);
            i++;
        }
        return combineneckletandfeederdoglist;
    }

    @Override
    public Integer CombineNeckletAndFeederDogTotal(String hamletCode) {
        int total = dogMapper.combineNeckletAndAppDogTotal(hamletCode);
        return total;
    }

    @Override
    public Map<String, Object> getCombineNeckletAndFeederDogByNeckletId(String neckletId, String hamletCode) {
        Map<String,Object> combineneckletandfeederdog = new HashMap<String,Object>();

        List<Dog> doglist = new ArrayList<Dog>();
        doglist = dogMapper.getCombineNeckletAndAppDogByNecId(neckletId, hamletCode);
        int i = 0;
        for(Dog each:doglist) {
            Map<String, Object> maptemp = new HashMap<String,Object>();
            maptemp.put("dogid", each.getDogId());
            maptemp.put("dogname", each.getDogName());
            String neckletid = each.getNecId();
            String apparatusid = each.getAppId();
            if(apparatusid.equals("-1") && !neckletid.equals("-1")) {
                Lastnecdosing lb = lastnecdosingMapper.getLastnecdosing(neckletid);
                if(lb != null) {
                    maptemp.put("neckletid",  neckletid);
                    Necconfig feedback = necconfigMapper.getNecconfig(neckletid);
                    maptemp.put("firstmedtime",  feedback.getFirstdosingTime());
                    maptemp.put("lastmed",  lb.getRealtime());
                    maptemp.put("timemed",  feedback.getDosingtotal() - lb.getLeftNum());
                    maptemp.put("nextmed",  lb.getNextdosingTime());
                    maptemp.put("exhibitcycle", (feedback.getAreacycle()/1440.00)+"");
                }else {
                    maptemp.put("neckletid",  "----");
                    maptemp.put("firstmedtime",  "");
                    maptemp.put("lastmed",  "");
                    maptemp.put("timemed",  0);
                    maptemp.put("nextmed",  "");
                    maptemp.put("exhibitcycle","10000");
                }
            }else if(!apparatusid.equals("-1") && neckletid.equals("-1")){
                Lastappdosing le = lastappdosingMapper.getLastappdosing(apparatusid);
                if(le!=null) {
                    maptemp.put("feederid", apparatusid);
                    Appconfig fb = appconfigMapper.getAppconfig(apparatusid);
                    maptemp.put("firstmedtime", fb.getFirstdosingTime());
                    maptemp.put("lastmed", le.getRealtime());
                    maptemp.put("timemed", fb.getDosingtotal()-le.getLeftNum());
                    maptemp.put("nextmed", le.getNextdosingTime());
                    maptemp.put("exhibitcycle", "10000");
                }else {
                    maptemp.put("feederid", "----");
                    maptemp.put("firstmedtime", "");
                    maptemp.put("lastmed", "");
                    maptemp.put("timemed", 0);
                    maptemp.put("nextmed", "");
                    maptemp.put("exhibitcycle","10000");
                }
            }
            combineneckletandfeederdog.put(""+i, maptemp);
            i++;
        }
        return combineneckletandfeederdog;
    }

}

