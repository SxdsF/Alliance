package com.sxdsf.alliance.sample.rxjava.whatever;

import android.net.Uri;

import com.sxdsf.alliance.core.impl.generic.GenericRequestBuilder;

/**
 * RxWhateverRequestBuilder
 *
 * @author Administrator
 * @date 2016/4/17-0:02
 * @desc ${描述类实现的功能}
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
