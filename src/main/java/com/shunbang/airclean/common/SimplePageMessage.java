package com.shunbang.airclean.common;

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

	public Pager<T> getPager() {
		return pager;
	}

	public void setPager(Pager<T> pager) {
		this.pager = pager;
	}
	
	
	
}
