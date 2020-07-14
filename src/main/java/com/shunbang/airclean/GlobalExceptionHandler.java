package com.shunbang.airclean;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.shunbang.airclean.common.SimpleErrorMessage;
import com.shunbang.airclean.common.SimpleMessage;
import com.shunbang.airclean.enums.MessageEnum;
import com.shunbang.airclean.exception.AbstractBaseExcepton;


/**
 * 全局异常统一处理
 * 
 * @author TL
 * @date 2018-11-21
 *
 */
@EnableWebMvc
@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 系统异常处理，比如：404,500
	 * 
	 * @param req
	 * @param resp
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public SimpleMessage<Object> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		 
		SimpleMessage<Object> sm =null;
		if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
			sm= new SimpleMessage<Object>(); 
			sm.setCode(MessageEnum.NONE.getCode());
			sm.setMessage("not found");
		} 
		//如果是系统定义的业务异常
		else if(AbstractBaseExcepton.class.isAssignableFrom(e.getClass())){
			sm= new SimpleMessage<Object>();
            //对于业务异常，不需要堆栈信息
			sm.setCode(((AbstractBaseExcepton)e).getCode());
		}
		else {
			logger.error("全局异常：;", e);
			sm=new SimpleErrorMessage<Object>();
			sm.setCode(MessageEnum.ERROR.getCode());
			((SimpleErrorMessage<Object>)sm).setStackTrace(e.getStackTrace());
		}
		sm.setMessage(e.getMessage());
		return sm;
	}
}
