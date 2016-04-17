package com.sxdsf.alliance.sample.rx.whatever;

import android.net.Uri;

import com.sxdsf.alliance.impl.generic.GenericRequestBuilder;

/**
 * RxWhateverRequestBuilder
 *
 * @author sunbowen
 * @date 2016/4/17-0:02
 * @desc whatever服务的请求创建类
 */
public class RxWhateverRequestBuilder extends GenericRequestBuilder<String> {

	public RxWhateverRequestBuilder(String scheme) {
		super(scheme);
	}

	public RxWhateverRequestBuilder setMessage(String message) {
		Uri uri = this.request.getUri();
		this.request.setUri(uri.buildUpon().authority(message).build());
		return this;
	}
}
