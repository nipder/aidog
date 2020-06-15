package com.sec.aidog.dao;

import com.sec.aidog.pojo.DevResource;
import com.sec.aidog.model.DevResourceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DevResourceMapper {
    int countByExample(DevResourceExample example);

    int deleteByExample(DevResourceExample example);

    int deleteByPrimaryKey(String id);

    int insert(DevResource record);

    int insertSelective(DevResource record);

    List<DevResource> selectByExample(DevResourceExample example);

    DevResource selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DevResource record, @Param("example") DevResourceExample example);

    int updateByExample(@Param("record") DevResource record, @Param("example") DevResourceExample example);

    int updateByPrimaryKeySelective(DevResource record);

    int updateByPrimaryKey(DevResource record);
}