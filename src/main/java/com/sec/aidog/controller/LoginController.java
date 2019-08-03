package com.sec.aidog.controller;

import com.sec.aidog.common.Constant;
import com.sec.aidog.pojo.Manager;
import com.sec.aidog.service.RedisService;
import com.sec.aidog.service.UserService;
import com.sec.aidog.util.JSONUtil;
import com.sec.aidog.util.JsonResult;

import com.sec.aidog.util.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;
    /**
     * 登录
     * @param request
     * @param username
     * @return
     */
    @PostMapping(value = "/sublogin")
    @ResponseBody
    public JsonResult sublogin(HttpServletRequest request, @RequestParam String username, @RequestParam String password){
        //判断登录
        try{
            //userService为自己定义的Service类
            Manager manager = userService.userLogin(username, password);
            if(manager!=null){
                //PassHandle为自己定义的一个生成Token的类，可以根据自己喜好来改
                String token = TokenGenerator.generateValue();
                manager.setPassword(password);
                //将token存到redis缓存中
                String managerjson = JSONUtil.objectToJson(manager).toString();
                redisService.set("token:"+ token, managerjson);
                String originusername = redisService.get("token:" + manager.getUsername());
                if(originusername!=""&&originusername!=null){
                    //只让一个人登录
                    redisService.remove("token:"+manager.getUsername());
                }
                redisService.set("token:"+manager.getUsername(),token);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("token", token);     //此data为token
                jsonObject.put("data",manager);
                return new JsonResult(Constant.SUCCESS.getCode(), "登录"+Constant.SUCCESS.getMsg(),true, jsonObject);
            } else
                return new JsonResult(Constant.LOGIN_EXCEPTION.getCode(), Constant.LOGIN_EXCEPTION.getMsg(),false, null);
        }catch (Exception e){
            return new JsonResult(Constant.LOGIN_EXCEPTION.getCode(), Constant.LOGIN_EXCEPTION.getMsg(),false, null);
        }
    }


    @GetMapping(value = "/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath()+"/adminlte/pages/login.html");
    }


    @GetMapping(value = "/logout")
    @ResponseBody
    public String logout(String username) throws IOException {
        //删除Redis中缓存的token
        String originusername = redisService.get("token:" + username);
        if(originusername!=""&&originusername!=null){
            redisService.remove("token:"+username);
        }
        return "success";
    }

}
