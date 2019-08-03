package com.sec.aidog.pojo;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Dog {
    private Integer dogId;

    private String dogName;

    private String necId;

    private String appId;

    private String username;

    private String managerName;

    private Integer dogownerId;

    private String dogWeight;

    private String dogColor;

    private Integer dogAge;

    private String dogInfo;

    private String dogStatus;

    private Date dogRegistertime;

    private String dogSex;

    private String dogGovcode;

    private String districtcode;

    public Dog(Integer dogId, String dogName, String necId, String appId, String username, String managerName, Integer dogownerId, String dogWeight, String dogColor, Integer dogAge, String dogInfo, String dogStatus, Date dogRegistertime, String dogSex, String dogGovcode, String districtcode) {
        this.dogId = dogId;
        this.dogName = dogName;
        this.necId = necId;
        this.appId = appId;
        this.username = username;
        this.managerName = managerName;
        this.dogownerId = dogownerId;
        this.dogWeight = dogWeight;
        this.dogColor = dogColor;
        this.dogAge = dogAge;
        this.dogInfo = dogInfo;
        this.dogStatus = dogStatus;
        this.dogRegistertime = dogRegistertime;
        this.dogSex = dogSex;
        this.dogGovcode = dogGovcode;
        this.districtcode = districtcode;
    }

    public Dog() {
        super();
    }

    public Integer getDogId() {
        return dogId;
    }

    public void setDogId(Integer dogId) {
        this.dogId = dogId;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName == null ? null : dogName.trim();
    }

    public String getNecId() {
        return necId;
    }

    public void setNecId(String necId) {
        this.necId = necId == null ? null : necId.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    public Integer getDogownerId() {
        return dogownerId;
    }

    public void setDogownerId(Integer dogownerId) {
        this.dogownerId = dogownerId;
    }

    public String getDogWeight() {
        return dogWeight;
    }

    public void setDogWeight(String dogWeight) {
        this.dogWeight = dogWeight == null ? null : dogWeight.trim();
    }

    public String getDogColor() {
        return dogColor;
    }

    public void setDogColor(String dogColor) {
        this.dogColor = dogColor == null ? null : dogColor.trim();
    }

    public Integer getDogAge() {
        return dogAge;
    }

    public void setDogAge(Integer dogAge) {
        this.dogAge = dogAge;
    }

    public String getDogInfo() {
        return dogInfo;
    }

    public void setDogInfo(String dogInfo) {
        this.dogInfo = dogInfo == null ? null : dogInfo.trim();
    }

    public String getDogStatus() {
        return dogStatus;
    }

    public void setDogStatus(String dogStatus) {
        this.dogStatus = dogStatus == null ? null : dogStatus.trim();
    }

    public Date getDogRegistertime() {
        return dogRegistertime;
    }

    public void setDogRegistertime(Date dogRegistertime) {
        this.dogRegistertime = dogRegistertime;
    }

    public String getDogSex() {
        return dogSex;
    }

    public void setDogSex(String dogSex) {
        this.dogSex = dogSex == null ? null : dogSex.trim();
    }

    public String getDogGovcode() {
        return dogGovcode;
    }

    public void setDogGovcode(String dogGovcode) {
        this.dogGovcode = dogGovcode == null ? null : dogGovcode.trim();
    }

    public String getDistrictcode() {
        return districtcode;
    }

    public void setDistrictcode(String districtcode) {
        this.districtcode = districtcode == null ? null : districtcode.trim();
    }
}