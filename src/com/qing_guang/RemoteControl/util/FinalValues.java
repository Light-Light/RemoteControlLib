package com.qing_guang.RemoteControl.util;

/**
 * 本类库所有用到的字符串常量<br />
 * 所有以 {@code JSON_TEXT_KEY} 开头的常量在没有特殊声明的情况下都是JSON文本的"路径名"
 * @author Qing_Guang
 *
 */
public final class FinalValues {
	
	//构造方法不对外开放
	private FinalValues() {}
	
	/** 数据包类型标志和数据包类型名的间隔符 */
	public static final String PACKET_TYPE_SEPARATOR_OF_THE_TYPE_AND_FROM = ":";
	/** 基本的客户端数据包类型标志 */
	public static final String CLIENT_PACKET_SIGN = "c";
	/** 基本的服务器数据包类型标志 */
	public static final String SERVER_PACKET_SIGN = "s";
	
	/** 数据包类型 */
	public static final String JSON_TEXT_KEY_PACKET_ID = "pktid";
	/** 服务器或客户端的版本号 */
	public static final String JSON_TEXT_KEY_APP_VERIFY_VERSION = "version";
	/** RSA公钥 */
	public static final String JSON_TEXT_KEY_RSA_PUBLIC_KEY = "pubkey";
	/** 发送者使用的字符串 */
	public static final String JSON_TEXT_KEY_RSA_PUBLIC_KEY_CHARSET = "charset";
	/** AES密钥 */
	public static final String JSON_TEXT_KEY_AES_KEY = "key";
	/** 登陆账户请求的用户名 */
	public static final String JSON_TEXT_KEY_LOGIN_ACCOUNT_UNAME = "uname";
	/** 登陆账户请求的密码 */
	public static final String JSON_TEXT_KEY_LOGIN_ACCOUNT_PASSWORD = "pwd";
	/** 是否登陆成功 */
	public static final String JSON_TEXT_KEY_SUCCESSFUL_LOGIN_OK = "ok";
	/** 登陆失败原因 */
	public static final String JSON_TEXT_KEY_SUCCESSFUL_FAILURE_REASON = "reason";
	/** 插件名 */
	public static final String JSON_TEXT_KEY_PLUGIN_INFO_NAME = "name";
	/** 插件版本 */
	public static final String JSON_TEXT_KEY_PLUGIN_INFO_VERSION = "version";
	/** 插件网站 */
	public static final String JSON_TEXT_KEY_PLUGIN_INFO_WEBSITE = "website";
	/** 插件地址 */
	public static final String JSON_TEXT_KEY_PLUGIN_INFO_JAR_PATH = "jar_path";
	/** 插件数据文件夹地址 */
	public static final String JSON_TEXT_KEY_PLUGIN_INFO_DATAFOLDER_PATH = "datafloder_path";
	/** 插件注册的所有权限 */
	public static final String JSON_TEXT_KEY_PLUGIN_INFO_PERMISSIONS = "pmss";
	/** 插件注册的所有权限 */
	public static final String JSON_TEXT_KEY_PLUGIN_INFO_REGISTERED_COMMANDS = "reged_cmds";
	/** 插件是否启用 */
	public static final String JSON_TEXT_KEY_PLUGIN_INFO_IS_ENABLE = "enable";
	/** 世界名 */
	public static final String JSON_TEXT_KEY_WORLD_INFO_NAME = "name";
	/** 世界难度 */
	public static final String JSON_TEXT_KEY_WORLD_INFO_DIFFCULTY = "diffculty";
	/** 世界类型 */
	public static final String JSON_TEXT_KEY_WORLD_INFO_ENVIRONMENT = "environment";
	/** 世界UUID */
	public static final String JSON_TEXT_KEY_WORLD_INFO_UUID = "uid";
	/** 世界最高建筑高度 */
	public static final String JSON_TEXT_KEY_WORLD_INFO_MAX_HEIGHT = "max_height";
	/** 世界种子 */
	public static final String JSON_TEXT_KEY_WORLD_INFO_SEED = "seed";
	/** 世界重生点x轴 */
	public static final String JSON_TEXT_KEY_WORLD_INFO_SPAWN_LOC_X = "spawn_loc_x";
	/** 世界重生点y轴 */
	public static final String JSON_TEXT_KEY_WORLD_INFO_SPAWN_LOC_Y = "spawn_loc_y";
	/** 世界重生点z轴 */
	public static final String JSON_TEXT_KEY_WORLD_INFO_SPAWN_LOC_Z = "spawn_loc_z";
	/** 服务器默认游戏模式 */
	public static final String JSON_TEXT_KEY_SERVER_INFO_DEFALUT_GAMEMODE = "def_gm";
	/** 游戏服务器版本号 */
	public static final String JSON_TEXT_KEY_SERVER_INFO_VERSION = "version";
	/** 服务器motd */
	public static final String JSON_TEXT_KEY_SERVER_INFO_MOTD = "motd";
	/** 游戏服务器使用的端口 */
	public static final String JSON_TEXT_KEY_SERVER_INFO_PORT = "port";
	/** 游戏服务器最多在线人数 */
	public static final String JSON_TEXT_KEY_SERVER_INFO_MAX_PLAYER = "max_player";
	/** 服务器最高视距 */
	public static final String JSON_TEXT_KEY_SERVER_INFO_VIEW_DISTANCE = "view_distance";
	/** 服务器是否允许地狱 */
	public static final String JSON_TEXT_KEY_SERVER_INFO_ALLOW_NETHER = "allow_nether";
	/** 服务器是否允许末地 */
	public static final String JSON_TEXT_KEY_SERVER_INFO_ALLOW_END = "allow_end";
	/** 服务器是否允许飞行 */
	public static final String JSON_TEXT_KEY_SERVER_INFO_ALLOW_FLY = "allow_fly";
	/** 服务器是否为极限模式 */
	public static final String JSON_TEXT_KEY_SERVER_INFO_IS_HARDCORE = "is_hardcore";
	/** 事物类型 */
	public static final String JSON_TEXT_KEY_ONLINE_MODE_CHANGE_TYPE = "type";
	/** 有效或无效 */
	public static final String JSON_TEXT_KEY_ONLINE_MODE_CHANGE_ON_OR_OFF = "ooo";
	/** 事物名称 */
	public static final String JSON_TEXT_KEY_ONLINE_MODE_CHANGE_NAME = "name";
	/** 后台新信息内容 */
	public static final String JSON_TEXT_KEY_BACKSTAGE_INFO_CONTENT = "content";
	/** 后台指令内容 */
	public static final String JSON_TEXT_KEY_COMMAND_LINE_CONTENT = "content";
	/** 拒绝操作原因 */
	public static final String JSON_TEXT_KEY_REFUSE_OPERATE_CAUSE = "cause";
	
}
