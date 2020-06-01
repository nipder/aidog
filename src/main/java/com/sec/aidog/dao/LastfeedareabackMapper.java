package com.sec.aidog.dao;

import com.sec.aidog.model.LastfeedareabackExample;
import com.sec.aidog.pojo.Lastfeedareaback;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LastfeedareabackMapper {
    int countByExample(LastfeedareabackExample example);

    int deleteByExample(LastfeedareabackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lastfeedareaback record);

    int insertSelective(Lastfeedareaback record);

    List<Lastfeedareaback> selectByExample(LastfeedareabackExample example);

    Lastfeedareaback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lastfeedareaback record, @Param("example") LastfeedareabackExample example);

    int updateByExample(@Param("record") Lastfeedareaback record, @Param("example") LastfeedareabackExample example);

    int updateByPrimaryKeySelective(Lastfeedareaback record);

    int updateByPrimaryKey(Lastfeedareaback record);

    @Select("select * from lastfeedareaback where feed_id = #{feedid}")
    com.sec.aidog.pojo.Lastfeedareaback getLastfeedareaback(String feedid);
}