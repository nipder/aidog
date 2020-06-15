package com.sec.aidog.dao;

import com.sec.aidog.model.DevPillRecExample;
import com.sec.aidog.pojo.DevPillRec;
import java.util.List;

import com.sec.aidog.pojo.DevPillRecView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DevPillRecMapper {
    int countByExample(DevPillRecExample example);

    int deleteByExample(DevPillRecExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DevPillRec record);

    int insertSelective(DevPillRec record);

    List<DevPillRec> selectByExample(DevPillRecExample example);

    DevPillRec selectByPrimaryKey(Integer id);

    @Select("select * FROM feed where mid = #{mid}")
    DevPillRec selectByMId(String mid);

    int updateByExampleSelective(@Param("record") DevPillRec record, @Param("example") DevPillRecExample example);

    int updateByExample(@Param("record") DevPillRec record, @Param("example") DevPillRecExample example);

    int updateByPrimaryKeySelective(DevPillRec record);

    int updateByPrimaryKey(DevPillRec record);

    @Select("select a.mid, a.config_time as configTime, a.pill_code as pillCode, b.pill_name as pillName, b.pill_factory as pillFactory, b.pill_spec as pillSpec, b.pill_batchnum as pillBatchnum, b.pill_expdate as pillExpdate, b.pill_buydate as pillBuydate, b.pill_buyer as pillBuyer, b.pill_buyertel as pillBuyertel from (select * from dogdev.devpillrec where mid = #{mid} order by config_time) a left join dogdev.pill b on a.pill_code = b.pill_code")
    List<DevPillRecView> selectBindRecViewLayMid(String mid);
}