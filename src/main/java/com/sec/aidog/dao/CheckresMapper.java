package com.sec.aidog.dao;

import com.sec.aidog.model.CheckresExample;
import com.sec.aidog.pojo.Checkres;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CheckresMapper {
    int countByExample(CheckresExample example);

    int deleteByExample(CheckresExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Checkres record);

    int insertSelective(Checkres record);

    List<Checkres> selectByExample(CheckresExample example);

    Checkres selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Checkres record, @Param("example") CheckresExample example);

    int updateByExample(@Param("record") Checkres record, @Param("example") CheckresExample example);

    int updateByPrimaryKeySelective(Checkres record);

    int updateByPrimaryKey(Checkres record);
}