package com.sec.aidog.pojo;

import java.util.Date;

public class Lastappareaback {
    private Integer id;

    private Date realtime;

    private String appId;

    private String power;

    private String temperature;

    private String lng;

    private String lat;

    private String appStatus;

    public Lastappareaback(Integer id, Date realtime, String appId, String power, String temperature, String lng, String lat, String appStatus) {
        this.id = id;
        this.realtime = realtime;
        this.appId = appId;
        this.power = power;
        this.temperature = temperature;
        this.lng = lng;
        this.lat = lat;
        this.appStatus = appStatus;
    }

    public Lastappareaback() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRealtime() {
        return realtime;
    }

    public void setRealtime(Date realtime) {
        this.realtime = realtime;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
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

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus == null ? null : appStatus.trim();
    }
}