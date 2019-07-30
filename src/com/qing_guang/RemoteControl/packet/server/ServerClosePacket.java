package com.qing_guang.RemoteControl.packet.server;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;

/**
 * �������ر����ݰ�
 * @author Qing_Guang
 *
 */
public class ServerClosePacket extends Packet<ServerClosePacket>{

	private static final long serialVersionUID = 6726810029889869702L;

	/**
	 * �½������ݰ�
	 */
	public ServerClosePacket() {
		super();
	}
	
	/**
	 * ���ݴ����JSON�ı�����һ�����ݰ�
	 * @param json JSON�ı�
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
