package com.qing_guang.RemoteControl.info;

import java.util.List;
import java.util.Map;

/**
 * ���������Ϣ
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
	 * ���ò����
	 * @param name �����
	 * @return ������
	 */
	public PluginInfo name(String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * ���ò���汾
	 * @param version ����汾
	 * @return ������
	 */
	public PluginInfo version(String version) {
		this.version = version;
		return this;
	}
	
	/**
	 * ���ò����վ
	 * @param website �����վ
	 * @return ������
	 */
	public PluginInfo website(String website) {
		this.website = website;
		return this;
	}
	
	/**
	 * ���ò����ַ
	 * @param jar_path �����ַ
	 * @return
	 */
	public PluginInfo jar_path(String jar_path) {
		this.jar_path = jar_path;
		return this;
	}
	
	/**
	 * ���ò�������ļ��е�ַ
	 * @param datafolder_path ��������ļ��е�ַ
	 * @return ������
	 */
	public PluginInfo datafolder_path(String datafolder_path) {
		this.datafolder_path = datafolder_path;
		return this;
	}
	
	/**
	 * ���ò��������ע���Ȩ��
	 * @param pmss ���������ע���Ȩ��(Ȩ����,Ȩ��ע��)
	 * @return ������
	 */
	public PluginInfo pmss(Map<String,String> pmss) {
		this.pmss = pmss;
		return this;
	}
	
	/**
	 * ���ò��������ע���ָ��
	 * @param reged_cmds ���������ע���ָ��
	 * @return ������
	 */
	public PluginInfo reged_cmds(List<String> reged_cmds) {
		this.reged_cmds = reged_cmds;
		return this;
	}
	
	/**
	 * ���ò���Ƿ���
	 * @param enable ����Ƿ���
	 * @return ������
	 */
	public PluginInfo enable(boolean enable) {
		this.enable = enable;
		return this;
	}

	/**
	 * �����
	 */
	public String getName() {
		return name;
	}

	/**
	 * ����汾
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * �����վ
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * �����ַ
	 */
	public String getJarPath() {
		return jar_path;
	}

	/**
	 * ��������ļ��е�ַ
	 */
	public String getDatafolderPath() {
		return datafolder_path;
	}

	/**
	 * ���������ע���Ȩ��(Ȩ����,Ȩ��ע��)
	 */
	public Map<String, String> getPmss() {
		return pmss;
	}

	/**
	 * ���������ע���ָ��
	 */
	public List<String> getRegedCmds() {
		return reged_cmds;
	}

	/**
	 * ����Ƿ���
	 */
	public boolean isEnable() {
		return enable;
	}
	
}
