package com.sec.aidog.dao;

import com.sec.aidog.model.SysDeviceconfExample;
import com.sec.aidog.model.SysDeviceconfKey;
import com.sec.aidog.pojo.SysDeviceconf;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component("sysDeviceconfMapper")
public interface SysDeviceconfMapper {
    int countByExample(SysDeviceconfExample example);

    int deleteByExample(SysDeviceconfExample example);

    int deleteByPrimaryKey(SysDeviceconfKey key);

    int insert(SysDeviceconf record);

    int insertSelective(SysDeviceconf record);

    List<SysDeviceconf> selectByExample(SysDeviceconfExample example);

    SysDeviceconf selectByPrimaryKey(SysDeviceconfKey key);

    int updateByExampleSelective(@Param("record") SysDeviceconf record, @Param("example") SysDeviceconfExample example);

    int updateByExample(@Param("record") SysDeviceconf record, @Param("example") SysDeviceconfExample example);

    int updateByPrimaryKeySelective(SysDeviceconf record);

    int updateByPrimaryKey(SysDeviceconf record);

    SysDeviceconf selectDeviceConfigByMid(String mid);
}