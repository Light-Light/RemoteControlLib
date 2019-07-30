package com.qing_guang.RemoteControl.packet.server;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;

/**
 * �ֶ��������ݰ�
 * @author Qing_Guang
 *
 */
public class ManualDisconnectedPacket extends Packet<ManualDisconnectedPacket>{

	private static final long serialVersionUID = 1508139911203700984L;
	
	/**
	 * �½������ݰ�
	 */
	public ManualDisconnectedPacket() {
		super();
	}
	
	/**
	 * ���ݴ����JSON�ı�����һ�����ݰ�
	 * @param json JSON�ı�
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
