package com.sec.aidog.pojo;

import com.sec.aidog.model.ManagersKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Mapper
@Component
public class Managers extends ManagersKey implements Serializable {
    private String managername;

    private String logintime;

    private String managertel;

    private String managerphone;

    private String password;

    private Integer privilegelevel;

    private String privilegedetail;

    private Integer managerstatus;

    private String managerretirtime;

    private String province;

    private String city;

    private String county;

    private String officecall;

    private String address;

    private String upusername;

    private String village;

    private String hamlet;

    private String workplace;

    private String chargehamlet;

    private String manageridentity;

    private String email;

    private Long districtcode;

    public Managers(Integer managerid, String username, String managername, String logintime, String managertel, String managerphone, String password, Integer privilegelevel, String privilegedetail, Integer managerstatus, String managerretirtime, String province, String city, String county, String officecall, String address, String upusername, String village, String hamlet, String workplace, String chargehamlet, String manageridentity, String email, Long districtcode) {
        super(managerid, username);
        this.managername = managername;
        this.logintime = logintime;
        this.managertel = managertel;
        this.managerphone = managerphone;
        this.password = password;
        this.privilegelevel = privilegelevel;
        this.privilegedetail = privilegedetail;
        this.managerstatus = managerstatus;
        this.managerretirtime = managerretirtime;
        this.province = province;
        this.city = city;
        this.county = county;
        this.officecall = officecall;
        this.address = address;
        this.upusername = upusername;
        this.village = village;
        this.hamlet = hamlet;
        this.workplace = workplace;
        this.chargehamlet = chargehamlet;
        this.manageridentity = manageridentity;
        this.email = email;
        this.districtcode = districtcode;
    }

    public Managers() {
        super();
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername == null ? null : managername.trim();
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime == null ? null : logintime.trim();
    }

    public String getManagertel() {
        return managertel;
    }

    public void setManagertel(String managertel) {
        this.managertel = managertel == null ? null : managertel.trim();
    }

    public String getManagerphone() {
        return managerphone;
    }

    public void setManagerphone(String managerphone) {
        this.managerphone = managerphone == null ? null : managerphone.trim();
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

    public String getPrivilegedetail() {
        return privilegedetail;
    }

    public void setPrivilegedetail(String privilegedetail) {
        this.privilegedetail = privilegedetail == null ? null : privilegedetail.trim();
    }

    public Integer getManagerstatus() {
        return managerstatus;
    }

    public void setManagerstatus(Integer managerstatus) {
        this.managerstatus = managerstatus;
    }

    public String getManagerretirtime() {
        return managerretirtime;
    }

    public void setManagerretirtime(String managerretirtime) {
        this.managerretirtime = managerretirtime == null ? null : managerretirtime.trim();
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

    public String getOfficecall() {
        return officecall;
    }

    public void setOfficecall(String officecall) {
        this.officecall = officecall == null ? null : officecall.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getUpusername() {
        return upusername;
    }

    public void setUpusername(String upusername) {
        this.upusername = upusername == null ? null : upusername.trim();
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

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace == null ? null : workplace.trim();
    }

    public String getChargehamlet() {
        return chargehamlet;
    }

    public void setChargehamlet(String chargehamlet) {
        this.chargehamlet = chargehamlet == null ? null : chargehamlet.trim();
    }

    public String getManageridentity() {
        return manageridentity;
    }

    public void setManageridentity(String manageridentity) {
        this.manageridentity = manageridentity == null ? null : manageridentity.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getDistrictcode() {
        return districtcode;
    }

    public void setDistrictcode(Long districtcode) {
        this.districtcode = districtcode;
    }

}