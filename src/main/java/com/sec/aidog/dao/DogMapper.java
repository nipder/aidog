package com.sec.aidog.dao;

import java.util.List;
import java.util.Map;

import com.sec.aidog.model.DogExample;
import com.sec.aidog.pojo.Dog;
import com.sec.aidog.pojo.DogView;
import com.sec.aidog.util.OrderProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface DogMapper {
    int countByExample(DogExample example);

    int deleteByExample(DogExample example);

    int deleteByPrimaryKey(Integer dogId);

    int insert(Dog record);

    int insertSelective(Dog record);

    List<Dog> selectByExample(DogExample example);

    Dog selectByPrimaryKey(Integer dogId);

    int updateByExampleSelective(@Param("record") Dog record, @Param("example") DogExample example);

    int updateByExample(@Param("record") Dog record, @Param("example") DogExample example);

    int updateByPrimaryKeySelective(Dog record);

    int updateByPrimaryKey(Dog record);

    @Select("select nec_id from dog where districtcode like concat(#{districtCode},'%')")
    List<String> getAllNeckletIdByDistrictcode(String districtCode);

    @Select("select * from dog where districtcode like concat(#{districtCode},'%') ")//and ((neckletid ='-1' and apparatusid !='-1') or (apparatusid ='-1' and neckletid !='-1'))
    List<Dog> getIndexInforByDistrictcode(String districtCode);

    @Select("select dog_id,nec_id,dog_name,manager_name from dog where districtcode = #{hamletcode} and nec_id != '-1'")
    List<Dog> getHamletDogs(String hamletcode);

    @Select("select dog_id,dog_name,app_id,manager_name from dog where districtcode = #{hamletcode} and app_id !='-1'")
    List<Dog> getFarmDogAppList(String hamletcode);

    @Select("select nec_id from dog where username = #{username}")
    List<Dog>  getLevel6AdminDogNum(String username);

    @Select("SELECT count(*) FROM dog WHERE districtcode=#{hamletCode}")
    Integer combineNeckletAndAppDogTotal(String hamletCode);

    @SelectProvider(type = OrderProvider.class, method = "combineNeckletAndAppDogListStr")
    List<Dog> combineNeckletAndAppDogList(Map<String, Object> paramsmap);

    @Select("SELECT dog_id,dog_name,nec_id,app_id,manager_name FROM dog WHERE nec_id=#{param1} and districtcode=#{param2}")
    List<Dog> getCombineNeckletAndAppDogByNecId(String neckletId, String hamletCode);

    @Select("select a.*,b.owner_name,b.owner_identity,b.owner_addr from dog a inner join dogowner b on a.dogowner_id = b.owner_id and a.districtcode like concat(#{districtCode},'%')")
    List<DogView> getDogListByDistrictcode(String districtCode);

    @Select("select a.dog_id,a.dog_govcode,a.dog_name,b.owner_name FROM dog a inner join dogowner b on a.nec_id='-1' and a.app_id='-1' and a.dogowner_id=b.owner_id and a.districtcode=#{districtcode}")
    List<DogView> getUnuseDogGovcodeList(String districtcode);

    @Select("select a.dog_id,a.dog_govcode,a.dog_name,b.owner_name FROM dog a inner join dogowner b on a.app_id='-1' and a.dogowner_id=b.owner_id and a.districtcode=#{districtcode}")
    List<DogView> getUnuseFeedDogGovcodeList(String districtcode);

    @Select("select a.dog_id,a.dog_govcode,a.dog_name,a.nec_id,a.app_id,b.owner_name FROM dog a inner join dogowner b on a.dogowner_id=b.owner_id and a.districtcode=#{districtcode}")
    List<DogView> getManureDogGovcodeList(String districtcode);

    @Select("select a.dog_id,a.nec_id FROM dog a inner join necklet b on a.districtcode = #{hamletcode} and a.dogowner_id = #{ownerid} and b.bind_time is not null and a.nec_id = b.nec_id")
    List<Dog> getUseNecListByHamletcode(@Param("hamletcode")String hamletcode,@Param("ownerid")Integer ownerid);

    @Select("select a.dog_id,a.app_id FROM dog a inner join apparatus b on a.districtcode = #{hamletcode} and a.dogowner_id = #{ownerid} and b.bind_time is not null and a.app_id = b.app_id")
    List<Dog> getUseAppListByHamletcode(@Param("hamletcode")String hamletcode,@Param("ownerid")Integer ownerid);
}