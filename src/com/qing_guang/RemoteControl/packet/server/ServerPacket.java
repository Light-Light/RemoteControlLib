package com.qing_guang.RemoteControl.packet.server;

import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * �����ķ��������ݰ�����
 * @author Qing_Guang
 *
 */
public enum ServerPacket implements PacketType{

	/**
	 * ������ȷ��
	 */
	SERVER_VERIFY,
	
	/**
	 * ����Ҫ��
	 */
	ENCRYPT_REQUIRE,
	
	/**
	 * RSA��Կ
	 */
	RSA_PUBLIC_KEY,
	
	/**
	 * AES��Կ
	 */
	AES_KEY,
	
	/**
	 * ��½�Ƿ�ɹ�
	 */
	SUCCESSFUL_LOGIN,
	
	/**
	 * �����Ϣ
	 */
	PLUGIN_INFO,
	
	/**
	 * ������Ϣ
	 */
	WORLD_INFO,
	
	/**
	 * ��������Ϣ
	 */
	SERVER_INFO,
	
	/**
	 * ��Ч״̬�ı�
	 */
	ONLINE_MODE_CHANGE,
	
	/**
	 * ��̨����Ϣ
	 */
	BACKSTAGE_INFO,
	
	/**
	 * �ֶ�����
	 */
	MANUAL_DISCONNECTED,
	
	/**
	 * �ܾ�����
	 */
	REFUSE_OPERATE,
	
	/**
	 * �������ر�
	 */
	SERVER_CLOSE;

	/**
	 * {@inheritDoc}
	 */
	public String getSign() {
		return FinalValues.SERVER_PACKET_SIGN;
	}
	
}
