package com.qing_guang.RemoteControl.packet.server;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;

/**
 * 服务器关闭数据包
 * @author Qing_Guang
 *
 */
public class ServerClosePacket extends Packet<ServerClosePacket>{

	private static final long serialVersionUID = 6726810029889869702L;

	/**
	 * 新建此数据包
	 */
	public ServerClosePacket() {
		super();
	}
	
	/**
	 * 根据传入的JSON文本创建一个数据包
	 * @param json JSON文本
	 */
	public ServerClosePacket(JsonObject json) {
		super(json);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public PacketType getPkttype() {
		return ServerPacket.SERVER_CLOSE;
	}

	/**
	 * {@inheritDoc}
	 */
	public ServerClosePacket clone() {
		return new ServerClosePacket();
	}

}
