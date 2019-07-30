package com.qing_guang.RemoteControl.packet.client;

import com.google.gson.JsonObject;
import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;

/**
 * �ͻ����˳����ݰ�
 * @author Qing_Guang
 *
 */
public class ClientExitPacket extends Packet<ClientExitPacket>{

	private static final long serialVersionUID = -1175951844698054249L;

	/**
	 * �½������ݰ�
	 */
	public ClientExitPacket() {
		super();
	}
	
	/**
	 * ���ݴ����JSON�ı�����һ�����ݰ�
	 * @param json JSON�ı�
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
