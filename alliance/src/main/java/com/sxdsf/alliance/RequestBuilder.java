package com.sxdsf.alliance;

import android.net.Uri;

/**
 * RequestBuilder
 *
 * @author sunbowen
 * @date 2016/4/6-17:25
 * @desc 请求参数的构造类
 */
public class RequestBuilder<T> {

	private Request<T> request = new Request<>();

	public RequestBuilder<T> setUri(Uri uri) {
		this.request.setUri(uri);
		return this;
	}

	public RequestBuilder<T> setDataClass(Class<T> cls) {
		this.request.setDataClass(cls);
		return this;
	}

	public RequestBuilder<T> setData(T data) {
		this.request.setData(data);
		return this;
	}

	public Request<T> build() {
		return this.request;
	}
}
