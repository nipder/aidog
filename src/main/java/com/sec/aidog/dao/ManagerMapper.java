package com.sec.aidog.dao;

import com.sec.aidog.model.ManagerExample;
import com.sec.aidog.pojo.Manager;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ManagerMapper {
    int countByExample(ManagerExample example);

    int deleteByExample(ManagerExample example);

    int deleteByPrimaryKey(Integer managerId);

    int insert(Manager record);

    int insertSelective(Manager record);

    List<Manager> selectByExample(ManagerExample example);

    Manager selectByPrimaryKey(Integer managerId);

    int updateByExampleSelective(@Param("record") Manager record, @Param("example") ManagerExample example);

    int updateByExample(@Param("record") Manager record, @Param("example") ManagerExample example);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);

    @Select("select * from manager where username = #{name}")
    Manager findUserByName(String name);

    @Select("select privilegelevel from manager")
    List<Integer> getManagerLevel();

    @Select("select privilegelevel from manager where province=#{provinceName}")
    List<Integer> getProvinceManagerLevelAndBelowByDistrictName(String provinceName);

    @Select("select * from manager where privilegelevel > #{privilegelevel} and districtcode like concat(#{districtcode},'%')")
    List<Manager> getUnderManagers(@Param("privilegelevel") Integer privilegelevel, @Param("districtcode") String districtcode);

    @Update("update manager set manager_status = 1  where manager_id= #{manager_id}")
    int activeManager(Integer manager_id);

    @Update("update manager set manager_status = 0  where manager_id= #{manager_id}")
    int freezeManager(Integer manager_id);

    @Update("update manager set password=#{pwd} where manager_id= #{manager_id}")
    int resetManagerPwd(@Param("manager_id") Integer manager_id, @Param("pwd") String pwd);

    @Select("select privilegelevel from manager where province=#{param1} and city=#{param2}")
    List<Integer> getCityManagerAndBelowByDistrictName(String provinceName, String cityName);

    @Select("select privilegelevel from manager where province=#{param1} and city=#{param2} and county=#{param3}")
    List<Integer> getCountyManagerAndBelowByDistrictName(String provinceName,String cityName, String countyName);

    @Select("select privilegelevel from manager where province=#{param1} and city=#{param2} and county=#{param3} and village=#{param4}")
    List<Integer> getVillageManagerAndBelowByDistrictName(String provinceName,String cityName, String countyName, String villageName);

    @Select("select privilegelevel from manager where province=#{param1} and city=#{param2} and county=#{param3} and village=#{param4} and hamlet=#{param5}")
    List<Integer> getHamletManagerByDistrictName(String provinceName,String cityName, String countyName, String villageName ,String hamletName);

    @Select("select * from manager where manager_name = #{managername} and districtcode = #{districtcode}")
    Manager selectByNameAndDistrictcode(@Param("managername") String managername, @Param("districtcode") String districtcode);
}