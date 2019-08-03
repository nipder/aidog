package com.sec.aidog.pojo;

public class Dogowner {
    private Integer ownerId;

    private String ownerName;

    private String ownerTel;

    private String ownerAddr;

    private Integer ownerStatus;

    private String ownerIdentity;

    private String ownerSex;

    private Integer ownerAge;

    private String ownerJob;

    private String districtcode;

    public Dogowner(Integer ownerId, String ownerName, String ownerTel, String ownerAddr, Integer ownerStatus, String ownerIdentity, String ownerSex, Integer ownerAge, String ownerJob, String districtcode) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.ownerTel = ownerTel;
        this.ownerAddr = ownerAddr;
        this.ownerStatus = ownerStatus;
        this.ownerIdentity = ownerIdentity;
        this.ownerSex = ownerSex;
        this.ownerAge = ownerAge;
        this.ownerJob = ownerJob;
        this.districtcode = districtcode;
    }

    public Dogowner() {
        super();
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public String getOwnerTel() {
        return ownerTel;
    }

    public void setOwnerTel(String ownerTel) {
        this.ownerTel = ownerTel == null ? null : ownerTel.trim();
    }

    public String getOwnerAddr() {
        return ownerAddr;
    }

    public void setOwnerAddr(String ownerAddr) {
        this.ownerAddr = ownerAddr == null ? null : ownerAddr.trim();
    }

    public Integer getOwnerStatus() {
        return ownerStatus;
    }

    public void setOwnerStatus(Integer ownerStatus) {
        this.ownerStatus = ownerStatus;
    }

    public String getOwnerIdentity() {
        return ownerIdentity;
    }

    public void setOwnerIdentity(String ownerIdentity) {
        this.ownerIdentity = ownerIdentity == null ? null : ownerIdentity.trim();
    }

    public String getOwnerSex() {
        return ownerSex;
    }

    public void setOwnerSex(String ownerSex) {
        this.ownerSex = ownerSex == null ? null : ownerSex.trim();
    }

    public Integer getOwnerAge() {
        return ownerAge;
    }

    public void setOwnerAge(Integer ownerAge) {
        this.ownerAge = ownerAge;
    }

    public String getOwnerJob() {
        return ownerJob;
    }

    public void setOwnerJob(String ownerJob) {
        this.ownerJob = ownerJob == null ? null : ownerJob.trim();
    }

    public String getDistrictcode() {
        return districtcode;
    }

    public void setDistrictcode(String districtcode) {
        this.districtcode = districtcode == null ? null : districtcode.trim();
    }
}