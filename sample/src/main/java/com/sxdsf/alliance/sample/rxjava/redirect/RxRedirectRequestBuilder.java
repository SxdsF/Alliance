package com.sxdsf.alliance.sample.rxjava.redirect;

import android.net.Uri;
import android.os.Bundle;

import com.sxdsf.alliance.core.impl.generic.GenericRequestBuilder;

/**
 * RxRedirectRequestBuilder
 *
 * @author Administrator
 * @date 2016/4/16-23:40
 * @desc ${描述类实现的功能}
 */
public class RxRedirectRequestBuilder extends GenericRequestBuilder<Bundle> {

	public RxRedirectRequestBuilder(String scheme) {
		super(scheme);
	}

	public RxRedirectRequestBuilder setTargetClassName(String className) {
		Uri uri = this.request.getUri();
		this.request.setUri(uri.buildUpon().authority(className).build());
		return this;
	}
}
