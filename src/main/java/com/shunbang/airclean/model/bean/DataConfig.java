package com.shunbang.airclean.model.bean;

import java.math.BigInteger;
import java.sql.Timestamp;

public class DataConfig {

	private BigInteger cfgNo;
	private String key;
	private String value;
	private String name;
	private String order;
	private Timestamp optTm;

	public BigInteger getCfgNo() {
		return cfgNo;
	}

	public void setCfgNo(BigInteger cfgNo) {
		this.cfgNo = cfgNo;
	}

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
