package com.sec.aidog.service.impl;

import com.sec.aidog.common.DistrictUtil;
import com.sec.aidog.common.RedisUtil;
import com.sec.aidog.dao.*;
import com.sec.aidog.model.*;
import com.sec.aidog.pojo.*;
import com.sec.aidog.service.RedisService;
import com.sec.aidog.service.UserService;
import com.sec.aidog.util.AESUtil;
import com.sec.aidog.util.JSONUtil;
import com.sec.aidog.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private ManagerMapper managerMapper;

    @Autowired
    private DogMapper dogMapper;

    @Autowired
    private ExhibitrealtimeDao exhibitrealtimeDao;

    @Autowired
    private AppexhibitrealtimeDao appexhibitrealtimeDao;

    @Autowired
    private DistrictMapper districtMapper;

    @Autowired
    private DistrictUtil districtUtil;

    @Autowired
    private NecdosingMapper necdosingMapper;

    @Autowired
    private AppdosingMapper appdosingMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public Manager userLogin(String username, String pwd) {
        AESUtil util = new AESUtil();
        Manager manager = null;
        manager = managerMapper.findUserByName(username);
        try {
            if(util.encryptData(pwd).equals(manager.getPassword())){
                return manager;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<String, Integer> GetIndexLogoInfo(Manager manager) {
        Map<String, Integer> map = new HashMap<String,Integer>();
        if(manager.getPrivilegelevel() == 1) {
            DogExample dogexample = new DogExample();
            List<Dog> sdlist = dogMapper.selectByExample(dogexample);
            int dognumtotal = 0;
            int feedernumtotal = 0;
            for(Dog each:sdlist){
                if(!each.getNecId().equals("-1")) {
                    dognumtotal++;
                }
                if(!each.getAppId().equals("-1")) {
                    feedernumtotal++;
                }
            }

            NecdosingExample necdosingexample = new NecdosingExample();
            int med1 = necdosingMapper.countByExample(necdosingexample);

            AppdosingExample appdosingexample = new AppdosingExample();
            int med2 = appdosingMapper.countByExample(appdosingexample);
            int mednumtotal = med1 + med2;

            List<District> alllist = new ArrayList<District>();
            List<District> dislist = new ArrayList<District>();
            List<District> armylist = new ArrayList<District>();

            DistrictExample districtExample = new DistrictExample();
            alllist = districtMapper.selectByExample(districtExample);
            for(District al : alllist)
            {
                if (al.getDistrictcode().startsWith("66"))
                {
                    armylist.add(al);
                }
                else
                {
                    dislist.add(al);
                }
            }

            int armyepidemictotal = 1;

            int provinceepidemictotal = 0;
            int cityepidemictotal = 0;

            int countyepidemictotal = 0;
            int villageepidemictotal = 0;
            int hamletepidemictotal = 0;

            for(District each : dislist) {
                if(each.getEpidemic() == 1) {
                    hamletepidemictotal++;
                    if(each.getDistrictcode().substring(2, 12).equals("0000000000")) {
                        provinceepidemictotal++;
                    }
                    if(each.getDistrictcode().substring(4, 12).equals("00000000")) {
                        cityepidemictotal ++;
                    }
                    if(each.getDistrictcode().substring(6,12).equals("000000")) {
                        countyepidemictotal ++;
                    }
                    if(each.getDistrictcode().substring(9,12).equals("000")) {
                        villageepidemictotal ++;
                    }
                }
            }

            int divisionepidemictotal=0;
            int regimentalepidemictotal =0;
            int companyepidemictotal = 0;
            for(District each : armylist) {
                if(each.getEpidemic() == 1) {
                    companyepidemictotal++;
                    if(each.getDistrictcode().substring(4,8).equals("0000")) {
                        divisionepidemictotal++;
                    }
                    if(each.getDistrictcode().substring(6,8).equals("00")) {
                        regimentalepidemictotal++;
                    }
                }
            }

            List<Integer> levellist = new ArrayList<Integer>();
            int countryadmintotal = 0;
            int provinceadmintotal = 0;
            int cityadmintotal = 0;
            int countyadmintotal = 0;
            int villageadmintotal = 0;
            int hamletadmintotal = 0;
            levellist = managerMapper.getManagerLevel();
            for(Integer each:levellist) {
                switch(each) {
                    case 1:
                        countryadmintotal++;
                        break;
                    case 2:
                        provinceadmintotal++;
                        break;
                    case 3:
                        cityadmintotal++;
                        break;
                    case 4:
                        countyadmintotal++;
                        break;
                    case 5:
                        villageadmintotal++;
                        break;
                    case 6:
                        hamletadmintotal++;
                        break;
                }
            }
            map.put("provinceepidemictotal", provinceepidemictotal + armyepidemictotal);
            map.put("cityepidemictotal", cityepidemictotal - provinceepidemictotal + (divisionepidemictotal - 1));
            map.put("countyepidemictotal", countyepidemictotal - cityepidemictotal + (regimentalepidemictotal - divisionepidemictotal));
            map.put("villageepidemictotal", villageepidemictotal - countyepidemictotal + (companyepidemictotal - regimentalepidemictotal));
            map.put("hamletepidemictotal",  hamletepidemictotal - villageepidemictotal - companyepidemictotal);
            map.put("countryadmintotal", countryadmintotal);
            map.put("provinceadmintotal", provinceadmintotal);
            map.put("cityadmintotal", cityadmintotal);
            map.put("countyadmintotal", countyadmintotal);
            map.put("villageadmintotal", villageadmintotal);
            map.put("hamletadmintotal", hamletadmintotal);
            map.put("countrydognumtotal", dognumtotal);
            map.put("alldognumtotal", 3280564);
            map.put("countrymednumtotal", mednumtotal);
            map.put("feedernumtotal", feedernumtotal);
        }
        return map;
    }

    @Override
    public Map<String, Object> GetCountryMap(){
        Map<String, Object> map = new HashMap<String,Object>();
        List<District> provincesandcities = new ArrayList<District>();
        provincesandcities = districtMapper.getProvincesAndCities();
        int i = 0;
        for(District each:provincesandcities) {
            if(each.getDistrictcode().endsWith("0000000000")) {
                Map<String, Object> maptemp = new HashMap<String,Object>();
                maptemp.put("provincename", each.getEchartname());
                String province0to2 = each.getDistrictcode().substring(0, 2);
                int citynum = 0;
                for(District each2:provincesandcities) {
                    if(each2.getDistrictcode().startsWith(province0to2) && each2.getDistrictcode().endsWith("00000000")
                            && !each2.getDistrictcode().equals(province0to2+"0000000000")) {
                        citynum++;
                    }
                }
                maptemp.put("citynum", citynum);

                int managernum = managerMapper.getProvinceManagerLevelAndBelowByDistrictName(each.getDistrictName()).size();
                maptemp.put("managernum", managernum);
                List<String> dognumlist = dogMapper.getAllNeckletIdByDistrictcode(province0to2);
                maptemp.put("dognum", dognumlist.size());
                int neckletnum = 0;
                for(String each3:dognumlist) {
                    if(!each3.equals("-1")) {
                        neckletnum++;
                    }
                }
                maptemp.put("neckletnum", neckletnum);
                int mednum = necdosingMapper.getExhiCountByDistrictcode(province0to2);
                maptemp.put("mednum", mednum);
                int feednum = appdosingMapper.getAppExhiCountByDistrictcode(province0to2);
                maptemp.put("feedernum", feednum);

                map.put(""+i, maptemp);
                i++;
            }
        }
        return map;
    }

    @Override
    public List<Map<String, String>> GetAllCities() throws Exception {
        List<Map<String,String>> citylist = new ArrayList<Map<String,String>>();
        List<District> list = districtMapper.getAllCities();
        Map<String,String> maptemp = null;
        JSONObject object = null;
        for (District district : list) {
            maptemp = new HashMap<String,String>();
            maptemp.put("districtcode", district.getDistrictcode());
            maptemp.put("districtname", district.getDistrictName());
            citylist.add(maptemp);
        }
        return citylist;
    }

    @Override
    public List<Map<String, String>> GetAllCounties() throws Exception {
        List<Map<String,String>> countylist = new ArrayList<Map<String,String>>();
        List<District> list = districtMapper.getAllCounties();
        Map<String,String> maptemp = null;
        JSONObject object = null;
        for (District district : list) {
            maptemp = new HashMap<String,String>();
            maptemp.put("districtcode", district.getDistrictcode());
            maptemp.put("districtname", district.getDistrictName());
            countylist.add(maptemp);
        }
        return countylist;
    }

    @Override
    public List<Map<String, String>> GetAllVillages() throws Exception {
        List<Map<String,String>> villagelist = new ArrayList<Map<String,String>>();
        List<District> list = districtMapper.getAllVillages();
        Map<String,String> maptemp = null;
        JSONObject object = null;
        for (District district : list) {
            maptemp = new HashMap<String,String>();
            maptemp.put("districtcode", district.getDistrictcode());
            maptemp.put("districtname", district.getDistrictName());
            villagelist.add(maptemp);
        }
        return villagelist;
    }

    @Override
    public List<Map<String, String>> GetAllHamlets() throws Exception {
        List<Map<String,String>> hamletlist = new ArrayList<Map<String,String>>();
        List<District> list = districtMapper.getAllHamlets();
        Map<String,String> maptemp = null;
        JSONObject object = null;
        for (District district : list) {
            maptemp = new HashMap<String,String>();
            maptemp.put("districtcode", district.getDistrictcode());
            maptemp.put("districtname", district.getDistrictName());
            hamletlist.add(maptemp);
        }
        return hamletlist;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public String addUser(String addtype, int privilegelevel, String username, String managername, String address,
                          String identity, String area, String officecall, String tel, String password) throws Exception {
        String result = "添加用户失败！";
        // 如果用户存在，则无法再次创建
        if (managerMapper.findUserByName(username)!=null) {
            result = "添加失败，用户已经存在！";
            return result;
        }
        Manager manager = new Manager();

        String province = "";
        String city = "";
        String county = "";
        String village = "";
        String hamlet = "";

        String[] areaarr = area.split("-");
        if (areaarr.length ==1)
        {
            province = areaarr[0];
            city = "";
            county = "";
            village = "";
            hamlet = "";
        }
        else if (areaarr.length ==2)
        {
            province = areaarr[0];
            city = areaarr[1];
            county = "";
            village = "";
            hamlet = "";
        }
        else if (areaarr.length ==3)
        {
            province = areaarr[0];
            city = areaarr[1];
            county = areaarr[2];
            village = "";
            hamlet = "";
        }
        else if (areaarr.length ==4)
        {
            province = areaarr[0];
            city = areaarr[1];
            county = areaarr[2];
            village = areaarr[3];
            hamlet = "";
        }
        else if (areaarr.length ==5)
        {
            province = areaarr[0];
            city = areaarr[1];
            county = areaarr[2];
            village = areaarr[3];
            hamlet = areaarr[4];
        }
        manager.setProvince(province);
        manager.setCity(city);
        manager.setCounty(county);
        manager.setVillage(village);
        manager.setHamlet(hamlet);

        manager.setUsername(username);
        manager.setManagerName(managername);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        manager.setRegisterTime(ChangeTimeFormat.changeTimeFormat(df.format(new Date()).toString()));
        manager.setRegisterTime(new Date());
        manager.setManagerTel(tel);
        AESUtil aes = new AESUtil();
        manager.setPassword(aes.encryptData(password));
        manager.setPrivilegelevel(privilegelevel);

        if (addtype.equals("self")) {
            manager.setManagerStatus(0);      //自己注册，待激活
        } else {
            manager.setManagerStatus(1);      //管理员代为注册，已激活
        }
        manager.setOfficetel(officecall);
        manager.setManagerAddr(address);
        manager.setWorkplace("");
        manager.setManagerIdentity(identity);
        manager.setManagerEmail("");
        // 获取地区编码
        System.out.println(manager.getRegisterTime());
        System.out.println(manager.getUsername()+"  "+manager.getPassword());
        manager.setDistrictcode(districtUtil.getDistrictCode(province, city, county, village, hamlet));
        managerMapper.insert(manager);

        result = "添加用户成功！";
        return result;
    }

    @Override
    public List<Manager> getUnderManagers(Integer privilegelevel, String districtcode) {
        return managerMapper.getUnderManagers(privilegelevel,districtcode);
    }

    @Override
    public Manager selectByPrimaryKey(Integer managerId) {
        return managerMapper.selectByPrimaryKey(managerId);
    }

    @Override
    public boolean activeManager(Integer manager_id) {
        return managerMapper.activeManager(manager_id)==1?true:false;
    }

    @Override
    public boolean freezeManager(Integer manager_id) {
        return managerMapper.freezeManager(manager_id)==1?true:false;
    }

    @Override
    public boolean resetManagerPwd(Integer manager_id, String pwd) {
        return managerMapper.resetManagerPwd(manager_id, pwd)==1?true:false;
    }

    @Override
    public String modifyUser(String username, String manager_name, String workplace, String manager_identity, String officetel, String manager_tel, String manager_addr, String manager_email, String password, String token) throws Exception {
        String result = null;
        Manager user = managerMapper.findUserByName(username);
        try {
            //给密码加密
            AESUtil aes = new AESUtil();
            user.setManagerName(manager_name);
            user.setWorkplace(workplace);
            user.setManagerIdentity(manager_identity);
            user.setOfficetel(officetel);
            user.setManagerTel(manager_tel);
            user.setManagerAddr(manager_addr);
            user.setManagerEmail(manager_email);
            user.setPassword(aes.encryptData(password));
            //根据username进行更新
            result = managerMapper.updateByPrimaryKey(user)==0?"修改失败！":"修改成功！";
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            if(result.equals("修改成功！")){
                redisService.remove("token:"+token);
                //将token存到redis缓存中
                String managerjson = JSONUtil.objectToJson(user).toString();
                redisService.set("token:"+ token, managerjson);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<String, Object> getHamletManagerList(String hamletcode) {
        Map<String, Object> map = new HashMap<String, Object>();
        ManagerExample example = new ManagerExample();
        example.createCriteria().andDistrictcodeEqualTo(hamletcode);
        List<Manager> dogmanagerList = managerMapper.selectByExample(example);
        int i=0;
        for (Manager item:dogmanagerList)
        {
            Map<String, Object> maptemp = new HashMap<String, Object>();
            maptemp.put("managerusername", item.getUsername());
            maptemp.put("managername", item.getManagerName());
            map.put(""+i, maptemp);
            i++;
        }
        return map;
    }

    @Override
    public Manager selectByNameAndDistrictcode(String managername, String districtcode) {
        return  managerMapper.selectByNameAndDistrictcode(managername,districtcode);
    }
}
