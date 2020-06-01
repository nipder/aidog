package com.sec.aidog.dao;

import com.sec.aidog.model.FeeddosingExample;
import com.sec.aidog.pojo.Feeddosing;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FeeddosingMapper {
    int countByExample(FeeddosingExample example);

    int deleteByExample(FeeddosingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Feeddosing record);

    int insertSelective(Feeddosing record);

    List<Feeddosing> selectByExample(FeeddosingExample example);

    Feeddosing selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Feeddosing record, @Param("example") FeeddosingExample example);

    int updateByExample(@Param("record") Feeddosing record, @Param("example") FeeddosingExample example);

    int updateByPrimaryKeySelective(Feeddosing record);

    int updateByPrimaryKey(Feeddosing record);

    @Select("select count(*) from feeddosing where districtcode like concat(#{districtCode},'%')")
    int getExhiCountByDistrictcode(String districtCode);
}