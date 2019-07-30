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
 * ���Ƶ��
 * @author Qing_Guang
 *
 */
public class WriteChannel extends AbstractStreamChannel{
	
	private BufferedWriter output;
	private Buffer<WillBeSendPacket> buffer = new Buffer<>();
	
	private boolean writing;
	private Object lock = new Object();
	
	/**
	 * �½�һ�����Ƶ��
	 * @param handler ��Ƶ���������� I/O �쳣ʱ,���ô˶���� {@code handle} ����
	 * @param client �ͻ������������Socket����
	 * @throws IOException ���½�Ƶ���г��� I/O �쳣ʱ�׳�
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
	 * һ�����������͵����ݰ�
	 * @author Qing_Guang
	 *
	 */
	public static class WillBeSendPacket{
		private Packet<?> pkt;
		private boolean encrypt;
		private boolean rsa_or_aes;
		
		/**
		 * �½�һ���������͵����ݰ�
		 * @param pkt ���ݰ�
		 * @param encrypt �Ƿ����
		 * @param rsa_or_aes ��Ϊtrue��ʹ��RSA�㷨����,����ʹ��AES�㷨����
		 */
		public WillBeSendPacket(Packet<?> pkt, boolean encrypt, boolean rsa_or_aes) {
			super();
			this.pkt = pkt;
			this.encrypt = encrypt;
			this.rsa_or_aes = rsa_or_aes;
		}

		/**
		 * ���ݰ�
		 */
		public Packet<?> getPkt() {
			return pkt;
		}

		/**
		 * �Ƿ����
		 */
		public boolean isEncrypt() {
			return encrypt;
		}

		/**
		 * ��Ϊtrue��ʹ��RSA�㷨����,����ʹ��AES�㷨����
		 */
		public boolean whatAlg() {
			return rsa_or_aes;
		}
		
	}
	
	/**
	 * ���һ�����������͵����ݰ�(������)
	 * @param pkt ���ݰ�
	 */
	public void addPacketWillSend(Packet<?> pkt) {
		buffer.add(new WillBeSendPacket(pkt,false,false));
	}
	
	/**
	 * ���һ�����������͵����ݰ�(����)
	 * @param pkt ���ݰ�
	 * @param rsa_or_aes ��Ϊtrue��ʹ��RSA�㷨����,����ʹ��AES�㷨����
	 */
	public void addPacketWillSend(Packet<?> pkt,boolean rsa_or_aes) {
		buffer.add(new WillBeSendPacket(pkt,true,rsa_or_aes));
	}
	
	/**
	 * ��Ƶ���Ƿ�����ִ��һ�������������
	 */
	public boolean isWriting() {
		return writing;
	}
	
	/**
	 * ������Ƶ���Ļ�����(����)
	 */
	public Buffer<WillBeSendPacket> getBuffer(){
		return buffer.clone();
	}

}
