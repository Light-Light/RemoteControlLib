package com.qing_guang.RemoteControl.packet.server;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;

/**
 * 加密要求数据包
 * @author Qing_Guang
 *
 */
public class EncryptRequirePacket extends Packet<EncryptRequirePacket>{
	
	private static final long serialVersionUID = -7231583345315448295L;

	/**
	 * 新建此数据包
	 */
	public EncryptRequirePacket() {
		super();
	}
	
	/**
	 * 根据传入的JSON文本创建一个数据包
	 * @param json JSON文本
	 */
	public EncryptRequirePacket(JsonObject json) {
		super(json);
	}

	/**
	 * {@inheritDoc}
	 */
	public PacketType getPkttype() {
		return ServerPacket.ENCRYPT_REQUIRE;
	}

	/**
	 * {@inheritDoc}
	 */
	public EncryptRequirePacket clone() {
		return new EncryptRequirePacket();
	}

}
