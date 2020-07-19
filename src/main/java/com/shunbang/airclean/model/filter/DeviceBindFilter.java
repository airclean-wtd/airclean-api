package com.shunbang.airclean.model.filter;

import java.io.Serializable;

/**
 * @author dxy
 * @date 20200719
 * @decription DeviceBindFilter 用于封装页面传入信息
 */
public class DeviceBindFilter implements Serializable {

	private String no;
	private String type;
	private String name;
	private String deviceTp;
	private String deviceNo;
	private String deviceMac;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeviceTp() {
		return deviceTp;
	}

	public void setDeviceTp(String deviceTp) {
		this.deviceTp = deviceTp;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getDeviceMac() {
		return deviceMac;
	}

	public void setDeviceMac(String deviceMac) {
		this.deviceMac = deviceMac;
	}
}
