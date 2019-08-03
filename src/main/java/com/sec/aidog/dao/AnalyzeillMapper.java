package com.sec.aidog.dao;

import com.sec.aidog.model.AnalyzeillExample;
import com.sec.aidog.pojo.Analyzeill;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AnalyzeillMapper {
    int countByExample(AnalyzeillExample example);

    int deleteByExample(AnalyzeillExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Analyzeill record);

    int insertSelective(Analyzeill record);

    List<Analyzeill> selectByExample(AnalyzeillExample example);

    Analyzeill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Analyzeill record, @Param("example") AnalyzeillExample example);

    int updateByExample(@Param("record") Analyzeill record, @Param("example") AnalyzeillExample example);

    int updateByPrimaryKeySelective(Analyzeill record);

    int updateByPrimaryKey(Analyzeill record);
}