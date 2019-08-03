package com.sec.aidog.pojo;

import java.util.Date;

public class Necconfig {
    private Integer id;

    private String necId;

    private Integer dosingcycle;

    private Integer areacycle;

    private Date updatetime;

    private Integer dosingtotal;

    private Date firstdosingTime;

    private Date enddosingTime;

    public Necconfig(Integer id, String necId, Integer dosingcycle, Integer areacycle, Date updatetime, Integer dosingtotal, Date firstdosingTime, Date enddosingTime) {
        this.id = id;
        this.necId = necId;
        this.dosingcycle = dosingcycle;
        this.areacycle = areacycle;
        this.updatetime = updatetime;
        this.dosingtotal = dosingtotal;
        this.firstdosingTime = firstdosingTime;
        this.enddosingTime = enddosingTime;
    }

    public Necconfig() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNecId() {
        return necId;
    }

    public void setNecId(String necId) {
        this.necId = necId == null ? null : necId.trim();
    }

    public Integer getDosingcycle() {
        return dosingcycle;
    }

    public void setDosingcycle(Integer dosingcycle) {
        this.dosingcycle = dosingcycle;
    }

    public Integer getAreacycle() {
        return areacycle;
    }

    public void setAreacycle(Integer areacycle) {
        this.areacycle = areacycle;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getDosingtotal() {
        return dosingtotal;
    }

    public void setDosingtotal(Integer dosingtotal) {
        this.dosingtotal = dosingtotal;
    }

    public Date getFirstdosingTime() {
        return firstdosingTime;
    }

    public void setFirstdosingTime(Date firstdosingTime) {
        this.firstdosingTime = firstdosingTime;
    }

    public Date getEnddosingTime() {
        return enddosingTime;
    }

    public void setEnddosingTime(Date enddosingTime) {
        this.enddosingTime = enddosingTime;
    }
}