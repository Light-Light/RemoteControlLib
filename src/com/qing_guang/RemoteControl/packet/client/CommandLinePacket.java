package com.qing_guang.RemoteControl.packet.client;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * ��ָ̨�����ݰ�
 * @author Qing_Guang
 *
 */
public class CommandLinePacket extends Packet<CommandLinePacket>{
	
	private static final long serialVersionUID = 6352020430024109395L;
	
	private final String cmd_line;
	
	/**
	 * �½������ݰ�
	 * @param cmd_line ��Ҫ��ִ̨�е�ָ��
	 */
	public CommandLinePacket(String cmd_line) {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_COMMAND_LINE_CONTENT, cmd_line);
		this.cmd_line = cmd_line;
	}
	
	/**
	 * ���ݴ����JSON�ı�����һ�����ݰ�
	 * @param json JSON�ı�
	 */
	public CommandLinePacket(JsonObject json) {
		super(json);
		this.cmd_line =  json.get(FinalValues.JSON_TEXT_KEY_COMMAND_LINE_CONTENT).getAsString();
	}

	/**
	 * {@inheritDoc}
	 */
	public PacketType getPkttype() {
		return ClientPacket.COMMAND_LINE;
	}

	/**
	 * {@inheritDoc}
	 */
	public CommandLinePacket clone() {
		return new CommandLinePacket(cmd_line);
	}
	
	/**
	 * Ҫ��ִ̨�е�ָ��
	 */
	public String getCmdLine() {
		return cmd_line;
	}

}
