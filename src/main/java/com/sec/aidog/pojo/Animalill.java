package com.sec.aidog.pojo;

import java.util.Date;

public class Animalill {
    private Integer id;

    private String num;

    private String killplace;

    private String code;

    private String type;

    private String sex;

    private Integer age;

    private String method;

    private String pcr;

    private String pcrSqjqdc;

    private String pcrDfjqdc;

    private String pcrXljqdc;

    private String eyeIllplace;

    private String eyeSize;

    private Integer eyeNum;

    private String checkres;

    private String checkperson;

    private Date checkdate;

    private String note;

    public Animalill(Integer id, String num, String killplace, String code, String type, String sex, Integer age, String method, String pcr, String pcrSqjqdc, String pcrDfjqdc, String pcrXljqdc, String eyeIllplace, String eyeSize, Integer eyeNum, String checkres, String checkperson, Date checkdate, String note) {
        this.id = id;
        this.num = num;
        this.killplace = killplace;
        this.code = code;
        this.type = type;
        this.sex = sex;
        this.age = age;
        this.method = method;
        this.pcr = pcr;
        this.pcrSqjqdc = pcrSqjqdc;
        this.pcrDfjqdc = pcrDfjqdc;
        this.pcrXljqdc = pcrXljqdc;
        this.eyeIllplace = eyeIllplace;
        this.eyeSize = eyeSize;
        this.eyeNum = eyeNum;
        this.checkres = checkres;
        this.checkperson = checkperson;
        this.checkdate = checkdate;
        this.note = note;
    }

    public Animalill() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public String getKillplace() {
        return killplace;
    }

    public void setKillplace(String killplace) {
        this.killplace = killplace == null ? null : killplace.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
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

    public Integer getEyeNum() {
        return eyeNum;
    }

    public void setEyeNum(Integer eyeNum) {
        this.eyeNum = eyeNum;
    }

    public String getCheckres() {
        return checkres;
    }

    public void setCheckres(String checkres) {
        this.checkres = checkres == null ? null : checkres.trim();
    }

    public String getCheckperson() {
        return checkperson;
    }

    public void setCheckperson(String checkperson) {
        this.checkperson = checkperson == null ? null : checkperson.trim();
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}