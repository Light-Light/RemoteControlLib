package com.qing_guang.RemoteControl.lib.main;

import org.bukkit.plugin.java.JavaPlugin;

import com.qing_guang.RemoteControl.packet.Packet;

public class Main extends JavaPlugin{

	public void onEnable() {
		getLogger().info("RemoteControl���ǰ�����ڼ���...");
		Packet.init();
		getLogger().info("���������,��л��ѡ��RemoteControl(�汾" + getDescription().getVersion() + ")");
	}
	
	public void onDisable() {
		getLogger().info("RemoteControl���ǰ����ж��");
	}
	
}
