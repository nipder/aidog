package com.sec.aidog.api;

import com.sec.aidog.common.RedisUtil;
import com.sec.aidog.service.DogService;
import com.sec.aidog.util.JsonResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("api")
@Controller
public class StatisticsApi {


    @Autowired
    private DogService dogService;

    //获取犬只统计信息
    @ApiOperation(value = "获取犬只统计信息", notes = "获取犬只统计信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startitem", value = "startitem", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pagesize", value = "pagesize", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "level", value = "地区等级", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "districtcode", value = "行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getdogstalist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetDogStaList(@RequestParam(value = "startitem") int startitem, @RequestParam(value = "pagesize") int pagesize, @RequestParam(value = "level",required = true)String level, @RequestParam(value = "districtcode",required = true)String districtcode, HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制

            switch (level){
                case "":
                    districtcode = "0";
                    break;
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
            Map<String, Object> map = dogService.getDogStaList(districtcode,startitem,pagesize);
            r.setCode(200);
            r.setMsg("获取牧犬统计信息成功！");
            r.setData(map);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取牧犬统计信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    //获取设备故障统计信息
    @ApiOperation(value = "获取设备故障统计信息", notes = "获取设备故障统计信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startitem", value = "startitem", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pagesize", value = "pagesize", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "level", value = "地区等级", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "districtcode", value = "行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getdevicestalist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetDeviceStaList(@RequestParam(value = "startitem") int startitem, @RequestParam(value = "pagesize") int pagesize, @RequestParam(value = "level",required = true)String level, @RequestParam(value = "districtcode",required = true)String districtcode, HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制

            switch (level){
                case "":
                    districtcode = "0";
                    break;
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
            Map<String, Object> map = dogService.getDeviceStaList(districtcode,startitem,pagesize);
            r.setCode(200);
            r.setMsg("获取牧犬统计信息成功！");
            r.setData(map);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取牧犬统计信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    //获取犬只统计信息
    @ApiOperation(value = "获取患病统计信息", notes = "获取患病统计信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startitem", value = "startitem", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pagesize", value = "pagesize", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "level", value = "地区等级", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "districtcode", value = "行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getillstalist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetIllStaList(@RequestParam(value = "startitem") int startitem, @RequestParam(value = "pagesize") int pagesize, @RequestParam(value = "level",required = true)String level, @RequestParam(value = "districtcode",required = true)String districtcode, HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制

            switch (level){
                case "":
                    districtcode = "0";
                    break;
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
            Map<String, Object> map = dogService.getIllStaList(districtcode,startitem,pagesize);
            r.setCode(200);
            r.setMsg("获取患病统计信息成功！");
            r.setData(map);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取患病统计信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    //获取犬只统计信息
    @ApiOperation(value = "获取人群患病情况信息", notes = "获取人群患病情况信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startitem", value = "startitem", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pagesize", value = "pagesize", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "level", value = "地区等级", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "districtcode", value = "行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getbillstalist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetBillStaList(@RequestParam(value = "startitem") int startitem, @RequestParam(value = "pagesize") int pagesize, @RequestParam(value = "level",required = true)String level, @RequestParam(value = "districtcode",required = true)String districtcode, HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制

            switch (level){
                case "":
                    districtcode = "0";
                    break;
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
            Map<String, Object> map = dogService.getBillStaList(districtcode,startitem,pagesize);
            r.setCode(200);
            r.setMsg("获取患病统计信息成功！");
            r.setData(map);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取患病统计信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    @ApiOperation(value = "获取人群患病情况信息", notes = "获取人群患病情况信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startitem", value = "startitem", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pagesize", value = "pagesize", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "level", value = "地区等级", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "districtcode", value = "行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getanabillstalist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetAnaBillStaList(@RequestParam(value = "startitem") int startitem, @RequestParam(value = "pagesize") int pagesize, @RequestParam(value = "level",required = true)String level, @RequestParam(value = "districtcode",required = true)String districtcode, HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制

            switch (level){
                case "":
                    districtcode = "0";
                    break;
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
            Map<String, Object> map = dogService.getAnaBillStaList(districtcode,startitem,pagesize);
            r.setCode(200);
            r.setMsg("获取患病统计信息成功！");
            r.setData(map);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取患病统计信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    @ApiOperation(value = "获取人群血清学情况信息", notes = "获取人群血清学情况信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startitem", value = "startitem", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pagesize", value = "pagesize", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "level", value = "地区等级", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "districtcode", value = "行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getanachildcheckstalist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetAnaChildCheckStaList(@RequestParam(value = "startitem") int startitem, @RequestParam(value = "pagesize") int pagesize, @RequestParam(value = "level",required = true)String level, @RequestParam(value = "districtcode",required = true)String districtcode, HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制

            switch (level){
                case "":
                    districtcode = "0";
                    break;
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
            Map<String, Object> map = dogService.getAnaChildCheckStaList(districtcode,startitem,pagesize);
            r.setCode(200);
            r.setMsg("获取血清学统计信息成功！");
            r.setData(map);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取血清学统计信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    @ApiOperation(value = "获取家畜分析情况信息", notes = "获取家畜分析情况信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startitem", value = "startitem", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pagesize", value = "pagesize", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "level", value = "地区等级", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "districtcode", value = "行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getanaanimalillstalist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetAnaDogillStaList(@RequestParam(value = "startitem") int startitem, @RequestParam(value = "pagesize") int pagesize, @RequestParam(value = "level",required = true)String level, @RequestParam(value = "districtcode",required = true)String districtcode, HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制

            switch (level){
                case "":
                    districtcode = "0";
                    break;
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
            Map<String, Object> map = dogService.getAnaAnimalillStaList(districtcode,startitem,pagesize);
            r.setCode(200);
            r.setMsg("获取犬感染统计信息成功！");
            r.setData(map);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取犬感染统计信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    @ApiOperation(value = "获取犬只分析情况信息", notes = "获取犬只分析情况信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startitem", value = "startitem", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pagesize", value = "pagesize", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "level", value = "地区等级", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "districtcode", value = "行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getanadogillStaList",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> getAnaDogillStaList(@RequestParam(value = "startitem") int startitem, @RequestParam(value = "pagesize") int pagesize, @RequestParam(value = "level",required = true)String level, @RequestParam(value = "districtcode",required = true)String districtcode, HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制

            switch (level){
                case "":
                    districtcode = "0";
                    break;
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
            Map<String, Object> map = dogService.getAnaDogillStaList(districtcode,startitem,pagesize);
            r.setCode(200);
            r.setMsg("获取犬感染统计信息成功！");
            r.setData(map);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取犬感染统计信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    //获取家畜情况信息
    @ApiOperation(value = "获取家畜情况信息", notes = "获取家畜情况信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startitem", value = "startitem", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pagesize", value = "pagesize", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "level", value = "地区等级", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "districtcode", value = "行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getanimallist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetAnimalillList(@RequestParam(value = "startitem") int startitem, @RequestParam(value = "pagesize") int pagesize, @RequestParam(value = "level",required = true)String level, @RequestParam(value = "districtcode",required = true)String districtcode, HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制

            switch (level){
                case "":
                    districtcode = "0";
                    break;
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
            Map<String, Object> map = dogService.getAnimalillList(districtcode,startitem,pagesize);
            r.setCode(200);
            r.setMsg("获取家畜列表信息成功！");
            r.setData(map);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取家畜列表信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    //获取儿童血清学情况信息
    @ApiOperation(value = "获取儿童血清学情况信息", notes = "获取儿童血清学情况信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startitem", value = "startitem", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pagesize", value = "pagesize", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "level", value = "地区等级", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "districtcode", value = "行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getchildchecklist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetChildcheckList(@RequestParam(value = "startitem") int startitem, @RequestParam(value = "pagesize") int pagesize, @RequestParam(value = "level",required = true)String level, @RequestParam(value = "districtcode",required = true)String districtcode, HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制

            switch (level){
                case "":
                    districtcode = "0";
                    break;
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
            Map<String, Object> map = dogService.getChildCheckList(districtcode,startitem,pagesize);
            r.setCode(200);
            r.setMsg("获取儿童列表信息成功！");
            r.setData(map);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取儿童列表信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    //获取儿童患病情况信息
    @ApiOperation(value = "获取儿童患病情况信息", notes = "获取儿童患病情况信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startitem", value = "startitem", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pagesize", value = "pagesize", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "level", value = "地区等级", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "districtcode", value = "行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getchildilllist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetChildillList(@RequestParam(value = "startitem") int startitem, @RequestParam(value = "pagesize") int pagesize, @RequestParam(value = "level",required = true)String level, @RequestParam(value = "districtcode",required = true)String districtcode, HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制

            switch (level){
                case "":
                    districtcode = "0";
                    break;
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
            Map<String, Object> map = dogService.getChildIllList(districtcode,startitem,pagesize);
            r.setCode(200);
            r.setMsg("获取儿童列表信息成功！");
            r.setData(map);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取儿童列表信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
}
