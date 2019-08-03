package com.sec.aidog.dao;

import com.sec.aidog.pojo.Systimepos;
import com.sec.aidog.model.SystimeposExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SystimeposMapper {
    int countByExample(SystimeposExample example);

    int deleteByExample(SystimeposExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Systimepos record);

    int insertSelective(Systimepos record);

    List<Systimepos> selectByExample(SystimeposExample example);

    Systimepos selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Systimepos record, @Param("example") SystimeposExample example);

    int updateByExample(@Param("record") Systimepos record, @Param("example") SystimeposExample example);

    int updateByPrimaryKeySelective(Systimepos record);

    int updateByPrimaryKey(Systimepos record);
}