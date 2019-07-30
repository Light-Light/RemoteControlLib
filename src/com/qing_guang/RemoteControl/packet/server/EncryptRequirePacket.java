package com.qing_guang.RemoteControl.packet.server;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;

/**
 * ����Ҫ�����ݰ�
 * @author Qing_Guang
 *
 */
public class EncryptRequirePacket extends Packet<EncryptRequirePacket>{
	
	private static final long serialVersionUID = -7231583345315448295L;

	/**
	 * �½������ݰ�
	 */
	public EncryptRequirePacket() {
		super();
	}
	
	/**
	 * ���ݴ����JSON�ı�����һ�����ݰ�
	 * @param json JSON�ı�
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
