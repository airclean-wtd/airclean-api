package com.shunbang.airclean.model.bean;

import java.sql.Timestamp;

public class Device {
	private String no;
	private String type;
	private String sid;
	private String mac;
	private String state;
	private Timestamp maintainTime;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Timestamp getMaintainTime() {
		return maintainTime;
	}

	public void setMaintainTime(Timestamp maintainTime) {
		this.maintainTime = maintainTime;
	}

}
