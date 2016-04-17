package com.sxdsf.alliance.sample.rx.network;

import com.sxdsf.alliance.impl.generic.GenericRequestBuilder;

import java.util.Map;

/**
 * RxNetworkRequestBuilder
 *
 * @author sunbowen
 * @date 2016/4/16-23:52
 * @desc 网络服务的请求创建类
 */
public class RxNetworkRequestBuilder extends GenericRequestBuilder<Map> {
	public RxNetworkRequestBuilder(String scheme) {
		super(scheme);
	}
}
