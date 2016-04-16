package com.sxdsf.alliance.core.impl.generic;

import android.net.Uri;

import com.sxdsf.alliance.core.impl.Request;
import com.sxdsf.alliance.core.impl.RequestBuilder;

/**
 * GenericRequestBuilder
 *
 * @author sunbowen
 * @date 2016/4/12-23:23
 * @desc 泛型的请求创建类
 */
public class GenericRequestBuilder<T> extends RequestBuilder {

	protected final GenericRequest<T> request = new GenericRequest<>();

	public GenericRequestBuilder(String scheme) {
		super(scheme);
		this.request.setUri(new Uri.Builder().scheme(scheme).build());
	}

	public GenericRequestBuilder<T> setData(T data) {
		this.request.setData(data);
		return this;
	}

	@Override
	public Request build() {
		return this.request;
	}
}
