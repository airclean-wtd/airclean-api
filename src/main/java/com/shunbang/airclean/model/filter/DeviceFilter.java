package com.shunbang.airclean.model.filter;

import java.io.Serializable;

/**
 * @author dxy
 * @date 20200716
 * @decription DeviceFilter 用于封装页面传入信息
 */
public class DeviceFilter implements Serializable {

	private Integer pageIndex;
	private String key;
	private String value;
	private String name;

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
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
}
