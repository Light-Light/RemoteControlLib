package com.qing_guang.RemoteControl.packet.server;

import java.util.UUID;

import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.info.WorldInfo;
import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * 世界信息数据包
 * @author Qing_Guang
 *
 */
public class WorldInfoPacket extends Packet<WorldInfoPacket>{
	
	private static final long serialVersionUID = -2461467026095828265L;
	
	private final WorldInfo info;

	/**
	 * 新建此数据包
	 * @param info 世界信息
	 */
	public WorldInfoPacket(WorldInfo info) {
		super();
		json.addProperty(FinalValues.JSON_TEXT_KEY_WORLD_INFO_NAME, info.getName());
		json.addProperty(FinalValues.JSON_TEXT_KEY_WORLD_INFO_DIFFCULTY, info.getDiffculty());
		json.addProperty(FinalValues.JSON_TEXT_KEY_WORLD_INFO_ENVIRONMENT, info.getEnvironment());
		json.addProperty(FinalValues.JSON_TEXT_KEY_WORLD_INFO_UUID, info.getUid().toString());
		json.addProperty(FinalValues.JSON_TEXT_KEY_WORLD_INFO_MAX_HEIGHT, info.getMaxHeight());
		json.addProperty(FinalValues.JSON_TEXT_KEY_WORLD_INFO_SEED, info.getSeed());
		json.addProperty(FinalValues.JSON_TEXT_KEY_WORLD_INFO_SPAWN_LOC_X, info.getSpawnLocX());
		json.addProperty(FinalValues.JSON_TEXT_KEY_WORLD_INFO_SPAWN_LOC_Y, info.getSpawnLocY());
		json.addProperty(FinalValues.JSON_TEXT_KEY_WORLD_INFO_SPAWN_LOC_Z, info.getSpawnLocZ());
		this.info = info;
	}
	
	/**
	 * 根据传入的JSON文本创建一个数据包
	 * @param json JSON文本
	 */
	public WorldInfoPacket(JsonObject json) {
		super(json);
		info = new WorldInfo().name(json.get(FinalValues.JSON_TEXT_KEY_WORLD_INFO_NAME).getAsString())
							  .diffculty(json.get(FinalValues.JSON_TEXT_KEY_WORLD_INFO_DIFFCULTY).getAsString())
							  .environment(json.get(FinalValues.JSON_TEXT_KEY_WORLD_INFO_ENVIRONMENT).getAsString())
							  .uid(UUID.fromString(json.get(FinalValues.JSON_TEXT_KEY_WORLD_INFO_UUID).getAsString()))
							  .max_height(json.get(FinalValues.JSON_TEXT_KEY_WORLD_INFO_MAX_HEIGHT).getAsInt())
							  .seed(json.get(FinalValues.JSON_TEXT_KEY_WORLD_INFO_SEED).getAsLong())
							  .spawn_loc_x(json.get(FinalValues.JSON_TEXT_KEY_WORLD_INFO_SPAWN_LOC_X).getAsDouble())
							  .spawn_loc_y(json.get(FinalValues.JSON_TEXT_KEY_WORLD_INFO_SPAWN_LOC_Y).getAsDouble())
							  .spawn_loc_z(json.get(FinalValues.JSON_TEXT_KEY_WORLD_INFO_SPAWN_LOC_Z).getAsDouble());
	}
	
	/**
	 * {@inheritDoc}
	 */
	public PacketType getPkttype() {
		return ServerPacket.WORLD_INFO;
	}

	/**
	 * {@inheritDoc}
	 */
	public WorldInfoPacket clone() {
		return new WorldInfoPacket(info);
	}
	
	/**
	 * @see com.qing_guang.RemoteControl.info.WorldInfo#getName()
	 */
	public String getName() {
		return info.getName();
	}
	
	/**
	 * @see com.qing_guang.RemoteControl.info.WorldInfo#getDiffculty()
	 */
	public String getDiffculty() {
		return info.getDiffculty();
	}
	
	/**
	 * @see com.qing_guang.RemoteControl.info.WorldInfo#getEnvironment()
	 */
	public String getEnvironment() {
		return info.getEnvironment();
	}
	
	/**
	 * @see com.qing_guang.RemoteControl.info.WorldInfo#getUid()
	 */
	public UUID getUid() {
		return info.getUid();
	}
	
	/**
	 * @see com.qing_guang.RemoteControl.info.WorldInfo#getMaxHeight()
	 */
	public int getMaxHeight() {
		return info.getMaxHeight();
	}
	
	/**
	 * @see com.qing_guang.RemoteControl.info.WorldInfo#getSeed()
	 */
	public long getSeed() {
		return info.getSeed();
	}
	
	/**
	 * @see com.qing_guang.RemoteControl.info.WorldInfo#getSpawnLocX()
	 */
	public double getSpawnLocX() {
		return info.getSpawnLocX();
	}
	
	/**
	 * @see com.qing_guang.RemoteControl.info.WorldInfo#getSpawnLocY()
	 */
	public double getSpawnLocY() {
		return info.getSpawnLocY();
	}
	
	/**
	 * @see com.qing_guang.RemoteControl.info.WorldInfo#getSpawnLocZ()
	 */
	public double getSpawnLocZ() {
		return info.getSpawnLocZ();
	}
	
	/**
	 * 世界信息
	 */
	public WorldInfo getInfo() {
		return info;
	}
	
}
