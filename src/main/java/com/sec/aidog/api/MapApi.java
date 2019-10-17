package com.sec.aidog.api;

import com.sec.aidog.common.RedisUtil;
import com.sec.aidog.pojo.Manager;
import com.sec.aidog.service.*;
import com.sec.aidog.util.CommonThreadPool;
import com.sec.aidog.util.JSONUtil;
import com.sec.aidog.util.JsonResult;
import com.sec.aidog.util.NameConversionUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import com.google.gson.Gson;

@RequestMapping("api")
@Controller
public class MapApi {

    @Autowired
    private RedisService redisService;

    @Autowired
    private UserService userService;

    @Resource
    private ProvinceService provinceService;

    @Autowired
    private CityService cityService;

    @Autowired
    private CountyService countyService;

    @Autowired
    private VillageService villageService;

    @Autowired
    private HamletService hamletService;

    @Autowired
    private NameConversionUtil nameConversionUtil;

    @Autowired
    private Gson gson;

    @ApiOperation(value = "获取默认地图数据", notes = "获取默认地图数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getindexmap",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<JsonResult> GetIndexMap(HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
//            String managerstr = redisService.get("token:"+token);
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            Manager resultUser = ((Manager) JSONUtil.JSONToObj(managerstr, Manager.class));
            JSONObject jsStr = null;
            switch(resultUser.getPrivilegelevel()) {
                case 1:
                    Map<String,Object> data = new HashMap<String,Object>();
                    data.put("data1",resultUser);
                    Map<String,Integer> LogoInfo = new HashMap<String,Integer>();
                    Map<String,Object> countrymap = new HashMap<String,Object>();
                    Future<Object> LogoInfotemp = CommonThreadPool.submit(()->{
                        //System.out.println("1开始。。。");
                        Map<String,Integer> temp = new HashMap<String, Integer>();
                        temp = gson.fromJson(redisService.get(resultUser.getUsername() + "_UserController_IndexLogoInfo"),temp.getClass());
                        if(temp == null) {
                            temp = userService.GetIndexLogoInfo(resultUser);
                            redisService.set1minute(resultUser.getUsername() + "_UserController_IndexLogoInfo", gson.toJson(temp));
                        }
                        return temp;
                    });
                    Future<Object> countrymaptemp = CommonThreadPool.submit(()->{
                        Map<String,Object> temp = new HashMap<String, Object>();
                        temp = gson.fromJson(redisService.get(resultUser.getUsername() + "_UserController_CountryMap"),temp.getClass());
                        if(temp == null) {
                            temp = userService.GetCountryMap();
                            redisService.set1minute(resultUser.getUsername() + "_UserController_CountryMap", gson.toJson(temp));
                        }
                        return temp;
                    });
                    try {
                        LogoInfo = (Map<String, Integer>) LogoInfotemp.get();
                        countrymap = (Map<String, Object>) countrymaptemp.get();
                    }catch(InterruptedException | ExecutionException ex) {
                        ex.printStackTrace();
                    }
                    data.put("data2",LogoInfo);
                    data.put("data3",countrymap);
                    jsStr = JSONObject.fromObject(data);
                    r.setCode(200);
                    r.setMsg("获取用户信息成功！");
                    r.setData(jsStr);
                    r.setSuccess(true);
                    break;
                case 2:
                    return GetProvinceMap(resultUser.getProvince(),request);
                case 3:
                    return GetCityMap(resultUser.getProvince(),resultUser.getCity(),request);
                case 4:
                    return GetCountyMap(resultUser.getProvince(),resultUser.getCity(),resultUser.getCounty(),request);
                case 5:
                    return GetVillageMap(resultUser.getProvince(),resultUser.getCity(),resultUser.getCounty(),resultUser.getVillage(),request);
                case 6:
                    return GetHamletMap(resultUser.getProvince(),resultUser.getCity(),resultUser.getCounty(),resultUser.getVillage(),resultUser.getHamlet(),request);
            }
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取默认地图信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    @RequestMapping(value="/getprovincemap",method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "province", value = "省份", required = false, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @ResponseBody
    public ResponseEntity<JsonResult> GetProvinceMap(@RequestParam(value="province",required = false) String province, HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
//            String managerstr = redisService.get("token:"+token);
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            Manager resultUser = ((Manager) JSONUtil.JSONToObj(managerstr, Manager.class));
            JSONObject jsStr = null;
            Map<String,Object> data = new HashMap<String,Object>();
            data.put("data1",resultUser);//data1保存用户信息
            String provinceres = province;
            if(provinceres!="" && provinceres!=null){
                //上级页面跳转而来，非首页，解码
//                provinceres = URLDecoder.decode(provinceres, "UTF-8");
            }else{
                //当前管理员首页
                province = resultUser.getProvince();
            }
            if(province.equals("建设兵团")) {//查看建设兵团的详情
                Map<String,Integer> armyIndexInfo = provinceService.GetArmyIndexLogo(province);//获得建设兵团的总体数据信息
                data.put("data2",armyIndexInfo);
                Map<String,Object> armyProvinceMap = provinceService.GetArmyProvinceMap(province);//获得该建设兵团下各个流行师的详细数据
                data.put("data3", armyProvinceMap);
                Map<String,Object> data4 = provinceService.GetDistrictcode(province);//获得该建设兵团的区域编码
                data.put("data4", data4);
            }else {//如果非建设兵团，即省
                Map<String,Integer> provinceIndexInfo = provinceService.GetIndexLogoInfo(province);//获得该省的总体数据信息
                data.put("data2",provinceIndexInfo);
                Map<String,Object> ProvinceMap = provinceService.GetProvinceMap(province);//获得该省下各个流行市的详细数据
                data.put("data3", ProvinceMap);
                Map<String,Object> data4 = provinceService.GetDistrictcode(province);//获得该省的区域编码
                data.put("data4", data4);
            }
            jsStr = JSONObject.fromObject(data);//数据转为json格式
            r.setCode(200);
            r.setMsg("获取用户信息成功！");
            r.setData(jsStr);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取省级地图信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    @RequestMapping(value="/getcitymap",method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "province", value = "省份", required = false, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "city", value = "所属市", required = false, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @ResponseBody
    public ResponseEntity<JsonResult> GetCityMap(@RequestParam(value="province",required = false) String province,@RequestParam(value="city",required = false) String city, HttpServletRequest request) {
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
//            String managerstr = redisService.get("token:"+token);
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            Manager resultUser = ((Manager) JSONUtil.JSONToObj(managerstr, Manager.class));
            JSONObject jsStr = null;
            Map<String,Object> data = new HashMap<String,Object>();
            data.put("data1",resultUser);//data1保存用户信息
            String cityres = city;
            if(cityres!="" && cityres!=null){
                //上级页面跳转而来，非首页，解码

            }else{
                //当前管理员首页
                province = resultUser.getProvince();
                city = resultUser.getCity();
            }
            if(province.equals("建设兵团")) {//查看建设兵团的详情
                Map<String,Integer> divisionIndexInfo = cityService.GetDivisionIndexLogo(province,city);//获得师德总体数据信息
                data.put("data2",divisionIndexInfo);
                Map<String,Object> armyCityMap = cityService.GetArmyCityMap(province,city);//获得该师下各个流行团的详细数据信息
                data.put("data3", armyCityMap);
                Map<String,Object> data4 = cityService.GetDistrictcode(province,city);//获得师的区域编码
                data.put("data4", data4);
            }else {//如果非建设兵团，即省
                Map<String,Integer> cityIndexInfo = cityService.GetIndexLogoInfo(province, city);//获得该市的总体数据信息
                data.put("data2",cityIndexInfo);
                Map<String,Object> cityMap = cityService.GetCityMap(province,city);//获得该市下各个流行县的详细数据信息
                data.put("data3", cityMap);
                Map<String,Object> data4 = cityService.GetDistrictcode(province,city);//获得该市的区域编码
                data.put("data4", data4);
            }
            jsStr = JSONObject.fromObject(data);//数据转为json格式
            r.setCode(200);
            r.setMsg("获取用户信息成功！");
            r.setData(jsStr);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取市级地图信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    @RequestMapping(value="/getcountymap",method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "province", value = "省份", required = false, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "city", value = "所属市", required = false, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "county", value = "所属县", required = false, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @ResponseBody
    public ResponseEntity<JsonResult> GetCountyMap(@RequestParam(value="province",required = false) String province,@RequestParam(value="city",required = false) String city, @RequestParam(value="county",required = false) String county,HttpServletRequest request) {
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
//            String managerstr = redisService.get("token:"+token);
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            Manager resultUser = ((Manager) JSONUtil.JSONToObj(managerstr, Manager.class));
            JSONObject jsStr = null;
            Map<String,Object> data = new HashMap<String,Object>();
            data.put("data1",resultUser);//data1保存用户信息
            String countyres = county;
            if(countyres!="" && countyres!=null){
                //上级页面跳转而来，非首页，解码

            }else{
                //当前管理员首页
                province = resultUser.getProvince();
                city = resultUser.getCity();
                county = resultUser.getCounty();
            }
            Map<String,Integer> countyIndexInfo = countyService.GetIndexLogoInfo(province, city,county);//该县的总体数据信息
            data.put("data2",countyIndexInfo);
            Map<String,Object> countyMap = countyService.GetCountyMap(province,city,county);//该县下各个流行乡的数据信息
            data.put("data3", countyMap);
            Map<String,Object> data4 = countyService.GetDistrictcode(province,city,county);//获得该县的区域编码
            data.put("data4", data4);
            jsStr = JSONObject.fromObject(data);//数据转为json格式
            r.setCode(200);
            r.setMsg("获取用户信息成功！");
            r.setData(jsStr);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取县级地图信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    @RequestMapping(value="/getvillagemap",method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "province", value = "省份", required = false, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "city", value = "所属市", required = false, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "county", value = "所属县", required = false, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "village", value = "所属乡镇", required = false, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @ResponseBody
    public ResponseEntity<JsonResult> GetVillageMap(@RequestParam(value="province",required = false) String province,@RequestParam(value="city",required = false) String city, @RequestParam(value="county",required = false) String county, @RequestParam(value="village",required = false) String village,HttpServletRequest request) {
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
//            String managerstr = redisService.get("token:"+token);
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            Manager resultUser = ((Manager) JSONUtil.JSONToObj(managerstr, Manager.class));
            JSONObject jsStr = null;
            Map<String,Object> data = new HashMap<String,Object>();
            data.put("data1",resultUser);//data1保存用户信息
            String villageres = village;
            if(villageres!="" && villageres!=null){
                //上级页面跳转而来，非首页，解码

            }else{
                //当前管理员首页
                province = resultUser.getProvince();
                city = resultUser.getCity();
                county = resultUser.getCounty();
                village = resultUser.getVillage();
            }
            Map<String,Integer> villageIndexInfo = villageService.GetIndexLogoInfo(province, city,county,village);//获得该乡的总体数据信息
            data.put("data2",villageIndexInfo);
            Map<String,Object> villageMap = villageService.GetVillageMap(province,city,county,village);//获得该乡下各村的数据信息
            data.put("data3", villageMap);
            Map<String,Object> data4 = villageService.GetDistrictcode(province,city,county,village);//获得该乡的区域编码
            data.put("data4", data4);
            jsStr = JSONObject.fromObject(data);//数据转为json格式
            r.setCode(200);
            r.setMsg("获取用户信息成功！");
            r.setData(jsStr);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取乡级地图信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    @RequestMapping(value="/gethamletmap",method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "province", value = "省份", required = false, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "city", value = "所属市", required = false, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "county", value = "所属县", required = false, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "village", value = "所属乡镇", required = false, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "hamlet", value = "所属乡镇", required = false, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @ResponseBody
    public ResponseEntity<JsonResult> GetHamletMap(@RequestParam(value="province",required = false) String province,@RequestParam(value="city",required = false) String city, @RequestParam(value="county",required = false) String county, @RequestParam(value="village",required = false) String village,@RequestParam(value="hamlet",required = false) String hamlet,HttpServletRequest request) {
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
//            String managerstr = redisService.get("token:"+token);
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            Manager resultUser = ((Manager) JSONUtil.JSONToObj(managerstr, Manager.class));
            JSONObject jsStr = null;
            Map<String,Object> data = new HashMap<String,Object>();
//            data.put("data1",resultUser);//data1保存用户信息
            String hamletres = hamlet;
            if(hamletres!="" && hamletres!=null){
                //上级页面跳转而来，非首页，解码

            }else{
                //当前管理员首页
                province = resultUser.getProvince();
                city = resultUser.getCity();
                county = resultUser.getCounty();
                village = resultUser.getVillage();
                hamlet = resultUser.getHamlet();
            }
            Map<String,Object> gethamletmap = new HashMap<String,Object>();
            gethamletmap = hamletService.GetHamletMap(province,city,county,village,hamlet,request);
            if(gethamletmap.size() != 0){
                data.put("data3", gethamletmap);
            }
            Map<String,String> data4 = new HashMap<String,String>();

            data4.put("provincename", nameConversionUtil.GovToEchartsAreaName(province));
            data4.put("cityname", nameConversionUtil.GovToEchartsAreaName(city));
            data4.put("countyname", nameConversionUtil.GovToEchartsAreaName(county));
            data4.put("villagename", nameConversionUtil.GovToEchartsAreaName(village));
            data4.put("hamletname", nameConversionUtil.GovToEchartsAreaName(hamlet));
            data.put("data4", data4);
            Map<String,Object> getHamletFeederMap = new HashMap<String,Object>();
            getHamletFeederMap = hamletService.GetHamletFeederMap(province,city,county,village,hamlet);
            if(getHamletFeederMap.size() != 0){
                data.put("data6", getHamletFeederMap);
            }
            jsStr = JSONObject.fromObject(data);//数据转为json格式
            r.setCode(200);
            r.setMsg("获取村级地图信息成功！");
            r.setData(jsStr.toString());
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取村级地图信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
}
