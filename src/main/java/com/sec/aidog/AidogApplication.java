package com.sec.aidog;

import com.sec.aidog.service.RedisService;
import com.sec.aidog.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

//@SpringBootApplication
//@EnableSwagger2
//public class AidogApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(AidogApplication.class, args);
//	}
//}


//for war
@EnableCaching
@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
public class AidogApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AidogApplication.class);
	}
	public static void main( String[] args ){
		SpringApplication.run(AidogApplication.class, args);
	}

	@Autowired
	private UserService userService;

	@Autowired
	private RedisService redisService;

	@PostConstruct
	private void init(){
		changestatus(127);

		Map<String,Object> data = new HashMap<String,Object>();
		try {
			List<Map<String, String>> map1 = userService.GetAllCities();
			data.put("data1",map1);
			List<Map<String, String>> map2 = userService.GetAllCounties();
			data.put("data2",map2);
			List<Map<String, String>> map3 = userService.GetAllVillages();
			data.put("data3",map3);
			List<Map<String, String>> map4 = userService.GetAllHamlets();
			data.put("data4",map4);
			String json = JSONObject.fromObject(data).toString();
			redisService.remove("_registerAllhamlets");
			redisService.set("_registerAllhamlets", json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String changestatus(Integer int_status){
		String status = Integer.toBinaryString(int_status);
		byte[] bytes = status.getBytes();
		//倒置
		for (int l = 0, h = status.length() - 1; l < h; l++, h--) {
			// Swap values at l and h
			byte temp = bytes[l];
			bytes[l] = bytes[h];
			bytes[h] = temp;
		}
		status = new String(bytes);
		while(status.length()<16){
			status = status+"0";
		}
//        status = status.substring(0,4)+"-"+status.substring(4,8)+"-"+status.substring(8,12)+"-"+status.substring(12,16);
//        System.out.println(status);
		return status;
	}
}
