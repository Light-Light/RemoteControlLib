package com.qing_guang.RemoteControl.packet;

import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * 所有的数据包类型的父接口
 * @author Qing_Guang
 *
 */
public interface PacketType {
	
	/**
	 * 根据一个类型字符串在已注册的数据包类型里寻找匹配的类型
	 * @param type 类型字符串
	 * @return 匹配的类型
	 */
	public static PacketType toPkttype(String type) {
		
		String[] strs = type.split(FinalValues.PACKET_TYPE_SEPARATOR_OF_THE_TYPE_AND_FROM);
		
		if(strs.length != 2) {
			return null;
		}else {
			Class<? extends PacketType> types = Packet.REG_TYPES.get(strs[0]);
			if(types == null) {
				return null;
			}
			try {
				return (PacketType) types.getMethod("valueOf", String.class).invoke(null, strs[1]);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}
	
	/**
	 * 这组数据包的标志
	 */
	public abstract String getSign();
	
	/**
	 * 获得这个数据包类型的类型字符串 <br />
	 * default方法无法重写 {@link java.lang.Object#toString()} 方法
	 */
	public default String string() {
		return getSign() + FinalValues.PACKET_TYPE_SEPARATOR_OF_THE_TYPE_AND_FROM + toString();
	}
	
}
