/*
    Suneee Android Client, StringUtils
    Copyright (c) 2014 Suneee Tech Company Limited
 */

package com.sien.doubeepk.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

import com.sd.core.common.PreferencesManager;
import com.sd.core.utils.NLog;
import com.sd.core.utils.encrypt.MD5;
import com.sien.doubeepk.common.Constants;
import com.sien.doubeepk.common.URLConstants;
import com.sien.doubeepk.model.Dig;
import com.sien.doubeepk.model.Image;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * [字符串工具类]
 * 
 * @author devin.hu
 * @version 1.0
 * @date 2014-2-25
 * 
 **/
public class StringUtils {

	private static final String tag = StringUtils.class.getSimpleName();

	/**
	 * 判断字符不能为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (TextUtils.isEmpty(str) || "".equals(str) || "null".equalsIgnoreCase(str) || str.trim().equals("")) {
			return true;
		}
		return false;
	}

	/**
	 * 判断数组不能为空
	 * 
	 * @param list
	 * @return
	 */
	public static <T> boolean isEmpty(List<T> list) {
		if (list == null || list.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean num(Object o) {
		int n = 0;
		try {
			n = Integer.parseInt(o.toString().trim());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (n > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean decimal(Object o) {
		double n = 0;
		try {
			n = Double.parseDouble(o.toString().trim());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (n > 0.0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 产生一个随机数
	 * 
	 * @param size
	 * @return
	 */
	public static int getRandomIndex(int size) {
		return (int) (Math.random() * size);
	}

	/**
	 * 获取字符串的长度，如果有中文，则每个中文字符计为2位
	 * 
	 * @param value
	 *            指定的字符串
	 * @return 字符串的长度
	 */
	public static int getStrlength(String value) {
		int valueLength = 0;
		String chinese = "[\u0391-\uFFE5]";
		/* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
		for (int i = 0; i < value.length(); i++) {
			/* 获取一个字符 */
			String temp = value.substring(i, i + 1);
			/* 判断是否为中文字符 */
			if (temp.matches(chinese)) {
				/* 中文字符长度为2 */
				valueLength += 2;
			} else {
				/* 其他字符长度为1 */
				valueLength += 1;
			}
		}
		NLog.e(tag, "getStrlength : " + valueLength);
		return valueLength;
	}

	/**
	 * 判断字符串是否全是数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher match = pattern.matcher(str);
		return match.matches();
	}

	/**
	 * 验证是否是邮箱格式
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);
		return m.matches();
	}

	/**
	 * 验证手机号码格式
	 * 
	 * @param mobile
	 * @return
	 */
	public static boolean isMobile(String mobile) {
		Pattern p = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobile);
		return m.matches();
	}

	/**
	 * 判断输入的字符串是否为纯汉字
	 * 
	 * @param str
	 *            传入的字符窜
	 * @return 如果是纯汉字返回true,否则返回false
	 */
	public static boolean isChinese(String str) {
		Pattern pattern = Pattern.compile("[\u0391-\uFFE5]+$");
		return pattern.matcher(str).matches();
	}

	final static String PLEASE_SELECT = "请选择...";

	public static boolean notEmpty(Object o) {
		return o != null && !"".equals(o.toString().trim())
				&& !"null".equalsIgnoreCase(o.toString().trim())
				&& !"undefined".equalsIgnoreCase(o.toString().trim())
				&& !PLEASE_SELECT.equals(o.toString().trim());
	}

	public static boolean empty(Object o) {
		return o == null || "".equals(o.toString().trim())
				|| "null".equalsIgnoreCase(o.toString().trim())
				|| "undefined".equalsIgnoreCase(o.toString().trim())
				|| PLEASE_SELECT.equals(o.toString().trim());
	}

	/**
	 * 获取WWW下面的完整URL方法
	 * 
	 * @param
	 * @param params
	 * @return
	 */
	public static String getAssetsURL(String model, String... params) {
		StringBuilder urlBilder = new StringBuilder(URLConstants.WWW_URL);
		if (!TextUtils.isEmpty(model)) {
			urlBilder.append("#");
			urlBilder.append(model);
		}
		if (params != null) {
			for (String param : params) {
				urlBilder.append("/" + param);
			}
		}
		return urlBilder.toString();
	}

	/**
	 * 判断当前用户是否点赞
	 * 
	 * @param mContext
	 * @param diglist
	 * @return
	 */
	public static boolean userHasDig(Context mContext, List<Dig> diglist) {
		String member_id = PreferencesManager.getInstance(mContext,
				Constants.SHARE_REFRENCE_PATH).get("member_id");
		if (diglist != null) {
			for (Dig dig : diglist) {
				if (member_id.equals(dig.getUid())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 判断当前说说或者公告是否是当前用户发的
	 * 
	 * @param mContext
	 * @param
	 * @return
	 */
	public static boolean isCurrentUser(Context mContext, String uid) {
		String member_id = PreferencesManager.getInstance(mContext,
				Constants.SHARE_REFRENCE_PATH).get("member_id");
		if (!TextUtils.isEmpty(uid)) {
			if (member_id.equals(uid)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断当前用户是否被禁言
	 * is_can_talk，1：未禁言；0：被禁言
	 * 
	 * @param mContext
	 * @return
	 */
	public static boolean isCanTalk(Context mContext) {
		String is_can_talk = PreferencesManager.getInstance(mContext,
				Constants.SHARE_REFRENCE_PATH).get("is_can_talk");
		if (!TextUtils.isEmpty(is_can_talk) && "0".equals(is_can_talk)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 获取图片id
	 * 
	 * @param imagelist
	 * @return
	 */
	public static String getImgIds(List<Image> imagelist) {
		String result = "";
		StringBuilder imgIds = new StringBuilder();
		if (imagelist != null && imagelist.size() > 0) {
			for (Image bean : imagelist) {
				if (!TextUtils.isEmpty(bean.getUpload_id())) {
					imgIds.append(bean.getUpload_id()).append(",");
				}
			}

			if (imgIds.toString().endsWith(",")) {
				result = imgIds.substring(0, imgIds.length() - 1);
			}
		}
		return result;
	}

	/**
	 * 生成图片唯一名字
	 * 
	 * @param uri
	 * @return
	 */
	public static String getImageName(Uri uri) {
		String path = String.valueOf(System.currentTimeMillis());
		if (uri != null) {
			path = path + uri.getPath().toString();
		}
		path = MD5.encrypt(path) + ".jpg";
		return path;
	}
}
