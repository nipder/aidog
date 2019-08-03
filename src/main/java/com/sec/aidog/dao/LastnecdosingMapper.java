package com.sec.aidog.dao;

import com.sec.aidog.model.LastnecdosingExample;
import com.sec.aidog.pojo.Lastnecdosing;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LastnecdosingMapper {
    int countByExample(LastnecdosingExample example);

    int deleteByExample(LastnecdosingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lastnecdosing record);

    int insertSelective(Lastnecdosing record);

    List<Lastnecdosing> selectByExample(LastnecdosingExample example);

    Lastnecdosing selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lastnecdosing record, @Param("example") LastnecdosingExample example);

    int updateByExample(@Param("record") Lastnecdosing record, @Param("example") LastnecdosingExample example);

    int updateByPrimaryKeySelective(Lastnecdosing record);

    int updateByPrimaryKey(Lastnecdosing record);

    @Select("select * from lastnecdosing where nec_id=#{neckletid}")
    Lastnecdosing getLastnecdosing(String neckletid);
}