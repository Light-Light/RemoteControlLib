package com.qing_guang.RemoteControl.packet.client;

import com.google.gson.JsonObject;
import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;

/**
 * 客户端退出数据包
 * @author Qing_Guang
 *
 */
public class ClientExitPacket extends Packet<ClientExitPacket>{

	private static final long serialVersionUID = -1175951844698054249L;

	/**
	 * 新建此数据包
	 */
	public ClientExitPacket() {
		super();
	}
	
	/**
	 * 根据传入的JSON文本创建一个数据包
	 * @param json JSON文本
	 */
	public ClientExitPacket(JsonObject json) {
		super(json);
	}

	/**
	 * {@inheritDoc}
	 */
	public PacketType getPkttype() {
		return ClientPacket.CLIENT_EXIT;
	}

	/**
	 * {@inheritDoc}
	 */
	public ClientExitPacket clone() {
		return new ClientExitPacket();
	}

}
