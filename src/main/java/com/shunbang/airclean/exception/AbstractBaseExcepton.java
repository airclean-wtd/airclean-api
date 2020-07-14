package com.shunbang.airclean.exception;

public abstract class AbstractBaseExcepton extends RuntimeException {
	 
	private static final long serialVersionUID = 1L;
	protected  String code;
	
	public AbstractBaseExcepton(){
		super();
		
	}
	public AbstractBaseExcepton(String message){
		super(message);
	}
	
	public AbstractBaseExcepton(Throwable err){
		super(err);
	}
	
	public AbstractBaseExcepton(String message,Throwable err){
		super(message,err);
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
