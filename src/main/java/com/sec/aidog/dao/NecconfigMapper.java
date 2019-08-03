package com.sec.aidog.dao;

import com.sec.aidog.model.NecconfigExample;
import com.sec.aidog.pojo.Necconfig;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NecconfigMapper {
    int countByExample(NecconfigExample example);

    int deleteByExample(NecconfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Necconfig record);

    int insertSelective(Necconfig record);

    List<Necconfig> selectByExample(NecconfigExample example);

    Necconfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Necconfig record, @Param("example") NecconfigExample example);

    int updateByExample(@Param("record") Necconfig record, @Param("example") NecconfigExample example);

    int updateByPrimaryKeySelective(Necconfig record);

    int updateByPrimaryKey(Necconfig record);

    @Select("select * from necconfig where nec_id=#{neckletid}")
    Necconfig getNecconfig(String neckletid);
}