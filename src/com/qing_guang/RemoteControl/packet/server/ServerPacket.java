package com.qing_guang.RemoteControl.packet.server;

import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * 基本的服务器数据包类型
 * @author Qing_Guang
 *
 */
public enum ServerPacket implements PacketType{

	/**
	 * 服务器确认
	 */
	SERVER_VERIFY,
	
	/**
	 * 加密要求
	 */
	ENCRYPT_REQUIRE,
	
	/**
	 * RSA公钥
	 */
	RSA_PUBLIC_KEY,
	
	/**
	 * AES密钥
	 */
	AES_KEY,
	
	/**
	 * 登陆是否成功
	 */
	SUCCESSFUL_LOGIN,
	
	/**
	 * 插件信息
	 */
	PLUGIN_INFO,
	
	/**
	 * 世界信息
	 */
	WORLD_INFO,
	
	/**
	 * 服务器信息
	 */
	SERVER_INFO,
	
	/**
	 * 有效状态改变
	 */
	ONLINE_MODE_CHANGE,
	
	/**
	 * 后台新信息
	 */
	BACKSTAGE_INFO,
	
	/**
	 * 手动断线
	 */
	MANUAL_DISCONNECTED,
	
	/**
	 * 拒绝操作
	 */
	REFUSE_OPERATE,
	
	/**
	 * 服务器关闭
	 */
	SERVER_CLOSE;

	/**
	 * {@inheritDoc}
	 */
	public String getSign() {
		return FinalValues.SERVER_PACKET_SIGN;
	}
	
}
