/*
    Copyright (c) 2014 Suneee Tech Company Limited
     Suneee Android Client, Constants
 */

package com.sien.doubeepk.common;

import android.os.Environment;
import android.os.Handler;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * [常量类]
 * 
 * @author huxinwu
 * @version 1.0
 * @date 2014-11-6
 * 
 **/
public class Constants {

	/** 是否第一次运行 **/
	public static final String FIRST_RUN_FLAG = "firstRunFlag";

	public static final String THEME = "Theme";
	public static final String LANG = "Lang";
	public static final String LOCAL_CACHE_PATH = "o2mall";

	/** 数据库名称 **/
	public static final String DB_NAME = "o2mall_db";
	/**
	 * 版本下载存放位置
	 */
	public static final String VERSION_DOWNLOAD_DIR = "o2mall/";

	/**
	 * 更新文件下载路径
	 */
	public static String VERSION_DOWNLOAD_URL = "";

	/**
	 * 版本名称
	 */
	public static int CURRENT_VERSION_CODE = 1;

	/**
	 * 新版本描述
	 */
	public static String VERSION_DESCRIPTION = "1.0.0";
	
	public static final String APP_ID = "SD123456789";
	public static final String CERTI_ID = "1414138763645";

	/**
	 * 下载文件名称
	 */
	public static String VERSION_DOWNLOAD_NAME = "o2mall";

	public static String IS_FIRST_RUN = "is_show_guide";// 显示指引页

	public static final String ACTION_NOTIFY_ADD_CHANGE = "com.suneee.o2mall.intent.action_notify_add_change"; // 消息记录添加广播
	public static String ACTION_NEW_MSG_CHANGE = "com.suneee.o2mall.intent.new_msg_change"; // 新消息标识广播
	
	
	public static final String ACTION_BOOT_COMPLETED_BROADCAST = "com.suneee.o2mall.intent.action_boot_completed_broadcast";// 开机广播
	public static final String ACTION_LOGIN_BIND_BROADCAST = "com.suneee.o2mall.intent.action_login_bind_broadcast"; // 绑定登录广播
	public static final String ACTION_LOGIN_BOOT_BROADCAST = "com.suneee.o2mall.intent.action_login_boot_broadcast"; // 启动登录服务广播

	public static final String ACTION_CONTACT_PRESENCE_CHANGE = "com.suneee.o2mall.intent.action_contact_presence_change"; // 好友状态更新广播
	public static final String ACTION_CONTACT_DATA_CHANGE = "com.suneee.o2mall.intent.action_contact_data_change"; // 好友数据更新广播
	public static final String ACTION_CONTACT_ADD_CHANGE = "com.suneee.o2mall.intent.action_contact_add_change"; // 同意添加好友广播
	public static final String ACTION_CONTACT_VCARD_CHANGE = "com.suneee.o2mall.intent.action_contact_vcard_change"; // 好友资料更新广播

	public static final String ACTION_MESSAGE_DATA_CHANGE = "com.suneee.o2mall.intent.action_message_data_change"; // 消息记录更新广播
	public static final String ACTION_MESSAGE_ADD_CHANGE = "com.suneee.o2mall.intent.action_message_add_change"; // 消息记录添加广播
	public static final String ACTION_MESSAGE_REFRESH_CHANGE = "com.suneee.o2mall.intent.action_message_refresh_change"; // 消息记录刷新广播
	

	public static final String ACTION_NET_CHANGE = "com.suneee.o2mall.intent.action_net_change"; // 网络变化广播
	public static final String NEW_MESSAGE_ACTION = "com.suneee.o2mall.intent.action.roster.newmessage";
	public static final String AUDIO_MESSAGE_ACTION = "com.suneee.o2mall.intent.action.audio_message_action";

	public static final String ACTION_AUTO_JOINED_ROOM = "com.suneee.o2mall.intent.action.auto_joined_room_action";
	public static final String ACTION_ROOM_MEMBER_CHANGE = "com.suneee.o2mall.intent.action.room_member_change_action";
	public static final String ACTION_ROOM_CHANGE = "com.suneee.o2mall.intent.action.room_change_action";
	public static final String ACTION_ROOM_DESTORY = "com.suneee.o2mall.intent.action.room_destory_action";
	// public static final String ACTION_ROOM_CHOOSE_PICTURE =
	// "com.suneee.o2mall.intent.action.choose_picture";

	public static final String ACTION_CHOOSE_PICTURE = "com.suneee.o2mall.intent.action_choose_picture"; // 选取图片广播
	// -----------------------------------------------------------------
	
	//------------------------------------------------------------sdk
	public static final String ACTION_DELETE_ROOM_HISTORY = "com.suneee.o2mall.intent.action_room_history";
	public static final String ACTION_MESSAGE_CHANGE_BROADCAST = "message_change_broadcast_action";   //聊天消息变化监听
	public static final String ACTION_MESSAGE_COUNT_CHANGE_BROADCAST = "message_count_change_broadcast_action";   //总消息变化监听
	public static final String ACTION_MESSAGE_IMAGE_UPLOAD = "message_image_upload_action";   //监听图片上传
	public static final String ACTION_MESSAGE_IMAGE_DOLOAD = "message_image_doload_action";   //监听图片下载
	public static final String ACTION_OTHER_CLIENT = "other_client_action";   //监听在其他设备登陆
	public static final String ACTION_CONNECT_RECONNECTING_IN = "connect_reconnecting_action";   //监听重连状态
	public static final String ACTION_CONNECT_DISCONNECTED = "connect_disconnect_action";   //监听未连接状态
	
	public static final String MESSAGE_DISCUSSION_DESTROY_BROADCAST_ACTION = "message_discussion_destroy_broadcast_action";		//侦听讨论组列表变化（比如销毁等）
	public static final String MESSAGE_DISCUSSION_INVITE_BROADCAST_ACTION = "message_discussion_invite_broadcast_action";		//侦听讨论组列表变化（比如销毁等）
	public static final String MESSAGE_DISCUSSION_LEAVE_BROADCAST_ACTION = "message_discussion_leave_broadcast_action";		//侦听讨论组列表变化（比如销毁等）
	public static final String MESSAGE_DISCUSSION_JOIN_BROADCAST_ACTION = "message_discussion_join_broadcast_action";		//侦听讨论组列表变化（比如销毁等）
	public static final String ACTION_ROOM_ADD = "add_room_action";
	public static final String ACTION_ROOMEMBER_REFRESH = "roomber_refresh_action";
	
	//性能测试环境
//	public static final int XMPP_SERVICE_PORT = 5222;
//	public static final String XMPP_SERVICE_IP = "172.19.2.11";
//	public static final String XMPP_SERVICE_NAME = "suneeese11";

	//109环境
//	public static final int XMPP_SERVICE_PORT = 5222;
//	public static final String XMPP_SERVICE_IP = "172.16.30.110";
//	public static final String XMPP_SERVICE_NAME = "zhangjing";
	
	 //16环境
//	 public static final int XMPP_SERVICE_PORT = 16522;
//	 public static final String XMPP_SERVICE_IP = "116.10.197.134";
//	 public static final String XMPP_SERVICE_NAME = "suneeesz16";
	
	 //正式环境
//	 public static final int XMPP_SERVICE_PORT = 16522;
//	 public static final String XMPP_SERVICE_IP = "h.weilian.cn";
//	 public static final String XMPP_SERVICE_NAME = "suneeesz16";
	 
	 //151环境
	 public static final int XMPP_SERVICE_PORT = 5222;
	 public static final String XMPP_SERVICE_IP = "172.16.30.151";
	 public static final String XMPP_SERVICE_NAME = "vz-vps-51";
	
	 //151外网
//	 public static final int XMPP_SERVICE_PORT = 15102;
//	 public static final String XMPP_SERVICE_IP = "221.7.133.74";
//	 public static final String XMPP_SERVICE_NAME = "vz-vps-51";

	 //10.0.0.72外网
//	 public static final int XMPP_SERVICE_PORT = 5222;
//	 public static final String XMPP_SERVICE_IP = "210.0.0.72";
//	 public static final String XMPP_SERVICE_NAME = "wlqydemo";
	 
	 //h.weilian.cn外网
//	 public static final int XMPP_SERVICE_PORT = 5222;
//	 public static final String XMPP_SERVICE_IP = "h.weilian.cn";
//	 public static final String XMPP_SERVICE_NAME = "vz-vps-51";
		 
	 //10.1.13.11外网
//	 public static final int XMPP_SERVICE_PORT = 5222;
//	 public static final String XMPP_SERVICE_IP = "10.1.13.11";
//	 public static final String XMPP_SERVICE_NAME = "vz-vps-51";
	 
	public static String USERNAME = "username";
	public static String PASSWORD = "password";
	public static String COMMUNITY_ID = "community_id";
	public static final String FIELD_SEX = "SEX";
	public static String APP_LOGIN_STATUS = "login_status";
	public static String APP_LOGOUT_FLAG = "logout_flag";
	public static String APP_CHANGE_LOGIN_FLAG_M = "change_login_flag_m";
	public static String APP_CHANGE_LOGIN_FLAG_F = "change_login_flag_f";
	
	public final static String WAKE_LOCAKNAME = "o2mall_WakeLock";

	public static final String OFFLINE = "offline";
	public static final String DND = "dnd";
	public static final String XA = "xa";
	public static final String AWAY = "away";
	public static final String AVAILABLE = "available";
	public static final String CHAT = "chat";
	public static final String PHONE_WORK = "PhoneWork";
	public static final String SCLIENTNOTIFY = "sclien_notify";
	public static final String VIBRANOTIFY = "vibra_notify";
	public static final String LEDNOTIFY = "led_notify";
	public static final String TICKER = "notify_ticker";
	public static final String PRIORITY = "priority";
	public static final String STATUS_MODE = "status_mode";
	public static final String STATUS_MESSAGE = "status_message";

	public final static String SHARE_REFRENCE_PATH = "o2mall_share";

	public static final String GROUP_MSG_TYPE_IMAGE = "image"; // 群聊消息图片类型
	public static final String GROUP_MSG_TYPE_TEXT = "text"; // 群聊消息文本类型
	public static final String GROUP_MSG_TYPE_SYSTEM = "system"; // 群聊消息系统消息类型（eg.谁加入、谁退出）

	/**
	 * 讨论组缓存文件夹
	 */
	public final static String GROUP_CACHE_IMAGE_PATH_SD = Environment
			.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
			.getAbsolutePath();
	public final static String GROUP_CACHE_IMAGE_PATH_PRE = File.separator
			+ "o2mall";
	public final static String GROUP_CACHE_IMAGE_PATH_MID = File.separator
			+ "imagecache" + File.separator;
	/**
	 * 精确到毫秒
	 */
	public static final String MS_FORMART = "yyyy-MM-dd HH:mm:ss";

	public static final int COMMUNITY_CONTACTOR_LIST = 10101;
	public static final int COMMUNITY_CONTACTOR = 10101;

	/**
	 * 获取首页广告列表
	 */
	public static final int MS_GET_AD_LIST = 100001;

	/***
	 * 获取限时抢购信息
	 */
	public static final int MS_GET_FlASH_SCALE = 100002;

	/***
	 * 获取聚优惠列表
	 */
	public static final int MS_GET_FAVOURABLE = 100003;

	/***
	 * 获取每日新品列表
	 */
	public static final int MS_GET_RECOMMEND_LIST = 100004;
	
	/***
	 * 获取限时抢购、聚优惠、每日新品列表
	 */
	public static final int MS_GET_HOME_RECOMMEND_LIST = 100006;

	/***
	 * 获取社区公告
	 */
	public static final int MS_GET_COMMUNITY_INFO = 100005;

	/**
	 * 搜索商品
	 */
	public static final int MSG_SEARCH_ITEM = 6;

	/** 验证码超时120秒 */
	public static final int TIME = 120;
	/** 当前时间 */
	public static Map<String,Integer> CURRENTTIME_MAP= new HashMap<String, Integer>();
	
	public static TimerTask timerTask;
	
	/**
	 * @return the timerTask
	 */
	public static TimerTask getTimerTask() {
		return timerTask;
	}
			
	public static void startTimer(final String clazzName) {
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			int currentTime = 0;
			@Override
			public void run() {
				currentTime++;
				if (currentTime == Constants.TIME) {
					if(getTimerTask()!=null){
						String cname = getTimerTask().getName();
						if(cname.equals(clazzName)){
							getTimerTask().onEnd();
							timerTask = null;
						}
					}
					handler.removeCallbacks(this);
					CURRENTTIME_MAP.remove(clazzName);
				} else{
					handler.postDelayed(this, 1000);
					if(getTimerTask()!=null){
						String cname = getTimerTask().getName();
						if(cname.equals(clazzName))
							getTimerTask().onTime(currentTime);
					}
					CURRENTTIME_MAP.put(clazzName, currentTime);
				}
			}
		}, 1000);
	}
	
	public static int getCurrentTime(String clazzName){
		if(CURRENTTIME_MAP.size() == 0 || ! CURRENTTIME_MAP.containsKey(clazzName)) return -1;
		return CURRENTTIME_MAP.get(clazzName);
	}
	
	public static abstract class TimerTask{
		public abstract void onEnd();
		public abstract void onTime(int time);
		public abstract String getName();
	} 
}
