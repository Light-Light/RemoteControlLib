package com.qing_guang.RemoteControl.info;

import java.util.UUID;

/**
 * ���������Ϣ
 * @author Qing_Guang
 *
 */
public class WorldInfo {

	private String name;
	private String diffculty;
	private String environment;
	private UUID uid;
	private int max_height;
	private long seed;
	
	private double spawn_loc_x;
	private double spawn_loc_y;
	private double spawn_loc_z;
	
	/**
	 * ����������
	 * @param name ������
	 * @return ������
	 */
	public WorldInfo name(String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * ���������Ѷ�
	 * @param name �����Ѷ�
	 * @return ������
	 */
	public WorldInfo diffculty(String diffculty) {
		this.diffculty = diffculty;
		return this;
	}
	
	/**
	 * ������������
	 * @param environment ��������
	 * @return ������
	 */
	public WorldInfo environment(String environment) {
		this.environment = environment;
		return this;
	}
	
	/**
	 * ��������UUID
	 * @param uid ����UUID
	 * @return ������
	 */
	public WorldInfo uid(UUID uid) {
		this.uid = uid;
		return this;
	}
	
	/**
	 * ����������߽����߶�
	 * @param max_height ������߽����߶�
	 * @return ������
	 */
	public WorldInfo max_height(int max_height) {
		this.max_height = max_height;
		return this;
	}
	
	/**
	 * ������������
	 * @param seed ��������
	 * @return ������
	 */
	public WorldInfo seed(long seed) {
		this.seed = seed;
		return this;
	}
	
	/**
	 * �������������x��
	 * @param spawn_loc_x ���������x��
	 * @return ������
	 */
	public WorldInfo spawn_loc_x(double spawn_loc_x) {
		this.spawn_loc_x = spawn_loc_x;
		return this;
	}
	
	/**
	 * �������������y��
	 * @param spawn_loc_y ���������y��
	 * @return ������
	 */
	public WorldInfo spawn_loc_y(double spawn_loc_y) {
		this.spawn_loc_y = spawn_loc_y;
		return this;
	}
	
	/**
	 * �������������z��
	 * @param spawn_loc_z ���������z��
	 * @return ������
	 */
	public WorldInfo spawn_loc_z(double spawn_loc_z) {
		this.spawn_loc_z = spawn_loc_z;
		return this;
	}

	/**
	 * ������
	 */
	public String getName() {
		return name;
	}

	/**
	 * �����Ѷ�
	 */
	public String getDiffculty() {
		return diffculty;
	}

	/**
	 * ��������
	 */
	public String getEnvironment() {
		return environment;
	}

	/**
	 * ����UUID
	 */
	public UUID getUid() {
		return uid;
	}

	/**
	 * ������߽����߶�
	 */
	public int getMaxHeight() {
		return max_height;
	}

	/**
	 * ��������
	 */
	public long getSeed() {
		return seed;
	}

	/**
	 * ���������x��
	 */
	public double getSpawnLocX() {
		return spawn_loc_x;
	}

	/**
	 * ���������y��
	 */
	public double getSpawnLocY() {
		return spawn_loc_y;
	}

	/**
	 * ���������z��
	 */
	public double getSpawnLocZ() {
		return spawn_loc_z;
	}
	
}
