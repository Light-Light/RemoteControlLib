package com.qing_guang.RemoteControl.packet;

import com.qing_guang.RemoteControl.util.FinalValues;

/**
 * ���е����ݰ����͵ĸ��ӿ�
 * @author Qing_Guang
 *
 */
public interface PacketType {
	
	/**
	 * ����һ�������ַ�������ע������ݰ�������Ѱ��ƥ�������
	 * @param type �����ַ���
	 * @return ƥ�������
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
	 * �������ݰ��ı�־
	 */
	public abstract String getSign();
	
	/**
	 * ���������ݰ����͵������ַ��� <br />
	 * default�����޷���д {@link java.lang.Object#toString()} ����
	 */
	public default String string() {
		return getSign() + FinalValues.PACKET_TYPE_SEPARATOR_OF_THE_TYPE_AND_FROM + toString();
	}
	
}
