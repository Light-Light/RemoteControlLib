package com.qing_guang.RemoteControl.packet.server;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * 当一个有是否有效的概念的事物改变有效状态时发送的数据包
 * @author Qing_Guang
 *
 */
public class OnlineModeChangePacket extends Packet<OnlineModeChangePacket>{

	private static final long serialVersionUID = -4799122844669060556L;

	private final Type type;
	private final String name;
	private final boolean on_or_off;
	
	/**
	 * 新建此数据包
	 * @param type 事物类型
	 * @param on_or_off 有效或无效
	 * @param name 事物名
	 */
	public OnlineModeChangePacket(Type type,boolean on_or_off,String name) {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_ONLINE_MODE_CHANGE_TYPE, type.toString());
		json.addProperty(FinalValues.JSON_TEXT_KEY_ONLINE_MODE_CHANGE_ON_OR_OFF, on_or_off);
		json.addProperty(FinalValues.JSON_TEXT_KEY_ONLINE_MODE_CHANGE_NAME, name);
		this.type = type;
		this.on_or_off = on_or_off;
		this.name = name;
	}
	
	/**
	 * 根据传入的JSON文本创建一个数据包
	 * @param json JSON文本
	 */
	public OnlineModeChangePacket(JsonObject json) {
		super(json);
		this.type = Type.valueOf(json.get(FinalValues.JSON_TEXT_KEY_ONLINE_MODE_CHANGE_TYPE).getAsString());
		this.on_or_off = json.get(FinalValues.JSON_TEXT_KEY_ONLINE_MODE_CHANGE_ON_OR_OFF).getAsBoolean();
		this.name = json.get(FinalValues.JSON_TEXT_KEY_ONLINE_MODE_CHANGE_NAME).getAsString();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public PacketType getPkttype() {
		return ServerPacket.ONLINE_MODE_CHANGE;
	}

	/**
	 * {@inheritDoc}
	 */
	public OnlineModeChangePacket clone() {
		return new OnlineModeChangePacket(type, on_or_off, name);
	}

	/**
	 * 事物类型
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * 有效或无效
	 */
	public boolean onOrOff() {
		return on_or_off;
	}

	/**
	 * 事物名
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 事物类型
	 * @author Qing_Guang
	 *
	 */
	public enum Type{
		
		/**
		 * 玩家
		 */
		PLAYER,
		
		/**
		 * 客户端
		 */
		CLIENT,
		
		/**
		 * 插件
		 */
		PLUGIN
		
	}

}
