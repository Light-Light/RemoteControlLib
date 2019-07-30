package com.qing_guang.RemoteControl.packet.server;

import com.google.gson.JsonObject;
import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * AES��Կ���ݰ�
 * @author Qing_Guang
 *
 */
public class AESKeyPacket extends Packet<AESKeyPacket>{

	private final String key;
	
	/**
	 * �½������ݰ�
	 * @param key AES��Կ
	 */
	public AESKeyPacket(String key) {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_AES_KEY, key);
		this.key = key;
	}
	
	/**
	 * ���ݴ����JSON�ı�����һ�����ݰ�
	 * @param json JSON�ı�
	 */
	public AESKeyPacket(JsonObject json) {
		super(json);
		key = json.get(FinalValues.JSON_TEXT_KEY_AES_KEY).getAsString();
	}
	
	private static final long serialVersionUID = 661446175939804460L;

	/**
	 * {@inheritDoc}
	 */
	public PacketType getPkttype() {
		return ServerPacket.AES_KEY;
	}

	/**
	 * {@inheritDoc}
	 */
	public AESKeyPacket clone() {
		return new AESKeyPacket(key);
	}
	
	/**
	 * AES��Կ
	 */
	public String getKey() {
		return key;
	}
	
}
