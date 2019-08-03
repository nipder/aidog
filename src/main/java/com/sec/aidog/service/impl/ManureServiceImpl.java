package com.sec.aidog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sec.aidog.dao.DogMapper;
import com.sec.aidog.dao.DogownerMapper;
import com.sec.aidog.dao.ManureMapper;
import com.sec.aidog.model.ManureExample;
import com.sec.aidog.pojo.Dog;
import com.sec.aidog.pojo.Dogowner;
import com.sec.aidog.pojo.Manure;
import com.sec.aidog.pojo.ManureView;
import com.sec.aidog.service.ManureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("manureService")
public class ManureServiceImpl implements ManureService{

    @Autowired
    private ManureMapper manureMapper;

    @Autowired
    private DogownerMapper dogownerMapper;

    @Autowired
    private DogMapper dogMapper;

    @Override
    public Map<String, Object> getManureList(String districtcode, int startPage, int pageSize) {
        Page page = PageHelper.startPage(startPage, pageSize);
        ManureExample example = new ManureExample();
        example.createCriteria().andDistrictcodeLike(districtcode);
        List<Manure> manurelist = manureMapper.selectByExample(example);
        List<ManureView> manureviewlist = new ArrayList<>();
        ManureView manureView = null;
        Integer num = 1;
        for(Manure manure: manurelist){
            manureView = new ManureView();
            manureView.setId(manure.getId());
            manureView.setCollectionDate(manure.getCollectionDate());
            manureView.setCollectionPerson(manure.getCollectionPerson());
            manureView.setDistrictcode(manure.getDistrictcode());
            manureView.setDogId(manure.getDogId());
            manureView.setDogmanureCode(manure.getDogmanureCode());
            manureView.setDogownerId(manure.getDogownerId());
            manureView.setTestingDate(manure.getTestingDate());
            manureView.setTestingMethod(manure.getTestingMethod());
            manureView.setTestingPerson(manure.getTestingPerson());
            manureView.setTestingResult(manure.getTestingResult());
            manureView.setPcrSqjqdc(manure.getPcrSqjqdc());
            manureView.setPcrDfjqdc(manure.getPcrDfjqdc());
            manureView.setPcrXljqdc(manure.getPcrXljqdc());
            Dogowner dogowner = dogownerMapper.selectByPrimaryKey(manure.getDogownerId());
            String ownername = dogowner.getOwnerName();
            String owneridentity = dogowner.getOwnerIdentity();
            Dog dog = dogMapper.selectByPrimaryKey(manure.getDogId());
            String dogname = dog.getDogName();
            String govcode = dog.getDogGovcode();
            manureView.setOwnerName(ownername);
            manureView.setOwnerIndentity(owneridentity);
            manureView.setDogName(dogname);
            manureView.setDogGovcode(govcode);
            if(!dog.getNecId().equals("-1" )&& dog.getAppId().equals("-1")){
                manureView.setManagemethod("项圈管理");
                manureView.setDeviceId(dog.getNecId());
            }else if(!dog.getAppId().equals("-1" ) && dog.getNecId().equals("-1")){
                manureView.setManagemethod("喂饲器管理");
                manureView.setDeviceId(dog.getAppId());
            }else if(dog.getNecId().equals("-1") && dog.getAppId().equals("-1")){
                manureView.setManagemethod("人工管理");
                manureView.setDeviceId("无设备");
            }
            manureView.setNum(num);
            num++;
            manureviewlist.add(manureView);
        }
        Map<String, Object> map = new HashMap<String,Object>();
        //每页信息
        map.put("data", manureviewlist);
        //管理员总数
        map.put("totalNum", page.getTotal());
        return map;
    }

    @Override
    public boolean addManure(String dogmanure_code, Integer dogowner_id, Integer dog_id, String collection_person, String districtcode,Date date, String managetype) {
        Manure manure = new Manure();
        manure.setDogmanureCode(dogmanure_code);
        manure.setDogownerId(dogowner_id);
        manure.setDogId(dog_id);
        manure.setCollectionDate(date);
        manure.setCollectionPerson(collection_person);
        manure.setDistrictcode(districtcode);
        manure.setManageMethod(managetype);
        boolean flag = manureMapper.insert(manure)==1?true:false;
        return flag;
    }

    @Override
    public boolean modifyManure(Integer manureid, String testmethod, Date testdate, String testresult, String testperson) {
        Manure manure = manureMapper.selectByPrimaryKey(manureid);
        manure.setTestingMethod(testmethod);
        manure.setTestingDate(testdate);
        manure.setTestingResult(testresult);
        manure.setTestingPerson(testperson);
        boolean flag = manureMapper.updateByPrimaryKey(manure)==1?true:false;
        return flag;
    }
}
