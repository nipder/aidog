package com.sec.aidog.dao;

import com.sec.aidog.model.PillExample;
import com.sec.aidog.pojo.Pill;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PillMapper {
    int countByExample(PillExample example);

    int deleteByExample(PillExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Pill record);

    int insertSelective(Pill record);

    List<Pill> selectByExample(PillExample example);

    Pill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Pill record, @Param("example") PillExample example);

    int updateByExample(@Param("record") Pill record, @Param("example") PillExample example);

    int updateByPrimaryKeySelective(Pill record);

    int updateByPrimaryKey(Pill record);

    @Select("select * from pill where districtcode like concat(#{districtCode},'%')")
    List<Pill> getPillListByDistrictcode(String districtCode);
}