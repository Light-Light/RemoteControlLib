package com.qing_guang.RemoteControl.info;

/**
 * ������������Ϣ
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
	 * ����Ĭ����Ϸģʽ
	 * @param default_gamemode Ĭ����Ϸģʽ
	 * @return ������
	 */
	public ServerInfo default_gamemode(String default_gamemode) {
		this.default_gamemode = default_gamemode;
		return this;
	}
	
	/**
	 * ���÷������汾��
	 * @param version �������汾��
	 * @return ������
	 */
	public ServerInfo version(String version) {
		this.version = version;
		return this;
	}
	
	/**
	 * ���÷�����motd
	 * @param motd ������motd
	 * @return ������
	 */
	public ServerInfo motd(String motd) {
		this.motd = motd;
		return this;
	}
	
	/**
	 * ���÷�����ʹ�õĶ˿�
	 * @param port ������ʹ�õĶ˿�
	 * @return ������
	 */
	public ServerInfo port(int port) {
		this.port = port;
		return this;
	}
	
	/**
	 * ���÷���������������
	 * @param max_player ����������������
	 * @return ������
	 */
	public ServerInfo max_player(int max_player) {
		this.max_player = max_player;
		return this;
	}
	
	/**
	 * ���÷������Ӿ�
	 * @param view_distance �������Ӿ�
	 * @return ������
	 */
	public ServerInfo view_distance(int view_distance) {
		this.view_distance = view_distance;
		return this;
	}
	
	/**
	 * ���÷������Ƿ��������
	 * @param allow_nether �������Ƿ��������
	 * @return ������
	 */
	public ServerInfo allow_nether(boolean allow_nether) {
		this.allow_nether = allow_nether;
		return this;
	}
	
	/**
	 * ���÷������Ƿ�����ĩ��
	 * @param allow_nether �������Ƿ�����ĩ��
	 * @return ������
	 */
	public ServerInfo allow_end(boolean allow_end) {
		this.allow_end = allow_end;
		return this;
	}
	
	/**
	 * ���÷������Ƿ��������
	 * @param allow_nether �������Ƿ��������
	 * @return ������
	 */
	public ServerInfo allow_fly(boolean allow_fly) {
		this.allow_fly = allow_fly;
		return this;
	}
	
	/**
	 * ���÷������Ƿ�Ϊ����ģʽ
	 * @param allow_nether �������Ƿ�Ϊ����ģʽ
	 * @return ������
	 */
	public ServerInfo is_hardcore(boolean is_hardcore) {
		this.is_hardcore = is_hardcore;
		return this;
	}

	/**
	 * ������Ĭ����Ϸģʽ
	 */
	public String getDefaultGamemode() {
		return default_gamemode;
	}

	/**
	 * �������汾��
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * ������motd
	 */
	public String getMotd() {
		return motd;
	}

	/**
	 * ������ʹ�õĶ˿�
	 */
	public int getPort() {
		return port;
	}

	/**
	 * ����������������
	 */
	public int getMaxPlayer() {
		return max_player;
	}

	/**
	 * �������Ӿ�
	 */
	public int getViewDistance() {
		return view_distance;
	}

	/**
	 * �������Ƿ��������
	 */
	public boolean isAllowNether() {
		return allow_nether;
	}

	/**
	 * �������Ƿ�����ĩ��
	 */
	public boolean isAllowEnd() {
		return allow_end;
	}

	/**
	 * �������Ƿ��������
	 */
	public boolean isAllowFly() {
		return allow_fly;
	}

	/**
	 * �������Ƿ�Ϊ����ģʽ
	 */
	public boolean isHardcore() {
		return is_hardcore;
	}
	
}
