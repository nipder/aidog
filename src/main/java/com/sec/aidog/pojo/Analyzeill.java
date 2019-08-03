package com.sec.aidog.pojo;

public class Analyzeill {
    private Integer id;

    private String districtcode;

    private Integer districtLevel;

    private String districtName;

    private Integer epidemic;

    private String lng;

    private String lat;

    private String echartname;

    private Integer personnum;

    private Integer personillnum;

    private Double personilllevel;

    private Integer dognum;

    private Integer dogillnum;

    private Double dogilllevel;

    public Analyzeill(Integer id, String districtcode, Integer districtLevel, String districtName, Integer epidemic, String lng, String lat, String echartname, Integer personnum, Integer personillnum, Double personilllevel, Integer dognum, Integer dogillnum, Double dogilllevel) {
        this.id = id;
        this.districtcode = districtcode;
        this.districtLevel = districtLevel;
        this.districtName = districtName;
        this.epidemic = epidemic;
        this.lng = lng;
        this.lat = lat;
        this.echartname = echartname;
        this.personnum = personnum;
        this.personillnum = personillnum;
        this.personilllevel = personilllevel;
        this.dognum = dognum;
        this.dogillnum = dogillnum;
        this.dogilllevel = dogilllevel;
    }

    public Analyzeill() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDistrictcode() {
        return districtcode;
    }

    public void setDistrictcode(String districtcode) {
        this.districtcode = districtcode == null ? null : districtcode.trim();
    }

    public Integer getDistrictLevel() {
        return districtLevel;
    }

    public void setDistrictLevel(Integer districtLevel) {
        this.districtLevel = districtLevel;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

    public Integer getEpidemic() {
        return epidemic;
    }

    public void setEpidemic(Integer epidemic) {
        this.epidemic = epidemic;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public String getEchartname() {
        return echartname;
    }

    public void setEchartname(String echartname) {
        this.echartname = echartname == null ? null : echartname.trim();
    }

    public Integer getPersonnum() {
        return personnum;
    }

    public void setPersonnum(Integer personnum) {
        this.personnum = personnum;
    }

    public Integer getPersonillnum() {
        return personillnum;
    }

    public void setPersonillnum(Integer personillnum) {
        this.personillnum = personillnum;
    }

    public Double getPersonilllevel() {
        return personilllevel;
    }

    public void setPersonilllevel(Double personilllevel) {
        this.personilllevel = personilllevel;
    }

    public Integer getDognum() {
        return dognum;
    }

    public void setDognum(Integer dognum) {
        this.dognum = dognum;
    }

    public Integer getDogillnum() {
        return dogillnum;
    }

    public void setDogillnum(Integer dogillnum) {
        this.dogillnum = dogillnum;
    }

    public Double getDogilllevel() {
        return dogilllevel;
    }

    public void setDogilllevel(Double dogilllevel) {
        this.dogilllevel = dogilllevel;
    }
}