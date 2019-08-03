package com.sec.aidog.pojo;

import javax.persistence.Entity;

@Entity
public class District {
    private Integer id;

    private String districtcode;

    private Integer districtLevel;

    private String districtName;

    private Integer epidemic;

    private String lng;

    private String lat;

    private String echartname;

    public District(Integer id, String districtcode, Integer districtLevel, String districtName, Integer epidemic, String lng, String lat, String echartname) {
        this.id = id;
        this.districtcode = districtcode;
        this.districtLevel = districtLevel;
        this.districtName = districtName;
        this.epidemic = epidemic;
        this.lng = lng;
        this.lat = lat;
        this.echartname = echartname;
    }

    public District() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDistrictcode() {
        return districtcode;
    }

    public void setDistrictcode(String districtcode) {
        this.districtcode = districtcode == null ? null : districtcode.trim();
    }

    public Integer getDistrictLevel() {
        return districtLevel;
    }

    public void setDistrictLevel(Integer districtLevel) {
        this.districtLevel = districtLevel;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

    public Integer getEpidemic() {
        return epidemic;
    }

    public void setEpidemic(Integer epidemic) {
        this.epidemic = epidemic;
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

    public String getEchartname() {
        return echartname;
    }

    public void setEchartname(String echartname) {
        this.echartname = echartname == null ? null : echartname.trim();
    }
}