package com.qing_guang.RemoteControl.packet.client;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * 后台指令数据包
 * @author Qing_Guang
 *
 */
public class CommandLinePacket extends Packet<CommandLinePacket>{
	
	private static final long serialVersionUID = 6352020430024109395L;
	
	private final String cmd_line;
	
	/**
	 * 新建此数据包
	 * @param cmd_line 需要后台执行的指令
	 */
	public CommandLinePacket(String cmd_line) {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_COMMAND_LINE_CONTENT, cmd_line);
		this.cmd_line = cmd_line;
	}
	
	/**
	 * 根据传入的JSON文本创建一个数据包
	 * @param json JSON文本
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
	 * 要后台执行的指令
	 */
	public String getCmdLine() {
		return cmd_line;
	}

}
