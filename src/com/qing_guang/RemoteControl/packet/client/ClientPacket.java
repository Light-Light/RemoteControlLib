package com.qing_guang.RemoteControl.packet.client;

import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * 基本的客户端数据包类型
 * @author Qing_Guang
 *
 */
public enum ClientPacket implements PacketType{

	/**
	 * 客户端确认
	 */
	CLIENT_VERIFY,
	
	/**
	 * RSA公钥
	 */
	RSA_PUBLIC_KEY,
	
	/**
	 * 登陆请求,包含请求的用户名和密码
	 */
	LOGIN_ACCOUNT,
	
	/**
	 * 后台指令
	 */
	COMMAND_LINE,
	
	/**
	 * 客户端退出
	 */
	CLIENT_EXIT;

	/**
	 * {@inheritDoc}
	 */
	public String getSign() {
		return FinalValues.CLIENT_PACKET_SIGN;
	}
	
}
