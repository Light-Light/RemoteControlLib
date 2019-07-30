package com.qing_guang.RemoteControl.packet.server;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * ������ȷ�����ݰ�
 * @author Qing_Guang
 *
 */
public class ServerVerifyPacket extends Packet<ServerVerifyPacket>{
	
	private static final long serialVersionUID = 4138456941833768833L;

	/**
	 * �½������ݰ�
	 * @param sversion �������汾
	 */
	public ServerVerifyPacket(String sversion) {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_APP_VERIFY_VERSION, sversion);
	}
	
	/**
	 * ���ݴ����JSON�ı�����һ�����ݰ�
	 * @param json JSON�ı�
	 */
	public ServerVerifyPacket(JsonObject json) {
		super(json);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public PacketType getPkttype() {
		return ServerPacket.SERVER_VERIFY;
	}

	/**
	 * {@inheritDoc}
	 */
	public ServerVerifyPacket clone() {
		return new ServerVerifyPacket(json.get(FinalValues.JSON_TEXT_KEY_APP_VERIFY_VERSION).getAsString());
	}
	
	/**
	 * �������汾
	 */
	public String getVersion() {
		return json.get(FinalValues.JSON_TEXT_KEY_APP_VERIFY_VERSION).getAsString();
	}

}
