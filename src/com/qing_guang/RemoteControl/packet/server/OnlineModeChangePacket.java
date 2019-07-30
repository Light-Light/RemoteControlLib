package com.qing_guang.RemoteControl.packet.server;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * ��һ�����Ƿ���Ч�ĸ��������ı���Ч״̬ʱ���͵����ݰ�
 * @author Qing_Guang
 *
 */
public class OnlineModeChangePacket extends Packet<OnlineModeChangePacket>{

	private static final long serialVersionUID = -4799122844669060556L;

	private final Type type;
	private final String name;
	private final boolean on_or_off;
	
	/**
	 * �½������ݰ�
	 * @param type ��������
	 * @param on_or_off ��Ч����Ч
	 * @param name ������
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
	 * ���ݴ����JSON�ı�����һ�����ݰ�
	 * @param json JSON�ı�
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
	 * ��������
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * ��Ч����Ч
	 */
	public boolean onOrOff() {
		return on_or_off;
	}

	/**
	 * ������
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * ��������
	 * @author Qing_Guang
	 *
	 */
	public enum Type{
		
		/**
		 * ���
		 */
		PLAYER,
		
		/**
		 * �ͻ���
		 */
		CLIENT,
		
		/**
		 * ���
		 */
		PLUGIN
		
	}

}
