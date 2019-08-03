package com.sec.aidog.dao;

import com.sec.aidog.model.SysLaytimeExample;
import com.sec.aidog.pojo.SysLaytime;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component("sysLaytimeMapper")
public interface SysLaytimeMapper {
    int countByExample(SysLaytimeExample example);

    int deleteByExample(SysLaytimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysLaytime record);

    int insertSelective(SysLaytime record);

    List<SysLaytime> selectByExample(SysLaytimeExample example);

    SysLaytime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysLaytime record, @Param("example") SysLaytimeExample example);

    int updateByExample(@Param("record") SysLaytime record, @Param("example") SysLaytimeExample example);

    int updateByPrimaryKeySelective(SysLaytime record);

    int updateByPrimaryKey(SysLaytime record);

    @Select("select * from sys_laytime as a where not exists (select 1 from sys_laytime where mid = a.mid and updatetime>a.updatetime)")
    List<SysLaytime> getAllDevicePosition();
}