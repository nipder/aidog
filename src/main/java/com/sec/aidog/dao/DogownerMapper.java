package com.sec.aidog.dao;

import com.sec.aidog.model.DogownerExample;
import com.sec.aidog.pojo.Dogowner;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DogownerMapper {
    int countByExample(DogownerExample example);

    int deleteByExample(DogownerExample example);

    int deleteByPrimaryKey(Integer ownerId);

    int insert(Dogowner record);

    int insertSelective(Dogowner record);

    List<Dogowner> selectByExample(DogownerExample example);

    Dogowner selectByPrimaryKey(Integer ownerId);

    int updateByExampleSelective(@Param("record") Dogowner record, @Param("example") DogownerExample example);

    int updateByExample(@Param("record") Dogowner record, @Param("example") DogownerExample example);

    int updateByPrimaryKeySelective(Dogowner record);

    int updateByPrimaryKey(Dogowner record);

    @Select("select * from dogowner where owner_tel = #{tel} and districtcode = #{districtcode}")
    Dogowner getOwnerByTelAndDistricode(@Param("tel")String tel,@Param("districtcode")String districtcode);
}