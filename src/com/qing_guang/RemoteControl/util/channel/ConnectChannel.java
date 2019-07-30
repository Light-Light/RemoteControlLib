package com.qing_guang.RemoteControl.util.channel;

import java.io.IOException;
import java.net.Socket;

import com.qing_guang.RemoteControl.util.ExceptionHandler;

/**
 * 与客户端的连接频道
 * @author Qing_Guang
 *
 */
public class ConnectChannel {

	private WriteChannel write;
	private ReadChannel read;
	
	/**
	 * 新建一个与客户端的连接频道
	 * @param client 客户端与服务器的Socket连接
	 * @param out_exc_handler 输出频道工作异常处理器
	 * @param in_exc_handler 输入频道工作异常处理器
	 * @throws IOException 当新建频道中出现 I/O 异常时抛出
	 */
	public ConnectChannel(Socket client,ExceptionHandler<IOException> out_exc_handler,ExceptionHandler<IOException> in_exc_handler) throws IOException{
		write = new WriteChannel(out_exc_handler,client);
		read = new ReadChannel(in_exc_handler,client);
	}
	
	/**
	 * 开启此频道
	 */
	public void start() {
		write.start();
		read.start();
	}
	
	/**
	 * 关闭此频道
	 * @throws IOException 当关闭频道时出现 I/O 异常时抛出
	 */
	public void close() throws IOException{
		write.close();
		read.close();
	}
	
	/**
	 * 此频道的输出频道
	 */
	public WriteChannel getWriteChannel(){
		return write;
	}
	
	/**
	 * 此频道的输入频道
	 */
	public ReadChannel getReadChannel(){
		return read;
	}
	
}
