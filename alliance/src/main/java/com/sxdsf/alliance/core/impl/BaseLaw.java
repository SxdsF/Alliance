package com.sxdsf.alliance.core.impl;

import com.sxdsf.alliance.core.Law;

/**
 * BaseLaw
 *
 * @author sunbowen
 * @date 2016/4/13-17:27
 * @desc 默认的protocol实现
 */
public abstract class BaseLaw<T> implements Law {

	/**
	 * 请求解析模块
	 */
	protected final RequestParser<T> parser;

	public BaseLaw() {
		this.parser = this.createRequestParser();
	}

	/**
	 * 请求解析模块的创建方法
	 * 
	 * @return
	 */
	protected abstract RequestParser<T> createRequestParser();
}
