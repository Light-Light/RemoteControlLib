package com.qing_guang.RemoteControl.packet.client;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * �ͻ���ȷ�����ݰ�
 * @author Qing_Guang
 *
 */
public class ClientVerifyPacket extends Packet<ClientVerifyPacket> {
	
	private static final long serialVersionUID = -6986212616753737231L;

	/**
	 * �½������ݰ�
	 * @param cversion �ͻ��˰汾
	 */
	public ClientVerifyPacket(String cversion) {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_APP_VERIFY_VERSION, cversion);
	}
	
	/**
	 * ���ݴ����JSON�ı�����һ�����ݰ�
	 * @param json JSON�ı�
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
	 * �ͻ��˰汾
	 */
	public String getVersion() {
		return json.get(FinalValues.JSON_TEXT_KEY_APP_VERIFY_VERSION).getAsString();
	}

}
