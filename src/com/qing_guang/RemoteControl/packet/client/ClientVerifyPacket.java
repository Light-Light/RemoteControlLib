package com.qing_guang.RemoteControl.packet.client;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * 客户端确认数据包
 * @author Qing_Guang
 *
 */
public class ClientVerifyPacket extends Packet<ClientVerifyPacket> {
	
	private static final long serialVersionUID = -6986212616753737231L;

	/**
	 * 新建此数据包
	 * @param cversion 客户端版本
	 */
	public ClientVerifyPacket(String cversion) {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_APP_VERIFY_VERSION, cversion);
	}
	
	/**
	 * 根据传入的JSON文本创建一个数据包
	 * @param json JSON文本
	 */
	public ClientVerifyPacket(JsonObject json) {
		super(json);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public PacketType getPkttype() {
		return ClientPacket.CLIENT_VERIFY;
	}

	/**
	 * {@inheritDoc}
	 */
	public ClientVerifyPacket clone() {
		return new ClientVerifyPacket(json.get(FinalValues.JSON_TEXT_KEY_APP_VERIFY_VERSION).getAsString());
	}
	
	/**
	 * 客户端版本
	 */
	public String getVersion() {
		return json.get(FinalValues.JSON_TEXT_KEY_APP_VERIFY_VERSION).getAsString();
	}

}
