package com.sec.aidog.dao;

import com.sec.aidog.model.NeckletExample;
import com.sec.aidog.pojo.Necklet;

import java.util.List;

import com.sec.aidog.pojo.SysDeviceconf;
import com.sec.aidog.pojo.SysLayconfig;
import com.sec.aidog.pojo.SysLaytime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NeckletMapper {
    int countByExample(NeckletExample example);

    int deleteByExample(NeckletExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Necklet record);

    int insertSelective(Necklet record);

    List<Necklet> selectByExample(NeckletExample example);

    Necklet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Necklet record, @Param("example") NeckletExample example);

    int updateByExample(@Param("record") Necklet record, @Param("example") NeckletExample example);

    int updateByPrimaryKeySelective(Necklet record);

    int updateByPrimaryKey(Necklet record);

    int insertBatchNecRegister(List<Necklet> neckletList);

    @Select("select nec_id FROM necklet where bind_time is null")
    List<String> getUnuseNecList();

    @Select("select * FROM necklet where nec_id = #{necid}")
    Necklet selectByNecId(String necid);

    //铸成NecklistView的3条核心查询语句
    @Select("select a.nec_id as mid,b.err, b.voltage,b.temperature,b.updatetime from (select distinct nec_id from dogdev.dog where districtcode like concat(#{districtCode},'%') and nec_id != '-1' order by nec_id) a left join (SELECT t.mid,t.err,t.voltage,t.temperature,t.updatetime FROM (SELECT * FROM dogdev.sys_laytime order by updatetime desc limit 9999999) t  GROUP BY t.mid) b on a.nec_id = b.mid")
    List<SysLaytime> selectViewLayTime(String districtCode);
    @Select("select a.nec_id  as mid,b.status,b.uimodifyflag,b.hardmodifyflag,b.updatetime from (select distinct nec_id from dogdev.dog where districtcode like concat(#{districtCode},'%') and nec_id != '-1' order by nec_id) a inner join dogdev.sys_deviceconf b where a.nec_id = b.mid")
    List<SysDeviceconf> selectViewDeviceconf(String districtCode);
    @Select("select a.nec_id  as mid,b.* from (select distinct nec_id from dogdev.dog where districtcode  like concat(#{districtCode},'%') and nec_id != '-1' order by nec_id) a inner join dogdev.sys_layconfig b where a.nec_id = b.mid")
    List<SysLayconfig> selectViewLayconfig(String districtCode);
}