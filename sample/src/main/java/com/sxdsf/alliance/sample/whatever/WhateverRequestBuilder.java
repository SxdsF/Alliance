package com.sxdsf.alliance.sample.whatever;

import android.net.Uri;

import com.sxdsf.alliance.impl.generic.GenericRequestBuilder;

/**
 * WhateverRequestBuilder
 *
 * @author sunbowen
 * @date 2016/4/16-0:28
 * @desc whatever服务的请求创建类
 */
public class WhateverRequestBuilder extends GenericRequestBuilder<String> {

	public WhateverRequestBuilder(String scheme) {
		super(scheme);
	}

	public WhateverRequestBuilder setMessage(String message) {
		Uri uri = this.request.getUri();
		this.request.setUri(uri.buildUpon().authority(message).build());
		return this;
	}
}
