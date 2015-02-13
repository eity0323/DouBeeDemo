/*
    Suneee Android Client, Image
    Copyright (c) 2014 Suneee Tech Company Limited
 */

package com.sien.doubeepk.model;


import com.sien.doubeepk.model.base.BaseModel;

/**
 * [A brief description]
 * 
 * @author huxinwu
 * @version 1.0
 * @date 2014-11-12
 * 
 **/
public class Image extends BaseModel {

	private String upload_id;
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUpload_id() {
		return upload_id;
	}

	public void setUpload_id(String upload_id) {
		this.upload_id = upload_id;
	}

}
