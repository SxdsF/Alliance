package com.sxdsf.alliance.sample.whatever;

import android.net.Uri;

import com.sxdsf.alliance.core.impl.generic.GenericRequestBuilder;

/**
 * WhateverRequestBuilder
 *
 * @author Administrator
 * @date 2016/4/16-0:28
 * @desc ${描述类实现的功能}
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
