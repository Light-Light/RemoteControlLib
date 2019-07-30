package com.qing_guang.RemoteControl.packet.server;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.info.ServerInfo;
import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * 服务器信息数据包
 * @author Qing_Guang
 *
 */
public class ServerInfoPacket extends Packet<ServerInfoPacket>{
	
	private static final long serialVersionUID = 7680277029373706741L;
	
	private final ServerInfo info;
	
	/**
	 * 新建此数据包
	 * @param info 服务器信息
	 */
	public ServerInfoPacket(ServerInfo info) {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_SERVER_INFO_DEFALUT_GAMEMODE, info.getDefaultGamemode());
		json.addProperty(FinalValues.JSON_TEXT_KEY_SERVER_INFO_VERSION, info.getVersion());
		json.addProperty(FinalValues.JSON_TEXT_KEY_SERVER_INFO_MOTD, info.getMotd());
		json.addProperty(FinalValues.JSON_TEXT_KEY_SERVER_INFO_PORT, info.getPort());
		json.addProperty(FinalValues.JSON_TEXT_KEY_SERVER_INFO_MAX_PLAYER, info.getMaxPlayer());
		json.addProperty(FinalValues.JSON_TEXT_KEY_SERVER_INFO_VIEW_DISTANCE, info.getViewDistance());
		json.addProperty(FinalValues.JSON_TEXT_KEY_SERVER_INFO_ALLOW_NETHER, info.isAllowNether());
		json.addProperty(FinalValues.JSON_TEXT_KEY_SERVER_INFO_ALLOW_END, info.isAllowEnd());
		json.addProperty(FinalValues.JSON_TEXT_KEY_SERVER_INFO_ALLOW_FLY, info.isAllowFly());
		json.addProperty(FinalValues.JSON_TEXT_KEY_SERVER_INFO_IS_HARDCORE, info.isHardcore());
		this.info = info;
	}
	
	/**
	 * 根据传入的JSON文本创建一个数据包
	 * @param json JSON文本
	 */
	public ServerInfoPacket(JsonObject json) {
		super(json);
		this.info = new ServerInfo().default_gamemode(json.get(FinalValues.JSON_TEXT_KEY_SERVER_INFO_DEFALUT_GAMEMODE).getAsString())
									.version(json.get(FinalValues.JSON_TEXT_KEY_SERVER_INFO_VERSION).getAsString())
									.motd(json.get(FinalValues.JSON_TEXT_KEY_SERVER_INFO_MOTD).getAsString())
									.port(json.get(FinalValues.JSON_TEXT_KEY_SERVER_INFO_PORT).getAsInt())
									.max_player(json.get(FinalValues.JSON_TEXT_KEY_SERVER_INFO_MAX_PLAYER).getAsInt())
									.view_distance(json.get(FinalValues.JSON_TEXT_KEY_SERVER_INFO_VIEW_DISTANCE).getAsInt())
									.allow_nether(json.get(FinalValues.JSON_TEXT_KEY_SERVER_INFO_ALLOW_NETHER).getAsBoolean())
									.allow_end(json.get(FinalValues.JSON_TEXT_KEY_SERVER_INFO_ALLOW_END).getAsBoolean())
									.allow_fly(json.get(FinalValues.JSON_TEXT_KEY_SERVER_INFO_ALLOW_FLY).getAsBoolean())
									.is_hardcore(json.get(FinalValues.JSON_TEXT_KEY_SERVER_INFO_IS_HARDCORE).getAsBoolean());
	}

	/**
	 * {@inheritDoc}
	 */
	public PacketType getPkttype() {
		return ServerPacket.SERVER_INFO;
	}

	/**
	 * {@inheritDoc}
	 */
	public ServerInfoPacket clone() {
		return new ServerInfoPacket(info);
	}
	
	public String getDefaultGamemode() {
		return info.getDefaultGamemode();
	}

	public String getVersion() {
		return info.getVersion();
	}

	public String getMotd() {
		return info.getMotd();
	}

	public int getPort() {
		return info.getPort();
	}

	public int getMaxPlayer() {
		return info.getMaxPlayer();
	}

	public int getViewDistance() {
		return info.getViewDistance();
	}

	public boolean isAllowNether() {
		return info.isAllowNether();
	}

	public boolean isAllowEnd() {
		return info.isAllowEnd();
	}

	public boolean isAllowFly() {
		return info.isAllowFly();
	}

	public boolean isHardcore() {
		return info.isHardcore();
	}
	
	public ServerInfo getInfo() {
		return info;
	}

}
