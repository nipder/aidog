package com.sec.aidog.pojo;


import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Feeddosing {
    private Integer id;

    private Date realtime;

    private String feedId;

    private String lng;

    private String lat;

    private String districtcode;

    public Feeddosing(Integer id, Date realtime, String feedId, String lng, String lat, String districtcode) {
        this.id = id;
        this.realtime = realtime;
        this.feedId = feedId;
        this.lng = lng;
        this.lat = lat;
        this.districtcode = districtcode;
    }

    public Feeddosing() {
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