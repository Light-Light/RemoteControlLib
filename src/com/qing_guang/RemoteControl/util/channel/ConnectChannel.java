package com.qing_guang.RemoteControl.util.channel;

import java.io.IOException;
import java.net.Socket;

import com.qing_guang.RemoteControl.util.ExceptionHandler;

/**
 * ��ͻ��˵�����Ƶ��
 * @author Qing_Guang
 *
 */
public class ConnectChannel {

	private WriteChannel write;
	private ReadChannel read;
	
	/**
	 * �½�һ����ͻ��˵�����Ƶ��
	 * @param client �ͻ������������Socket����
	 * @param out_exc_handler ���Ƶ�������쳣������
	 * @param in_exc_handler ����Ƶ�������쳣������
	 * @throws IOException ���½�Ƶ���г��� I/O �쳣ʱ�׳�
	 */
	public ConnectChannel(Socket client,ExceptionHandler<IOException> out_exc_handler,ExceptionHandler<IOException> in_exc_handler) throws IOException{
		write = new WriteChannel(out_exc_handler,client);
		read = new ReadChannel(in_exc_handler,client);
	}
	
	/**
	 * ������Ƶ��
	 */
	public void start() {
		write.start();
		read.start();
	}
	
	/**
	 * �رմ�Ƶ��
	 * @throws IOException ���ر�Ƶ��ʱ���� I/O �쳣ʱ�׳�
	 */
	public void close() throws IOException{
		write.close();
		read.close();
	}
	
	/**
	 * ��Ƶ�������Ƶ��
	 */
	public WriteChannel getWriteChannel(){
		return write;
	}
	
	/**
	 * ��Ƶ��������Ƶ��
	 */
	public ReadChannel getReadChannel(){
		return read;
	}
	
}
