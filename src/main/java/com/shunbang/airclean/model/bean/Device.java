package com.shunbang.airclean.model.bean;

import java.sql.Timestamp;

public class Device {
	private String no;
	private String tp;
	private String sid;
	private String ip;
	private String port;
	private String mac;
	private String st;
	private String del;
	private Timestamp mtTm;

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

	public String getDel() {
		return del;
	}

	public void setDel(String del) {
		this.del = del;
	}

	public Timestamp getMtTm() {
		return mtTm;
	}

	public void setMtTm(Timestamp mtTm) {
		this.mtTm = mtTm;
	}
}
