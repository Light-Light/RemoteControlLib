package com.qing_guang.RemoteControl.util.channel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.security.PrivateKey;

import com.google.gson.JsonSyntaxException;
import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.util.Buffer;
import com.qing_guang.RemoteControl.util.CommunicateEncryptUtil;
import com.qing_guang.RemoteControl.util.ExceptionHandler;
import com.qing_guang.RemoteControl.util.JsonUtil;

/**
 * ����Ƶ��
 * @author Qing_Guang
 *
 */
public class ReadChannel extends AbstractStreamChannel{

	private BufferedReader input;
	private Buffer<byte[]> buffer = new Buffer<>();
	
	/**
	 * �½�һ������Ƶ��
	 * @param handler ��Ƶ���������� I/O �쳣ʱ,���ô˶���� {@code handle} ����
	 * @param client �ͻ������������Socket����
	 * @throws IOException ���½�Ƶ���г��� I/O �쳣ʱ�׳�
	 */
	public ReadChannel(ExceptionHandler<IOException> handler,Socket client) throws IOException {
		super(handler);
		input = new BufferedReader(new InputStreamReader(client.getInputStream()));
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
				
				String read = null;
				if((read = input.readLine()) != null) {
					byte[] de_base64 = CommunicateEncryptUtil.parseHaxStr2Byte(read);
					buffer.add(de_base64);
					Thread.sleep(20);
				}
			} catch (IOException e) {
				handler.handle(e);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (JsonSyntaxException e) {
				continue;
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void close() throws IOException{
		super.close();
		input.close();
	}
	
	/**
	 * ��ȡһ���������ܵ����ݰ�
	 * @return ��ȡ�������ݰ�,�������﷨����������޷���ʼ�����ݰ��������򷵻�null
	 * @throws UnsupportedEncodingException �� {@link AbstractStreamChannel#getCharset()} Ϊ��֧�ֵ��ַ���ʱ�׳�
	 */
	public Packet<?> getPacket() throws UnsupportedEncodingException {
		
		byte[] naive = buffer.get();
		
		if(naive != null) {
			
			String decrypt_c = charset == null ? new String(naive) : new String(naive,charset);
			Packet<?> pkt = Packet.getByJson(JsonUtil.toJsonObject(decrypt_c));
			if(pkt != null) {
				return pkt;
			}else {
				buffer.insertToLast();
				return null;
			}
			
		}
		
		return null;
		
	}
	
	/**
	 * ��ȡһ���������ܵ����ݰ�
	 * @param rsa_or_aes ��Ϊtrue��ʹ��RSA�㷨����,����ʹ��AES�㷨����
	 * @return ��ȡ�������ݰ�,�������﷨����������޷���ʼ�����ݰ��������򷵻�null
	 * @throws UnsupportedEncodingException �� {@link AbstractStreamChannel#getCharset()} Ϊ��֧�ֵ��ַ���ʱ�׳�
	 */
	public Packet<?> getPacket(boolean rsa_or_aes) throws UnsupportedEncodingException {
		
		byte[] naive = buffer.get();
		
		if(naive != null) {
			
			String decrypt_c = rsa_or_aes ? charset == null ? CommunicateEncryptUtil.decrypt_RSA((PrivateKey) rsa_key, naive)
															: CommunicateEncryptUtil.decrypt_RSA((PrivateKey) rsa_key, naive, charset)
										  : charset == null ? CommunicateEncryptUtil.decrypt_AES(naive, aes_key)
															: CommunicateEncryptUtil.decrypt_AES(naive, aes_key, charset);
			
			Packet<?> pkt = Packet.getByJson(JsonUtil.toJsonObject(decrypt_c));
			if(pkt != null) {
				return pkt;
			}else {
				buffer.insertToLast();
				return null;
			}
			
		}
		
		return null;
		
	}
	
	/**
	 * ������Ƶ���Ļ�����(����)
	 */
	public Buffer<byte[]> getBuffer(){
		return buffer.clone();
	}
	
}
