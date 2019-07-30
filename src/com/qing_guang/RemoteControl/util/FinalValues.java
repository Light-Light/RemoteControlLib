package com.qing_guang.RemoteControl.util;

/**
 * ����������õ����ַ�������<br />
 * ������ {@code JSON_TEXT_KEY} ��ͷ�ĳ�����û����������������¶���JSON�ı���"·����"
 * @author Qing_Guang
 *
 */
public final class FinalValues {
	
	//���췽�������⿪��
	private FinalValues() {}
	
	/** ���ݰ����ͱ�־�����ݰ��������ļ���� */
	public static final String PACKET_TYPE_SEPARATOR_OF_THE_TYPE_AND_FROM = ":";
	/** �����Ŀͻ������ݰ����ͱ�־ */
	public static final String CLIENT_PACKET_SIGN = "c";
	/** �����ķ��������ݰ����ͱ�־ */
	public static final String SERVER_PACKET_SIGN = "s";
	
	/** ���ݰ����� */
	public static final String JSON_TEXT_KEY_PACKET_ID = "pktid";
	/** ��������ͻ��˵İ汾�� */
	public static final String JSON_TEXT_KEY_APP_VERIFY_VERSION = "version";
	/** RSA��Կ */
	public static final String JSON_TEXT_KEY_RSA_PUBLIC_KEY = "pubkey";
	/** ������ʹ�õ��ַ��� */
	public static final String JSON_TEXT_KEY_RSA_PUBLIC_KEY_CHARSET = "charset";
	/** AES��Կ */
	public static final String JSON_TEXT_KEY_AES_KEY = "key";
	/** ��½�˻�������û��� */
	public static final String JSON_TEXT_KEY_LOGIN_ACCOUNT_UNAME = "uname";
	/** ��½�˻���������� */
	public static final String JSON_TEXT_KEY_LOGIN_ACCOUNT_PASSWORD = "pwd";
	/** �Ƿ��½�ɹ� */
	public static final String JSON_TEXT_KEY_SUCCESSFUL_LOGIN_OK = "ok";
	/** ��½ʧ��ԭ�� */
	public static final String JSON_TEXT_KEY_SUCCESSFUL_FAILURE_REASON = "reason";
	/** ����� */
	public static final String JSON_TEXT_KEY_PLUGIN_INFO_NAME = "name";
	/** ����汾 */
	public static final String JSON_TEXT_KEY_PLUGIN_INFO_VERSION = "version";
	/** �����վ */
	public static final String JSON_TEXT_KEY_PLUGIN_INFO_WEBSITE = "website";
	/** �����ַ */
	public static final String JSON_TEXT_KEY_PLUGIN_INFO_JAR_PATH = "jar_path";
	/** ��������ļ��е�ַ */
	public static final String JSON_TEXT_KEY_PLUGIN_INFO_DATAFOLDER_PATH = "datafloder_path";
	/** ���ע�������Ȩ�� */
	public static final String JSON_TEXT_KEY_PLUGIN_INFO_PERMISSIONS = "pmss";
	/** ���ע�������Ȩ�� */
	public static final String JSON_TEXT_KEY_PLUGIN_INFO_REGISTERED_COMMANDS = "reged_cmds";
	/** ����Ƿ����� */
	public static final String JSON_TEXT_KEY_PLUGIN_INFO_IS_ENABLE = "enable";
	/** ������ */
	public static final String JSON_TEXT_KEY_WORLD_INFO_NAME = "name";
	/** �����Ѷ� */
	public static final String JSON_TEXT_KEY_WORLD_INFO_DIFFCULTY = "diffculty";
	/** �������� */
	public static final String JSON_TEXT_KEY_WORLD_INFO_ENVIRONMENT = "environment";
	/** ����UUID */
	public static final String JSON_TEXT_KEY_WORLD_INFO_UUID = "uid";
	/** ������߽����߶� */
	public static final String JSON_TEXT_KEY_WORLD_INFO_MAX_HEIGHT = "max_height";
	/** �������� */
	public static final String JSON_TEXT_KEY_WORLD_INFO_SEED = "seed";
	/** ����������x�� */
	public static final String JSON_TEXT_KEY_WORLD_INFO_SPAWN_LOC_X = "spawn_loc_x";
	/** ����������y�� */
	public static final String JSON_TEXT_KEY_WORLD_INFO_SPAWN_LOC_Y = "spawn_loc_y";
	/** ����������z�� */
	public static final String JSON_TEXT_KEY_WORLD_INFO_SPAWN_LOC_Z = "spawn_loc_z";
	/** ������Ĭ����Ϸģʽ */
	public static final String JSON_TEXT_KEY_SERVER_INFO_DEFALUT_GAMEMODE = "def_gm";
	/** ��Ϸ�������汾�� */
	public static final String JSON_TEXT_KEY_SERVER_INFO_VERSION = "version";
	/** ������motd */
	public static final String JSON_TEXT_KEY_SERVER_INFO_MOTD = "motd";
	/** ��Ϸ������ʹ�õĶ˿� */
	public static final String JSON_TEXT_KEY_SERVER_INFO_PORT = "port";
	/** ��Ϸ����������������� */
	public static final String JSON_TEXT_KEY_SERVER_INFO_MAX_PLAYER = "max_player";
	/** ����������Ӿ� */
	public static final String JSON_TEXT_KEY_SERVER_INFO_VIEW_DISTANCE = "view_distance";
	/** �������Ƿ�������� */
	public static final String JSON_TEXT_KEY_SERVER_INFO_ALLOW_NETHER = "allow_nether";
	/** �������Ƿ�����ĩ�� */
	public static final String JSON_TEXT_KEY_SERVER_INFO_ALLOW_END = "allow_end";
	/** �������Ƿ�������� */
	public static final String JSON_TEXT_KEY_SERVER_INFO_ALLOW_FLY = "allow_fly";
	/** �������Ƿ�Ϊ����ģʽ */
	public static final String JSON_TEXT_KEY_SERVER_INFO_IS_HARDCORE = "is_hardcore";
	/** �������� */
	public static final String JSON_TEXT_KEY_ONLINE_MODE_CHANGE_TYPE = "type";
	/** ��Ч����Ч */
	public static final String JSON_TEXT_KEY_ONLINE_MODE_CHANGE_ON_OR_OFF = "ooo";
	/** �������� */
	public static final String JSON_TEXT_KEY_ONLINE_MODE_CHANGE_NAME = "name";
	/** ��̨����Ϣ���� */
	public static final String JSON_TEXT_KEY_BACKSTAGE_INFO_CONTENT = "content";
	/** ��ָ̨������ */
	public static final String JSON_TEXT_KEY_COMMAND_LINE_CONTENT = "content";
	/** �ܾ�����ԭ�� */
	public static final String JSON_TEXT_KEY_REFUSE_OPERATE_CAUSE = "cause";
	
}
