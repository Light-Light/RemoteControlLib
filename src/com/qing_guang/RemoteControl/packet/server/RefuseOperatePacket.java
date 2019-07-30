package com.qing_guang.RemoteControl.packet.server;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * 拒绝操作数据包
 * @author Qing_Guang
 *
 */
public class RefuseOperatePacket extends Packet<RefuseOperatePacket> {

	private static final long serialVersionUID = -1329477531605907215L;
	
	private final String cause;
	
	/**
	 * 新建此数据包
	 * @param cause 拒绝原因
	 */
	public RefuseOperatePacket(String cause) {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_REFUSE_OPERATE_CAUSE, cause);
		this.cause = cause;
	}
	
	/**
	 * 根据传入的JSON文本创建一个数据包
	 * @param json JSON文本
	 */
	public RefuseOperatePacket(JsonObject json) {
		super(json);
		this.cause = json.get(FinalValues.JSON_TEXT_KEY_REFUSE_OPERATE_CAUSE).getAsString();
	}

	/**
	 * {@inheritDoc}
	 */
	public PacketType getPkttype() {
		return ServerPacket.REFUSE_OPERATE;
	}

	/**
	 * {@inheritDoc}
	 */
	public RefuseOperatePacket clone() {
		return new RefuseOperatePacket(cause);
	}
	
	/**
	 * 拒绝原因
	 */
	public String getCause() {
		return cause;
	}

}
