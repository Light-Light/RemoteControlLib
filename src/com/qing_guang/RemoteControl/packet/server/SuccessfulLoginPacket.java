package com.qing_guang.RemoteControl.packet.server;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * 登陆是否成功数据包
 * @author Qing_Guang
 *
 */
public class SuccessfulLoginPacket extends Packet<SuccessfulLoginPacket>{
	
	private static final long serialVersionUID = 5931325830432960740L;
	
	private final boolean ok;
	private final LoginFailureReason reason;
	
	/**
	 * 新建此数据包(登陆成功)
	 */
	public SuccessfulLoginPacket() {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_SUCCESSFUL_LOGIN_OK, true);
		json.addProperty(FinalValues.JSON_TEXT_KEY_SUCCESSFUL_FAILURE_REASON, LoginFailureReason.NAN.name());
		ok = true;
		reason = null;
	}
	
	/**
	 * 新建此数据包(登陆失败)
	 * @param reason 失败原因
	 */
	public SuccessfulLoginPacket(LoginFailureReason reason) {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_SUCCESSFUL_LOGIN_OK, false);
		json.addProperty(FinalValues.JSON_TEXT_KEY_SUCCESSFUL_FAILURE_REASON, reason.name());
		ok = false;
		this.reason = reason;
	}
	
	/**
	 * 根据传入的JSON文本创建一个数据包
	 * @param json JSON文本
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
	 * 登陆是否成功
	 */
	public boolean ok() {
		return ok;
	}
	
	/**
	 * 登陆失败原因
	 */
	public LoginFailureReason failureReason() {
		return reason;
	}
	
	/**
	 * 登陆失败原因
	 * @author Qing_Guang
	 *
	 */
	public enum LoginFailureReason{
		
		/**
		 * 用户名或密码错误
		 */
		UNAME_OR_PASSWORD_WRONG,
		
		/**
		 * 账户正在被使用
		 */
		ALREADY_LOGGED,
		
		/**
		 * 被BAN的账户
		 */
		BANNED_ACCOUNT,
		
		/**
		 * 登陆成功拿来占位
		 */
		NAN
		
	}

}
