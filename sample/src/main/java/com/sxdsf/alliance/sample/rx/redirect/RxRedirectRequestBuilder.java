package com.sxdsf.alliance.sample.rx.redirect;

import android.net.Uri;
import android.os.Bundle;

import com.sxdsf.alliance.impl.generic.GenericRequestBuilder;

/**
 * RxRedirectRequestBuilder
 *
 * @author sunbowen
 * @date 2016/4/16-23:40
 * @desc 跳转服务的请求创建类
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
