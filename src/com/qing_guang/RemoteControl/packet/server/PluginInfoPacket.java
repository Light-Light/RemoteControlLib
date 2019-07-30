package com.qing_guang.RemoteControl.packet.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import com.qing_guang.RemoteControl.info.PluginInfo;
import com.qing_guang.RemoteControl.packet.Packet;
import com.qing_guang.RemoteControl.packet.PacketType;
import com.qing_guang.RemoteControl.util.FinalValues;
import com.qing_guang.RemoteControl.util.JsonUtil;

/**
 * 插件信息数据包
 * @author Qing_Guang
 *
 */
public class PluginInfoPacket extends Packet<PluginInfoPacket>{
	
	private static final long serialVersionUID = 8177294134962049696L;
	
	private final PluginInfo info;
	
	/**
	 * 新建此数据包
	 * @param info 插件信息
	 */
	public PluginInfoPacket(PluginInfo info) {
		
		super();
		
		json.addProperty(FinalValues.JSON_TEXT_KEY_PLUGIN_INFO_NAME, info.getName());
		json.addProperty(FinalValues.JSON_TEXT_KEY_PLUGIN_INFO_VERSION, info.getVersion());
		json.addProperty(FinalValues.JSON_TEXT_KEY_PLUGIN_INFO_WEBSITE, info.getWebsite());
		json.addProperty(FinalValues.JSON_TEXT_KEY_PLUGIN_INFO_JAR_PATH, info.getJarPath());
		json.addProperty(FinalValues.JSON_TEXT_KEY_PLUGIN_INFO_DATAFOLDER_PATH, info.getDatafolderPath());
		json.add(FinalValues.JSON_TEXT_KEY_PLUGIN_INFO_PERMISSIONS, JsonUtil.toJsonObject(info.getPmss(), new JsonObject()));
		json.add(FinalValues.JSON_TEXT_KEY_PLUGIN_INFO_REGISTERED_COMMANDS, JsonUtil.toJsonArray(info.getRegedCmds().toArray(new String[info.getRegedCmds().size()]),new JsonArray()));
		
		this.info = info;
		
	}
	
	/**
	 * 根据传入的JSON文本创建一个数据包
	 * @param json JSON文本
	 */
	public PluginInfoPacket(JsonObject json) {
		super(json);
		JsonElement version = json.get(FinalValues.JSON_TEXT_KEY_PLUGIN_INFO_VERSION);
		JsonElement website = json.get(FinalValues.JSON_TEXT_KEY_PLUGIN_INFO_WEBSITE);
		String ver = version.isJsonNull() ? "null" : version.getAsString();
		String web = website.isJsonNull() ? "null" : version.getAsString();
		info = new PluginInfo().name(json.get(FinalValues.JSON_TEXT_KEY_PLUGIN_INFO_NAME).getAsString())
							   .version(ver)
							   .website(web)
							   .jar_path(json.get(FinalValues.JSON_TEXT_KEY_PLUGIN_INFO_JAR_PATH).getAsString())
							   .datafolder_path(json.get(FinalValues.JSON_TEXT_KEY_PLUGIN_INFO_DATAFOLDER_PATH).getAsString())
							   .pmss(JsonUtil.toMap(json.get(FinalValues.JSON_TEXT_KEY_PLUGIN_INFO_PERMISSIONS).getAsJsonObject(), new HashMap<>()))
							   .reged_cmds(new ArrayList<>(Arrays.asList(JsonUtil.toArray(json.get(FinalValues.JSON_TEXT_KEY_PLUGIN_INFO_REGISTERED_COMMANDS).getAsJsonArray(), new String[json.get(FinalValues.JSON_TEXT_KEY_PLUGIN_INFO_REGISTERED_COMMANDS).getAsJsonArray().size()]))));
	}

	/**
	 * {@inheritDoc}
	 */
	public PacketType getPkttype() {
		return ServerPacket.PLUGIN_INFO;
	}

	/**
	 * {@inheritDoc}
	 */
	public PluginInfoPacket clone() {
		return new PluginInfoPacket(info);
	}
	
	/**
	 * @see com.qing_guang.RemoteControl.info.PluginInfo#getName()
	 */
	public String getName() {
		return info.getName();
	}
	
	/**
	 * @see com.qing_guang.RemoteControl.info.PluginInfo#getVersion()
	 */
	public String getVersion() {
		return info.getVersion();
	}
	
	/**
	 * @see com.qing_guang.RemoteControl.info.PluginInfo#getWebsite()
	 */
	public String getWebsite() {
		return info.getWebsite();
	}
	
	/**
	 * @see com.qing_guang.RemoteControl.info.PluginInfo#getJarPath()
	 */
	public String getJarPath() {
		return info.getJarPath();
	}

	/**
	 * @see com.qing_guang.RemoteControl.info.PluginInfo#getDatafolderPath()
	 */
	public String getDatafolderPath() {
		return info.getDatafolderPath();
	}
	
	/**
	 * @see com.qing_guang.RemoteControl.info.PluginInfo#getPmss()
	 */
	public Map<String,String> getPmss(){
		return info.getPmss();
	}
	
	/**
	 * @see com.qing_guang.RemoteControl.info.PluginInfo#getRegedCmds()
	 */
	public List<String> getRegedCmds(){
		return info.getRegedCmds();
	}
	
	/**
	 * 插件信息
	 */
	public PluginInfo getInfo() {
		return info;
	}
	
}
