/*
    Suneee Android Client, Dig
    Copyright (c) 2014 Suneee Tech Company Limited
 */

package com.sien.doubeepk.model;


import com.sien.doubeepk.model.base.BaseModel;

/**
 * [赞对象model]
 * 
 * @author huxinwu
 * @version 1.0
 * @date 2014-11-12
 * 
 **/
public class Dig extends BaseModel {

	/** serialVersionUID **/
	private static final long serialVersionUID = 2527569304860774101L;

	private String dig_id;
	private String notice_id;
	private String uid;
	private String user_name;
	private String add_time;
	private String is_dig;

	public String getDig_id() {
		return dig_id;
	}

	public void setDig_id(String dig_id) {
		this.dig_id = dig_id;
	}

	public String getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getAdd_time() {
		return add_time;
	}

	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}

	public String getIs_dig() {
		return is_dig;
	}

	public void setIs_dig(String is_dig) {
		this.is_dig = is_dig;
	}

}
