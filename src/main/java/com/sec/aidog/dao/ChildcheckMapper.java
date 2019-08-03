package com.sec.aidog.dao;

import com.sec.aidog.model.ChildcheckExample;
import com.sec.aidog.pojo.Childcheck;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChildcheckMapper {
    int countByExample(ChildcheckExample example);

    int deleteByExample(ChildcheckExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Childcheck record);

    int insertSelective(Childcheck record);

    List<Childcheck> selectByExample(ChildcheckExample example);

    Childcheck selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Childcheck record, @Param("example") ChildcheckExample example);

    int updateByExample(@Param("record") Childcheck record, @Param("example") ChildcheckExample example);

    int updateByPrimaryKeySelective(Childcheck record);

    int updateByPrimaryKey(Childcheck record);
}