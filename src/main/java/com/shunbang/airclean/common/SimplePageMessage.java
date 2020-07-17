package com.shunbang.airclean.common;

import java.util.List;

/**
 * 相应统一返回数据定义(分页)
 * 
 * @author TL
 * @date 2018-12-05
 *
 */
public class SimplePageMessage<T> extends SimpleMessage<T> {
	 
	/**
	 * 分页信息
	 */
	private Pager<T> pager;

	/**
	 * 数据集合，不分页
	 */
	private List<T> dataList;


	public Pager<T> getPager() {
		return pager;
	}

	public void setPager(Pager<T> pager) {
		this.pager = pager;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
}
