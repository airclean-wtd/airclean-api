package com.shunbang.airclean.model.bean;

import java.sql.Timestamp;

public class DeviceOperationLog {
	private Integer logNo;
	private String deviceNo;
	private String type;
	private Timestamp operationTime;

	public Integer getLogNo() {
		return logNo;
	}

	public void setLogNo(Integer logNo) {
		this.logNo = logNo;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Timestamp operationTime) {
		this.operationTime = operationTime;
	}

}
