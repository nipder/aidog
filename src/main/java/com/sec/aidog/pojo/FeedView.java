package com.sec.aidog.pojo;

import java.util.Date;

public class FeedView {

    private Integer id;
    private String feedId;
    private String pillcode;
    private String dosingstatus;   //投药状态
    private String dosingvideo;
    private Date firstDosingTime;
    private Date nextDosingTime;
    private Integer leftnum;
    private String power;
    private String temperature;
    private String confstatus;
    private String err;
    private Date lastUpdateTime;

    public String getDistrictcode() {
        return districtcode;
    }

    public void setDistrictcode(String districtcode) {
        this.districtcode = districtcode;
    }

    private String districtcode;

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
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
        this.feedId = feedId;
    }

    public String getPillcode() {
        return pillcode;
    }

    public void setPillcode(String pillcode) {
        this.pillcode = pillcode;
    }

    public String getDosingstatus() {
        return dosingstatus;
    }

    public void setDosingstatus(String dosingstatus) {
        this.dosingstatus = dosingstatus;
    }
    
    public String getDosingvideo() {
        return dosingvideo;
    }

    public void setDosingvideo(String dosingvideo) {
        this.dosingvideo = dosingvideo;
    }

    public Date getFirstDosingTime() {
        return firstDosingTime;
    }

    public void setFirstDosingTime(Date firstDosingTime) {
        this.firstDosingTime = firstDosingTime;
    }

    public Date getNextDosingTime() {
        return nextDosingTime;
    }

    public void setNextDosingTime(Date nextDosingTime) {
        this.nextDosingTime = nextDosingTime;
    }

    public Integer getLeftnum() {
        return leftnum;
    }

    public void setLeftnum(Integer leftnum) {
        this.leftnum = leftnum;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getConfstatus() {
        return confstatus;
    }

    public void setConfstatus(String confstatus) {
        this.confstatus = confstatus;
    }
}
