/*
    Suneee Android Client, BaseApplication
    Copyright (c) 2014 Suneee Tech Company Limited
 */

package com.sien.doubeepk.ui;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.utils.L;
import com.sd.core.common.APPOnCrashListener;
import com.sd.core.common.AppCrashHandler;
import com.sd.core.common.CacheManager;
import com.sd.core.utils.NLog;
import com.sien.doubeepk.R;
import com.sien.doubeepk.common.Constants;
import com.sien.doubeepk.utils.CommonUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.CrashReport.UserStrategy;

import java.io.File;

import cn.jpush.android.api.JPushInterface;


/**
 * [系统Application类，设置全局变量以及初始化组件]
 * 
 * @author devin.hu
 * @version 1.0
 * @date 2013-9-17
 * 
 **/
public class BaseApplication extends Application implements APPOnCrashListener {

	private final String tag = BaseApplication.class.getSimpleName();
	
	private static BaseApplication baseApplication;
	public static boolean encryp = true;
	
//	public String remoteName;

	public static BaseApplication getApplicationInstance() {
		return baseApplication;
	}
	
	@Override
	public void onCreate() {
		baseApplication = this;
		
		init();
		initXMPP();
	}

	/**
	 * 初始化
	 */
	private void init() {
		// 初始化debug模式
		String flag = CommonUtils.getProperty(getApplicationContext(), "debug");
		if (!TextUtils.isEmpty(flag)) {
			Boolean isDebug = Boolean.parseBoolean(flag);
			NLog.setDebug(isDebug);
			NLog.e(tag, "isDebug: " + isDebug);
		}
		
		//初始化加密标志
		String encrypFlag = CommonUtils.getProperty(getApplicationContext(), "encryp");
		if(!TextUtils.isEmpty(encrypFlag)){
			encryp = Boolean.parseBoolean(encrypFlag);
			NLog.e(tag, "encryp: " + encryp);
		}

		// 设置默认缓存路径
		CacheManager.setSysCachePath(getCacheDir().getPath());

		// 初始化默认异常处理组件
		AppCrashHandler crashHandler = AppCrashHandler.getInstance(getApplicationContext());
		crashHandler.setOnCrashListener(this);

		//集成腾讯bugly
		String appId = "900002127";
        boolean isDebug = true ;  //true代表App处于调试阶段，false代表App发布阶段
		UserStrategy strategy = new UserStrategy(getApplicationContext());
		strategy.setAppVersion(CommonUtils.getVersionName(getApplicationContext()));
		strategy.setAppReportDelay(5000);
	    CrashReport.initCrashReport(getApplicationContext(), appId, isDebug, strategy);
			    
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.showImageOnFail(R.drawable.icon_default_bg)
				.showImageForEmptyUri(R.drawable.icon_default_bg)
				.showStubImage(R.drawable.icon_default_bg).cacheInMemory(true)
				.cacheOnDisc(true).build();
		// 初始化图片下载组件
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				getApplicationContext()).defaultDisplayImageOptions(options)
				.threadPriority(Thread.NORM_PRIORITY - 2)
				.denyCacheImageMultipleSizesInMemory()
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				.tasksProcessingOrder(QueueProcessingType.LIFO).build();

		// Initialize ImageLoader with configuration.
		ImageLoader.getInstance().init(config);
		L.disableLogging();
	}
	
	private void initXMPP(){
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
	}

	@Override
	public void onCrashDialog(Context context) {
		
	}
	// 侦听讨论组列表变化（比如销毁等）
	private void setSEIMDiscussionListener() {

	}

	/* 成员变化状态存放本地 */
	private void sendMemberChangeMessage(final String uid, final String roomid,
			final int type) {

	}

	/* 保存本地数据 */
	private void saveMemberChangeMessage(String uid,final String roomid,
			final String roomname,final int type) {
		

	}

	/*
	 * 注册监听消息
	 */
	public void setSEIMMessageListener() {

	}

	// 连接状态改变监听
	private void onConnectionStatusChanged() {

	}

	/*
	 * 注册消息数量变化监听
	 */
	public void setCountSEIMMessageListener() {
		Intent msgBroadcastIntent = new Intent(
				Constants.ACTION_MESSAGE_COUNT_CHANGE_BROADCAST);
		msgBroadcastIntent.putExtra("type", 0);
		sendBroadcast(msgBroadcastIntent);
	}
	
	/*
	 * 
	 * 在其他设备登陆
	 */
	protected void conflictLogin() {

	}
	
	/*有新公告*/
	private void caculateNotifyNews(){
		Intent t = new Intent(Constants.ACTION_NOTIFY_ADD_CHANGE);
		sendBroadcast(t);
	}
	
	/*有新消息*/
    private void caculateMsgNews(){

    }

	@Override
	public void onCrashPost(String crashReport, File file) {
		
	}
	
}
