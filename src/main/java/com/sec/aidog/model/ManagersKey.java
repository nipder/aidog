package com.sec.aidog.model;

public class ManagersKey {
    private Integer managerid;

    private String username;

    public ManagersKey(Integer managerid, String username) {
        this.managerid = managerid;
        this.username = username;
    }

    public ManagersKey() {
        super();
    }

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}