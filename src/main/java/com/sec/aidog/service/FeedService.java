package com.sec.aidog.service;

import com.sec.aidog.pojo.Feed;
import com.sec.aidog.pojo.VolTemp;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface FeedService {
    boolean batchFeedRegister(List<Feed> feedlist);

    boolean singleFeedRegister(Feed feed);

    boolean bindFeed(String feedid, Integer dogid);

    Map<String, Object> getHamletOwnerFeedList(String hamletcode,Integer ownerid);

    Map<String, Object> getFeedList(String districtcode, int startPage, int pageSize);

    Map<String,Object> getFeedLngLat(String districtcode, Date begintime, Date endtime,String feedid);

    Map<String, Object> getCommonFeedList(String districtcode);

    List<VolTemp> getFeedVolAndTempVoltemplist(String districtcode, Date begintime, Date endtime, String feedid);

    Map<String,Object> getFeedVolAndTemp(String districtcode, Date begintime, Date endtime,String feedid);

    Map<String,Object> getFeedTemp(String districtcode, Date begintime, Date endtime,String feedid);
}
