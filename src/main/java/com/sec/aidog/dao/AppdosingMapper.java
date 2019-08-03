package com.sec.aidog.dao;

import com.sec.aidog.model.AppdosingExample;
import com.sec.aidog.pojo.Appdosing;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AppdosingMapper {
    int countByExample(AppdosingExample example);

    int deleteByExample(AppdosingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Appdosing record);

    int insertSelective(Appdosing record);

    List<Appdosing> selectByExample(AppdosingExample example);

    Appdosing selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Appdosing record, @Param("example") AppdosingExample example);

    int updateByExample(@Param("record") Appdosing record, @Param("example") AppdosingExample example);

    int updateByPrimaryKeySelective(Appdosing record);

    int updateByPrimaryKey(Appdosing record);

    @Select("select count(*) from appdosing where districtcode like concat(#{districtCode},'%')")
    int getAppExhiCountByDistrictcode(String districtCode);
}