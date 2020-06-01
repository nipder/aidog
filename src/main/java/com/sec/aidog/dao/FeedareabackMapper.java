package com.sec.aidog.dao;

import com.sec.aidog.model.FeedareabackExample;
import com.sec.aidog.pojo.LngLat;
import com.sec.aidog.pojo.Feedareaback;

import java.util.Date;
import java.util.List;

import com.sec.aidog.pojo.VolTemp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FeedareabackMapper {
    int countByExample(FeedareabackExample example);

    int deleteByExample(FeedareabackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Feedareaback record);

    int insertSelective(Feedareaback record);

    List<Feedareaback> selectByExample(FeedareabackExample example);

    Feedareaback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Feedareaback record, @Param("example") FeedareabackExample example);

    int updateByExample(@Param("record") Feedareaback record, @Param("example") FeedareabackExample example);

    int updateByPrimaryKeySelective(Feedareaback record);

    int updateByPrimaryKey(Feedareaback record);

    @Select("select lng, lat,feed_id as device_id ,realtime from feedareaback where feed_id in (select distinct feed_id from dogdev.dog where districtcode like concat(#{districtCode},'%') and feed_id != '-1' order by feed_id) and realtime >= #{begintime} and realtime <= #{endtime} limit 100000")
    List<LngLat> selectLngLatByDistrictcode(@Param("districtCode")String districtCode,@Param("begintime")Date begintime,@Param("endtime")Date endtime);

    @Select("select lng ,lat,feed_id as device_id, realtime from feedareaback where feed_id =#{feedid} and realtime >= #{begintime} and realtime <= #{endtime} limit 100000")
    List<LngLat> selectLngLatByFeedId(@Param("feedid")String feedid,@Param("begintime")Date begintime,@Param("endtime")Date endtime);

    @Select("select power as vol,temperature as temp,feed_id as device_id ,realtime from feedareaback where feed_id in (select distinct feed_id from dogdev.dog where districtcode like concat(#{districtCode},'%') and feed_id != '-1' order by feed_id) and realtime >= #{begintime} and realtime <= #{endtime} order by feed_id limit 10000")
    List<VolTemp> selectVolTempByDistrictcode(@Param("districtCode")String districtCode, @Param("begintime")Date begintime, @Param("endtime")Date endtime);

    @Select("select power as vol,temperature as temp,feed_id as device_id, realtime from feedareaback where feed_id =#{feedid} and realtime >= #{begintime} and realtime <= #{endtime} limit 100000")
    List<VolTemp> selectVolTempByFeedId(@Param("feedid")String feedid,@Param("begintime")Date begintime,@Param("endtime")Date endtime);

}