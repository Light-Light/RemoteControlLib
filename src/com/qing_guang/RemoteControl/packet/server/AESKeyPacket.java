package com.qing_guang.RemoteControl.packet.server;

import com.google.gson.JsonObject;
import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * AES密钥数据包
 * @author Qing_Guang
 *
 */
public class AESKeyPacket extends Packet<AESKeyPacket>{

	private final String key;
	
	/**
	 * 新建此数据包
	 * @param key AES密钥
	 */
	public AESKeyPacket(String key) {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_AES_KEY, key);
		this.key = key;
	}
	
	/**
	 * 根据传入的JSON文本创建一个数据包
	 * @param json JSON文本
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
	 * AES密钥
	 */
	public String getKey() {
		return key;
	}
	
}
