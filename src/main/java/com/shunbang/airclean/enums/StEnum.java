package com.shunbang.airclean.enums;

/**
 * 数据有效无效状态信息
 * 
 * @author TL
 *
 */
public enum StEnum {
	/**
	 * 成功
	 */
	Y("1", "有效"),
	/**
	 * 无权限
	 */
	N("0","无效");
	 
	
	private String text;
	private String code;
	
	private StEnum( String code,String text) {
		this.code = code;
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public String getCode() {
		return code;
	}
	
	public static StEnum valueOf(int ordinal) {
		if (ordinal <0 || ordinal>=values().length) {
			throw new IndexOutOfBoundsException("非法的ordinal序号值");
		}

		return values()[ordinal];
	}
}
