package com.shunbang.airclean.model.vo;

import java.sql.Timestamp;

public class RoomVO {
	private String no;
	private String type;
	private String name;
	private String del;
	private String deviceNo;
	private String deviceTp;
	private String deviceMac;
	private String deviceSt;

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

	public String getDel() {
		return del;
	}

	public void setDel(String del) {
		this.del = del;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getDeviceTp() {
		return deviceTp;
	}

	public void setDeviceTp(String deviceTp) {
		this.deviceTp = deviceTp;
	}

	public String getDeviceMac() {
		return deviceMac;
	}

	public void setDeviceMac(String deviceMac) {
		this.deviceMac = deviceMac;
	}

	public String getDeviceSt() {
		return deviceSt;
	}

	public void setDeviceSt(String deviceSt) {
		this.deviceSt = deviceSt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getMaintainTime() {
		return maintainTime;
	}

	public void setMaintainTime(Timestamp maintainTime) {
		this.maintainTime = maintainTime;
	}
}
