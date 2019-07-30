package com.qing_guang.RemoteControl.info;

/**
 * 服务器基本信息
 * @author Qing_Guang
 *
 */
public class ServerInfo {

	private String default_gamemode;
	private String version;
	private String motd;
	private int port;
	private int max_player;
	private int view_distance;
	private boolean allow_nether;
	private boolean allow_end;
	private boolean allow_fly;
	private boolean is_hardcore;
	
	/**
	 * 设置默认游戏模式
	 * @param default_gamemode 默认游戏模式
	 * @return 本对象
	 */
	public ServerInfo default_gamemode(String default_gamemode) {
		this.default_gamemode = default_gamemode;
		return this;
	}
	
	/**
	 * 设置服务器版本号
	 * @param version 服务器版本号
	 * @return 本对象
	 */
	public ServerInfo version(String version) {
		this.version = version;
		return this;
	}
	
	/**
	 * 设置服务器motd
	 * @param motd 服务器motd
	 * @return 本对象
	 */
	public ServerInfo motd(String motd) {
		this.motd = motd;
		return this;
	}
	
	/**
	 * 设置服务器使用的端口
	 * @param port 服务器使用的端口
	 * @return 本对象
	 */
	public ServerInfo port(int port) {
		this.port = port;
		return this;
	}
	
	/**
	 * 设置服务器最大玩家人数
	 * @param max_player 服务器最大玩家人数
	 * @return 本对象
	 */
	public ServerInfo max_player(int max_player) {
		this.max_player = max_player;
		return this;
	}
	
	/**
	 * 设置服务器视距
	 * @param view_distance 服务器视距
	 * @return 本对象
	 */
	public ServerInfo view_distance(int view_distance) {
		this.view_distance = view_distance;
		return this;
	}
	
	/**
	 * 设置服务器是否允许地狱
	 * @param allow_nether 服务器是否允许地狱
	 * @return 本对象
	 */
	public ServerInfo allow_nether(boolean allow_nether) {
		this.allow_nether = allow_nether;
		return this;
	}
	
	/**
	 * 设置服务器是否允许末地
	 * @param allow_nether 服务器是否允许末地
	 * @return 本对象
	 */
	public ServerInfo allow_end(boolean allow_end) {
		this.allow_end = allow_end;
		return this;
	}
	
	/**
	 * 设置服务器是否允许飞行
	 * @param allow_nether 服务器是否允许飞行
	 * @return 本对象
	 */
	public ServerInfo allow_fly(boolean allow_fly) {
		this.allow_fly = allow_fly;
		return this;
	}
	
	/**
	 * 设置服务器是否为极限模式
	 * @param allow_nether 服务器是否为极限模式
	 * @return 本对象
	 */
	public ServerInfo is_hardcore(boolean is_hardcore) {
		this.is_hardcore = is_hardcore;
		return this;
	}

	/**
	 * 服务器默认游戏模式
	 */
	public String getDefaultGamemode() {
		return default_gamemode;
	}

	/**
	 * 服务器版本号
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * 服务器motd
	 */
	public String getMotd() {
		return motd;
	}

	/**
	 * 服务器使用的端口
	 */
	public int getPort() {
		return port;
	}

	/**
	 * 服务器最大玩家人数
	 */
	public int getMaxPlayer() {
		return max_player;
	}

	/**
	 * 服务器视距
	 */
	public int getViewDistance() {
		return view_distance;
	}

	/**
	 * 服务器是否允许地狱
	 */
	public boolean isAllowNether() {
		return allow_nether;
	}

	/**
	 * 服务器是否允许末地
	 */
	public boolean isAllowEnd() {
		return allow_end;
	}

	/**
	 * 服务器是否允许飞行
	 */
	public boolean isAllowFly() {
		return allow_fly;
	}

	/**
	 * 服务器是否为极限模式
	 */
	public boolean isHardcore() {
		return is_hardcore;
	}
	
}
