package com.qing_guang.RemoteControl.packet.server;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;

/**
 * 手动断线数据包
 * @author Qing_Guang
 *
 */
public class ManualDisconnectedPacket extends Packet<ManualDisconnectedPacket>{

	private static final long serialVersionUID = 1508139911203700984L;
	
	/**
	 * 新建此数据包
	 */
	public ManualDisconnectedPacket() {
		super();
	}
	
	/**
	 * 根据传入的JSON文本创建一个数据包
	 * @param json JSON文本
	 */
	public ManualDisconnectedPacket(JsonObject json) {
		super(json);
	}

	/**
	 * {@inheritDoc}
	 */
	public PacketType getPkttype() {
		return ServerPacket.MANUAL_DISCONNECTED;
	}

	/**
	 * {@inheritDoc}
	 */
	public ManualDisconnectedPacket clone() {
		return new ManualDisconnectedPacket();
	}

}
