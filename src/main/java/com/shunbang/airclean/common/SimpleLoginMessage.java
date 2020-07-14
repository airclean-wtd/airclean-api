package com.shunbang.airclean.common;

/**
 * 登录返回的SimpleMessage
 * 
 * @author TL
 * @date 2019-01-08 
 *  
 */
public class SimpleLoginMessage<T> extends SimpleMessage<T> {
	/**
	 * 返回单个实体结果
	 */
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	 
	
}
