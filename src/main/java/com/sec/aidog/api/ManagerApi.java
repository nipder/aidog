package com.sec.aidog.api;

import com.sec.aidog.common.RedisUtil;
import com.sec.aidog.pojo.Manager;
import com.sec.aidog.service.RedisService;
import com.sec.aidog.service.UserService;
import com.sec.aidog.util.JSONUtil;
import com.sec.aidog.util.JsonResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("api")
@Controller
public class ManagerApi {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @ApiOperation(value = "获取当前用户信息", notes = "获取当前用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "username", value = "用户名标识", required = false, dataType = "String",paramType = "query")
    })
    @RequestMapping(value="getuserinfo",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<JsonResult> GetManagerInfo(@RequestParam(value = "username",required = false)String username,HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            r.setCode(200);
            r.setMsg("获取用户信息成功！");
            r.setData(managerstr);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取用户信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    @RequestMapping(value="/register/{id}", produces="text/html;charset=UTF-8",method=RequestMethod.GET)
    @ResponseBody
    public String register(@PathVariable(value="id")Integer id) {
        Map<String,Object> data = new HashMap<String,Object>();
        String json = null;
        switch(id) {
            case 1:
                json = redisService.get("_registerAllcities");
                if(json == null) {
                    try {
                        List<Map<String, String>> map = null;
                        map = userService.GetAllCities();
                        data.put("data1",map);
                        json = JSONObject.fromObject(data).toString();
                        redisService.remove("_registerAllcities");
                        redisService.set("_registerAllcities", json);
                        break;
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                break;
            case 2:
                json = redisService.get("_registerAllcounties");
                if(json == null) {
                    try {
                        List<Map<String, String>> map1 = userService.GetAllCities();
                        data.put("data1",map1);
                        List<Map<String, String>> map2 = userService.GetAllCounties();
                        data.put("data2",map2);
                        json = JSONObject.fromObject(data).toString();
                        redisService.remove("_registerAllcounties");
                        redisService.set("_registerAllcounties", json);
                        break;
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                break;
            case 3:
                json = redisService.get("_registerAllvillages");
                if(json == null) {
                    try {
                        List<Map<String, String>> map1 = userService.GetAllCities();
                        data.put("data1",map1);
                        List<Map<String, String>> map2 = userService.GetAllCounties();
                        data.put("data2",map2);
                        List<Map<String, String>> map3 = userService.GetAllVillages();
                        data.put("data3",map3);
                        json = JSONObject.fromObject(data).toString();
                        redisService.remove("_registerAllvillages");
                        redisService.set("_registerAllvillages", json);
                        break;
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                break;
            case 4:
                json = redisService.get("_registerAllhamlets");
                if(json == null) {
                    try {
                        List<Map<String, String>> map1 = userService.GetAllCities();
                        data.put("data1",map1);
                        List<Map<String, String>> map2 = userService.GetAllCounties();
                        data.put("data2",map2);
                        List<Map<String, String>> map3 = userService.GetAllVillages();
                        data.put("data3",map3);
                        List<Map<String, String>> map4 = userService.GetAllHamlets();
                        data.put("data4",map4);
                        json = JSONObject.fromObject(data).toString();
                        redisService.remove("_registerAllhamlets");
                        redisService.set("_registerAllhamlets", json);
                        break;
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                break;
        }
        return json;
    }


    @ApiOperation(value = "查询下属管理员列表", notes = "查询下属管理员列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="getunderuserlist",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<JsonResult> GetUnderManagerList(HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
//            String managerstr = redisService.get("token:"+token);
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            Manager manager = ((Manager) JSONUtil.JSONToObj(managerstr,Manager.class));
            int privilegelevel = manager.getPrivilegelevel();
            String districode = manager.getDistrictcode();
            switch (privilegelevel){
                case 1:
                    districode = "";
                    break;
                case 2:
                    districode = districode.substring(0,2);
                    break;
                case 3:
                    districode = districode.substring(0,4);
                    break;
                case 4:
                    districode = districode.substring(0,6);
                    break;
                case 5:
                    districode = districode.substring(0,9);
                    break;
            }
            List<Manager> managerlist = userService.getUnderManagers(privilegelevel,districode);
            //并不是任何信息都想返给前端
            List<Object> list = new ArrayList<>();
            int i = 1;
            for (Manager item:managerlist)
            {
                Map<String, Object> maptemp = new HashMap<String, Object>();
                maptemp.put("manager_id", item.getManagerId());
                maptemp.put("id", i);
                maptemp.put("username", item.getUsername());
                maptemp.put("manager_name", item.getManagerName());
                maptemp.put("register_time", item.getRegisterTime());
                maptemp.put("addr", item.getProvince()+item.getCity()+item.getCounty()+item.getVillage()+item.getHamlet());
                maptemp.put("manager_tel", item.getManagerTel());
                maptemp.put("manager_status", item.getManagerStatus());
                list.add(maptemp);
                i++;
            }
            r.setCode(200);
            r.setMsg("获取用户信息成功！");
            r.setData(list);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取下属用户列表失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    @ApiOperation(value = "激活/冻结/重置管理员密码", notes = "激活/冻结/重置管理员密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "managerid", value = "用户标识", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "flag", value = "激活/冻结/重置标识（1,0,2）", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header")
    })
    @RequestMapping(value="activeorfreezeuser",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> ActiveOrFreezeUser(@RequestParam(value = "managerid")Integer managerid,@RequestParam(value = "flag")Integer flag,HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            String managerstr = redisService.get("token:"+token);
            Manager manager = ((Manager) JSONUtil.JSONToObj(managerstr,Manager.class));
            int privilegelevel = manager.getPrivilegelevel();
            String districode = manager.getDistrictcode();
            Manager underManager = userService.selectByPrimaryKey(managerid);

            int level_2 = underManager.getPrivilegelevel();
            String districode_2 = underManager.getDistrictcode();

            if(level_2 <= privilegelevel){
                r.setCode(500);
                r.setMsg("您无权限操作更高级或平级管理员！");
                r.setData(null);
                r.setSuccess(false);
                return ResponseEntity.ok(r);
            }
            boolean tempflag = true;
            switch (privilegelevel){
                case 2:
                    districode = districode.substring(0,2);
                    if(!districode_2.substring(0,2).equals(districode)){
                        tempflag = false;
                    }
                    break;
                case 3:
                    districode = districode.substring(0,4);
                    if(!districode_2.substring(0,4).equals(districode)){
                        tempflag = false;
                    }
                    break;
                case 4:
                    districode = districode.substring(0,6);
                    if(!districode_2.substring(0,6).equals(districode)){
                        tempflag = false;
                    }
                    break;
                case 5:
                    districode = districode.substring(0,9);
                    if(!districode_2.substring(0,9).equals(districode)){
                        tempflag = false;
                    }
                    break;
            }
            if(!tempflag){
                r.setCode(500);
                r.setMsg("您无权限管理非所辖区域管理员！");
                r.setData(null);
                r.setSuccess(false);
                return ResponseEntity.ok(r);
            }
            boolean result = false;
            switch (flag){
                //激活用户
                case 1:
                    result = userService.activeManager(managerid);
                    r.setMsg("激活管理员成功！");
                    break;
                case 0:
                    result = userService.freezeManager(managerid);
                    r.setMsg("冻结管理员成功！");
                    break;
                case 2:
                    result = userService.resetManagerPwd(managerid,"yXVUkR45PFz0UfpbDB8/ew==");   //默认为123456
                    r.setMsg("重置管理员密码成功！ 重置后密码为：123456");
                    break;
            }
            if(result){
                r.setCode(200);
                r.setData(null);
                r.setSuccess(true);
            }else{
                r.setCode(500);
                r.setMsg("操作失败！");
                r.setData(null);
                r.setSuccess(false);
            }
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("服务器网络不好，操作下级用户信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    @RequestMapping(value = "modifypersonalinfo",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String indexApi(@RequestBody JSONObject senddata, HttpServletRequest request) {
        String clickType = senddata.getString("clicktype");
        String username = senddata.getString("username");
        String jsStr = null;
        //确认修改
        if(clickType.equals("modifyself")) {
            String manager_name = senddata.getString("managername");
            String workplace = senddata.getString("managerjob");
            String manager_identity = senddata.getString("manageridentity");
            String officetel = senddata.getString("officecall");
            String manager_tel = senddata.getString("managertel");
            String manager_addr = senddata.getString("manageraddress");
            String manager_email = senddata.getString("email");
            String password = senddata.getString("password");
            String result = "";
            try {
                String token = request.getHeader("token");
                result = userService.modifyUser(username, manager_name, workplace, manager_identity, officetel, manager_tel, manager_addr, manager_email, password,token);
            } catch (Exception e) {
                result = "修改失败！";
            }
            jsStr =  result;
        }
        return jsStr;
    }


    @ApiOperation(value = "获取某村管理员列表", notes = "获取某村管理员列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "通行证", required = true, dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "hamletcode", value = "村行政编码", required = true , dataType = "String",paramType = "query")
    })
    @RequestMapping(value="gethamletmanagerlist",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetHamletManagerList(@RequestParam(value = "hamletcode",required = true)String hamletcode, HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制

            Map<String, Object> map = userService.getHamletManagerList(hamletcode);
            r.setCode(200);
            r.setMsg("获取村管理员列表信息成功！");
            r.setData(map);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取村管理员列表信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
}
