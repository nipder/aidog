package com.sec.aidog.pojo;

import java.util.Date;

public class DevResource {
    private String id;

    private Integer category;

    private Date createtime;

    private String createrid;

    private String extension;

    private Double imgh;

    private Double imgw;

    private Double latitude;

    private Double longitude;

    private String name;

    private String path;

    private Double posx;

    private Double posy;

    private String qiniuurl;

    private Long size;

    private Integer type;

    private Date updatetime;

    private String updaterid;

    private String url;

    private String resourcedescribe;

    public DevResource(String id, Integer category, Date createtime, String createrid, String extension, Double imgh, Double imgw, Double latitude, Double longitude, String name, String path, Double posx, Double posy, String qiniuurl, Long size, Integer type, Date updatetime, String updaterid, String url, String resourcedescribe) {
        this.id = id;
        this.category = category;
        this.createtime = createtime;
        this.createrid = createrid;
        this.extension = extension;
        this.imgh = imgh;
        this.imgw = imgw;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.path = path;
        this.posx = posx;
        this.posy = posy;
        this.qiniuurl = qiniuurl;
        this.size = size;
        this.type = type;
        this.updatetime = updatetime;
        this.updaterid = updaterid;
        this.url = url;
        this.resourcedescribe = resourcedescribe;
    }

    public DevResource() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreaterid() {
        return createrid;
    }

    public void setCreaterid(String createrid) {
        this.createrid = createrid == null ? null : createrid.trim();
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension == null ? null : extension.trim();
    }

    public Double getImgh() {
        return imgh;
    }

    public void setImgh(Double imgh) {
        this.imgh = imgh;
    }

    public Double getImgw() {
        return imgw;
    }

    public void setImgw(Double imgw) {
        this.imgw = imgw;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Double getPosx() {
        return posx;
    }

    public void setPosx(Double posx) {
        this.posx = posx;
    }

    public Double getPosy() {
        return posy;
    }

    public void setPosy(Double posy) {
        this.posy = posy;
    }

    public String getQiniuurl() {
        return qiniuurl;
    }

    public void setQiniuurl(String qiniuurl) {
        this.qiniuurl = qiniuurl == null ? null : qiniuurl.trim();
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdaterid() {
        return updaterid;
    }

    public void setUpdaterid(String updaterid) {
        this.updaterid = updaterid == null ? null : updaterid.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getResourcedescribe() {
        return resourcedescribe;
    }

    public void setResourcedescribe(String resourcedescribe) {
        this.resourcedescribe = resourcedescribe == null ? null : resourcedescribe.trim();
    }
}