package com.sec.aidog.dao;

import com.sec.aidog.pojo.Guestinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GuestInfoDao {

    @Select("select * from guestinfo where feederid = '-1'")
    List<Guestinfo> getGuestNeckletInfo();

    @Select("select * from guestinfo where neckletid = '-1'")
    List<Guestinfo> getGuestFeederInfo();
}
