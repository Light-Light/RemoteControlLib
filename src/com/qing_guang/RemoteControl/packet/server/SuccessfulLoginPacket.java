package com.qing_guang.RemoteControl.packet.server;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * ��½�Ƿ�ɹ����ݰ�
 * @author Qing_Guang
 *
 */
public class SuccessfulLoginPacket extends Packet<SuccessfulLoginPacket>{
	
	private static final long serialVersionUID = 5931325830432960740L;
	
	private final boolean ok;
	private final LoginFailureReason reason;
	
	/**
	 * �½������ݰ�(��½�ɹ�)
	 */
	public SuccessfulLoginPacket() {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_SUCCESSFUL_LOGIN_OK, true);
		json.addProperty(FinalValues.JSON_TEXT_KEY_SUCCESSFUL_FAILURE_REASON, LoginFailureReason.NAN.name());
		ok = true;
		reason = null;
	}
	
	/**
	 * �½������ݰ�(��½ʧ��)
	 * @param reason ʧ��ԭ��
	 */
	public SuccessfulLoginPacket(LoginFailureReason reason) {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_SUCCESSFUL_LOGIN_OK, false);
		json.addProperty(FinalValues.JSON_TEXT_KEY_SUCCESSFUL_FAILURE_REASON, reason.name());
		ok = false;
		this.reason = reason;
	}
	
	/**
	 * ���ݴ����JSON�ı�����һ�����ݰ�
	 * @param json JSON�ı�
	 */
	public SuccessfulLoginPacket(JsonObject json) {
		super(json);
		ok = json.get(FinalValues.JSON_TEXT_KEY_SUCCESSFUL_LOGIN_OK).getAsBoolean();
		this.reason = LoginFailureReason.valueOf(json.get(FinalValues.JSON_TEXT_KEY_SUCCESSFUL_FAILURE_REASON).getAsString());
	}

	/**
	 * {@inheritDoc}
	 */
	public PacketType getPkttype() {
		return ServerPacket.SUCCESSFUL_LOGIN;
	}

	/**
	 * {@inheritDoc}
	 */
	public SuccessfulLoginPacket clone() {
		if(ok) {
			return new SuccessfulLoginPacket();
		}else {
			return new SuccessfulLoginPacket(reason);
		}
	}
	
	/**
	 * ��½�Ƿ�ɹ�
	 */
	public boolean ok() {
		return ok;
	}
	
	/**
	 * ��½ʧ��ԭ��
	 */
	public LoginFailureReason failureReason() {
		return reason;
	}
	
	/**
	 * ��½ʧ��ԭ��
	 * @author Qing_Guang
	 *
	 */
	public enum LoginFailureReason{
		
		/**
		 * �û������������
		 */
		UNAME_OR_PASSWORD_WRONG,
		
		/**
		 * �˻����ڱ�ʹ��
		 */
		ALREADY_LOGGED,
		
		/**
		 * ��BAN���˻�
		 */
		BANNED_ACCOUNT,
		
		/**
		 * ��½�ɹ�����ռλ
		 */
		NAN
		
	}

}
