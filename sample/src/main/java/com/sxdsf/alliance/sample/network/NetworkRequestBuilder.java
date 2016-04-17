package com.sxdsf.alliance.sample.network;

import android.net.Uri;

import com.sxdsf.alliance.impl.generic.GenericRequestBuilder;

import java.util.Map;

/**
 * NetworkRequestBuilder
 *
 * @author sunbowen
 * @date 2016/4/16-0:21
 * @desc 网络服务的请求创建类
 */
public class NetworkRequestBuilder extends GenericRequestBuilder<Map> {

	public NetworkRequestBuilder(String scheme) {
		super(scheme);
	}

	public NetworkRequestBuilder setUrl(String url) {
		Uri uri = this.request.getUri();
		this.request.setUri(uri.buildUpon().authority(url).build());
		return this;
	}
}
