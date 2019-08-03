package com.sec.aidog.pojo;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Appdosing {
    private Integer id;

    private Date realtime;

    private String appId;

    private String lng;

    private String lat;

    private String districtcode;

    public Appdosing(Integer id, Date realtime, String appId, String lng, String lat, String districtcode) {
        this.id = id;
        this.realtime = realtime;
        this.appId = appId;
        this.lng = lng;
        this.lat = lat;
        this.districtcode = districtcode;
    }

    public Appdosing() {
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
}