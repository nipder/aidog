package com.sec.aidog.dao;

import com.sec.aidog.pojo.Lastappexhibitrealtime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AppexhibitrealtimeDao {
	@Select("select count(*) from appexhibitrealtime")
	public int getAppExhiCount();
	
	@Select("select count(*) from appexhibitrealtime where districtcode like concat(#{districtCode},'%')")
	public int getAppExhiCountByDistrictcode(String districtCode);
	
	@Select("select count(*) from appexhibitrealtime where districtcode like concat('66','%')")
	public int getArmyFeederNum();
	
	@Select("select realtime,tableremain,nextexhibittime from lastappexhibitrealtime where apparatusid = #{apparatusid}")
	public Lastappexhibitrealtime getDogInfo(String apparatusid);
}
