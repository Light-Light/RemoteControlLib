package com.qing_guang.RemoteControl.util;

/**
 * �쳣����ӿ�
 * @author Qing_Guang
 * @param <T> Ҫ������쳣����
 */
public interface ExceptionHandler<T extends Exception> {

	/**
	 * �������쳣ʱ�˷���������
	 * @param exc �쳣����
	 */
	void handle(T exc);
	
}
