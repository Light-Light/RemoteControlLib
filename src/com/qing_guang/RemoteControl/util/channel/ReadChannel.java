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
 * 输入频道
 * @author Qing_Guang
 *
 */
public class ReadChannel extends AbstractStreamChannel{

	private BufferedReader input;
	private Buffer<byte[]> buffer = new Buffer<>();
	
	/**
	 * 新建一个输入频道
	 * @param handler 当频道工作发生 I/O 异常时,调用此对象的 {@code handle} 方法
	 * @param client 客户端与服务器的Socket连接
	 * @throws IOException 当新建频道中出现 I/O 异常时抛出
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
	 * 获取一个不经解密的数据包
	 * @return 获取到的数据包,若出现语法错误或其他无法初始化数据包的问题则返回null
	 * @throws UnsupportedEncodingException 当 {@link AbstractStreamChannel#getCharset()} 为不支持的字符集时抛出
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
	 * 获取一个经过解密的数据包
	 * @param rsa_or_aes 若为true则使用RSA算法解密,否则使用AES算法解密
	 * @return 获取到的数据包,若出现语法错误或其他无法初始化数据包的问题则返回null
	 * @throws UnsupportedEncodingException 当 {@link AbstractStreamChannel#getCharset()} 为不支持的字符集时抛出
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
	 * 此输入频道的缓冲区(副本)
	 */
	public Buffer<byte[]> getBuffer(){
		return buffer.clone();
	}
	
}
