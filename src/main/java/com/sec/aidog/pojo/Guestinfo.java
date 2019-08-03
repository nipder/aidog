package com.sec.aidog.pojo;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

public class Guestinfo {
    @Id
    @GeneratedValue
    public int id;

    public int dogid;

    public String neckletid;

    public String feederid;

    public double lng;

    public double lat;

    public String managername;

    public String managerphone;

    public String ownername;

    public String ownerphone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDogid() {
        return dogid;
    }

    public void setDogid(int dogid) {
        this.dogid = dogid;
    }

    public String getNeckletid() {
        return neckletid;
    }

    public void setNeckletid(String neckletid) {
        this.neckletid = neckletid;
    }

    public String getFeederid() {
        return feederid;
    }

    public void setFeederid(String feederid) {
        this.feederid = feederid;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

    public String getManagerphone() {
        return managerphone;
    }

    public void setManagerphone(String managerphone) {
        this.managerphone = managerphone;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getOwnerphone() {
        return ownerphone;
    }

    public void setOwnerphone(String ownerphone) {
        this.ownerphone = ownerphone;
    }

    public String getDevicehealthy() {
        return devicehealthy;
    }

    public void setDevicehealthy(String devicehealthy) {
        this.devicehealthy = devicehealthy;
    }

    public String devicehealthy;
}

