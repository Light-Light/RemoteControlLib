package com.qing_guang.RemoteControl.packet;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import com.qing_guang.RemoteControl.packet.client.ClientPacket;
import com.qing_guang.RemoteControl.packet.client.ClientVerifyPacket;
import com.qing_guang.RemoteControl.packet.client.CommandLinePacket;
import com.qing_guang.RemoteControl.packet.client.LoginAccountPacket;
import com.qing_guang.RemoteControl.packet.server.BackstageInfoPacket;
import com.qing_guang.RemoteControl.packet.server.OnlineModeChangePacket;
import com.qing_guang.RemoteControl.packet.server.EncryptRequirePacket;
import com.qing_guang.RemoteControl.packet.server.ManualDisconnectedPacket;
import com.qing_guang.RemoteControl.packet.server.PluginInfoPacket;
import com.qing_guang.RemoteControl.packet.server.RefuseOperatePacket;
import com.qing_guang.RemoteControl.packet.server.ServerClosePacket;
import com.qing_guang.RemoteControl.packet.server.ServerInfoPacket;
import com.qing_guang.RemoteControl.packet.server.ServerPacket;
import com.qing_guang.RemoteControl.packet.server.ServerVerifyPacket;
import com.qing_guang.RemoteControl.packet.server.SuccessfulLoginPacket;
import com.qing_guang.RemoteControl.packet.server.WorldInfoPacket;
import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * 所有数据包的父类
 * @author Qing_Guang
 * @param <T> 子类类型
 */
public abstract class Packet<T extends Packet<T>> implements Serializable,Cloneable{
	
	private static final long serialVersionUID = 2468964775152350908L;
	
	static final Map<String,Class<? extends PacketType>> REG_TYPES = new HashMap<>();
	private static final Map<PacketType,Class<? extends Packet<?>>> REG_PKTS = new HashMap<>();
	
	/**
	 * 调用此方法以注册基本的数据包类型
	 */
	public static void init() {

		registerPacketType(FinalValues.SERVER_PACKET_SIGN, ServerPacket.class);
		registerPacketType(FinalValues.CLIENT_PACKET_SIGN, ClientPacket.class);
		
		registerPacket(ServerPacket.SERVER_VERIFY,ServerVerifyPacket.class);
		registerPacket(ServerPacket.ENCRYPT_REQUIRE,EncryptRequirePacket.class);
		registerPacket(ServerPacket.RSA_PUBLIC_KEY, com.qing_guang.RemoteControl.packet.server.RSAPublicKeyPacket.class);
		registerPacket(ServerPacket.AES_KEY, com.qing_guang.RemoteControl.packet.server.AESKeyPacket.class);
		registerPacket(ServerPacket.SUCCESSFUL_LOGIN,SuccessfulLoginPacket.class);
		registerPacket(ServerPacket.SERVER_INFO,ServerInfoPacket.class);
		registerPacket(ServerPacket.PLUGIN_INFO,PluginInfoPacket.class);
		registerPacket(ServerPacket.WORLD_INFO,WorldInfoPacket.class);
		registerPacket(ServerPacket.ONLINE_MODE_CHANGE, OnlineModeChangePacket.class);
		registerPacket(ServerPacket.BACKSTAGE_INFO, BackstageInfoPacket.class);
		registerPacket(ServerPacket.MANUAL_DISCONNECTED, ManualDisconnectedPacket.class);
		registerPacket(ServerPacket.REFUSE_OPERATE, RefuseOperatePacket.class);
		registerPacket(ServerPacket.SERVER_CLOSE, ServerClosePacket.class);
		
		registerPacket(ClientPacket.CLIENT_VERIFY, ClientVerifyPacket.class);
		registerPacket(ClientPacket.RSA_PUBLIC_KEY, com.qing_guang.RemoteControl.packet.client.RSAPublicKeyPacket.class);
		registerPacket(ClientPacket.LOGIN_ACCOUNT, LoginAccountPacket.class);
		registerPacket(ClientPacket.COMMAND_LINE, CommandLinePacket.class);
		
	}
	
	/**
	 * 注册一组数据包类型
	 * @param sign 此类型数据包的标志
	 * @param pkttypes 数据包类型的class对象
	 * @throws IllegalArgumentException 当传入的参数都为null或者数据包类型不是java.lang.Enum的子类时抛出
	 */
	public static void registerPacketType(String sign,Class<? extends PacketType> pkttypes) throws IllegalArgumentException{
		if(pkttypes == null || sign == null) {
			throw new IllegalArgumentException("Packet type and packet class cannot be null");
		}else if(!Enum.class.isAssignableFrom(pkttypes)) {
			throw new IllegalArgumentException("Unsupported packet type");
		}else {
			REG_TYPES.put(sign, pkttypes);
		}
		
	}
	
	/**
	 * 注册一个数据包
	 * @param pkttype 数据包所对应的类型
	 * @param pktclass 数据包的class对象
	 * @throws IllegalArgumentException 当传入的参数中有一个是null或者数据包类型没被注册或者数据包已被注册时抛出
	 */
	public static void registerPacket(PacketType pkttype,Class<? extends Packet<?>> pktclass) throws IllegalArgumentException{
		if(pkttype == null || pktclass == null) {
			throw new IllegalArgumentException("Packet type and packet class cannot be null");
		}else if(!REG_TYPES.containsKey(pkttype.getSign()) || REG_PKTS.containsKey(pkttype)) {
			throw new IllegalArgumentException("Illegal packet type and packet class");
		}else {
			REG_PKTS.put(pkttype, pktclass);
		}
	}
	
	/**
	 * 判断此数据包类型是否注册且此类型对应的数据包是否与传入的相符
	 * @param pkttype 数据包类型
	 * @param pktclass 数据包的class对象
	 * @return 此数据包类型是否注册且此类型对应的数据包是否与传入的相符
	 * @throws IllegalArgumentException 当传入的参数中有一个是null时抛出
	 */
	public static boolean isLegal(PacketType pkttype,Class<? extends Packet<?>> pktclass) throws IllegalArgumentException{
		if(pkttype == null || pktclass == null) {
			throw new IllegalArgumentException("Packet type and packet class cannot be null");
		}else if(!REG_PKTS.containsKey(pkttype)) {
			return false;
		}else if(REG_PKTS.get(pkttype).getName().equals(pktclass.getName())) {
			return false;
		}
		return true;
	}
	
	/**
	 * 判断此数据包类型是否被注册
	 * @param pkttypes 数据包类型
	 * @return 此数据包类型是否被注册
	 * @throws 当传入的数据包类型为null时抛出
	 */
	public static boolean isLegal(PacketType pkttypes) throws IllegalArgumentException{
		if(pkttypes == null) {
			throw new IllegalArgumentException("Packet type cannot be null");
		}else if(!REG_PKTS.containsKey(pkttypes)) {
			return false;
		}
		return true;
	}
	
	/**
	 * 判断一个数据包或者一组数据包类型是否被注册,如果 pktclass 不为null则判断数据包是否被注册,否则判断后面一组数据包的类型是否被注册 <br />
	 * 由于泛型擦除的关系就只能使用这样的方法来把两个功能加到一个函数里
	 * @param pktclass 数据包的class对象
	 * @param pkttypes 数据包类型的class对象
	 * @return 需要判断的数据包或者类型是否被注册
	 * @throws IllegalArgumentException 当传入的两个参数都为null时抛出
	 */
	public static boolean isLegal(Class<? extends Packet<?>> pktclass,Class<? extends PacketType> pkttypes) throws IllegalArgumentException{
		if(pktclass == null && pkttypes == null) {
			throw new IllegalArgumentException("Packet type class and packet class both are null");
		}else if(pktclass != null){
			return REG_PKTS.values().contains(pktclass);
		}else {
			return REG_TYPES.values().contains(pkttypes);
		}
	}
	
	/**
	 * 使用JSON文本创建一个已注册的数据包
	 * @param json JSON文本
	 * @return 创建的数据包,如果在初始化时出现问题则返回null
	 * @throws IllegalArgumentException 当传入的JSON文本为null或者文本里面的类型没有被注册时抛出
	 */
	public static Packet<?> getByJson(JsonObject json) throws IllegalArgumentException{
		
		if(json == null) {
			throw new IllegalArgumentException("JSON text cannot be null");
		}
		
		PacketType pkttype = PacketType.toPkttype(json.get(FinalValues.JSON_TEXT_KEY_PACKET_ID).getAsString());
		
		if(pkttype == null) {
			throw new IllegalArgumentException("Unrelizeable JSON text");
		}else {
			Class<? extends Packet<?>> clazz = REG_PKTS.get(pkttype);
			Packet<?> pkt = null;
			try {
				pkt = clazz.getConstructor(JsonObject.class).newInstance(json);
			} catch (ReflectiveOperationException | IllegalArgumentException | SecurityException e) {
				e.printStackTrace();
			}
			return pkt;
		}
		
	}

	/**
	 * 此数据包的JSON文本
	 */
	protected final JsonObject json;
	
	/**
	 * 创建一个仅包含数据包类型信息的数据包
	 */
	protected Packet() {
		json = new JsonObject();
		json.addProperty(FinalValues.JSON_TEXT_KEY_PACKET_ID, getPkttype().string());
	}
	
	/**
	 * 根据传入的JSON文本创建一个数据包
	 * @param json JSON文本
	 */
	protected Packet(JsonObject json) {
		this.json = json;
	}
	
	/**
	 * 此数据包对应的数据包类型
	 */
	public abstract PacketType getPkttype();
	
	/**
	 * 克隆一个相同的数据包
	 * @see java.lang.Object#clone()
	 */
	public abstract T clone();
	
	/**
	 * 把此数据包根据JSON文本转成字符串
	 * @see com.google.gson.JsonElement#toString()
	 */
	public String toString() {
		return json.toString();
	}
	
}
