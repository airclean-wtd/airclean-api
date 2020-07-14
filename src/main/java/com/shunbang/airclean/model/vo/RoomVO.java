package com.shunbang.airclean.model.vo;

import java.sql.Timestamp;

public class RoomVO {
	private String no;
	private String type;
	private String sid;
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

	public Timestamp getMaintainTime() {
		return maintainTime;
	}

	public void setMaintainTime(Timestamp maintainTime) {
		this.maintainTime = maintainTime;
	}
}
