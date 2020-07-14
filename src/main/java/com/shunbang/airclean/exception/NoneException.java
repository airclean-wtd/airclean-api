package com.shunbang.airclean.exception;

import com.shunbang.airclean.enums.MessageEnum;

/**
 * 无资源异常404
 * 
 * @author TL
 * @date 2018-11-20
 *
 */
public class NoneException extends AbstractBaseExcepton{ 
	 
	private static final long serialVersionUID = 1L;
	
	{ 
		this.code=MessageEnum.NONE.getCode();
	}

	public NoneException(){
		super();
	}
	
	public NoneException(String message){
	   super(message);	
	}
	
	public NoneException(Throwable err){
		super(err);
	}
	
	public NoneException(String message,Throwable err){
		super(message,err);
	}

}
