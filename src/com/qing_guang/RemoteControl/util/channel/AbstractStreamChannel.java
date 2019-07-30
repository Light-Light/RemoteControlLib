package com.qing_guang.RemoteControl.util.channel;

import java.io.Closeable;
import java.io.IOException;
import java.security.Key;

import com.qing_guang.RemoteControl.util.ExceptionHandler;

/**
 * һ�������Ƶ��
 * @author Qing_Guang
 *
 */
public abstract class AbstractStreamChannel extends Thread implements Closeable{

	/** ��Ƶ���Ƿ񱻹ر� */
	protected boolean isClosed = false;
	/** ��Ƶ���Ƿ����� */
	protected boolean isBlocked = false;
	/** ��Ƶ���������� I/O �쳣ʱ,���ô˶���� {@code handle} ���� */
	protected ExceptionHandler<IOException> handler;
	/** Ƶ��ʹ�õ�RSA��Կ */
	protected Key rsa_key;
	/** Ƶ��ʹ�õ�AES��Կ */
	protected String aes_key;
	/** Ƶ���������ַ��� */
	protected String charset;
	
	/**
	 * Ĭ�ϵĹ�����
	 * @param handler ��Ƶ���������� I/O �쳣ʱ,���ô˶���� {@code handle} ����
	 */
	public AbstractStreamChannel(ExceptionHandler<IOException> handler) {
		this.handler = handler;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public abstract void run();
	
	/**
	 * ��Ƶ���Ƿ񱻹ر�
	 */
	public boolean isClosed() {
		return isClosed;
	}
	
	/**
	 * �رմ�Ƶ��
	 * @see java.io.Closeable#close()
	 */
	public void close() throws IOException{
		this.isClosed = true;
	}
	
	/**
	 * ��Ƶ���Ƿ�����
	 */
	public boolean isBlocked() {
		return isBlocked;
	}
	
	/**
	 * ���ô�Ƶ���Ƿ�����
	 */
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	
	/**
	 * Ƶ���������ַ���
	 */
	public String getCharset() {
		return charset;
	}

	/**
	 * ����Ƶ���������ַ���
	 */
	public void setCharset(String charset) {
		this.charset = charset;
	}
	
	/**
	 * Ƶ��ʹ�õ�RSA��Կ
	 */
	public Key getRSAKey() {
		return rsa_key;
	}
	
	/**
	 * ����Ƶ��ʹ�õ�RSA��Կ
	 */
	public void setRSAKey(Key key) {
		this.rsa_key = key;
	}
	
	/**
	 * Ƶ��ʹ�õ�AES��Կ
	 */
	public String getAESKey() {
		return aes_key;
	}
	
	/**
	 * ����Ƶ��ʹ�õ�AES��Կ
	 */
	public void setAESKey(String key) {
		this.aes_key = key;
	}
	
}
