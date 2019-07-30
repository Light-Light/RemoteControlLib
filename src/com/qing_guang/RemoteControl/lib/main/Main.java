package com.qing_guang.RemoteControl.lib.main;

import org.bukkit.plugin.java.JavaPlugin;

import com.qing_guang.RemoteControl.packet.Packet;

public class Main extends JavaPlugin{

	public void onEnable() {
		getLogger().info("RemoteControl插件前置正在加载...");
		Packet.init();
		getLogger().info("加载已完成,感谢您选择RemoteControl(版本" + getDescription().getVersion() + ")");
	}
	
	public void onDisable() {
		getLogger().info("RemoteControl插件前置已卸载");
	}
	
}
