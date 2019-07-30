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
 * �������ݰ��ĸ���
 * @author Qing_Guang
 * @param <T> ��������
 */
public abstract class Packet<T extends Packet<T>> implements Serializable,Cloneable{
	
	private static final long serialVersionUID = 2468964775152350908L;
	
	static final Map<String,Class<? extends PacketType>> REG_TYPES = new HashMap<>();
	private static final Map<PacketType,Class<? extends Packet<?>>> REG_PKTS = new HashMap<>();
	
	/**
	 * ���ô˷�����ע����������ݰ�����
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
	 * ע��һ�����ݰ�����
	 * @param sign ���������ݰ��ı�־
	 * @param pkttypes ���ݰ����͵�class����
	 * @throws IllegalArgumentException ������Ĳ�����Ϊnull�������ݰ����Ͳ���java.lang.Enum������ʱ�׳�
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
	 * ע��һ�����ݰ�
	 * @param pkttype ���ݰ�����Ӧ������
	 * @param pktclass ���ݰ���class����
	 * @throws IllegalArgumentException ������Ĳ�������һ����null�������ݰ�����û��ע��������ݰ��ѱ�ע��ʱ�׳�
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
	 * �жϴ����ݰ������Ƿ�ע���Ҵ����Ͷ�Ӧ�����ݰ��Ƿ��봫������
	 * @param pkttype ���ݰ�����
	 * @param pktclass ���ݰ���class����
	 * @return �����ݰ������Ƿ�ע���Ҵ����Ͷ�Ӧ�����ݰ��Ƿ��봫������
	 * @throws IllegalArgumentException ������Ĳ�������һ����nullʱ�׳�
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
	 * �жϴ����ݰ������Ƿ�ע��
	 * @param pkttypes ���ݰ�����
	 * @return �����ݰ������Ƿ�ע��
	 * @throws ����������ݰ�����Ϊnullʱ�׳�
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
	 * �ж�һ�����ݰ�����һ�����ݰ������Ƿ�ע��,��� pktclass ��Ϊnull���ж����ݰ��Ƿ�ע��,�����жϺ���һ�����ݰ��������Ƿ�ע�� <br />
	 * ���ڷ��Ͳ����Ĺ�ϵ��ֻ��ʹ�������ķ��������������ܼӵ�һ��������
	 * @param pktclass ���ݰ���class����
	 * @param pkttypes ���ݰ����͵�class����
	 * @return ��Ҫ�жϵ����ݰ����������Ƿ�ע��
	 * @throws IllegalArgumentException �����������������Ϊnullʱ�׳�
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
	 * ʹ��JSON�ı�����һ����ע������ݰ�
	 * @param json JSON�ı�
	 * @return ���������ݰ�,����ڳ�ʼ��ʱ���������򷵻�null
	 * @throws IllegalArgumentException �������JSON�ı�Ϊnull�����ı����������û�б�ע��ʱ�׳�
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
	 * �����ݰ���JSON�ı�
	 */
	protected final JsonObject json;
	
	/**
	 * ����һ�����������ݰ�������Ϣ�����ݰ�
	 */
	protected Packet() {
		json = new JsonObject();
		json.addProperty(FinalValues.JSON_TEXT_KEY_PACKET_ID, getPkttype().string());
	}
	
	/**
	 * ���ݴ����JSON�ı�����һ�����ݰ�
	 * @param json JSON�ı�
	 */
	protected Packet(JsonObject json) {
		this.json = json;
	}
	
	/**
	 * �����ݰ���Ӧ�����ݰ�����
	 */
	public abstract PacketType getPkttype();
	
	/**
	 * ��¡һ����ͬ�����ݰ�
	 * @see java.lang.Object#clone()
	 */
	public abstract T clone();
	
	/**
	 * �Ѵ����ݰ�����JSON�ı�ת���ַ���
	 * @see com.google.gson.JsonElement#toString()
	 */
	public String toString() {
		return json.toString();
	}
	
}
