package com.sec.aidog.dao;

import com.sec.aidog.model.FeedconfigExample;
import com.sec.aidog.pojo.Feedconfig;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FeedconfigMapper {
    int countByExample(FeedconfigExample example);

    int deleteByExample(FeedconfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Feedconfig record);

    int insertSelective(Feedconfig record);

    List<Feedconfig> selectByExample(FeedconfigExample example);

    Feedconfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Feedconfig record, @Param("example") FeedconfigExample example);

    int updateByExample(@Param("record") Feedconfig record, @Param("example") FeedconfigExample example);

    int updateByPrimaryKeySelective(Feedconfig record);

    int updateByPrimaryKey(Feedconfig record);

    @Select("select * from necconfig where nec_id=#{neckletid}")
    Feedconfig getFeedconfig(String neckletid);
}