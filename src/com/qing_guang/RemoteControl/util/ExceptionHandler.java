package com.qing_guang.RemoteControl.util;

/**
 * 异常处理接口
 * @author Qing_Guang
 * @param <T> 要处理的异常类型
 */
public interface ExceptionHandler<T extends Exception> {

	/**
	 * 当发生异常时此方法被调用
	 * @param exc 异常对象
	 */
	void handle(T exc);
	
}
