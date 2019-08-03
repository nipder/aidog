package com.sec.aidog.pojo;

import java.util.Date;

public class Necareaback {
    private Integer id;

    private Date realtime;

    private String necId;

    private String power;

    private String temperature;

    private String lng;

    private String lat;

    private String necStatus;

    public Necareaback(Integer id, Date realtime, String necId, String power, String temperature, String lng, String lat, String necStatus) {
        this.id = id;
        this.realtime = realtime;
        this.necId = necId;
        this.power = power;
        this.temperature = temperature;
        this.lng = lng;
        this.lat = lat;
        this.necStatus = necStatus;
    }

    public Necareaback() {
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

    public String getNecId() {
        return necId;
    }

    public void setNecId(String necId) {
        this.necId = necId == null ? null : necId.trim();
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

    public String getNecStatus() {
        return necStatus;
    }

    public void setNecStatus(String necStatus) {
        this.necStatus = necStatus == null ? null : necStatus.trim();
    }
}