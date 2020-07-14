package com.shunbang.airclean.common;

/**
 * 结果数据为单个实体的SimpleMessage
 * 
 * @author TL
 * @date 2018-12-05
 * 
 * @param <T>
 */
public class SimpleObjectMessage<T> extends SimpleMessage<T> {
	/**
	 * 返回单个实体结果
	 */
	private T record;

	public T getRecord() {
		return record;
	}

	public void setRecord(T record) {
		this.record = record;
	}
	
}
