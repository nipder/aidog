package com.sec.aidog.dao;

import java.util.ArrayList;
import java.util.List;

import com.sec.aidog.pojo.Managers;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ManagersDao {
	@Select("select * from managers where userName=#{ManagerName}")
	public Managers login(String ManagerName);
	
	@Select("select * from managers where userName=#{ManagerName}")
	public Managers checkLogin(String ManagerName);
	
	@Select("select * from managers where userName=#{username}")
	public Managers getManagerByUsername(String username);
	
	@Select("select privilegelevel from managers ")
	public List<Integer> getManagerLevel();

	@Select("select privilegelevel from managers where province=#{provinceName}")
	public List<Integer> getProvinceManagerLevelAndBelowByDistrictName(String provinceName);
	
	@Select("select count(*) from managers where province = '建设兵团'")
	public int getArmyManagerNum();
	
	@Select("select privilegelevel from managers where province=#{param1} and city=#{param2}")
	public List<Integer> getCityManagerAndBelowByDistrictName(String provinceName, String cityName);

	@Select("select privilegelevel from managers where province=#{param1} and city=#{param2} and county=#{param3}")
	public List<Integer> getCountyManagerAndBelowByDistrictName(String provinceName, String cityName, String countyName);

	@Select("select privilegelevel from managers where province=#{param1} and city=#{param2} and county=#{param3} and village=#{param4}")
	public List<Integer> getVillageManagerAndBelowByDistrictName(String provinceName, String cityName, String countyName, String villageName);

	@Select("select privilegelevel from managers where province=#{param1} and city=#{param2} and county=#{param3} and village=#{param4} and hamlet=#{param5}")
	public List<Integer> getHamletManagerByDistrictName(String provinceName, String cityName, String countyName, String villageName, String hamletName);

	@Select("select * from managers where username=#{name}")
	public Managers getManagerByName(String name);
	
	@Select("select username,managername,logintime,province,city,county, village, hamlet, workplace,managertel,officecall from managers where privilegelevel=#{privilegelevel}")
	public List<Managers> getManagersByPrivilegelevel(int privilegelevel);
		
	@Select("select username,managername,logintime,province,city,county, village, hamlet, workplace,managertel,officecall from managers where districtcode like concat(#{param1},'%') and privilegelevel=#{param2}")
	public List<Managers> getManagersByDistrictcodeAndPrivilegelevel(String districtcode, int privilegelevel);
	
	@Select("select * from managers where privilegelevel > #{param1} and ( managername REGEXP #{param2} or province REGEXP #{param2} or city REGEXP #{param2} or village REGEXP #{param2} or hamlet REGEXP #{param2} or managertel REGEXP #{param2} )")
	public List<Managers> getAllManagersByManagerName(int getPrivilegelevel, String managerName);
	@Select("select * from managers where privilegelevel > #{param1} and districtcode like concat(#{param2},'%')and ( managername REGEXP #{param3} or province REGEXP #{param3} or city REGEXP #{param3} or village REGEXP #{param3} or hamlet REGEXP #{param3} or managertel REGEXP #{param3})")
	public List<Managers> getAllManagersByManagerNameAndDistrictcode(int getPrivilegelevel, String districtcode, String managerName);

	@Select("select * from managers where privilegelevel >= #{privilegelevel} and managerstatus = 0")
	public List<Managers> getManagersByPrivilegelevelAndManagerstatus(int privilegelevel);
	
	@Select("select * from managers where username= #{param1} or username=#{param2}")
	public List<Managers> getUserAndActiveUser(String usrname, String activeUsername);
	
	@Update("update managers set managerstatus = 1  where username= #{activeUsername}")
	public void activeManager(String activeUsername);
	@Update("update managers set managerstatus = 0  where username= #{activeUsername}")
	public void freezeManager(String activeUsername);
	
	@Update("update managers set managername = #{param2}, workplace =#{param3} ,manageridentity =#{param4} ,officecall = #{param5},managertel =#{param6} ,address = #{param7}, email = #{param8},password = #{param9} where username= #{param1}")
	public void updateManager(String username, String managername, String managerjob,
                              String manageridentity, String officecall, String managertel, String manageraddress, String email,
                              String password);
	@Insert("insert into managers(username, managername, logintime, managertel, managerphone, password, privilegelevel,"
			+ "privilegedetail, managerstatus, managerretirtime, province, city, county, officecall, address, upusername,"
			+ "village, hamlet, workplace, chargehamlet, manageridentity, email, districtcode) values (#{username}, #{managername}, #{logintime},#{managertel} , #{managerphone}, #{password}, #{privilegelevel},"
			+ "#{privilegedetail}, #{managerstatus}, #{managerretirtime}, #{province}, #{city}, #{county}, #{officecall}, #{address}, #{upusername},"
			+ "#{village}, #{hamlet}, #{workplace}, #{chargehamlet}, #{manageridentity}, #{email}, #{districtcode})")
	public void insertManager(Managers manager);
	
	@Select("select username, privilegelevel from managers where username= #{param1} or username=#{param2}")
	public List<Managers> getUserAndRebackUser(String usrname, String rebackUsername);
	@Update("update managers set password=#{param2} where username= #{param1}")
	public void rebackManager(String rebackUsername, String password);
}
