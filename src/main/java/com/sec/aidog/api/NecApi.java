package com.sec.aidog.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sec.aidog.common.RedisUtil;
import com.sec.aidog.dao.DevPillRecMapper;
import com.sec.aidog.dao.NeckletMapper;
import com.sec.aidog.pojo.DevPillRec;
import com.sec.aidog.pojo.Feed;
import com.sec.aidog.pojo.Manager;
import com.sec.aidog.pojo.Necklet;
import com.sec.aidog.service.NeckletService;
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
public class NecApi {

    @Autowired
    private NeckletService neckletService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private NeckletMapper neckletMapper;

    @Autowired
    private DevPillRecMapper devPillRecMapper;

    @RequestMapping(value = "batchnecregister",produces = "application/json; charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public String BatchNecRegister(@RequestBody JSONObject json, HttpServletRequest request) {
        String result = "";
        String data = json.getString("data");
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            String managerstr = redisService.get("token:" + token);
            Manager manager = ((Manager) JSONUtil.JSONToObj(managerstr, Manager.class));
            //权限控制

            JSONArray arr = JSON.parseArray(data);
            List<Necklet> neclist = new ArrayList<>();
            Necklet necklet = null;
            for(Object obj:arr){
                necklet = new Necklet();
                necklet.setNecId(((JSONObject)obj).get("nec_id")+"");
                necklet.setPillCode(((JSONObject)obj).get("pill_code")+"");
                necklet.setProduceTime(new Date(Long.valueOf(((JSONObject)obj).get("producetime")+"")));
                necklet.setRegisterTime(new Date());
                necklet.setChangepillTime(necklet.getRegisterTime());
                neclist.add(necklet);
            }
            if(neclist.size()>0){
                boolean isSuccess = neckletService.batchNecRegister(neclist);
                isSuccess = batchNecPillRecByNecList(neclist);
                if(isSuccess){
                    result = "批量注册项圈成功!";
                }else{
                    result = "批量注册项圈失败!";
                }
            }
        }catch (Exception e) {
            result = "批量注册项圈失败!";
        }
        return result.toString();
    }

    @SuppressWarnings("unused")
	private boolean batchNecPillRecByNecList(List<Necklet> neclist){
    	boolean bRtn = false;
    	for(Necklet nec:neclist){
    		DevPillRec devPillRec = new DevPillRec();
    		devPillRec.setMid(nec.getNecId());
            devPillRec.setPillCode(nec.getPillCode());
            devPillRec.setConfigTime(nec.getChangepillTime());
            boolean flge = devPillRecMapper.insert(devPillRec) > 0 ? true : false;
    	}
    	bRtn = true;
    	return bRtn;
    }

    @ApiOperation(value = "单个项圈注册", notes = "单个项圈注册")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "nec_id", value = "项圈标识", required = true, dataType = "String",paramType = "query"),
        @ApiImplicitParam(name = "pill_code", value = "药编号", required = true, dataType = "String",paramType = "query"),
        @ApiImplicitParam(name = "producetime", value = "生产日期", required = true, dataType = "String",paramType = "query"),
        @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="singlenecregister",method = RequestMethod.POST)
    @Transactional
    @ResponseBody
    public ResponseEntity<JsonResult> singleNecRegister(@RequestParam(value = "nec_id")String nec_id, @RequestParam(value = "pill_code")String pill_code, @RequestParam(value = "producetime")String producetime, HttpServletRequest request){
        JsonResult r = new JsonResult();
        try {
            Necklet necklet = new Necklet();
            necklet.setNecId(nec_id);
            necklet.setPillCode(pill_code);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");//注意格式化的表达式
            necklet.setProduceTime(format.parse(producetime));
            necklet.setRegisterTime(new Date());
            necklet.setChangepillTime(necklet.getRegisterTime());
            boolean isSuccess = neckletService.singleNecRegister(necklet);
            if(isSuccess){
            	DevPillRec devPillRec = new DevPillRec();
        		devPillRec.setMid(necklet.getNecId());
                devPillRec.setPillCode(necklet.getPillCode());
                devPillRec.setConfigTime(necklet.getChangepillTime());
                boolean flge = devPillRecMapper.insert(devPillRec) > 0 ? true : false;
            }
            if(isSuccess){
                r.setCode(200);
                r.setMsg("注册项圈成功!");
                r.setData(necklet);
                r.setSuccess(true);
            }else{
                r.setCode(500);
                r.setData(null);
                r.setMsg("注册项圈失败！");
                r.setSuccess(false);
            }
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("注册项圈失败！");
            r.setSuccess(false);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    @ApiOperation(value = "项圈配对激活", notes = "项圈配对激活")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "necid", value = "项圈标识", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "dogid", value = "犬只编号", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="bindnecklet",method = RequestMethod.POST)
    @Transactional
    @ResponseBody
    public ResponseEntity<JsonResult> bindNecklet(@RequestParam(value = "necid")String necid, @RequestParam(value = "dogid")Integer dogid, HttpServletRequest request){
        JsonResult r = new JsonResult();
        try {
            boolean isSuccess = neckletService.bindNecklet(necid,dogid);
            if(isSuccess){
                r.setCode(200);
                r.setMsg("绑定项圈成功!");
                r.setData(null);
                r.setSuccess(true);
            }else{
                r.setCode(500);
                r.setData(null);
                r.setMsg("绑定项圈失败！");
                r.setSuccess(false);
            }
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("绑定项圈失败！");
            r.setSuccess(false);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    @ApiOperation(value = "获取某村主人名下绑定项圈列表", notes = "获取某村主人名下绑定项圈列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "hamletcode", value = "村行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "ownerid", value = "主人标识", required = true , dataType = "String",paramType = "query"),
    })
    @RequestMapping(value="gethamletneclist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetHamletOwnerList(@RequestParam(value = "hamletcode",required = true)String hamletcode,@RequestParam(value = "ownerid",required = true)Integer ownerid, HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制

            Map<String, Object> map = neckletService.getHamletOwnerNecList(hamletcode,ownerid);
            r.setCode(200);
            r.setMsg("获取某村绑定项圈列表信息成功！");
            r.setData(map);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取某村绑定项圈列表信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    //获取项圈列表，根据地区编号
    @ApiOperation(value = "获取项圈列表", notes = "获取项圈列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startitem", value = "startitem", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pagesize", value = "pagesize", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "level", value = "地区等级", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "districtcode", value = "行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getneclist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetNeckletList(@RequestParam(value = "startitem") int startitem,@RequestParam(value = "pagesize") int pagesize,@RequestParam(value = "level",required = true)String level,@RequestParam(value = "districtcode",required = true)String districtcode, HttpServletRequest request){
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
            Map<String, Object> map = neckletService.getNeckletList(districtcode==null?"":districtcode,startitem,pagesize);
            r.setCode(200);
            r.setMsg("获取项圈列表信息成功！");
            r.setData(map);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取项圈列表信息成功");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    //获取项圈列表，根据地区编号
    @ApiOperation(value = "获取经纬度列表", notes = "获取经纬度列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "level", value = "地区等级", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "districtcode", value = "行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "necid", value = "项圈编号", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "begintime", value = "开始时间", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "endtime", value = "结束时间", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getneclnglatlist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetNeckletLngLatList(@RequestParam(value = "level",required = true)String level,@RequestParam(value = "districtcode",required = true)String districtcode,@RequestParam(value = "necid",required = true)String necid,
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
            Map<String, Object> map = neckletService.getNeckletLngLat(districtcode==null?"":districtcode,format.parse(begintime),format.parse(endtime),necid);
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


    //获取项圈列表，根据地区编号
    @ApiOperation(value = "获取电压温度列表", notes = "获取电压温度列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "level", value = "地区等级", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "districtcode", value = "行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "necid", value = "项圈编号", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "begintime", value = "开始时间", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "endtime", value = "结束时间", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getnecvoltemplist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetNeckletVolTempList(@RequestParam(value = "level",required = true)String level,@RequestParam(value = "districtcode",required = true)String districtcode,@RequestParam(value = "necid",required = true)String necid,
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
            Map<String, Object> map = neckletService.getNeckletVolAndTemp(districtcode==null?"":districtcode,format.parse(begintime),format.parse(endtime),necid);
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
    
    @RequestMapping(value = "/batchnecpillbind", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> BatchNecPillBind( HttpServletRequest request, @RequestBody JSONObject json){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制
            String mids = json.getString("mids");
            String pill_code = json.getString("pill_code");
            String configtime = json.getString("configtime");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date configTime = format.parse(configtime);

            if(mids.contains("|")){
                String[] midarr = mids.split("\\|");
                for(int i=0;i<midarr.length;i++){
                    r = NecPillBind(midarr[i], pill_code, configTime);
                }
            }else{
                r = NecPillBind(mids, pill_code, configTime);
            }
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("药饵配对失败4");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    private JsonResult NecPillBind(String mid, String pill_code, Date configTime){
        JsonResult r = new JsonResult();
        try {
        	Necklet nec = neckletMapper.selectByNecId(mid);
        	nec.setPillCode(pill_code);
        	nec.setChangepillTime(configTime);
            boolean flge = neckletMapper.updateByPrimaryKey(nec)==1?true:false;
            DevPillRec devPillRec = new DevPillRec();
            if(flge){
                devPillRec.setMid(mid);
                devPillRec.setPillCode(pill_code);
                devPillRec.setConfigTime(configTime);
                flge = devPillRecMapper.insert(devPillRec) > 0 ? true : false;
                if(flge){
                    r.setCode(200);
                    r.setMsg("配置项圈药饵配对成功！");
                    r.setData(devPillRec);
                    r.setSuccess(true);
                }else{
                    r.setCode(500);
                    r.setData(null);
                    r.setMsg("配置项圈药饵配对失败2");
                    r.setSuccess(false);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                }
            }else{
                r.setCode(500);
                r.setData(null);
                r.setMsg("配置项圈药饵配对失败1");
                r.setSuccess(false);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("配置项圈药饵失败3");
            r.setSuccess(false);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return r;
    }
}

