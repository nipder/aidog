package com.sec.aidog.pojo;

import java.util.Date;

public class Lastfeedareaback {
    private Integer id;

    private Date realtime;

    private String feedId;

    private String power;

    private String temperature;

    private String lng;

    private String lat;

    private String feedStatus;

    public Lastfeedareaback(Integer id, Date realtime, String feedId, String power, String temperature, String lng, String lat, String feedStatus) {
        this.id = id;
        this.realtime = realtime;
        this.feedId = feedId;
        this.power = power;
        this.temperature = temperature;
        this.lng = lng;
        this.lat = lat;
        this.feedStatus = feedStatus;
    }

    public Lastfeedareaback() {
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

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId == null ? null : feedId.trim();
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

    public String getFeedStatus() {
        return feedStatus;
    }

    public void setFeedStatus(String feedStatus) {
        this.feedStatus = feedStatus == null ? null : feedStatus.trim();
    }
}