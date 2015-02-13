/*
    Suneee Android Client, CommonUtils
    Copyright (c) 2014 Suneee Tech Company Limited
 */

package com.sien.doubeepk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.sd.core.utils.NLog;
import com.sien.doubeepk.common.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;


/**
 * [公共工具类，与Android API相关的辅助类]
 *	
 * @author devin.hu 
 * @version 1.0
 * @date 2013-9-30
 *
 **/
public class CommonUtils {

	private static final String tag = CommonUtils.class.getSimpleName();
	
	/** 网络类型 **/ 
	public static final int NETTYPE_WIFI = 0x01;
	public static final int NETTYPE_CMWAP = 0x02;
	public static final int NETTYPE_CMNET = 0x03;
	
	
	/**
	 * 根据key获取config.properties里面的值
	 * @param context
	 * @param key
	 * @return
	 */
	public static String getProperty(Context context, String key){
		try {
			Properties props = new Properties();
			InputStream input = context.getAssets().open("config.properties");
			if (input != null) {
				props.load(input);
				return props.getProperty(key);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 检测网络是否可用
	 * 
	 * @return
	 */
	public static boolean isNetworkConnected(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		return ni != null && ni.isConnectedOrConnecting();
	}
	
	/**
	 * 获取当前网络类型
	 * 
	 * @return 0：没有网络 1：WIFI网络 2：WAP网络 3：NET网络
	 */
	public static int getNetworkType(Context context) {
		int netType = 0;
		ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		if (networkInfo == null) {
			return netType;
		}
		int nType = networkInfo.getType();
		if (nType == ConnectivityManager.TYPE_MOBILE) {
			String extraInfo = networkInfo.getExtraInfo();
			if (!TextUtils.isEmpty(extraInfo)) {
				if (extraInfo.toLowerCase(Locale.getDefault()).equals("cmnet")) {
					netType = NETTYPE_CMNET;
				} else {
					netType = NETTYPE_CMWAP;
				}
			}
		} else if (nType == ConnectivityManager.TYPE_WIFI) {
			netType = NETTYPE_WIFI;
		}
		return netType;
	}
	
	
	/**
	 * 判断SDCard是否存在,并可写
	 * 
	 * @return
	 */
	public static boolean checkSDCard(){
		String  flag = Environment.getExternalStorageState();
		if(Environment.MEDIA_MOUNTED.equals(flag)){
			return true;
		}
		return false;
	}
	
	/**
	 * 获取屏幕宽度
	 * @param context
	 * @return
	 */
	public static int getScreenWidth(Context context){
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		return dm.widthPixels;
	}
	
	/**
	 * 获取屏幕高度
	 * @param context
	 * @return
	 */
	public static int getScreenHeight(Context context){
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		return dm.heightPixels;
	}
	
	/**
	 * 获取屏幕显示信息对象
	 * @param context
	 * @return
	 */
	public static DisplayMetrics getDisplayMetrics(Context context){
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		return dm;
	}
	
	/**
	 * dp转pixel
     */
	public static float dpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return dp * (metrics.densityDpi / 160f);
    }

    /**
     * pixel转dp
     */
    public static float pixelsToDp(float px, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return px / (metrics.densityDpi / 160f);
    }
    
    /**
	 * 生成二维码图片
	 * @param str
	 * @return
	 */
	public static Bitmap create2DCode(String str) {
		try {
			// 生成二维矩阵,编码时指定大小,不要生成了图片以后再进行缩放,这样会模糊导致识别失败
			BitMatrix matrix = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, 300, 300);
			int width = matrix.getWidth();
			int height = matrix.getHeight();
			
			// 二维矩阵转为一维像素数组,也就是一直横着排了
			int[] pixels = new int[width * height];
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					if (matrix.get(x, y)) {
						pixels[y * width + x] = 0xff000000;
					}
				}
			}
			
			Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
			// 通过像素数组生成bitmap,具体参考api
			bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
			return bitmap;
		} catch (WriterException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 短信分享
	 * 
	 * @param mContext
	 * @param smstext 短信分享内容
	 * @return
	 */
	public static Boolean sendSms(Context mContext, String smstext){
		Uri smsToUri = Uri.parse("smsto:");
		Intent mIntent = new Intent(Intent.ACTION_SENDTO, smsToUri);
		mIntent.putExtra("sms_body", smstext);
		mContext.startActivity(mIntent);
		return null;
	}
	
	/**
	 * 邮件分享
	 * 
	 * @param mContext
	 * @param title 邮件的标题
	 * @param text 邮件的内容
	 * @return
	 */
	public static void sendMail(Context mContext, String title, String text){
		// 调用系统发邮件
		Intent emailIntent = new Intent(Intent.ACTION_SEND);
		// 设置文本格式
		emailIntent.setType("text/plain");
		// 设置对方邮件地址
		emailIntent.putExtra(Intent.EXTRA_EMAIL, "");
		// 设置标题内容
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, title);
		// 设置邮件文本内容
		emailIntent.putExtra(Intent.EXTRA_TEXT, text);
		mContext.startActivity(Intent.createChooser(emailIntent, "Choose Email Client"));
	}
	
	/**
	 * 隐藏软键盘
	 * @param activity
	 */
	public static void hideKeyboard(Activity activity) {
		if(activity != null){
			InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
			if(imm.isActive()){
				imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
			}
		}
	}

	/**
	 * 显示软键盘
	 * @param activity
	 */
	public static void showKeyboard(Activity activity) {
		if(activity != null){
			InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
			if(!imm.isActive()){
				imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);
			}
		}
	}
	
	/**
	 * 是否横屏
	 * @param context
	 * @return true为横屏，false为竖屏
	 */
	public static boolean isLandscape(Context context){
		if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){  
			return true;
		}  
		return false;
	}
	
	/**
	 * 判断是否是平板
	 * 这个方法是从 Google I/O App for Android 的源码里找来的，非常准确。
	 * @param context
	 * @return
	 */
	public static boolean isTablet(Context context) {       
		return (context.getResources().getConfiguration().screenLayout 
				& Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE; 
	} 
	
	/**
	 * 获取版本号
	 * @param context
	 * @return
	 */
	public static String getVersionName(Context context){
		try {
			PackageManager packageManager = context.getPackageManager();
			PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
			return packInfo.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return "0.0";
	}
	
	/**
	 * 根据url得到文件名
	 * @param
	 * @return
	 * @throws Exception 
	 */
	public static String getLocalFileName() throws Exception{
		
		if(!checkSDCard()){
			throw new Exception("SDCard is unavailable");
		}
		
		String path = getPath(getSDCardPath(), Constants.LOCAL_CACHE_PATH);
		File file = new File(path);
		StringBuilder fileName = new StringBuilder(file.getAbsolutePath());
		fileName.append(File.separator);
		fileName.append(String.valueOf(System.currentTimeMillis()));
		fileName.append(".jpg");
		
		NLog.e(tag, "getFileName: " + fileName.toString());
		return fileName.toString();
	}
	
	
	/**
	 * 获取SD卡路径
	 * @return
	 */
	public static String getSDCardPath(){
		return Environment.getExternalStorageDirectory().getPath();
	}
	
	
	public static String getPath(String...pathlist){
		return getPath(true, pathlist);
	}
	
	/**
	 * 获取路径方法
	 * @param pathlist
	 * @return
	 */
	public static String getPath(boolean isMkdirs, String...pathlist){
		StringBuilder pathBuilder = new StringBuilder();
		try {
			if(pathlist != null){
				for(int i=0; i<pathlist.length ;i++){
					if(!TextUtils.isEmpty(pathlist[i])){
						pathBuilder.append(pathlist[i]);
						if(i < pathlist.length-1){
							pathBuilder.append("/");
						}
					}
				}
				
				File file = new File(pathBuilder.toString());
				if(!file.exists() && isMkdirs){
					file.mkdirs();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		NLog.e(tag, "path: " + pathBuilder.toString());
		return pathBuilder.toString();
	}
	
	/**
	 * 判断是否登陆
	 * @param mContext
	 * @return
	 */
	public static boolean isLogin(Context mContext){
//		Object obj = PreferencesManager.getInstance(mContext, Constants.SHARE_REFRENCE_PATH).get(UserLoginData.class);
//		if(obj != null){
//			UserLoginData data = (UserLoginData)obj;
//			if(!TextUtils.isEmpty(data.getMember_id()) && !TextUtils.isEmpty(data.getCust_name())){
//				boolean loginStatus = PreferencesManager.getInstance(mContext, Constants.SHARE_REFRENCE_PATH).get(Constants.APP_LOGIN_STATUS, false);
//				boolean loginFlag = PreferencesManager.getInstance(mContext, Constants.SHARE_REFRENCE_PATH).get(Constants.APP_LOGOUT_FLAG, false);
//				if(loginStatus && !loginFlag){
//					return true;
//				}
//			}
//		}
		return false;
	}
	
	/**
	 * 判断是否登陆
	 * @param mContext
	 * @return
	 */
	public static String getLoginInfo(Context mContext){
//		Object obj = PreferencesManager.getInstance(mContext, Constants.SHARE_REFRENCE_PATH).get(UserLoginData.class);
//		try {
//			if(obj != null){
//				UserLoginData user = (UserLoginData)obj;
//				return JsonMananger.getInstance().beanToJson(user);
//			}
//		} catch (HttpException e) {
//			e.printStackTrace();
//		}
		return null;
	}
	
	public static Bitmap decodeUriAsBitmap(Context context, Uri uri) {
        if (context == null || uri == null) {
        	return null;
        }
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return bitmap;
    }
}
