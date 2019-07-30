package com.qing_guang.RemoteControl.packet.client;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * ��½�������ݰ�,����������û���������
 * @author Qing_Guang
 *
 */
public class LoginAccountPacket extends Packet<LoginAccountPacket>{
	
	private static final long serialVersionUID = 4715037971234068653L;
	
	private final String uname;
	private final String pwd;
	
	/**
	 * �½������ݰ�
	 * @param uname ������û���
	 * @param pwd ���������
	 */
	public LoginAccountPacket(String uname,String pwd) {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_LOGIN_ACCOUNT_UNAME, uname);
		json.addProperty(FinalValues.JSON_TEXT_KEY_LOGIN_ACCOUNT_PASSWORD, pwd);
		this.uname = uname;
		this.pwd = pwd;
	}
	
	/**
	 * ���ݴ����JSON�ı�����һ�����ݰ�
	 * @param json JSON�ı�
	 */
	public LoginAccountPacket(JsonObject json) {
		super(json);
		this.uname = json.get(FinalValues.JSON_TEXT_KEY_LOGIN_ACCOUNT_UNAME).getAsString();
		this.pwd = json.get(FinalValues.JSON_TEXT_KEY_LOGIN_ACCOUNT_PASSWORD).getAsString();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public PacketType getPkttype() {
		return ClientPacket.LOGIN_ACCOUNT;
	}

	/**
	 * {@inheritDoc}
	 */
	public LoginAccountPacket clone() {
		return new LoginAccountPacket(uname,pwd);
	}
	
	/**
	 * ������û���
	 */
	public String getUname() {
		return uname;
	}
	
	/**
	 * ���������
	 */
	public String getPwd() {
		return pwd;
	}

}
