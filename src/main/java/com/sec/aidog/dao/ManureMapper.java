package com.sec.aidog.dao;

import com.sec.aidog.model.ManureExample;
import com.sec.aidog.pojo.Manure;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ManureMapper {
    int countByExample(ManureExample example);

    int deleteByExample(ManureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Manure record);

    int insertSelective(Manure record);

    List<Manure> selectByExample(ManureExample example);

    Manure selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Manure record, @Param("example") ManureExample example);

    int updateByExample(@Param("record") Manure record, @Param("example") ManureExample example);

    int updateByPrimaryKeySelective(Manure record);

    int updateByPrimaryKey(Manure record);
}