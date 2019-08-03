package com.sec.aidog.dao;

import com.sec.aidog.model.SysLayconfigExample;
import com.sec.aidog.pojo.SysLayconfig;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
//@Component("sysLayconfigMapper")
public interface SysLayconfigMapper {
    int countByExample(SysLayconfigExample example);

    int deleteByExample(SysLayconfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysLayconfig record);

    int insertSelective(SysLayconfig record);

    List<SysLayconfig> selectByExample(SysLayconfigExample example);

    SysLayconfig selectByPrimaryKey(Integer id);

    @Select("select * from sys_layconfig where mid = #{mid} order by updatetime desc limit 1")
    SysLayconfig selectLayConfigByMid(@Param("mid") String mid);

    int updateByExampleSelective(@Param("record") SysLayconfig record, @Param("example") SysLayconfigExample example);

    int updateByExample(@Param("record") SysLayconfig record, @Param("example") SysLayconfigExample example);

    int updateByPrimaryKeySelective(SysLayconfig record);

    int updateByPrimaryKey(SysLayconfig record);

    int deleteOldestLayConfigByMid(String mid);

    int updateOtherLayConfigflag(String mid);
}