package com.sec.aidog.pojo;

import java.util.Date;

public class Manure {
    private Integer id;

    private String dogmanureCode;

    private Integer dogownerId;

    private Integer dogId;

    private Date collectionDate;

    private String collectionPerson;

    private String districtcode;

    private Date testingDate;

    private String testingMethod;

    private String testingResult;

    private String testingPerson;

    private String manageMethod;

    private String pcr;

    private String pcrSqjqdc;

    private String pcrDfjqdc;

    private String pcrXljqdc;

    public Manure(Integer id, String dogmanureCode, Integer dogownerId, Integer dogId, Date collectionDate, String collectionPerson, String districtcode, Date testingDate, String testingMethod, String testingResult, String testingPerson, String manageMethod, String pcr, String pcrSqjqdc, String pcrDfjqdc, String pcrXljqdc) {
        this.id = id;
        this.dogmanureCode = dogmanureCode;
        this.dogownerId = dogownerId;
        this.dogId = dogId;
        this.collectionDate = collectionDate;
        this.collectionPerson = collectionPerson;
        this.districtcode = districtcode;
        this.testingDate = testingDate;
        this.testingMethod = testingMethod;
        this.testingResult = testingResult;
        this.testingPerson = testingPerson;
        this.manageMethod = manageMethod;
        this.pcr = pcr;
        this.pcrSqjqdc = pcrSqjqdc;
        this.pcrDfjqdc = pcrDfjqdc;
        this.pcrXljqdc = pcrXljqdc;
    }

    public Manure() {
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

    public String getManageMethod() {
        return manageMethod;
    }

    public void setManageMethod(String manageMethod) {
        this.manageMethod = manageMethod == null ? null : manageMethod.trim();
    }

    public String getPcr() {
        return pcr;
    }

    public void setPcr(String pcr) {
        this.pcr = pcr == null ? null : pcr.trim();
    }

    public String getPcrSqjqdc() {
        return pcrSqjqdc;
    }

    public void setPcrSqjqdc(String pcrSqjqdc) {
        this.pcrSqjqdc = pcrSqjqdc == null ? null : pcrSqjqdc.trim();
    }

    public String getPcrDfjqdc() {
        return pcrDfjqdc;
    }

    public void setPcrDfjqdc(String pcrDfjqdc) {
        this.pcrDfjqdc = pcrDfjqdc == null ? null : pcrDfjqdc.trim();
    }

    public String getPcrXljqdc() {
        return pcrXljqdc;
    }

    public void setPcrXljqdc(String pcrXljqdc) {
        this.pcrXljqdc = pcrXljqdc == null ? null : pcrXljqdc.trim();
    }
}