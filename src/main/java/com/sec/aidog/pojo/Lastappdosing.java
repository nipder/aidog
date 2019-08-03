package com.sec.aidog.pojo;

import java.util.Date;

public class Lastappdosing {
    private Integer id;

    private String appId;

    private Date firstdosingTime;

    private Date lastdosingTime;

    private Date nextdosingTime;

    private Date enddosingTime;

    private Integer leftNum;

    private String dosingMethod;

    private String appStatus;

    private String pillCode;

    private String power;

    private String temperature;

    private Date realtime;

    private String lng;

    private String lat;

    private String districtcode;

    private Integer positioncycle;

    private Integer dosingcycle;

    private Date errTime;

    private Integer errNum;

    public Lastappdosing(Integer id, String appId, Date firstdosingTime, Date lastdosingTime, Date nextdosingTime, Date enddosingTime, Integer leftNum, String dosingMethod, String appStatus, String pillCode, String power, String temperature, Date realtime, String lng, String lat, String districtcode, Integer positioncycle, Integer dosingcycle, Date errTime, Integer errNum) {
        this.id = id;
        this.appId = appId;
        this.firstdosingTime = firstdosingTime;
        this.lastdosingTime = lastdosingTime;
        this.nextdosingTime = nextdosingTime;
        this.enddosingTime = enddosingTime;
        this.leftNum = leftNum;
        this.dosingMethod = dosingMethod;
        this.appStatus = appStatus;
        this.pillCode = pillCode;
        this.power = power;
        this.temperature = temperature;
        this.realtime = realtime;
        this.lng = lng;
        this.lat = lat;
        this.districtcode = districtcode;
        this.positioncycle = positioncycle;
        this.dosingcycle = dosingcycle;
        this.errTime = errTime;
        this.errNum = errNum;
    }

    public Lastappdosing() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public Date getFirstdosingTime() {
        return firstdosingTime;
    }

    public void setFirstdosingTime(Date firstdosingTime) {
        this.firstdosingTime = firstdosingTime;
    }

    public Date getLastdosingTime() {
        return lastdosingTime;
    }

    public void setLastdosingTime(Date lastdosingTime) {
        this.lastdosingTime = lastdosingTime;
    }

    public Date getNextdosingTime() {
        return nextdosingTime;
    }

    public void setNextdosingTime(Date nextdosingTime) {
        this.nextdosingTime = nextdosingTime;
    }

    public Date getEnddosingTime() {
        return enddosingTime;
    }

    public void setEnddosingTime(Date enddosingTime) {
        this.enddosingTime = enddosingTime;
    }

    public Integer getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(Integer leftNum) {
        this.leftNum = leftNum;
    }

    public String getDosingMethod() {
        return dosingMethod;
    }

    public void setDosingMethod(String dosingMethod) {
        this.dosingMethod = dosingMethod == null ? null : dosingMethod.trim();
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus == null ? null : appStatus.trim();
    }

    public String getPillCode() {
        return pillCode;
    }

    public void setPillCode(String pillCode) {
        this.pillCode = pillCode == null ? null : pillCode.trim();
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power == null ? null : power.trim();
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature == null ? null : temperature.trim();
    }

    public Date getRealtime() {
        return realtime;
    }

    public void setRealtime(Date realtime) {
        this.realtime = realtime;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public String getDistrictcode() {
        return districtcode;
    }

    public void setDistrictcode(String districtcode) {
        this.districtcode = districtcode == null ? null : districtcode.trim();
    }

    public Integer getPositioncycle() {
        return positioncycle;
    }

    public void setPositioncycle(Integer positioncycle) {
        this.positioncycle = positioncycle;
    }

    public Integer getDosingcycle() {
        return dosingcycle;
    }

    public void setDosingcycle(Integer dosingcycle) {
        this.dosingcycle = dosingcycle;
    }

    public Date getErrTime() {
        return errTime;
    }

    public void setErrTime(Date errTime) {
        this.errTime = errTime;
    }

    public Integer getErrNum() {
        return errNum;
    }

    public void setErrNum(Integer errNum) {
        this.errNum = errNum;
    }
}