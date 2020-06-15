package com.sec.aidog.pojo;

import java.util.Date;

public class DevPillRecView {
    private String mid;

    private String pillCode;

    private Date configTime;

    private String pillName;

    private String pillFactory;

    private String pillSpec;

    private String pillBatchnum;

    private Date pillExpdate;

    private Date pillBuydate;

    private String pillBuyer;

    private String pillBuyertel;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getPillCode() {
        return pillCode;
    }

    public void setPillCode(String pillCode) {
        this.pillCode = pillCode;
    }

    public Date getConfigTime() {
        return configTime;
    }

    public void setConfigTime(Date configTime) {
        this.configTime = configTime;
    }

    public String getPillName() {
        return pillName;
    }

    public void setPillName(String pillName) {
        this.pillName = pillName;
    }

    public String getPillFactory() {
        return pillFactory;
    }

    public void setPillFactory(String pillFactory) {
        this.pillFactory = pillFactory;
    }

    public String getPillSpec() {
        return pillSpec;
    }

    public void setPillSpec(String pillSpec) {
        this.pillSpec = pillSpec;
    }

    public String getPillBatchnum() {
        return pillBatchnum;
    }

    public void setPillBatchnum(String pillBatchnum) {
        this.pillBatchnum = pillBatchnum;
    }

    public Date getPillExpdate() {
        return pillExpdate;
    }

    public void setPillExpdate(Date pillExpdate) {
        this.pillExpdate = pillExpdate;
    }

    public Date getPillBuydate() {
        return pillBuydate;
    }

    public void setPillBuydate(Date pillBuydate) {
        this.pillBuydate = pillBuydate;
    }

    public String getPillBuyer() {
        return pillBuyer;
    }

    public void setPillBuyer(String pillBuyer) {
        this.pillBuyer = pillBuyer;
    }

    public String getPillBuyertel() {
        return pillBuyertel;
    }

    public void setPillBuyertel(String pillBuyertel) {
        this.pillBuyertel = pillBuyertel;
    }
}
