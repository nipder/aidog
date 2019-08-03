package com.sec.aidog.model;

public class SysDeviceconfKey {
    private Integer id;

    private String mid;

    public SysDeviceconfKey(Integer id, String mid) {
        this.id = id;
        this.mid = mid;
    }

    public SysDeviceconfKey() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }
}