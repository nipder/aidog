package com.sec.aidog.mongoservice.impl;

//import com.alibaba.fastjson.JSON;
//import com.github.pagehelper.Page;
//import com.github.pagehelper.PageHelper;
//import com.mongodb.*;
//import com.mongodb.client.DistinctIterable;
//import com.sec.aidog.mgpojo.MgSysLaytime;
import com.sec.aidog.mongoservice.MgLaytimeService;
//import org.bson.Document;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.aggregation.Aggregation;
//import org.springframework.data.mongodb.core.aggregation.AggregationResults;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.stereotype.Service;

import java.util.*;

//@Service
public class MgLaytimeServiceImpl implements MgLaytimeService {

//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Override
//    public List<MgSysLaytime> getMidLaytimeList(String mid, int startitem,int pagesize) {
//        Query query = new Query();
//        query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"updatetime")));
//        query.addCriteria(Criteria.where("mid").is(mid)).limit(pagesize).skip((startitem-1)*pagesize);
//        List<MgSysLaytime> mgSysLaytimeList = mongoTemplate.find(query,MgSysLaytime.class);
//        return mgSysLaytimeList;
//    }
//
//    //select * from sys_laytime as a where not exists (select 1 from sys_laytime where mid = a.mid and updatetime>a.updatetime)
//    @Override
//    public List<MgSysLaytime> getAllDevicePosition() {
//        List<MgSysLaytime>  mgSysLaytimeList = new ArrayList<MgSysLaytime>();
////        DBCollection coll = (DBCollection)mongoTemplate.getCollection("sys_laytime");
////        List<String> mids = coll.distinct("mid");
////        Query query = new Query();
////        query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"updatetime")));
////        for (String mid:mids) {
////            query.addCriteria(Criteria.where("mid").is(mid)).limit(1);
////            mgSysLaytimeList.add(mongoTemplate.findOne(query,MgSysLaytime.class));
////        }
//
//        String jsonSql = "{distinct:'sys_laytime', key:'mid'}";
//        List<MgSysLaytime> list = mongoTemplate.findDistinct("mid",MgSysLaytime.class,MgSysLaytime.class);
//        Query query = null;
//        for (int i = 0; i < list.size(); i ++) {
//            query = new Query();
//            query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"updatetime")));
//            query.addCriteria(Criteria.where("mid").is(list.get(i))).limit(1);
//            mgSysLaytimeList.add(mongoTemplate.findOne(query,MgSysLaytime.class));
//        }
//        return mgSysLaytimeList;
//    }
}
