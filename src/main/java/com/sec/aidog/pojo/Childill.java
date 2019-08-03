package com.sec.aidog.pojo;

import java.util.Date;

public class Childill {
    private Integer id;

    private String num;

    private String school;

    private String name;

    private Integer age;

    private String sex;

    private String classname;

    private String bcheckres;

    private String checkperson;

    private Date checkdate;

    private String note;

    public Childill(Integer id, String num, String school, String name, Integer age, String sex, String classname, String bcheckres, String checkperson, Date checkdate, String note) {
        this.id = id;
        this.num = num;
        this.school = school;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.classname = classname;
        this.bcheckres = bcheckres;
        this.checkperson = checkperson;
        this.checkdate = checkdate;
        this.note = note;
    }

    public Childill() {
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getBcheckres() {
        return bcheckres;
    }

    public void setBcheckres(String bcheckres) {
        this.bcheckres = bcheckres == null ? null : bcheckres.trim();
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