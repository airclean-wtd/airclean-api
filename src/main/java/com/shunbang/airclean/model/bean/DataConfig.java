package com.shunbang.airclean.model.bean;

import java.sql.Timestamp;

public class DataConfig {
	private String key;
	private String value;
	private String name;
	private String order;
	private Timestamp optTm;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Timestamp getOptTm() {
		return optTm;
	}

	public void setOptTm(Timestamp optTm) {
		this.optTm = optTm;
	}
}
