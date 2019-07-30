package com.qing_guang.RemoteControl.util.channel;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.security.PublicKey;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.util.Buffer;
import com.qing_guang.RemoteControl.util.CommunicateEncryptUtil;
import com.qing_guang.RemoteControl.util.ExceptionHandler;

/**
 * 输出频道
 * @author Qing_Guang
 *
 */
public class WriteChannel extends AbstractStreamChannel{
	
	private BufferedWriter output;
	private Buffer<WillBeSendPacket> buffer = new Buffer<>();
	
	private boolean writing;
	private Object lock = new Object();
	
	/**
	 * 新建一个输出频道
	 * @param handler 当频道工作发生 I/O 异常时,调用此对象的 {@code handle} 方法
	 * @param client 客户端与服务器的Socket连接
	 * @throws IOException 当新建频道中出现 I/O 异常时抛出
	 */
	public WriteChannel(ExceptionHandler<IOException> handler,Socket client) throws IOException{
		super(handler);
		output = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
	}

	/**
	 * {@inheritDoc}
	 */
	public void run() {
		while(!isClosed()) {
			try {
				while(isBlocked()) {
					Thread.sleep(20);
				}
				
				WillBeSendPacket pkt = buffer.get();
				if(pkt != null) {
					synchronized (lock) {
						writing = true;
						String naive = pkt.pkt.toString();
						byte[] encrypt = !pkt.encrypt ? charset == null ? naive.getBytes() : naive.getBytes(charset)
													  : pkt.rsa_or_aes ? charset == null ? CommunicateEncryptUtil.encrypt_RSA((PublicKey) rsa_key, naive)
															  							 : CommunicateEncryptUtil.encrypt_RSA((PublicKey) rsa_key, naive, charset)
															  		   : charset == null ? CommunicateEncryptUtil.encrypt_AES(naive, aes_key)
															  				   			 : CommunicateEncryptUtil.encrypt_AES(naive, aes_key, charset);
						String willbe_send = CommunicateEncryptUtil.parseByte2HexStr(encrypt).replace("\r\n", "");
						output.write(willbe_send);
						output.newLine();
						output.flush();
						writing = false;
					}
				}
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				handler.handle(e);
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void close() throws IOException{
		synchronized (lock) {
			super.close();
			output.close();
		}
	}
	
	/**
	 * 一个即将被发送的数据包
	 * @author Qing_Guang
	 *
	 */
	public static class WillBeSendPacket{
		private Packet<?> pkt;
		private boolean encrypt;
		private boolean rsa_or_aes;
		
		/**
		 * 新建一个即将发送的数据包
		 * @param pkt 数据包
		 * @param encrypt 是否加密
		 * @param rsa_or_aes 若为true则使用RSA算法加密,否则使用AES算法加密
		 */
		public WillBeSendPacket(Packet<?> pkt, boolean encrypt, boolean rsa_or_aes) {
			super();
			this.pkt = pkt;
			this.encrypt = encrypt;
			this.rsa_or_aes = rsa_or_aes;
		}

		/**
		 * 数据包
		 */
		public Packet<?> getPkt() {
			return pkt;
		}

		/**
		 * 是否加密
		 */
		public boolean isEncrypt() {
			return encrypt;
		}

		/**
		 * 若为true则使用RSA算法加密,否则使用AES算法加密
		 */
		public boolean whatAlg() {
			return rsa_or_aes;
		}
		
	}
	
	/**
	 * 添加一个即将被发送的数据包(不加密)
	 * @param pkt 数据包
	 */
	public void addPacketWillSend(Packet<?> pkt) {
		buffer.add(new WillBeSendPacket(pkt,false,false));
	}
	
	/**
	 * 添加一个即将被发送的数据包(加密)
	 * @param pkt 数据包
	 * @param rsa_or_aes 若为true则使用RSA算法加密,否则使用AES算法加密
	 */
	public void addPacketWillSend(Packet<?> pkt,boolean rsa_or_aes) {
		buffer.add(new WillBeSendPacket(pkt,true,rsa_or_aes));
	}
	
	/**
	 * 此频道是否正在执行一个数据输出任务
	 */
	public boolean isWriting() {
		return writing;
	}
	
	/**
	 * 此输入频道的缓冲区(副本)
	 */
	public Buffer<WillBeSendPacket> getBuffer(){
		return buffer.clone();
	}

}
