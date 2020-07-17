package com.shunbang.airclean.model.vo;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author dxy
 * @date 20200716
 * @description VO用于封装数据库查出的数据
 */
public class DeviceVO {

	private String index;
	private String no;
	private String label;
	private String tp;
	private String sid;
	private String ip;
	private String port;
	private String mac;
	private String st;
	private String mtTm;
	private String del;
	private String roomName;

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTp() {
		return tp;
	}

	public void setTp(String tp) {
		this.tp = tp;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	public String getMtTm() {
		return mtTm;
	}

	public void setMtTm(String mtTm) {
		this.mtTm = mtTm;
	}

	public String getDel() {
		return del;
	}

	public void setDel(String del) {
		this.del = del;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
}
