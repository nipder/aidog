package com.sec.aidog.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sec.aidog.common.RedisUtil;
import com.sec.aidog.pojo.Manager;
import com.sec.aidog.pojo.Feed;
import com.sec.aidog.service.FeedService;
import com.sec.aidog.service.RedisService;
import com.sec.aidog.util.JSONUtil;
import com.sec.aidog.util.JsonResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("api")
@Controller
public class FeedApi {

    @Autowired
    private FeedService feedService;

    @Autowired
    private RedisService redisService;
    
    @RequestMapping(value = "feedtest",produces = "application/json; charset=utf-8",method = RequestMethod.GET)
    @ResponseBody
    public String FeedTestApi(){
    	return "api feed ctrl ok!";
    }

    @RequestMapping(value = "batchfeedregister",produces = "application/json; charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public String BatchFeedRegister(@RequestBody JSONObject json, HttpServletRequest request) {
        String result = "";
        String data = json.getString("data");
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            String managerstr = redisService.get("token:" + token);
            Manager manager = ((Manager) JSONUtil.JSONToObj(managerstr, Manager.class));
            //权限控制

            JSONArray arr = JSON.parseArray(data);
            List<Feed> feedlist = new ArrayList<>();
            Feed feed = null;
            for(Object obj:arr){
                feed = new Feed();
                feed.setFeedId(((JSONObject)obj).get("feed_id")+"");
                feed.setPillCode(((JSONObject)obj).get("pill_code")+"");
                feed.setProduceTime(new Date(Long.valueOf(((JSONObject)obj).get("producetime")+"")));
                feed.setRegisterTime(new Date());
                feedlist.add(feed);
            }
            if(feedlist.size()>0){
                boolean isSuccess = feedService.batchFeedRegister(feedlist);
                if(isSuccess){
                    result = "批量注册喂饲器成功!";
                }else{
                    result = "批量注册喂饲器失败!";
                }
            }
        }catch (Exception e) {
            result = "批量注册喂饲器失败!";
        }
        return result.toString();
    }


    @ApiOperation(value = "单个喂饲器注册", notes = "单个喂饲器注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "feed_id", value = "喂饲器标识", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "pill_code", value = "药编号", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "producetime", value = "生产日期", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="singlefeedregister",method = RequestMethod.POST)
    @Transactional
    @ResponseBody
    public ResponseEntity<JsonResult> singleFeedRegister(@RequestParam(value = "feed_id")String feed_id, @RequestParam(value = "pill_code")String pill_code, @RequestParam(value = "producetime")String producetime, HttpServletRequest request){
        JsonResult r = new JsonResult();
        try {
            Feed feed = new Feed();
            feed.setFeedId(feed_id);
            feed.setPillCode(pill_code);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");//注意格式化的表达式
            feed.setProduceTime(format.parse(producetime));
            feed.setRegisterTime(new Date());
            boolean isSuccess = feedService.singleFeedRegister(feed);
            if(isSuccess){
                r.setCode(200);
                r.setMsg("注册喂饲器成功!");
                r.setData(feed);
                r.setSuccess(true);
            }else{
                r.setCode(500);
                r.setData(null);
                r.setMsg("注册喂饲器失败！");
                r.setSuccess(false);
            }
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("注册喂饲器失败！");
            r.setSuccess(false);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    @ApiOperation(value = "喂饲器配对激活", notes = "喂饲器配对激活")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "feedid", value = "喂饲器标识", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "dogid", value = "犬只编号", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="bindfeed",method = RequestMethod.POST)
    @Transactional
    @ResponseBody
    public ResponseEntity<JsonResult> bindFeed(@RequestParam(value = "feedid")String feedid, @RequestParam(value = "dogid")Integer dogid, HttpServletRequest request){
        JsonResult r = new JsonResult();
        try {
            boolean isSuccess = feedService.bindFeed(feedid,dogid);
            if(isSuccess){
                r.setCode(200);
                r.setMsg("绑定喂饲器成功!");
                r.setData(null);
                r.setSuccess(true);
            }else{
                r.setCode(500);
                r.setData(null);
                r.setMsg("绑定喂饲器失败！");
                r.setSuccess(false);
            }
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("绑定喂饲器失败！");
            r.setSuccess(false);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    @ApiOperation(value = "获取某村主人名下绑定喂饲器列表", notes = "获取某村主人名下绑定喂饲器列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "hamletcode", value = "村行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "ownerid", value = "主人标识", required = true , dataType = "String",paramType = "query"),
    })
    @RequestMapping(value="gethamletfeedlist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetHamletOwnerList(@RequestParam(value = "hamletcode",required = true)String hamletcode,@RequestParam(value = "ownerid",required = true)Integer ownerid, HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制

            Map<String, Object> map = feedService.getHamletOwnerFeedList(hamletcode,ownerid);
            r.setCode(200);
            r.setMsg("获取某村绑定喂饲器列表信息成功！");
            r.setData(map);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取某村绑定喂饲器列表信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    //获取喂饲器列表，根据地区编号
    @ApiOperation(value = "获取喂饲器列表", notes = "获取喂饲器列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startitem", value = "startitem", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pagesize", value = "pagesize", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "level", value = "地区等级", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "districtcode", value = "行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getfeedlist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetFeedList(@RequestParam(value = "startitem") int startitem,@RequestParam(value = "pagesize") int pagesize,@RequestParam(value = "level",required = true)String level,@RequestParam(value = "districtcode",required = true)String districtcode, HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制

            switch (level){
                case "province":
                    districtcode = districtcode.substring(0,2);
                    break;
                case "city":
                    districtcode = districtcode.substring(0,4);
                    break;
                case "county":
                    districtcode = districtcode.substring(0,6);
                    break;
                case "village":
                    districtcode = districtcode.substring(0,9);
                    break;
            }
            Map<String, Object> map = feedService.getFeedList(districtcode==null?"":districtcode,startitem,pagesize);
            r.setCode(200);
            r.setMsg("获取喂饲器列表信息成功！");
            r.setData(map);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取喂饲器列表信息成功");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    //获取喂饲器列表，根据地区编号
    @ApiOperation(value = "获取经纬度列表", notes = "获取经纬度列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "level", value = "地区等级", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "districtcode", value = "行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "feedid", value = "喂饲器编号", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "begintime", value = "开始时间", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "endtime", value = "结束时间", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getfeedlnglatlist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetFeedLngLatList(@RequestParam(value = "level",required = true)String level,@RequestParam(value = "districtcode",required = true)String districtcode,@RequestParam(value = "feedid",required = true)String feedid,
                                                           @RequestParam(value = "begintime")String begintime,@RequestParam(value = "endtime")String endtime,HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制

            switch (level){
                case "province":
                    districtcode = districtcode.substring(0,2);
                    break;
                case "city":
                    districtcode = districtcode.substring(0,4);
                    break;
                case "county":
                    districtcode = districtcode.substring(0,6);
                    break;
                case "village":
                    districtcode = districtcode.substring(0,9);
                    break;
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");//注意格式化的表达式
            Map<String, Object> map = feedService.getFeedLngLat(districtcode==null?"":districtcode,format.parse(begintime),format.parse(endtime),feedid);
            r.setCode(200);
            r.setMsg("获取经纬度列表信息成功！");
            r.setData(map);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取经纬度列表信息失败！");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    //获取喂饲器列表，根据地区编号
    @ApiOperation(value = "获取电压温度列表", notes = "获取电压温度列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "level", value = "地区等级", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "districtcode", value = "行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "feedid", value = "喂饲器编号", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "begintime", value = "开始时间", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "endtime", value = "结束时间", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getfeedvoltemplist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetFeedVolTempList(@RequestParam(value = "level",required = true)String level,@RequestParam(value = "districtcode",required = true)String districtcode,@RequestParam(value = "feedid",required = true)String feedid,
                                                            @RequestParam(value = "begintime")String begintime,@RequestParam(value = "endtime")String endtime,HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制

            switch (level){
                case "province":
                    districtcode = districtcode.substring(0,2);
                    break;
                case "city":
                    districtcode = districtcode.substring(0,4);
                    break;
                case "county":
                    districtcode = districtcode.substring(0,6);
                    break;
                case "village":
                    districtcode = districtcode.substring(0,9);
                    break;
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");//注意格式化的表达式
            Map<String, Object> map = feedService.getFeedVolAndTemp(districtcode==null?"":districtcode,format.parse(begintime),format.parse(endtime),feedid);
            r.setCode(200);
            r.setMsg("获取温度电压列表信息成功！");
            r.setData(map);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取温度电压列表信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
}

