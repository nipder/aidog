package com.sec.aidog.api;

import com.sec.aidog.common.RedisUtil;
import com.sec.aidog.pojo.DevPillRecView;
import com.sec.aidog.service.DevPillRecService;
import com.sec.aidog.service.PillService;
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
import java.util.List;
import java.util.Map;

@RequestMapping("api")
@Controller
public class PillApi {

    @Autowired
    private PillService pillService;

    @Autowired
    private DevPillRecService devPillRecService;

    //获取牧犬列表，根据地区编号
    @ApiOperation(value = "获取药饵列表", notes = "获取药饵列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startitem", value = "startitem", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pagesize", value = "pagesize", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "level", value = "地区等级", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "districtcode", value = "行政编码", required = true , dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getpilllist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetDogList(@RequestParam(value = "startitem") int startitem, @RequestParam(value = "pagesize") int pagesize, @RequestParam(value = "level",required = true)String level, @RequestParam(value = "districtcode",required = true)String districtcode, HttpServletRequest request){
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
            Map<String, Object> map = pillService.getPillList(districtcode,startitem,pagesize);
            r.setCode(200);
            r.setMsg("获取药饵列表信息成功！");
            r.setData(map);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取药饵列表信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    @RequestMapping(value="getpillbindreclist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetPillBindRecList(@RequestParam(value = "mid",required = true)String mid, HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制

            List<DevPillRecView> list = devPillRecService.GetPillBindRecList(mid);
            r.setCode(200);
            r.setMsg("获取药饵配对记录成功！");
            r.setData(list);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取药饵配对记录失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
}
