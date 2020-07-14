package com.shunbang.airclean.model.bean;

import java.sql.Timestamp;

public class DeviceRoomRelation {
	private String roomNo;
	private String deviceNo;
	private Timestamp startTime;
	private Timestamp endTime;
	private Timestamp maintainTime;

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Timestamp getMaintainTime() {
		return maintainTime;
	}

	public void setMaintainTime(Timestamp maintainTime) {
		this.maintainTime = maintainTime;
	}

}
