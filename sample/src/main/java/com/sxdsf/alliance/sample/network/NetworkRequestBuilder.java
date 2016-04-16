package com.sxdsf.alliance.sample.network;

import android.net.Uri;

import com.sxdsf.alliance.core.impl.generic.GenericRequestBuilder;

import java.util.Map;

/**
 * NetworkRequestBuilder
 *
 * @author Administrator
 * @date 2016/4/16-0:21
 * @desc ${描述类实现的功能}
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
