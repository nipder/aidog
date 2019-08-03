package com.sec.aidog.dao;

import com.sec.aidog.model.NecdosingExample;
import com.sec.aidog.pojo.Necdosing;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NecdosingMapper {
    int countByExample(NecdosingExample example);

    int deleteByExample(NecdosingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Necdosing record);

    int insertSelective(Necdosing record);

    List<Necdosing> selectByExample(NecdosingExample example);

    Necdosing selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Necdosing record, @Param("example") NecdosingExample example);

    int updateByExample(@Param("record") Necdosing record, @Param("example") NecdosingExample example);

    int updateByPrimaryKeySelective(Necdosing record);

    int updateByPrimaryKey(Necdosing record);

    @Select("select count(*) from necdosing where districtcode like concat(#{districtCode},'%')")
    int getExhiCountByDistrictcode(String districtCode);
}