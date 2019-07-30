package com.qing_guang.RemoteControl.packet.server;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * 服务器确认数据包
 * @author Qing_Guang
 *
 */
public class ServerVerifyPacket extends Packet<ServerVerifyPacket>{
	
	private static final long serialVersionUID = 4138456941833768833L;

	/**
	 * 新建此数据包
	 * @param sversion 服务器版本
	 */
	public ServerVerifyPacket(String sversion) {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_APP_VERIFY_VERSION, sversion);
	}
	
	/**
	 * 根据传入的JSON文本创建一个数据包
	 * @param json JSON文本
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
	 * 服务器版本
	 */
	public String getVersion() {
		return json.get(FinalValues.JSON_TEXT_KEY_APP_VERIFY_VERSION).getAsString();
	}

}
