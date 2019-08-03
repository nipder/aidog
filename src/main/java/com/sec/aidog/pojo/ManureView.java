package com.sec.aidog.pojo;

import java.util.Date;

public class ManureView {
    private Integer id;

    private Integer num;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    private String dogmanureCode;

    private Integer dogownerId;

    private String ownerIndentity;

    private String managemethod;

    private Integer dogId;

    private Date collectionDate;

    private String collectionPerson;

    private String districtcode;

    private Date testingDate;

    private String testingMethod;

    private String testingResult;

    private String testingPerson;

    private String deviceId;

    private String pcrSqjqdc;

    private String pcrDfjqdc;

    private String pcrXljqdc;

    public String getPcrSqjqdc() {
        return pcrSqjqdc;
    }

    public void setPcrSqjqdc(String pcrSqjqdc) {
        this.pcrSqjqdc = pcrSqjqdc;
    }

    public String getPcrDfjqdc() {
        return pcrDfjqdc;
    }

    public void setPcrDfjqdc(String pcrDfjqdc) {
        this.pcrDfjqdc = pcrDfjqdc;
    }

    public String getPcrXljqdc() {
        return pcrXljqdc;
    }

    public void setPcrXljqdc(String pcrXljqdc) {
        this.pcrXljqdc = pcrXljqdc;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getOwnerIndentity() {
        return ownerIndentity;
    }

    public void setOwnerIndentity(String ownerIndentity) {
        this.ownerIndentity = ownerIndentity;
    }

    public String getManagemethod() {
        return managemethod;
    }

    public void setManagemethod(String managemethod) {
        this.managemethod = managemethod;
    }

    public ManureView() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDogmanureCode() {
        return dogmanureCode;
    }

    public void setDogmanureCode(String dogmanureCode) {
        this.dogmanureCode = dogmanureCode == null ? null : dogmanureCode.trim();
    }

    public Integer getDogownerId() {
        return dogownerId;
    }

    public void setDogownerId(Integer dogownerId) {
        this.dogownerId = dogownerId;
    }

    public Integer getDogId() {
        return dogId;
    }

    public void setDogId(Integer dogId) {
        this.dogId = dogId;
    }

    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    public String getCollectionPerson() {
        return collectionPerson;
    }

    public void setCollectionPerson(String collectionPerson) {
        this.collectionPerson = collectionPerson == null ? null : collectionPerson.trim();
    }

    public String getDistrictcode() {
        return districtcode;
    }

    public void setDistrictcode(String districtcode) {
        this.districtcode = districtcode == null ? null : districtcode.trim();
    }

    public Date getTestingDate() {
        return testingDate;
    }

    public void setTestingDate(Date testingDate) {
        this.testingDate = testingDate;
    }

    public String getTestingMethod() {
        return testingMethod;
    }

    public void setTestingMethod(String testingMethod) {
        this.testingMethod = testingMethod == null ? null : testingMethod.trim();
    }

    public String getTestingResult() {
        return testingResult;
    }

    public void setTestingResult(String testingResult) {
        this.testingResult = testingResult == null ? null : testingResult.trim();
    }

    public String getTestingPerson() {
        return testingPerson;
    }

    public void setTestingPerson(String testingPerson) {
        this.testingPerson = testingPerson == null ? null : testingPerson.trim();
    }


    private String dogName;

    private String dogGovcode;

    private String ownerName;

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogGovcode() {
        return dogGovcode;
    }

    public void setDogGovcode(String dogGovcode) {
        this.dogGovcode = dogGovcode;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
