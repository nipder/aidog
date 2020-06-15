package com.sec.aidog.pojo;

import java.util.Date;

public class DevPillRec{
	private Integer id;

	private String mid;

	private String pillCode;

	private Date configTime;

	public DevPillRec(Integer id, String mid, String pillCode, Date configTime) {
		this.id = id;
		this.mid = mid;
		this.pillCode = pillCode;
		this.configTime = configTime;
	}

	public DevPillRec() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid == null ? null : mid.trim();
	}

	public String getPillCode() {
		return pillCode;
	}

	public void setPillCode(String pillCode) {
		this.pillCode = pillCode == null ? null : pillCode.trim();
	}

	public Date getConfigTime() {
		return configTime;
	}

	public void setConfigTime(Date configTime) {
		this.configTime = configTime;
	}
}