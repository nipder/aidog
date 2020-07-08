package com.sec.aidog.pojo;

import java.util.Date;

public class DevResource {
    private String id;

    private String mid;

    private Integer num;

    private String ccid;

    private Integer category;

    private Date createtime;

    private String extension;

    private String name;

    private String path;

    private Long size;

    private Integer type;

    private Date updatetime;

    private String updaterid;

    private String url;

    private String resourcedescribe;

    public DevResource(String id, String mid, Integer num, String ccid, Integer category, Date createtime, String extension, String name, String path, Long size, Integer type, Date updatetime, String updaterid, String url, String resourcedescribe) {
        this.id = id;
        this.mid = mid;
        this.num = num;
        this.ccid = ccid;
        this.category = category;
        this.createtime = createtime;
        this.extension = extension;
        this.name = name;
        this.path = path;
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

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCcid() {
        return ccid;
    }

    public void setCcid(String ccid) {
        this.ccid = ccid == null ? null : ccid.trim();
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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension == null ? null : extension.trim();
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