package com.shunbang.airclean.model.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Room implements Serializable {
	private String no;
	private String type;
	private String name;
	private Timestamp maintainTime;
	private String delete;

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

	public Timestamp getMaintainTime() {
		return maintainTime;
	}

	public void setMaintainTime(Timestamp maintainTime) {
		this.maintainTime = maintainTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}
	
	
	
	
}
