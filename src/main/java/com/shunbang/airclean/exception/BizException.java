package com.shunbang.airclean.exception;

import com.shunbang.airclean.enums.MessageEnum;

/**
 * 业务异常定义
 * 
 * @author TL
 * @date 2018-11-20
 *
 */
public class BizException extends AbstractBaseExcepton{ 
	 
	private static final long serialVersionUID = 1L;
	
	{ 
		this.code=MessageEnum.ERROR.getCode();
	}

	public BizException(){
		super();
	}
	
	public BizException(String message){
	   super(message);	
	}
	
	public BizException(Throwable err){
		super(err);
	}
	
	public BizException(String message,Throwable err){
		super(message,err);
	}

}
