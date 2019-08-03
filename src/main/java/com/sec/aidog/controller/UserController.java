package com.sec.aidog.controller;

import com.sec.aidog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value="register", produces="text/html;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestParam(value="privilegelevel")Integer privilegelevel, @RequestParam(value="username")String username,
                          @RequestParam(value="managername")String managername, @RequestParam(value="address")String address,
                          @RequestParam(value="identity")String identity, @RequestParam(value="area")String area,
                          @RequestParam(value="officecall")String officecall, @RequestParam(value="tel")String tel,
                          @RequestParam(value="password")String password, @RequestParam(value="addtype")String addtype) {
        String json = "";
        try {
            json = userService.addUser(addtype, privilegelevel, username, managername, address, identity, area, officecall, tel, password);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return json;
    }
}
