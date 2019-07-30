package com.qing_guang.RemoteControl.packet.client;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * 登陆请求数据包,包含请求的用户名和密码
 * @author Qing_Guang
 *
 */
public class LoginAccountPacket extends Packet<LoginAccountPacket>{
	
	private static final long serialVersionUID = 4715037971234068653L;
	
	private final String uname;
	private final String pwd;
	
	/**
	 * 新建此数据包
	 * @param uname 请求的用户名
	 * @param pwd 请求的密码
	 */
	public LoginAccountPacket(String uname,String pwd) {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_LOGIN_ACCOUNT_UNAME, uname);
		json.addProperty(FinalValues.JSON_TEXT_KEY_LOGIN_ACCOUNT_PASSWORD, pwd);
		this.uname = uname;
		this.pwd = pwd;
	}
	
	/**
	 * 根据传入的JSON文本创建一个数据包
	 * @param json JSON文本
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
	 * 请求的用户名
	 */
	public String getUname() {
		return uname;
	}
	
	/**
	 * 请求的密码
	 */
	public String getPwd() {
		return pwd;
	}

}
