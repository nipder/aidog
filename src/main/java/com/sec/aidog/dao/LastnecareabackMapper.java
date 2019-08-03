package com.sec.aidog.dao;

import com.sec.aidog.model.LastnecareabackExample;
import com.sec.aidog.pojo.Lastnecareaback;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LastnecareabackMapper {
    int countByExample(LastnecareabackExample example);

    int deleteByExample(LastnecareabackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lastnecareaback record);

    int insertSelective(Lastnecareaback record);

    List<Lastnecareaback> selectByExample(LastnecareabackExample example);

    Lastnecareaback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lastnecareaback record, @Param("example") LastnecareabackExample example);

    int updateByExample(@Param("record") Lastnecareaback record, @Param("example") LastnecareabackExample example);

    int updateByPrimaryKeySelective(Lastnecareaback record);

    int updateByPrimaryKey(Lastnecareaback record);

    @Select("select * from lastnecareaback where nec_id = #{neckletid}")
    com.sec.aidog.pojo.Lastnecareaback getLastnecareaback(String neckletid);
}