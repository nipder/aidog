package com.sec.aidog.dao;

import com.sec.aidog.model.AppconfigExample;
import com.sec.aidog.pojo.Appconfig;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AppconfigMapper {
    int countByExample(AppconfigExample example);

    int deleteByExample(AppconfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Appconfig record);

    int insertSelective(Appconfig record);

    List<Appconfig> selectByExample(AppconfigExample example);

    Appconfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Appconfig record, @Param("example") AppconfigExample example);

    int updateByExample(@Param("record") Appconfig record, @Param("example") AppconfigExample example);

    int updateByPrimaryKeySelective(Appconfig record);

    int updateByPrimaryKey(Appconfig record);

    @Select("select * from appconfig where app_id = #{apparatusid}")
    Appconfig getAppconfig(String apparatusid);
}