package com.qing_guang.RemoteControl.util.channel;

import java.io.Closeable;
import java.io.IOException;
import java.security.Key;

import com.qing_guang.RemoteControl.util.ExceptionHandler;

/**
 * 一个抽象的频道
 * @author Qing_Guang
 *
 */
public abstract class AbstractStreamChannel extends Thread implements Closeable{

	/** 此频道是否被关闭 */
	protected boolean isClosed = false;
	/** 此频道是否被阻塞 */
	protected boolean isBlocked = false;
	/** 当频道工作发生 I/O 异常时,调用此对象的 {@code handle} 方法 */
	protected ExceptionHandler<IOException> handler;
	/** 频道使用的RSA密钥 */
	protected Key rsa_key;
	/** 频道使用的AES密钥 */
	protected String aes_key;
	/** 频道工作的字符集 */
	protected String charset;
	
	/**
	 * 默认的构造器
	 * @param handler 当频道工作发生 I/O 异常时,调用此对象的 {@code handle} 方法
	 */
	public AbstractStreamChannel(ExceptionHandler<IOException> handler) {
		this.handler = handler;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public abstract void run();
	
	/**
	 * 此频道是否被关闭
	 */
	public boolean isClosed() {
		return isClosed;
	}
	
	/**
	 * 关闭此频道
	 * @see java.io.Closeable#close()
	 */
	public void close() throws IOException{
		this.isClosed = true;
	}
	
	/**
	 * 此频道是否被阻塞
	 */
	public boolean isBlocked() {
		return isBlocked;
	}
	
	/**
	 * 设置此频道是否被阻塞
	 */
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	
	/**
	 * 频道工作的字符集
	 */
	public String getCharset() {
		return charset;
	}

	/**
	 * 设置频道工作的字符集
	 */
	public void setCharset(String charset) {
		this.charset = charset;
	}
	
	/**
	 * 频道使用的RSA密钥
	 */
	public Key getRSAKey() {
		return rsa_key;
	}
	
	/**
	 * 设置频道使用的RSA密钥
	 */
	public void setRSAKey(Key key) {
		this.rsa_key = key;
	}
	
	/**
	 * 频道使用的AES密钥
	 */
	public String getAESKey() {
		return aes_key;
	}
	
	/**
	 * 设置频道使用的AES密钥
	 */
	public void setAESKey(String key) {
		this.aes_key = key;
	}
	
}
