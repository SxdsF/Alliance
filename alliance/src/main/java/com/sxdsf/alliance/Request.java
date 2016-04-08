package com.sxdsf.alliance;

import android.net.Uri;

/**
 * Request
 *
 * @author sunbowen
 * @date 2016/4/6-16:56
 * @desc 请求参数的实体类
 */
public class Request<T> {
	private Uri uri;
	private Class<T> dataClass;
	private T data;

	public Uri getUri() {
		return uri;
	}

	public void setUri(Uri uri) {
		this.uri = uri;
	}

	public Class<T> getDataClass() {
		return dataClass;
	}

	public void setDataClass(Class<T> dataClass) {
		this.dataClass = dataClass;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
