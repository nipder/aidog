package com.sec.aidog.dao;

import com.sec.aidog.model.AnaallillExample;
import com.sec.aidog.pojo.Anaallill;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AnaallillMapper {
    int countByExample(AnaallillExample example);

    int deleteByExample(AnaallillExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Anaallill record);

    int insertSelective(Anaallill record);

    List<Anaallill> selectByExample(AnaallillExample example);

    Anaallill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Anaallill record, @Param("example") AnaallillExample example);

    int updateByExample(@Param("record") Anaallill record, @Param("example") AnaallillExample example);

    int updateByPrimaryKeySelective(Anaallill record);

    int updateByPrimaryKey(Anaallill record);
}