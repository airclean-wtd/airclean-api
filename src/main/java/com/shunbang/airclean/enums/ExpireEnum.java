package com.shunbang.airclean.enums;

import java.util.concurrent.TimeUnit;
/**
 * redis 失效时间枚举
 *  
 *
 */
public enum ExpireEnum {
	
	// 未读消息的有效期为30天
	UNREAD_MSG(30L, TimeUnit.DAYS);

	/**
	 * 过期时间
	 */
	private Long time;
	/**
	 * 时间单位
	 */
	private TimeUnit timeUnit;

	ExpireEnum(Long time, TimeUnit timeUnit) {
		this.time = time;
		this.timeUnit = timeUnit;
	}

	public Long getTime() {
		return time;
	}

	public TimeUnit getTimeUnit() {
		return timeUnit;
	}
}
