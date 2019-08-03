package com.sec.aidog.dao;

import com.sec.aidog.model.ChildillExample;
import com.sec.aidog.pojo.Childill;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChildillMapper {
    int countByExample(ChildillExample example);

    int deleteByExample(ChildillExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Childill record);

    int insertSelective(Childill record);

    List<Childill> selectByExample(ChildillExample example);

    Childill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Childill record, @Param("example") ChildillExample example);

    int updateByExample(@Param("record") Childill record, @Param("example") ChildillExample example);

    int updateByPrimaryKeySelective(Childill record);

    int updateByPrimaryKey(Childill record);
}