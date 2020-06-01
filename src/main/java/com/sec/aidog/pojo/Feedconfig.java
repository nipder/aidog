package com.sec.aidog.pojo;

import java.util.Date;

public class Feedconfig {
    private Integer id;

    private String feedId;

    private Integer dosingcycle;

    private Integer areacycle;

    private Date updatetime;

    private Integer dosingtotal;

    private Date firstdosingTime;

    private Date enddosingTime;

    public Feedconfig(Integer id, String feedId, Integer dosingcycle, Integer areacycle, Date updatetime, Integer dosingtotal, Date firstdosingTime, Date enddosingTime) {
        this.id = id;
        this.feedId = feedId;
        this.dosingcycle = dosingcycle;
        this.areacycle = areacycle;
        this.updatetime = updatetime;
        this.dosingtotal = dosingtotal;
        this.firstdosingTime = firstdosingTime;
        this.enddosingTime = enddosingTime;
    }

    public Feedconfig() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId == null ? null : feedId.trim();
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