package com.sec.aidog.pojo;

public class Checkres {
    private Integer id;

    private String eyeIllplace;

    private String eyeSize;

    private Integer pcrNum;

    private String pcrSqjqdc;

    private String pcrDfjqdc;

    private String pcrXljqdc;

    private String note;

    public Checkres(Integer id, String eyeIllplace, String eyeSize, Integer pcrNum, String pcrSqjqdc, String pcrDfjqdc, String pcrXljqdc, String note) {
        this.id = id;
        this.eyeIllplace = eyeIllplace;
        this.eyeSize = eyeSize;
        this.pcrNum = pcrNum;
        this.pcrSqjqdc = pcrSqjqdc;
        this.pcrDfjqdc = pcrDfjqdc;
        this.pcrXljqdc = pcrXljqdc;
        this.note = note;
    }

    public Checkres() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEyeIllplace() {
        return eyeIllplace;
    }

    public void setEyeIllplace(String eyeIllplace) {
        this.eyeIllplace = eyeIllplace == null ? null : eyeIllplace.trim();
    }

    public String getEyeSize() {
        return eyeSize;
    }

    public void setEyeSize(String eyeSize) {
        this.eyeSize = eyeSize == null ? null : eyeSize.trim();
    }

    public Integer getPcrNum() {
        return pcrNum;
    }

    public void setPcrNum(Integer pcrNum) {
        this.pcrNum = pcrNum;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}