package com.sec.aidog.dao;

import com.sec.aidog.model.NecareabackExample;
import com.sec.aidog.pojo.LngLat;
import com.sec.aidog.pojo.Necareaback;

import java.util.Date;
import java.util.List;

import com.sec.aidog.pojo.VolTemp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NecareabackMapper {
    int countByExample(NecareabackExample example);

    int deleteByExample(NecareabackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Necareaback record);

    int insertSelective(Necareaback record);

    List<Necareaback> selectByExample(NecareabackExample example);

    Necareaback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Necareaback record, @Param("example") NecareabackExample example);

    int updateByExample(@Param("record") Necareaback record, @Param("example") NecareabackExample example);

    int updateByPrimaryKeySelective(Necareaback record);

    int updateByPrimaryKey(Necareaback record);

    @Select("select lng, lat,nec_id as device_id ,realtime from necareaback where nec_id in (select distinct nec_id from dogdev.dog where districtcode like concat(#{districtCode},'%') and nec_id != '-1' order by nec_id) and realtime >= #{begintime} and realtime <= #{endtime} limit 100000")
    List<LngLat> selectLngLatByDistrictcode(@Param("districtCode")String districtCode,@Param("begintime")Date begintime,@Param("endtime")Date endtime);

    @Select("select lng ,lat,nec_id as device_id, realtime from necareaback where nec_id =#{necid} and realtime >= #{begintime} and realtime <= #{endtime} limit 100000")
    List<LngLat> selectLngLatByNecId(@Param("necid")String necid,@Param("begintime")Date begintime,@Param("endtime")Date endtime);

    @Select("select power as vol,temperature as temp,nec_id as device_id ,realtime from necareaback where nec_id in (select distinct nec_id from dogdev.dog where districtcode like concat(#{districtCode},'%') and nec_id != '-1' order by nec_id) and realtime >= #{begintime} and realtime <= #{endtime} order by nec_id limit 10000")
    List<VolTemp> selectVolTempByDistrictcode(@Param("districtCode")String districtCode, @Param("begintime")Date begintime, @Param("endtime")Date endtime);

    @Select("select power as vol,temperature as temp,nec_id as device_id, realtime from necareaback where nec_id =#{necid} and realtime >= #{begintime} and realtime <= #{endtime} limit 100000")
    List<VolTemp> selectVolTempByNecId(@Param("necid")String necid,@Param("begintime")Date begintime,@Param("endtime")Date endtime);

}