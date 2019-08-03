package com.sec.aidog.dao;


import com.sec.aidog.pojo.Districts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DistrictsDao {
	@Select("select * from districts")
	public List<Districts> getDistricts();
	
	@Select("select * from districts where districtname=#{provinceName} or shortname=#{provinceName}")
    public Districts getDistrictsByDistrictName(String provinceName);
	
	@Select("select * from districts where (districtname=#{param1} or shortname=#{param1}) and districtcode like concat(#{param2},'%')")
	public Districts getCityAndBelowDistrictsByDistrictName(String districtName, String higherLevelDistrictCode);
		
	@Select("select * from districts where districtcode like concat(#{districtCode},'%')")
	public List<Districts> getDistrictsByDistrictcode(String districtCode);
	
	@Select("select * from districts where districtcode REGEXP '.{4}00000000' and epidemic = 1")
	public List<Districts> getProvicesAndCities();
	
	@Select("select * from districts where districtcode REGEXP concat(#{provinceCode0to2}, '.{4}000000') and districtcode !=concat(#{provinceCode0to2}, '0000000000')and epidemic = 1")
	public List<Districts> getCitiesAndCountiesByDistrictcode(String provinceCode0to2);
	
	@Select("select * from districts where districtcode REGEXP concat(#{cityCode0to4}, '.{5}000') and districtcode !=concat(#{cityCode0to4}, '00000000')and epidemic = 1")
	public List<Districts> getCountiesAndVillagesByDistrictcode(String cityCode0to4);
	
	@Select("select districtcode, districtname,shortname,epidemic,lng,lat from districts where districtcode REGEXP concat(#{countyCode0to6}, '.{6}') and districtcode !=concat(#{countyCode0to6}, '000000')and epidemic = 1 ")
	public List<Districts> getVillagesAndHamletsByDistrictcode(String countyCode0to6);
	
	@Select("select districtcode, districtname,shortname,epidemic,lng,lat from districts where districtcode REGEXP concat(#{villageCode0to9}, '.{3}') and districtcode !=concat(#{villageCode0to9}, '000')and epidemic = 1 ")
	public List<Districts> getHamletsByDistrictcode(String villageCode0to9);
	
	@Select("select count(*) from districts where districtcode REGEXP '66.{2}0000' and districtcode != 66000000 and epidemic = 1")
	public int getDivisions(); 
	
	@Select("select * from districts where districtcode REGEXP concat(#{armyCode0to2}, '.{4}00')  and districtcode !=concat(#{armyCode0to2}, '000000') and epidemic = 1")
	public List<Districts> getDivisionsAndRegimentalByDistrictcode(String armyCode0to2);
	
	@Select("select * from districts where districtcode REGEXP concat(#{divisionCode0to4}, '.{4}')  and districtcode !=concat(#{divisionCode0to4}, '0000') and epidemic = 1")
	public List<Districts> getRegimentalAndCompanyByDistrictcode(String divisionCode0to4);
	
	@Select("select shortname from districts where districtname =#{districtName} or shortname =#{districtName}")
	public String getEchartsareanametempByDistrictName(String districtName);
	
	@Select("select districtname from districts where districtname =#{districtName} or shortname =#{districtName}")
	public String getGovareanametempByDistrictName(String districtName);
	
	@Select("select districtname from districts where districtcode=#{districtCode}")
	public String getDistrictNameByDistrictCode(String districtCode);
	
	@Select("select * from districts where districtcode = '66000000' and epidemic = 1")
	public List<Districts> getArmyPosition();
	
	@Select("select districtlevel,districtcode,districtname,epidemic from districts where districtcode REGEXP '.{2}0000000000'")
	public List<Districts> getProvinces();
	@Select("select districtlevel,districtcode,districtname,epidemic from districts where districtcode REGEXP concat(#{provinceCode0to2}, '.{2}00000000') and districtcode !=concat(#{provinceCode0to2}, '0000000000')")
	public List<Districts> getCities(String provinceCode0to2);
	
	@Select("select districtlevel,districtcode,districtname,epidemic from districts where districtcode REGEXP concat(#{cityCode0to4}, '.{2}000000') and districtcode !=concat(#{cityCode0to4}, '00000000')")
	public List<Districts> getCounties(String cityCode0to4);
	
	@Select("select districtlevel,districtcode,districtname,epidemic from districts where districtcode REGEXP concat(#{countyCode0to6}, '.{3}000') and districtcode !=concat(#{countyCode0to6}, '000000') ")
	public List<Districts> getVillages(String countyCode0to6);
	
	@Select("select districtlevel,districtcode,districtname,epidemic from districts where districtcode REGEXP concat(#{villageCode0to9}, '.{3}') and districtcode !=concat(#{villageCode0to9}, '000') ")
	public List<Districts> getHamlets(String villageCode0to9);
	
	@Select("select districtcode,districtname from districts where districtlevel = 1")
	public List<Districts> getAllCities();
	
	@Select("select districtcode,districtname from districts where districtlevel = 2")
	public List<Districts> getAllCounties();
	
	@Select("select districtcode,districtname from districts where districtlevel = 3")
	public List<Districts> getAllVillages();
	
	@Select("select districtcode,districtname from districts where districtlevel = 4")
	public List<Districts> getAllHamlets();
}
