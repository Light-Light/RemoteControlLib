package com.qing_guang.RemoteControl.packet.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;
import com.qing_guang.RemoteControl.util.JsonUtil;

/**
 * RSA��Կ���ݰ�
 * @author Qing_Guang
 *
 */
public class RSAPublicKeyPacket extends Packet<RSAPublicKeyPacket>{
	
	private static final long serialVersionUID = -4775566683028083946L;
	
	private final byte[] pubkey;
	private final String charset;

	/**
	 * �½������ݰ�
	 * @param pubkey RSA��Կ
	 * @param charset ���ͷ�ʹ�õ��ַ���
	 */
	public RSAPublicKeyPacket(byte[] pubkey,String charset) {
		super();
		this.pubkey = pubkey;
		this.charset = charset;
		json.add(FinalValues.JSON_TEXT_KEY_RSA_PUBLIC_KEY, JsonUtil.toJsonArray(pubkey,new JsonArray()));
		json.addProperty(FinalValues.JSON_TEXT_KEY_RSA_PUBLIC_KEY_CHARSET, charset);
	}
	
	/**
	 * ���ݴ����JSON�ı�����һ�����ݰ�
	 * @param json JSON�ı�
	 */
	public RSAPublicKeyPacket(JsonObject json) {
		super(json);
		JsonArray jpubkey = json.get(FinalValues.JSON_TEXT_KEY_RSA_PUBLIC_KEY).getAsJsonArray();
		pubkey = JsonUtil.toArray(jpubkey,new byte[jpubkey.size()]);
		charset = json.get(FinalValues.JSON_TEXT_KEY_RSA_PUBLIC_KEY_CHARSET).getAsString();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public PacketType getPkttype() {
		return ClientPacket.RSA_PUBLIC_KEY;
	}

	/**
	 * {@inheritDoc}
	 */
	public RSAPublicKeyPacket clone() {
		return new RSAPublicKeyPacket(pubkey,charset);
	}
	
	/**
	 * RSA��Կ
	 * @see java.security.Key#getEncoded()
	 */
	public byte[] getPubkey() {
		return pubkey;
	}
	
	/**
	 * ���ͷ�ʹ�õ��ַ���
	 * @see java.nio.charset.Charset#defaultCharset()
	 */
	public String getCharset() {
		return charset;
	}

}