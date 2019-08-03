package com.sec.aidog.pojo;

import java.util.Date;

public class Pill {
    private Integer id;

    private String pillCode;

    private String pillName;

    private String pillFactory;

    private String pillSpec;

    private String pillBatchnum;

    private Date pillExpdate;

    private Date pillBuydate;

    private String pillBuyer;

    private String pillBuyertel;

    private String districtcode;

    public Pill(Integer id, String pillCode, String pillName, String pillFactory, String pillSpec, String pillBatchnum, Date pillExpdate, Date pillBuydate, String pillBuyer, String pillBuyertel, String districtcode) {
        this.id = id;
        this.pillCode = pillCode;
        this.pillName = pillName;
        this.pillFactory = pillFactory;
        this.pillSpec = pillSpec;
        this.pillBatchnum = pillBatchnum;
        this.pillExpdate = pillExpdate;
        this.pillBuydate = pillBuydate;
        this.pillBuyer = pillBuyer;
        this.pillBuyertel = pillBuyertel;
        this.districtcode = districtcode;
    }

    public Pill() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPillCode() {
        return pillCode;
    }

    public void setPillCode(String pillCode) {
        this.pillCode = pillCode == null ? null : pillCode.trim();
    }

    public String getPillName() {
        return pillName;
    }

    public void setPillName(String pillName) {
        this.pillName = pillName == null ? null : pillName.trim();
    }

    public String getPillFactory() {
        return pillFactory;
    }

    public void setPillFactory(String pillFactory) {
        this.pillFactory = pillFactory == null ? null : pillFactory.trim();
    }

    public String getPillSpec() {
        return pillSpec;
    }

    public void setPillSpec(String pillSpec) {
        this.pillSpec = pillSpec == null ? null : pillSpec.trim();
    }

    public String getPillBatchnum() {
        return pillBatchnum;
    }

    public void setPillBatchnum(String pillBatchnum) {
        this.pillBatchnum = pillBatchnum == null ? null : pillBatchnum.trim();
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
        this.pillBuyer = pillBuyer == null ? null : pillBuyer.trim();
    }

    public String getPillBuyertel() {
        return pillBuyertel;
    }

    public void setPillBuyertel(String pillBuyertel) {
        this.pillBuyertel = pillBuyertel == null ? null : pillBuyertel.trim();
    }

    public String getDistrictcode() {
        return districtcode;
    }

    public void setDistrictcode(String districtcode) {
        this.districtcode = districtcode == null ? null : districtcode.trim();
    }
}