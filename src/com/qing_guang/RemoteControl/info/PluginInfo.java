package com.qing_guang.RemoteControl.info;

import java.util.List;
import java.util.Map;

/**
 * 插件基本信息
 * @author Qing_Guang
 *
 */
public class PluginInfo {
	
	private String name;
	private String version;
	private String website;
	private String jar_path;
	private String datafolder_path;
	
	private Map<String,String> pmss;
	private List<String> reged_cmds;
	
	private boolean enable;
	
	/**
	 * 设置插件名
	 * @param name 插件名
	 * @return 本对象
	 */
	public PluginInfo name(String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * 设置插件版本
	 * @param version 插件版本
	 * @return 本对象
	 */
	public PluginInfo version(String version) {
		this.version = version;
		return this;
	}
	
	/**
	 * 设置插件网站
	 * @param website 插件网站
	 * @return 本对象
	 */
	public PluginInfo website(String website) {
		this.website = website;
		return this;
	}
	
	/**
	 * 设置插件地址
	 * @param jar_path 插件地址
	 * @return
	 */
	public PluginInfo jar_path(String jar_path) {
		this.jar_path = jar_path;
		return this;
	}
	
	/**
	 * 设置插件数据文件夹地址
	 * @param datafolder_path 插件数据文件夹地址
	 * @return 本对象
	 */
	public PluginInfo datafolder_path(String datafolder_path) {
		this.datafolder_path = datafolder_path;
		return this;
	}
	
	/**
	 * 设置插件所有已注册的权限
	 * @param pmss 插件所有已注册的权限(权限名,权限注释)
	 * @return 本对象
	 */
	public PluginInfo pmss(Map<String,String> pmss) {
		this.pmss = pmss;
		return this;
	}
	
	/**
	 * 设置插件所有已注册的指令
	 * @param reged_cmds 插件所有已注册的指令
	 * @return 本对象
	 */
	public PluginInfo reged_cmds(List<String> reged_cmds) {
		this.reged_cmds = reged_cmds;
		return this;
	}
	
	/**
	 * 设置插件是否开启
	 * @param enable 插件是否开启
	 * @return 本对象
	 */
	public PluginInfo enable(boolean enable) {
		this.enable = enable;
		return this;
	}

	/**
	 * 插件名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 插件版本
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * 插件网站
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * 插件地址
	 */
	public String getJarPath() {
		return jar_path;
	}

	/**
	 * 插件数据文件夹地址
	 */
	public String getDatafolderPath() {
		return datafolder_path;
	}

	/**
	 * 插件所有已注册的权限(权限名,权限注释)
	 */
	public Map<String, String> getPmss() {
		return pmss;
	}

	/**
	 * 插件所有已注册的指令
	 */
	public List<String> getRegedCmds() {
		return reged_cmds;
	}

	/**
	 * 插件是否开启
	 */
	public boolean isEnable() {
		return enable;
	}
	
}
