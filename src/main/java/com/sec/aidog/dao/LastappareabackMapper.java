package com.sec.aidog.dao;

import com.sec.aidog.model.LastappareabackExample;
import com.sec.aidog.pojo.Lastappareaback;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LastappareabackMapper {
    int countByExample(LastappareabackExample example);

    int deleteByExample(LastappareabackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lastappareaback record);

    int insertSelective(Lastappareaback record);

    List<Lastappareaback> selectByExample(LastappareabackExample example);

    Lastappareaback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lastappareaback record, @Param("example") LastappareabackExample example);

    int updateByExample(@Param("record") Lastappareaback record, @Param("example") LastappareabackExample example);

    int updateByPrimaryKeySelective(Lastappareaback record);

    int updateByPrimaryKey(Lastappareaback record);

    @Select("select * from lastappareaback where app_id = #{apparatusid}")
    Lastappareaback getLastappareaback(String apparatusid);
}