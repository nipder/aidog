package com.sec.aidog.pojo;

import java.util.Date;

public class Feed {
    private Integer id;

    private String feedId;

    private String pillCode;

    private Date produceTime;

    private Date registerTime;

    private Integer dosingTotal;

    private Date changebatteryTime;

    private Date changepillTime;

    private Date bindTime;

    private String hamlet;

    private String districtcode;

    public Feed(Integer id, String feedId, String pillCode, Date produceTime, Date registerTime, Integer dosingTotal, Date changebatteryTime, Date changepillTime, Date bindTime, String hamlet, String districtcode) {
        this.id = id;
        this.feedId = feedId;
        this.pillCode = pillCode;
        this.produceTime = produceTime;
        this.registerTime = registerTime;
        this.dosingTotal = dosingTotal;
        this.changebatteryTime = changebatteryTime;
        this.changepillTime = changepillTime;
        this.bindTime = bindTime;
        this.hamlet = hamlet;
        this.districtcode = districtcode;
    }

    public Feed() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId == null ? null : feedId.trim();
    }

    public String getPillCode() {
        return pillCode;
    }

    public void setPillCode(String pillCode) {
        this.pillCode = pillCode == null ? null : pillCode.trim();
    }


    public Date getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Date produceTime) {
        this.produceTime = produceTime;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getDosingTotal() {
        return dosingTotal;
    }

    public void setDosingTotal(Integer dosingTotal) {
        this.dosingTotal = dosingTotal;
    }

    public Date getChangebatteryTime() {
        return changebatteryTime;
    }

    public void setChangebatteryTime(Date changebatteryTime) {
        this.changebatteryTime = changebatteryTime;
    }

    public Date getChangepillTime() {
        return changepillTime;
    }

    public void setChangepillTime(Date changepillTime) {
        this.changepillTime = changepillTime;
    }

    public Date getBindTime() {
        return bindTime;
    }

    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    public String getHamlet() {
        return hamlet;
    }

    public void setHamlet(String hamlet) {
        this.hamlet = hamlet == null ? null : hamlet.trim();
    }

    public String getDistrictcode() {
        return districtcode;
    }

    public void setDistrictcode(String districtcode) {
        this.districtcode = districtcode == null ? null : districtcode.trim();
    }
}
