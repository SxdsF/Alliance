package com.sxdsf.alliance.sample.redirect;

import android.net.Uri;
import android.os.Bundle;

import com.sxdsf.alliance.impl.generic.GenericRequestBuilder;

/**
 * RedirectRequestBuilder
 *
 * @author sunbowen
 * @date 2016/4/15-23:07
 * @desc 跳转服务的请求创建类
 */
public class RedirectRequestBuilder extends GenericRequestBuilder<Bundle> {

	public RedirectRequestBuilder(String scheme) {
		super(scheme);
	}

	public RedirectRequestBuilder setTargetClassName(String className) {
		Uri uri = this.request.getUri();
		this.request.setUri(uri.buildUpon().authority(className).build());
		return this;
	}
}
