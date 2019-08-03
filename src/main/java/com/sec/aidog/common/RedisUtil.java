package com.sec.aidog.common;

import com.sec.aidog.service.RedisService;
import com.sec.aidog.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {

    private static RedisService redisService;

    public RedisUtil(RedisService redisService){
        RedisUtil.redisService = redisService;
    }

    public static JsonResult ConnectRedisCheckToken(String token){
        String tokenvalue = "";
        JsonResult r = new JsonResult();
        int retry = 1;
        while (retry<=5){
            try
            {
                //业务代码
                tokenvalue = redisService.get(token);
                r.setCode(200);
                r.setData(tokenvalue);
                r.setMsg("连接成功！");
                r.setSuccess(true);
                break;
            }
            catch(Exception ex)
            {
                //重试
                retry++;
                if(retry == 6){
                    //记录错误
                    r.setCode(Constant.Redis_TIMEDOWN.getCode());
                    r.setData("");
                    r.setMsg(Constant.Redis_TIMEDOWN.getMsg());
                    r.setSuccess(false);
                    return r;
                }
            }
        }
        return r;
    }

    public static String RedisGetValue(String token){
        String tokenvalue = null;
        JsonResult r = new JsonResult();
        int retry = 1;
        while (retry<=3){
            try
            {
                //业务代码
                tokenvalue = redisService.get(token);
                break;
            }
            catch(Exception ex)
            {
                //重试
                retry++;
                if(retry == 4){
                    return null;
                }
            }
        }
        return tokenvalue;
    }

}
