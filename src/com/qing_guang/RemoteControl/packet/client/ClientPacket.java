package com.qing_guang.RemoteControl.packet.client;

import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * �����Ŀͻ������ݰ�����
 * @author Qing_Guang
 *
 */
public enum ClientPacket implements PacketType{

	/**
	 * �ͻ���ȷ��
	 */
	CLIENT_VERIFY,
	
	/**
	 * RSA��Կ
	 */
	RSA_PUBLIC_KEY,
	
	/**
	 * ��½����,����������û���������
	 */
	LOGIN_ACCOUNT,
	
	/**
	 * ��ָ̨��
	 */
	COMMAND_LINE,
	
	/**
	 * �ͻ����˳�
	 */
	CLIENT_EXIT;

	/**
	 * {@inheritDoc}
	 */
	public String getSign() {
		return FinalValues.CLIENT_PACKET_SIGN;
	}
	
}
