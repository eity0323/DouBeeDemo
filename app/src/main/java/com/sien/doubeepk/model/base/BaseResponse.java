/*
    Suneee Android Client, BaseResponse
    Copyright (c) 2014 Suneee Tech Company Limited
 */

package com.sien.doubeepk.model.base;

import android.text.TextUtils;

/**
 * [返回结果基类，返回结果公共字段本类实现]
 * 
 * @author huxinwu
 * @version 1.0
 * @date 2014-11-6
 * 
 **/
public class BaseResponse extends BaseModel {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -5616901114632786764L;

    private String error_code;

    private String message;

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

    /**
     * 判断返回结果是否成功
     * @return
     */
    public boolean isSuccess(){
    	if(!TextUtils.isEmpty(error_code) && "200".equals(error_code)){
    		return true;
    	}
    	return false;
    }
}
