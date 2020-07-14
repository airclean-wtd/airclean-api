package com.shunbang.airclean.model.bean;

import java.sql.Timestamp;

public class DeviceSamplingData {

	private Integer samplingNo;
	private String deviceNo;
	private String deviceType;
	private String dataType;
	private String value;
	private Timestamp samplingTime;

	public Integer getSamplingNo() {
		return samplingNo;
	}

	public void setSamplingNo(Integer samplingNo) {
		this.samplingNo = samplingNo;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Timestamp getSamplingTime() {
		return samplingTime;
	}

	public void setSamplingTime(Timestamp samplingTime) {
		this.samplingTime = samplingTime;
	}

}
