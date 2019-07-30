package com.qing_guang.RemoteControl.info;

import java.util.UUID;

/**
 * 世界基本信息
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
	 * 设置世界名
	 * @param name 世界名
	 * @return 本对象
	 */
	public WorldInfo name(String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * 设置世界难度
	 * @param name 世界难度
	 * @return 本对象
	 */
	public WorldInfo diffculty(String diffculty) {
		this.diffculty = diffculty;
		return this;
	}
	
	/**
	 * 设置世界类型
	 * @param environment 世界类型
	 * @return 本对象
	 */
	public WorldInfo environment(String environment) {
		this.environment = environment;
		return this;
	}
	
	/**
	 * 设置世界UUID
	 * @param uid 世界UUID
	 * @return 本对象
	 */
	public WorldInfo uid(UUID uid) {
		this.uid = uid;
		return this;
	}
	
	/**
	 * 设置世界最高建筑高度
	 * @param max_height 世界最高建筑高度
	 * @return 本对象
	 */
	public WorldInfo max_height(int max_height) {
		this.max_height = max_height;
		return this;
	}
	
	/**
	 * 设置世界种子
	 * @param seed 世界种子
	 * @return 本对象
	 */
	public WorldInfo seed(long seed) {
		this.seed = seed;
		return this;
	}
	
	/**
	 * 设置世界出生点x轴
	 * @param spawn_loc_x 世界出生点x轴
	 * @return 本对象
	 */
	public WorldInfo spawn_loc_x(double spawn_loc_x) {
		this.spawn_loc_x = spawn_loc_x;
		return this;
	}
	
	/**
	 * 设置世界出生点y轴
	 * @param spawn_loc_y 世界出生点y轴
	 * @return 本对象
	 */
	public WorldInfo spawn_loc_y(double spawn_loc_y) {
		this.spawn_loc_y = spawn_loc_y;
		return this;
	}
	
	/**
	 * 设置世界出生点z轴
	 * @param spawn_loc_z 世界出生点z轴
	 * @return 本对象
	 */
	public WorldInfo spawn_loc_z(double spawn_loc_z) {
		this.spawn_loc_z = spawn_loc_z;
		return this;
	}

	/**
	 * 世界名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 世界难度
	 */
	public String getDiffculty() {
		return diffculty;
	}

	/**
	 * 世界类型
	 */
	public String getEnvironment() {
		return environment;
	}

	/**
	 * 世界UUID
	 */
	public UUID getUid() {
		return uid;
	}

	/**
	 * 世界最高建筑高度
	 */
	public int getMaxHeight() {
		return max_height;
	}

	/**
	 * 世界种子
	 */
	public long getSeed() {
		return seed;
	}

	/**
	 * 世界出生点x轴
	 */
	public double getSpawnLocX() {
		return spawn_loc_x;
	}

	/**
	 * 世界出生点y轴
	 */
	public double getSpawnLocY() {
		return spawn_loc_y;
	}

	/**
	 * 世界出生点z轴
	 */
	public double getSpawnLocZ() {
		return spawn_loc_z;
	}
	
}
