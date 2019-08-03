package com.sec.aidog.dao;

import com.sec.aidog.model.LastappdosingExample;
import com.sec.aidog.pojo.Lastappdosing;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LastappdosingMapper {
    int countByExample(LastappdosingExample example);

    int deleteByExample(LastappdosingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lastappdosing record);

    int insertSelective(Lastappdosing record);

    List<Lastappdosing> selectByExample(LastappdosingExample example);

    Lastappdosing selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lastappdosing record, @Param("example") LastappdosingExample example);

    int updateByExample(@Param("record") Lastappdosing record, @Param("example") LastappdosingExample example);

    int updateByPrimaryKeySelective(Lastappdosing record);

    int updateByPrimaryKey(Lastappdosing record);

    @Select("select * from lastappdosing where app_id = #{apparatusid}")
    Lastappdosing getLastappdosing(String apparatusid);
}