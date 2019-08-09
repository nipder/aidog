package com.sec.aidog.api;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sec.aidog.dao.SysDeviceconfMapper;
import com.sec.aidog.pojo.SysDeviceconf;
import com.sec.aidog.service.RedisService;
import com.sec.aidog.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RequestMapping("api")
@Controller
public class SysDeviceConfApi {
	
	@Autowired
	private SysDeviceconfMapper sysDeviceconfMapper;
	
	@Autowired
    private RedisService redisService;

	@ApiOperation(value = "通过项圈编号查询项圈配置信息", notes = "通过项圈编号查询项圈配置信息")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "mid", value = "项圈标识", required = true, dataType = "String",paramType = "query")
	})
	@RequestMapping(value="getdeviceconfigbynecid",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetLayConfigByNeckletId(@RequestParam(value = "mid")String mid){
        JsonResult r = new JsonResult();
        try {
        	SysDeviceconf deviceconfig  = sysDeviceconfMapper.selectDeviceConfigByMid(mid);
        	if(deviceconfig!=null) {
        		r.setCode(200);
                r.setMsg("获取项圈配置信息成功！");
                r.setData(deviceconfig);
                r.setSuccess(true);
        	}else {
        		r.setCode(500);
                r.setData(null);
                r.setMsg("该项圈不存在，请先添加！");
                r.setSuccess(false);
        	}      
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("该项圈不存在，请先添加！");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
	
	
	
	@ApiOperation(value = "通过项圈编号配置项圈信息", notes = "通过项圈编号配置项圈信息")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "mid", value = "项圈标识", required = true, dataType = "String",paramType = "query"),
        @ApiImplicitParam(name = "simccid", value = "SIM_CCID", required = false, dataType = "String",paramType = "query"),
        @ApiImplicitParam(name = "swver", value = "版本号", required = false, dataType = "String",paramType = "query"),
        @ApiImplicitParam(name = "ip", value = "ip地址", required = false, dataType = "String",paramType = "query"),
        @ApiImplicitParam(name = "port", value = "端口号", required = false, dataType = "Integer",paramType = "query"),
        @ApiImplicitParam(name = "infoupdatecycle", value = "信息上传周期", required = false, dataType = "Integer",paramType = "query"),
        @ApiImplicitParam(name = "tickcycle", value = "心跳周期", required = false, dataType = "Integer",paramType = "query"),
		@ApiImplicitParam(name = "bastimes", value = "基站定位时间", required = false, dataType = "Byte",paramType = "query"),
		@ApiImplicitParam(name = "gpstimes", value = "GPS定位时间", required = false, dataType = "Byte",paramType = "query"),
        @ApiImplicitParam(name = "ledenable", value = "led使能", required = false, dataType = "Byte",paramType = "query"),
        @ApiImplicitParam(name = "tempflag", value = "临时投药标志", required = false, dataType = "Byte",paramType = "query"),
        @ApiImplicitParam(name = "tempgmt", value = "临时投药时间", required = false, dataType = "String",paramType = "query"),
        @ApiImplicitParam(name = "clearerr", value = "清除故障标志", required = false, dataType = "Byte",paramType = "query"),
        @ApiImplicitParam(name = "factory", value = "恢复出厂设置", required = false, dataType = "Byte",paramType = "query")
	})
	@RequestMapping(value="setdeviceconfigbynecid",method = RequestMethod.POST)
	@Transactional
    @ResponseBody
    public ResponseEntity<JsonResult> setDeviceConfigByNeckletId(@RequestParam(value = "mid")String mid,@RequestParam(value = "simccid",required = false)String simccid,@RequestParam(value = "swver",required = false)String swver,
    		@RequestParam(value = "ip",required = false)String ip,@RequestParam(value = "port",required = false)Integer port,
    		@RequestParam(value = "infoupdatecycle",required = false)Integer infoupdatecycle,@RequestParam(value = "tickcycle",required = false)Integer tickcycle,
			@RequestParam(value = "bastimes",required = false)Byte bastimes,@RequestParam(value = "gpstimes",required = false)Byte gpstimes,
    		@RequestParam(value = "ledenable",required = false)Byte ledenable,@RequestParam(value = "tempflag",required = false)Byte tempflag,
    		@RequestParam(value = "tempgmt",required = false)String tempgmt,@RequestParam(value = "clearerr",required = false)Byte clearerr,
    		@RequestParam(value = "factory",required = false)Byte factory){
        JsonResult r = new JsonResult();
		if(mid.contains("|")){
			String[] necarr = mid.split("\\|");
			for(int i=0;i<necarr.length;i++){
				r = setDeviceConfig(necarr[i],simccid,swver,ip,port,infoupdatecycle,tickcycle,bastimes,gpstimes,ledenable,tempflag,tempgmt,clearerr,factory);
			}
		}else{
			r = setDeviceConfig(mid,simccid,swver,ip,port,infoupdatecycle,tickcycle,bastimes,gpstimes,ledenable,tempflag,tempgmt,clearerr,factory);
		}
		return ResponseEntity.ok(r);

//        try {
//        	SysDeviceconf sysDeviceconf = sysDeviceconfMapper.selectDeviceConfigByMid(mid);
//        	sysDeviceconf.setSimccid(simccid);
//        	sysDeviceconf.setSwver(swver);
//        	sysDeviceconf.setIp(ip);
//        	sysDeviceconf.setPort(port);
//        	sysDeviceconf.setInfoupdatecycle(infoupdatecycle);
//        	sysDeviceconf.setTickcycle(tickcycle);
//			sysDeviceconf.setBastimes(bastimes);
//			sysDeviceconf.setGpstimes(gpstimes);
//        	sysDeviceconf.setLedenable(ledenable);
//        	sysDeviceconf.setTemporaryflag(tempflag);
//        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");//注意格式化的表达式
//        	sysDeviceconf.setTemporarygmt(format.parse(tempgmt));
//        	byte uimodifyflag = 1;
//        	sysDeviceconf.setUimodifyflag(uimodifyflag);
//        	byte hardmodifyflag = 0;
//        	sysDeviceconf.setHardmodifyflag(hardmodifyflag);
//        	sysDeviceconf.setUpdatetime(new Date());
//        	sysDeviceconf.setClearerr(clearerr);
//        	sysDeviceconf.setFactory(factory);
//
//        	boolean flag  = sysDeviceconfMapper.updateByPrimaryKey(sysDeviceconf)==1?true:false;
//        	boolean flag2  = false;
//        	if(flag) {
//        		String command03 = Analyse.Command_03_Send(sysDeviceconf);
//        		flag2  = redisService.setpersist("device_"+mid, command03);
//        	}
//        	if(flag2) {
//        		r.setCode(200);
//                r.setMsg("配置项圈信息成功！");
//                r.setData(null);
//                r.setSuccess(true);
//        	}else {
//        		r.setCode(500);
//                r.setData(null);
//                r.setMsg("服务器忙，配置项圈信息失败");
//                r.setSuccess(false);
//        	}
//        } catch (Exception e) {
//            r.setCode(500);
//            r.setData(e.getClass().getName() + ":" + e.getMessage());
//            r.setMsg("配置项圈信息失败");
//            r.setSuccess(false);
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            e.printStackTrace();
//        }
//        return ResponseEntity.ok(r);
    }

	public JsonResult setDeviceConfig(String mid,String simccid,String swver,String ip,Integer port,
																 Integer infoupdatecycle,Integer tickcycle,Byte bastimes,Byte gpstimes,
																 Byte ledenable,Byte tempflag,String tempgmt,Byte clearerr,Byte factory){
		JsonResult r = new JsonResult();

		try {
			SysDeviceconf sysDeviceconf = sysDeviceconfMapper.selectDeviceConfigByMid(mid);
			if(simccid!=null){
				sysDeviceconf.setSimccid(simccid);
			}
			if(swver!=null){
				sysDeviceconf.setSwver(swver);
			}
			if(ip!=null){
				sysDeviceconf.setIp(ip);
			}
			if(port!=null){
				sysDeviceconf.setPort(port);
			}
			if(infoupdatecycle!=null){
				sysDeviceconf.setInfoupdatecycle(infoupdatecycle);
			}
			if(tickcycle!=null){
				sysDeviceconf.setTickcycle(tickcycle);
			}
			if(bastimes!=null){
				sysDeviceconf.setBastimes(bastimes);
			}
			if(gpstimes!=null){
				sysDeviceconf.setGpstimes(gpstimes);
			}
			if(ledenable!=null){
				sysDeviceconf.setLedenable(ledenable);
			}
			if(tempflag!=null){
				sysDeviceconf.setTemporaryflag(tempflag);
			}
			if(tempgmt!=null){
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");//注意格式化的表达式
				sysDeviceconf.setTemporarygmt(format.parse(tempgmt));
			}
			if(clearerr!=null){
				sysDeviceconf.setClearerr(clearerr);
			}
			if(factory!=null){
				sysDeviceconf.setFactory(factory);
			}
			byte uimodifyflag = 1;
			sysDeviceconf.setUimodifyflag(uimodifyflag);
			byte hardmodifyflag = 0;
			sysDeviceconf.setHardmodifyflag(hardmodifyflag);
			sysDeviceconf.setUpdatetime(new Date());

			boolean flag  = sysDeviceconfMapper.updateByPrimaryKey(sysDeviceconf)==1?true:false;
			boolean flag2  = false;
			if(flag) {
				String command03 = Analyse.Command_03_Send(sysDeviceconf);
				flag2  = redisService.setpersist("device_"+mid, command03);
			}
			if(flag2) {
				r.setCode(200);
				r.setMsg("配置项圈信息成功！");
				r.setData(null);
				r.setSuccess(true);
			}else {
				r.setCode(500);
				r.setData(null);
				r.setMsg("服务器忙，配置项圈信息失败");
				r.setSuccess(false);
			}
		} catch (Exception e) {
			r.setCode(500);
			r.setData(e.getClass().getName() + ":" + e.getMessage());
			r.setMsg("配置项圈信息失败");
			r.setSuccess(false);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
		}
		return r;
	}
}
