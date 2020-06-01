package com.sec.aidog.dao;

import com.sec.aidog.model.LastfeeddosingExample;
import com.sec.aidog.pojo.Lastfeeddosing;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LastfeeddosingMapper {
    int countByExample(LastfeeddosingExample example);

    int deleteByExample(LastfeeddosingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lastfeeddosing record);

    int insertSelective(Lastfeeddosing record);

    List<Lastfeeddosing> selectByExample(LastfeeddosingExample example);

    Lastfeeddosing selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lastfeeddosing record, @Param("example") LastfeeddosingExample example);

    int updateByExample(@Param("record") Lastfeeddosing record, @Param("example") LastfeeddosingExample example);

    int updateByPrimaryKeySelective(Lastfeeddosing record);

    int updateByPrimaryKey(Lastfeeddosing record);

    @Select("select * from lastfeeddosing where feed_id=#{feedid}")
    Lastfeeddosing getLastfeeddosing(String feedid);
}