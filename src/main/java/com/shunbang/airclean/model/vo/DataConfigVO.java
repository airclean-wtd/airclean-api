package com.shunbang.airclean.model.vo;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author dxy
 * @date 20200716
 * @description VO用于封装数据库查出的数据
 */
public class DataConfigVO {

	private BigInteger cfgNo;
	private String index;
	private String key;
	private String name;
	private String value;
	private String label;
	private String order;
	private Timestamp optTm;


	public BigInteger getCfgNo() {
		return cfgNo;
	}

	public void setCfgNo(BigInteger cfgNo) {
		this.cfgNo = cfgNo;
	}

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

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getOptTm() {
		return optTm;
	}

	public void setOptTm(Timestamp optTm) {
		this.optTm = optTm;
	}
}
