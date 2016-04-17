package com.sxdsf.alliance.impl;

import com.sxdsf.alliance.Builder;

/**
 * RequestBuilder
 *
 * @author sunbowen
 * @date 2016/4/12-23:03
 * @desc 请求的创建类
 */
public abstract class RequestBuilder implements Builder<Request> {

	/**
	 * 请求创建类在初始化的时候需要传入scheme来明确是哪个服务的请求创建类
	 * 
	 * @param scheme
	 */
	public RequestBuilder(String scheme) {
	}

}
