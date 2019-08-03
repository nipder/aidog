package com.sec.aidog.pojo;


import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Necdosing {
    private Integer id;

    private Date realtime;

    private String necId;

    private String lng;

    private String lat;

    private String districtcode;

    public Necdosing(Integer id, Date realtime, String necId, String lng, String lat, String districtcode) {
        this.id = id;
        this.realtime = realtime;
        this.necId = necId;
        this.lng = lng;
        this.lat = lat;
        this.districtcode = districtcode;
    }

    public Necdosing() {
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