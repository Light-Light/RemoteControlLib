package com.qing_guang.RemoteControl.packet.server;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * 新后台信息数据包
 * @author Qing_Guang
 *
 */
public class BackstageInfoPacket extends Packet<BackstageInfoPacket>{

	private static final long serialVersionUID = -6557091393369290870L;

	private final String content;
	
	/**
	 * 新建此数据包
	 * @param content 新后台信息
	 */
	public BackstageInfoPacket(String content) {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_BACKSTAGE_INFO_CONTENT, content);
		this.content = content;
	}
	
	/**
	 * 根据传入的JSON文本创建一个数据包
	 * @param json JSON文本
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
	 * 新后台信息
	 */
	public String getContent() {
		return content;
	}
	
}
