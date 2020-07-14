package com.shunbang.airclean.common;

import com.shunbang.airclean.enums.MessageEnum;

/**
 * 相应统一返回数据定义
 * 
 * @author TL
 * @date 2018-08-13
 */
public class SimpleMessage<T> {
	 
	/**
	 * 状态码
	 */ 
	private String code;
	/**
	 * 状态信息
	 */
	private String message;  
 

	/**
	 * 默认是成功
	 */
	public SimpleMessage(){
		code=MessageEnum.SUCCESS.getCode();
		message=MessageEnum.SUCCESS.getText();
	} 


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
 
	 
 
	
}
