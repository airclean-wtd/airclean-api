package com.shunbang.airclean.model.filter;

import java.io.Serializable;

/**
 * @author dxy
 * @date 20200804
 * @decription StatFilter 用于封装页面传入信息
 */
public class StatFilter implements Serializable {

	private String roomNo;
	private String deviceTp;
	private String dataTp;

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getDeviceTp() {
		return deviceTp;
	}

	public void setDeviceTp(String deviceTp) {
		this.deviceTp = deviceTp;
	}

	public String getDataTp() {
		return dataTp;
	}

	public void setDataTp(String dataTp) {
		this.dataTp = dataTp;
	}
}
