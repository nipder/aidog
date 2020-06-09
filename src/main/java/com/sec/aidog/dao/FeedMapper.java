package com.sec.aidog.dao;

import com.sec.aidog.model.FeedExample;
import com.sec.aidog.pojo.Feed;

import java.util.List;

import com.sec.aidog.pojo.SysDeviceconf;
import com.sec.aidog.pojo.SysLayconfig;
import com.sec.aidog.pojo.SysLaytime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FeedMapper {
    int countByExample(FeedExample example);

    int deleteByExample(FeedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Feed record);

    int insertSelective(Feed record);

    List<Feed> selectByExample(FeedExample example);

    Feed selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Feed record, @Param("example") FeedExample example);

    int updateByExample(@Param("record") Feed record, @Param("example") FeedExample example);

    int updateByPrimaryKeySelective(Feed record);

    int updateByPrimaryKey(Feed record);

    int insertBatchFeedRegister(List<Feed> feedList);

    @Select("select feed_id FROM feed where bind_time is null")
    List<String> getUnuseFeedList();

    @Select("select * FROM feed where feed_id = #{feedid}")
    Feed selectByFeedId(String feedid);

    //铸成FeedklistView的3条核心查询语句
    @Select("select a.app_id as mid,b.err, b.voltage,b.temperature,b.updatetime from (select distinct app_id from dogdev.dog where districtcode like concat(#{districtCode},'%') and app_id != '-1' order by app_id) a left join (SELECT t.mid,t.err,t.voltage,t.temperature,t.updatetime FROM (SELECT * FROM dogdev.sys_laytime order by updatetime desc limit 9999999) t  GROUP BY t.mid) b on a.app_id = b.mid")
    List<SysLaytime> selectViewLayTime(String districtCode);
    @Select("select a.app_id  as mid,b.status,b.uimodifyflag,b.hardmodifyflag,b.updatetime from (select distinct app_id from dogdev.dog where districtcode like concat(#{districtCode},'%') and app_id != '-1' order by app_id) a inner join dogdev.sys_deviceconf b where a.app_id = b.mid")
    List<SysDeviceconf> selectViewDeviceconf(String districtCode);
    @Select("select a.app_id  as mid,b.* from (select distinct app_id from dogdev.dog where districtcode  like concat(#{districtCode},'%') and app_id != '-1' order by app_id) a inner join dogdev.sys_layconfig b where a.app_id = b.mid")
    List<SysLayconfig> selectViewLayconfig(String districtCode);
}
