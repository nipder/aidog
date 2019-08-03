package com.sec.aidog.pojo;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Manager {
    private Integer managerId;

    private String username;

    private String managerName;

    private Date registerTime;

    private String managerTel;

    private String officetel;

    private String password;

    private Integer privilegelevel;

    private Integer managerStatus;

    private String province;

    private String city;

    private String county;

    private String village;

    private String hamlet;

    private String managerAddr;

    private String workplace;

    private String managerIdentity;

    private String managerEmail;

    private String districtcode;

    public Manager(Integer managerId, String username, String managerName, Date registerTime, String managerTel, String officetel, String password, Integer privilegelevel, Integer managerStatus, String province, String city, String county, String village, String hamlet, String managerAddr, String workplace, String managerIdentity, String managerEmail, String districtcode) {
        this.managerId = managerId;
        this.username = username;
        this.managerName = managerName;
        this.registerTime = registerTime;
        this.managerTel = managerTel;
        this.officetel = officetel;
        this.password = password;
        this.privilegelevel = privilegelevel;
        this.managerStatus = managerStatus;
        this.province = province;
        this.city = city;
        this.county = county;
        this.village = village;
        this.hamlet = hamlet;
        this.managerAddr = managerAddr;
        this.workplace = workplace;
        this.managerIdentity = managerIdentity;
        this.managerEmail = managerEmail;
        this.districtcode = districtcode;
    }

    public Manager() {
        super();
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
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

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getManagerTel() {
        return managerTel;
    }

    public void setManagerTel(String managerTel) {
        this.managerTel = managerTel == null ? null : managerTel.trim();
    }

    public String getOfficetel() {
        return officetel;
    }

    public void setOfficetel(String officetel) {
        this.officetel = officetel == null ? null : officetel.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getPrivilegelevel() {
        return privilegelevel;
    }

    public void setPrivilegelevel(Integer privilegelevel) {
        this.privilegelevel = privilegelevel;
    }

    public Integer getManagerStatus() {
        return managerStatus;
    }

    public void setManagerStatus(Integer managerStatus) {
        this.managerStatus = managerStatus;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village == null ? null : village.trim();
    }

    public String getHamlet() {
        return hamlet;
    }

    public void setHamlet(String hamlet) {
        this.hamlet = hamlet == null ? null : hamlet.trim();
    }

    public String getManagerAddr() {
        return managerAddr;
    }

    public void setManagerAddr(String managerAddr) {
        this.managerAddr = managerAddr == null ? null : managerAddr.trim();
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace == null ? null : workplace.trim();
    }

    public String getManagerIdentity() {
        return managerIdentity;
    }

    public void setManagerIdentity(String managerIdentity) {
        this.managerIdentity = managerIdentity == null ? null : managerIdentity.trim();
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail == null ? null : managerEmail.trim();
    }

    public String getDistrictcode() {
        return districtcode;
    }

    public void setDistrictcode(String districtcode) {
        this.districtcode = districtcode == null ? null : districtcode.trim();
    }
}