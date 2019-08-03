package com.sec.aidog.dao;

import com.sec.aidog.model.AnimalillExample;
import com.sec.aidog.pojo.Animalill;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AnimalillMapper {
    int countByExample(AnimalillExample example);

    int deleteByExample(AnimalillExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Animalill record);

    int insertSelective(Animalill record);

    List<Animalill> selectByExample(AnimalillExample example);

    Animalill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Animalill record, @Param("example") AnimalillExample example);

    int updateByExample(@Param("record") Animalill record, @Param("example") AnimalillExample example);

    int updateByPrimaryKeySelective(Animalill record);

    int updateByPrimaryKey(Animalill record);
}