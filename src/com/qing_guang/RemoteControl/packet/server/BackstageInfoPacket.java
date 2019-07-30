package com.qing_guang.RemoteControl.packet.server;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * �º�̨��Ϣ���ݰ�
 * @author Qing_Guang
 *
 */
public class BackstageInfoPacket extends Packet<BackstageInfoPacket>{

	private static final long serialVersionUID = -6557091393369290870L;

	private final String content;
	
	/**
	 * �½������ݰ�
	 * @param content �º�̨��Ϣ
	 */
	public BackstageInfoPacket(String content) {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_BACKSTAGE_INFO_CONTENT, content);
		this.content = content;
	}
	
	/**
	 * ���ݴ����JSON�ı�����һ�����ݰ�
	 * @param json JSON�ı�
	 */
	public BackstageInfoPacket(JsonObject json) {
		super(json);
		content = json.get(FinalValues.JSON_TEXT_KEY_BACKSTAGE_INFO_CONTENT).getAsString();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public PacketType getPkttype() {
		return ServerPacket.BACKSTAGE_INFO;
	}

	/**
	 * {@inheritDoc}
	 */
	public BackstageInfoPacket clone() {
		return new BackstageInfoPacket(content);
	}

	/**
	 * �º�̨��Ϣ
	 */
	public String getContent() {
		return content;
	}
	
}
